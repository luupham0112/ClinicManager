package com.phanmemquanly.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yaml.snakeyaml.serializer.Serializer;

import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.ServiceExam;
import com.phanmemquanly.model.PatientDto;

import com.phanmemquanly.model.ServiceExamDto;
import com.phanmemquanly.service.DonthuocService;
import com.phanmemquanly.service.KhamBenhService;
import com.phanmemquanly.service.PatientService;

import com.phanmemquanly.service.ServiceExamService;

@Controller
@RequestMapping("admin/service")
public class ServiceController {
	
	@Autowired
	private ServiceExamService serviceExamService;
	
	
	

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("service", new ServiceExamDto());
		return "admin/service/form";
	}

	// Luu va chuyen huong den danh sach
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,  @ModelAttribute("service") ServiceExamDto dto) {

		ServiceExam entity = new ServiceExam();

		BeanUtils.copyProperties(dto, entity);

		serviceExamService.save(entity);

		return new ModelAndView("redirect:/admin/service/list", model);
	}

	// Sua thong tin
	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") int idService) {
		Optional<ServiceExam> optional = serviceExamService.findById(idService);
		ServiceExamDto dto= new ServiceExamDto();
		
		if (optional.isPresent()) {
			ServiceExam entity = optional.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("service", dto);
			return new ModelAndView("admin/service/form", model);
		}
		
		return new ModelAndView("redirect:/admin/service/list", model);
	}

	// Tra ve danh sach
	@RequestMapping("list")
	public String list(ModelMap model) {
	    List<ServiceExam> list= serviceExamService.findAll();
		model.addAttribute("services", list);
		return "admin/service/list";
	}
	// Xoa du lieu
	@GetMapping("delete/{idService}")
	public ModelAndView delete(ModelMap model, @PathVariable("idService") int idService) {
		serviceExamService.deleteById(idService);
		
		return new ModelAndView("redirect:/admin/service/list", model);
	}

}
