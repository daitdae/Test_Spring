package net.softsociety.spring5.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails{
	
	 String memberid;   	//사용자 식별 ID 
	 String memberpw; 		//비밀번호
	 String membername;		//사용자 이름
	 String email;    		//이메일주소
	 String phone;	 		//전화번호
	 String address;		//주소
	 boolean enabled;		//계정 상태(숫자 1:사용가능 0:불가능)
	 String rolename;		//Role(회원등급)('ROLE_USER':일반회원,'ROLE_ADMIN':관리자)
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getPassword() {
		return memberpw;
	}
	@Override
	public String getUsername() {
		return memberid;
	}
	
	@Override
	public boolean isEnabled() {	//써도 되는지 체크하기 위해 넣음
		return enabled;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	 
	 
}
