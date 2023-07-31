package com.dolethanhtuan.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUserDTO extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyUserDTO(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	private String fullname;
	
	public MyUserDTO(String fullname,String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.fullname = fullname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
}
