package com.phanmemquanly.controller;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phanmemquanly.domain.User;
import com.phanmemquanly.model.UserDto;
import com.phanmemquanly.service.UserService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("register")
public class RegisterController {
	@Autowired
	UserService userService;
	
	// Them tai khoan
	@GetMapping("")
	public String add(Model model) {
		model.addAttribute("user",new UserDto());	
		return "admin/users/register";	
	}
	
	//Lưu và chuyển hướng đến trang danh sách
		@PostMapping("saveOrUpdate")
		public ModelAndView saveOrUpdate(ModelMap model,
				@Valid @ModelAttribute("user") UserDto dto, BindingResult result) {
			//kiem tra validate
			if(result.hasErrors()) {
				return new ModelAndView("admin/users/register");
			}	
			User entity = new User();
			
			BeanUtils.copyProperties(dto, entity);
				
			userService.save(entity);
			model.addAttribute("message", "Tai khoan da duoc luu");
			return new ModelAndView( "redirect:/login",model);	
			
		}

}
