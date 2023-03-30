package com.phanmemquanly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phanmemquanly.domain.TiepNhan;
import com.phanmemquanly.service.DonthuocService;
import com.phanmemquanly.service.KhamBenhService;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.ThuocService;
import com.phanmemquanly.service.TiepNhanService;

@Controller
@RequestMapping("admin")
public class HomeController {
	
	@Autowired
	ThuocService thuocService;
	
	@Autowired
	PatientService patientService;
	@Autowired
	DonthuocService donthuocService;
	
	@Autowired
	KhamBenhService khamBenhService;
	
	@RequestMapping("home")
	public String showForm(Model model) {
		long patient= patientService.count();
		model.addAttribute("numberPatient", patient);
		long thuoc= thuocService.count();
		model.addAttribute("numberThuoc", thuoc);
		long benhan= khamBenhService.count();
		model.addAttribute("numberBenhan", benhan);
		
		
		return "admin/home";
	}
	

}
