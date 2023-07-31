package com.dolethanhtuan.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dolethanhtuan.dto.MyUserDTO;

public class SecurityUtils {
	
	public static MyUserDTO getCurrentUser() {
		MyUserDTO user = (MyUserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}