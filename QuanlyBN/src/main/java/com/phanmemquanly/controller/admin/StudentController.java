package com.phanmemquanly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class StudentController {
	@GetMapping("hello")
	public String showForm(ModelMap model) {
		model.addAttribute("message", "<h3>Hello he</h3>");
		return "hello";
	}
	

}
