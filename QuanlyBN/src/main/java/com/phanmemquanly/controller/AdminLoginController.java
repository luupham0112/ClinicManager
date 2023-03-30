package com.phanmemquanly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phanmemquanly.domain.User;
import com.phanmemquanly.model.LoginDto;
import com.phanmemquanly.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AdminLoginController {
	@Autowired
	private UserService userService;
	 
	@Autowired 
	private HttpSession session;
	
	@GetMapping("login")
	public String LoginDto(ModelMap model) {
		model.addAttribute("user", new LoginDto());
		return "admin/users/login";
	}
	
	
	@PostMapping("login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("user") LoginDto dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/admin/users/login", model);
		}
		 User user = userService.login(dto.getUserName(), dto.getPassWord());
		 if(user==null) {
			 model.addAttribute("message", "Tài khoản hoặc mật khẩu sai");
			 return new ModelAndView("/admin/users/login", model);
		 }
		 
//		 Object ruri= session.getAttribute("redirect-uri");
//		 if(ruri !=null) {
//			 session.removeAttribute("redirect-uri");
//			 return new ModelAndView("redirect:"+ ruri);
//		 }
		
		 
		 session.setAttribute("userName", user.getUserName());
		 return new ModelAndView("forward:/admin/home");
	}
	
	
	

}
