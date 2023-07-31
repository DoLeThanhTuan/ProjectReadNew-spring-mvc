package com.dolethanhtuan.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dolethanhtuan.dto.UserDTO;
import com.dolethanhtuan.service.impl.UserService;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {
	
	@Autowired
	private UserService userService;
	@GetMapping(value = "/trang-chu")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	@GetMapping(value = "/dang-nhap")
	public ModelAndView dangNhapPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	@GetMapping(value = "/dang-ky")
	public ModelAndView dangkyPage() {
		return new ModelAndView("register");
	}
	@PostMapping(value = "/dang-ky")
	public ModelAndView dangky(@ModelAttribute UserDTO user) {
		String url = "";
		if(!user.getPassword().equals(user.getRepeat_password())) {
			url = "redirect:/dang-ky?wrongPassword";
		}
		else {
			user = userService.save(user);
			if(user == null) {
				url = "redirect:/dang-ky?existedUser";
			}
			else {
				url = "redirect:/dang-ky?registerSuccess";
			}
		}
		return new ModelAndView(url);
	}
	@GetMapping(value = "/thoat")
	public ModelAndView thoatPage(HttpServletRequest req,HttpServletResponse resp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
}
