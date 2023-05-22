package net.softsociety.spring5.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.service.BoardService;
import net.softsociety.spring5.util.FileService;
import net.softsociety.spring5.util.PageNavigator;



@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService service;
	
	//설정파일에 정의된 업로드할 경로를 읽어서 아래 변수에 대입(from application.properites)
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	//페이지 당 글 수
	@Value("${user.board.page}")
	int countPerPage;
	
	//페이지당 이동링크 수
	@Value("${user.board.group}")
	int pagePerGroup;
	
	//글 목록 2.9일(목) 서치추가, 2.10 페이지수 추가
	@GetMapping("/list")
	public String list
			(@RequestParam(name="page", defaultValue="1") int page
				,String type
				, String searchWord
				, Model model) {

		PageNavigator navi = 
				service.getPageNavigator(pagePerGroup, countPerPage, page, type, searchWord);
//		이 밑의 코드 뜻은 서비스 객체로 부터 리턴받은
//		보드객체가 여러개 들어있는 어레이리스트를
//		모드에 저장한다는 뜻
//		원래는 list()안에 아무것도 없었는데 검색을 위해 type, searchWord 추가
		ArrayList<Board> blist = service.list(navi.getStartRecord(),countPerPage, type, searchWord);
		
		model.addAttribute("blist",blist);
		model.addAttribute("navi",navi);
		
		model.addAttribute("type",type);
		model.addAttribute("searchWord",searchWord);
		
		return "/boardview/list";
	}
	
	@GetMapping("/write")
		public String write() {
		return"/boardview/write";
	}
	
	//save
	@PostMapping("/write")
		public String write(@AuthenticationPrincipal UserDetails user
				,Board board
				,MultipartFile upload) {	
		//얘를 어레이 리스트에 담으면 한화면에서 여러개 파일 업로드 가능
		//ArrayList<MultipartFile> 
		
//		log.debug("파일정보:{} ",upload.getContentType());
//		log.debug("파일정보:{} ",upload.getOriginalFilename());
//		log.debug("파일정보:{} ",upload.getSize());
//		log.debug("파일정보:{} ",upload.isEmpty());
		
		//첨부파일이 있으면 지정한 경로에 저장하고 파일명을 board객체에 추가
		if(upload !=null && !upload.isEmpty()) { //반대로 하면 오류남
			//String filename=FileService.saveFile(upload, "D:/JH/Spring/upload"); 
			//원래는 위처럼 해야하는데 applicaion.properites에 경로 지정해놔서 위에 선언하고 밑에 처럼 함
			String filename=FileService.saveFile(upload, uploadPath);
			board.setOriginfile(upload.getOriginalFilename());
			board.setSavedfile(filename);
		}
		
		//로그인한 아이디 읽어서 board객체에 추가
		board.setMemberid(user.getUsername());
		
		log.debug("저장할 글 정보: ",board);
		
		//db에 저장
		service.write(board);
		return "redirect:/board/list";
	}
	
	//글 읽기
	@GetMapping("read")
	public String read(
			@RequestParam(name="num",defaultValue="0") int num
			,Model model
			) {
		//num 이라는 글번호를 board라는 객체를 통하여 전달받음 중요
		Board board = service.read(num);
//		log.debug("글 하나: {}",board);
		//전달받은 글번호를 서비스로 전달
		//서비스가 리턴한 Board객체를 Model에 저장
		model.addAttribute("board",board);
		
		//해당글에 달린 리플목록 출력
		ArrayList<Reply>replylist = service.readReply(num);
		model.addAttribute("replylist",replylist);
		log.debug("{}글의 리플들: {}",num, replylist);
		//HTML파일로 포워딩하여 출력
		return "/boardview/read";
	}
	
	//첨부파일 다운로드
	@GetMapping("download")
	public String download(@RequestParam(name="num",defaultValue="0") int num
			,Model model
			, HttpServletResponse response) {
		Board board = service.read(num);
		if(board == null || board.getSavedfile()==null) {
			return "redirect:list";
		}
		
		String file = uploadPath +"/"+ board.getSavedfile();
		log.debug("파일:{}",file);
		
		FileInputStream in = null;
		ServletOutputStream out = null;
		
		try {
			//응답정보의 헤더 세팅
			response.setHeader("Content-Disposition",
					"attachment;filename=" 
					+ URLEncoder.encode(board.getSavedfile(),"UTF-8"));
			//getOriginfile하면 원래 파일이름, getSavedfile하면 서버에 저장된 파일이름(랜덤)으로
			
			in = new FileInputStream(file);
			out = response.getOutputStream();
			
			FileCopyUtils.copy(in, out);
			
			in.close();
			out.close();
		} 
		catch(IOException e){
			//예외 메시지 출력
		}
		return "redirect:/";
	}
	
	//글 삭제
	@GetMapping("delete")
	public String delete(@RequestParam(name="num",defaultValue="0") int num
			,@AuthenticationPrincipal UserDetails user){
		//null값을 방지하기 위해 넣는게 requestparam
		log.debug("번호:{}",num);
		//로그인한 사용자의 아이디를 읽음
		String id =user.getUsername();
		//글번호 읽어오는거(글 읽기 화면에서 글번호가 전달됨)
		Board board = service.read(num);
		//해당번호의 글이 있는지 확인, 없으면 글목록으로
		if(board==null) return "redirect:list";
		//로그인한 본인의 글이 맞는지 확인 아니면 글목록으로
		if(!board.getMemberid().equals(id)) return "redirect:list";
		//첨부된 파일이 있으면 파일삭제
		if(board.getSavedfile() !=null) {
			FileService.deleteFile(uploadPath +"/"+ board.getSavedfile());
		}
		//실제글 db에서 삭제
		service.delete(board);
		

		//글 목록으로 리다이렉트
		return "redirect:list";
	}
	
	//글 수정
	@GetMapping("update")
	public String update(
			Model model
			,int num
			,@AuthenticationPrincipal UserDetails user) {
		
		//전달된 번호의 글정보 읽기
		Board board = service.read(num);
		//로그인한 사용자의 아이디를 읽음
		String id =user.getUsername();
		//본인 글인지 확인, 아니면 글목록으로 이동
		if(!board.getMemberid().equals(id)) return "redirect:list";
		//글정보를 모델에 저장
		model.addAttribute("board",board);
		//수정을 html로 포워딩
		return "boardview/update.html";
	}
	
	//수정폼에서 보낸 내용 처리
	@PostMapping("update")
	public String update(
			Board board
			,@AuthenticationPrincipal UserDetails user
			,MultipartFile upload
			,String memberid) {
		
		//전달된 board객체(글번호,제목,내용)에 로그인한 아이디 추가 저장
//		board.setMemberid(user.getUsername());
//		log.debug("수정정보: {}", memberid );
		board.setMemberid(user.getUsername());
		Board oldBoard = null;
		String oldSavedfile = null;
		String savedfile = null;
		
//		//업로드된 파일이 있으면 
//			//1. 기존 파일이 있으면 삭제
//			//2. 업로드된 파일 저장하고 파일명 board객체에 추가
//			// 내가 한건데 나처럼 하면 폴더안에 저장되어있는 파일이 안지워짐
//		if(board.getSavedfile() !=null) {
//			FileService.deleteFile(uploadPath +"/"+ board.getSavedfile());
//		} else if(upload !=null && !upload.isEmpty()) { 
//			String filename=FileService.saveFile(upload, uploadPath);
//			board.setOriginfile(upload.getOriginalFilename());
//			board.setSavedfile(filename);
//		}
		if (upload != null && !upload.isEmpty()) {
			oldBoard = service.read(board.getBoardnum());
			oldSavedfile = oldBoard == null ? null : oldBoard.getSavedfile();
			
			savedfile = FileService.saveFile(upload, uploadPath);
			board.setOriginfile(upload.getOriginalFilename());
			board.setSavedfile(savedfile);
			log.debug("새파일:{}, 구파일:{}", savedfile, oldSavedfile);
		}
		
		//board객체를 전달해서 DB에서 글정보 수정
		log.debug("보드객체: {}", board );
//		service.update(board);
		int result = service.update(board);
		
		//글 수정 성공 and 첨부된 파일이 있는 경우 파일도 삭제
			if (result == 1 && savedfile != null) {
				FileService.deleteFile(uploadPath + "/" + oldSavedfile);
			}
	

		//이전에 읽던 글로 리다이렉트
		return "redirect:read?num="+board.getBoardnum();
//		return"redirect:list";
	}
	
	//댓글 추가해서 저장
		@PostMapping("writeReply")
		public String writeReply(
				 Reply reply
				, @AuthenticationPrincipal UserDetails user
				, String memberid) {
			//폼에서 전달된 본문 글번호, 리플내용에 작성자 아이디 추가 저장
			reply.setMemberid(user.getUsername());
			//db에 저장
			service.writeReply(reply);
			//읽던 글로 되돌아감
			return "redirect:read?num="+reply.getBoardnum();
		}
	
	//댓글 삭제
		@GetMapping("deleteReply")
		public String deleteReply(
				Reply reply
				,@AuthenticationPrincipal UserDetails user
//				,@RequestParam(name="num",defaultValue="0") int replynum
				) {
			
//			지금 주석친 부분이 내가 한건데 이게 다 필요없음
//			String id = user.getUsername();
//			리플 번호 읽어옴
//			service.readReply(replynum);
//			
//			if(reply ==null) return"redirect:read?num="+reply.getBoardnum();			
//			if(!reply.getMemberid().equals(user.getUsername())) return"redirect:read?num="+reply.getBoardnum();
			
			//이게 멤버 네임 가져오는것
			reply.setMemberid(user.getUsername());
			int result = service.deleteReply(reply);
			log.debug("삭제되나?:{}",reply);
			
			return "redirect:read?num="+reply.getBoardnum();
		}
		
	
	
	

}
