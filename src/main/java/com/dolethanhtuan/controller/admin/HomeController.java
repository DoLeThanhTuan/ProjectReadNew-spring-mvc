package com.dolethanhtuan.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dolethanhtuan.dto.CategoryDTO;
import com.dolethanhtuan.dto.NewDTO;
import com.dolethanhtuan.dto.PageDTO;
import com.dolethanhtuan.service.ICategoryService;
import com.dolethanhtuan.service.INewService;
import com.dolethanhtuan.util.message.messageUtil;

@Controller(value = "HomeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private messageUtil messUtil;
	
	
	@GetMapping(value = {"/quan-tri/trang-chu","/quan-tri"})
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
	@GetMapping(value = {"/accessDenied"})
	public ModelAndView deniedPage() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	@GetMapping(value = {"/quan-tri/new/danh-sach"})
	public ModelAndView listPage(@RequestParam(name = "index" , required = false) Integer index) {
		ModelAndView mav = new ModelAndView("admin/list");
		if(index == null) {
			index = 1;
		}
		PageDTO<NewDTO> pageDTO = newService.findAll(new PageRequest(index-1, 3));
		mav.addObject("page", pageDTO);
		return mav;
	}
	@GetMapping(value = {"/quan-tri/new/them","/quan-tri/new/chinh-sua"})
	public ModelAndView viewAdd(@RequestParam(name = "id",required = false) Long id,@RequestParam(name = "report",required = false) String report) {
		ModelAndView mav = new ModelAndView("admin/form");
		List<CategoryDTO> listCate = cateService.findAll();
		mav.addObject("listCate",listCate);
		NewDTO newDTO = new NewDTO();
		if(id != null && newService.findOneById(id)!= null)
			newDTO = newService.findOneById(id);
		mav.addObject("newDTO",newDTO);
		if(report != null) {
			Map<String,String> message = messUtil.getMessage(report);
			mav.addObject("report", report);
			mav.addObject("mess", message.get(report));
		}
		
		return mav;
	}
	
}
