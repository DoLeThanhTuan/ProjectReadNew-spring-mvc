package com.dolethanhtuan.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		ArrayList<String> roles = new ArrayList<>();
		// Lấy danh sách vai trò của người dùng hiện tại
		for (GrantedAuthority authority: SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			roles.add(authority.getAuthority());
		}
		if(isAdmin(roles)) {
			url = "/quan-tri";
		}
		else {
			url = "/trang-chu";
		}
		return url;
	}
	
	public boolean isAdmin(ArrayList<String> roles) {
		return roles.contains("ADMIN");
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
}
