package net.softsociety.spring5.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring5.dao.BoardDAO;
import net.softsociety.spring5.domain.Board;
import net.softsociety.spring5.domain.Reply;
import net.softsociety.spring5.util.PageNavigator;

@Service
public class BoardServiceImpl implements BoardService{

		@Autowired
		BoardDAO dao;
		
		@Override
		public int write(Board board) {
			int n = dao.write(board);
			return n;
		}
		
		
		
		@Override
		public PageNavigator getPageNavigator(
				int pagePerGroup, int countPerPage, int page, String type, String searchWord) {
			
			//검색대상과 검색어
			HashMap<String, String> map = new HashMap<>();
			map.put("type", type); 
			map.put("searchWord", searchWord);
			
			//검색결과 갯수
			int t = dao.total(map);
			
			//페이지 이동 링크수, 페이지당 글수, 현재페이지, 전체 글 수를 전달하여 객체 생성
			PageNavigator navi = 
					new PageNavigator(pagePerGroup, countPerPage, page, t);
			return navi;
		}

		//실제 실행되는건 여기서
		@Override
		public ArrayList<Board> list(int start, int count, String type, String searchWord) {
			//맵에 담아서 넘겨줄거임 검색대상과 검색어
			HashMap<String, String> map = new HashMap<>();//이부분 2.9 추가됨
			map.put("type", type); //html에서 넘어온걸 맵에 저장한다
			map.put("searchWord", searchWord);
			
			//조회 결과 중 위치, 개수 지정
			RowBounds rb = new RowBounds(start, count);
			
			//map하고 rb부분 추가
			ArrayList<Board> blist = dao.list(map,rb);
			return blist;
		}


		@Override
		public Board read(int num) {
			
			//글 정보 읽기
			Board board = dao.read(num);
			
			//조회수 1증가
			dao.add(num);
			
			return board;
		}



		@Override
		public int delete(Board board) {
			int n = dao.delete(board);
			return n;
		}



		@Override
//		내가한건데 컨트롤러에 리설트를 추가했기때문에 여기도 리설트 넣어야함
//		public int update(Board board) {
//			int n = dao.update(board);
//			return n;
//		}
		public int update(Board board) {
			int result = dao.update(board);
			return result;
		}



		@Override
		public int writeReply(Reply reply) {
			int n = dao.writeReply(reply);
			return n;
		}



		@Override
		public ArrayList<Reply> readReply(int num) {
			ArrayList<Reply> readReply= dao.readReply(num);
			return readReply;
		}



		@Override //여기가 틀렸는데 컨트롤러에 result넣어서 이렇게된듯 주석처리가 내가한거
		public int deleteReply(Reply reply) {
			int result = dao.deleteReply(reply);
//			int n = dao.deleteReply(reply);
			return result;
//			return n;
		}




		
		
		
		
		
		
		
		
		
		

		
		
		
		
		

		
		
		
		
		
		

		

		

		
		
		

		
		
		


		


}
