package com.phanmemquanly.controller.admin;

import java.sql.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.ServiceExam;
import com.phanmemquanly.domain.TiepNhan;
import com.phanmemquanly.model.PatientDto;
import com.phanmemquanly.model.ServiceExamDto;
import com.phanmemquanly.model.TiepNhanDto;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.ServiceExamService;
import com.phanmemquanly.service.TiepNhanService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("admin/tiepnhans")
public class TiepNhanController {
	@Autowired
	PatientService patientService;
	
	@Autowired
	ServiceExamService service;
	
	@Autowired
	TiepNhanService tiepnhanService;
	
	@ModelAttribute("patients")
	public List<PatientDto> getPatients(){
		return patientService.findAll().stream().map(item->{
			PatientDto dto= new PatientDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	@ModelAttribute("services")
	public List<ServiceExamDto> getServices(){
		return service.findAll().stream().map(item->{
			ServiceExamDto dto= new ServiceExamDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	
	@GetMapping("")
	public String add(Model model) {
		model.addAttribute("patient", new PatientDto());
		model.addAttribute("tiepnhan",new TiepNhanDto());	
		model.addAttribute("service", new ServiceExam());
		return "admin/tiepnhans/form";	
	}
	
	//Tiep nhan Benh nhan
		@GetMapping("{idBenhNhan}")
		public ModelAndView tiepnhans(ModelMap model, @PathVariable("idBenhNhan") int idBenhNhan) {
			Optional<Patient> optional = patientService.findById(idBenhNhan);
			PatientDto dto = new PatientDto();		
			Patient entity = optional.get();
			BeanUtils.copyProperties(entity, dto);				
			model.addAttribute("patient", dto);			
			model.addAttribute("tiepnhan",new TiepNhanDto());
			
			return new ModelAndView("admin/tiepnhans/form", model);
		
		}
	
	// Luu va chuyen huong den danh sach
		@PostMapping("saveOrUpdate")
		public ModelAndView saveOrUpdate(ModelMap model,
				@Valid @ModelAttribute("tiepnhan") TiepNhanDto dto,BindingResult result) {
			
//			//kiem tra validate
//			if(result.hasErrors()) {
//				return new ModelAndView("admin/tiepnhans/form");
//			}	
			TiepNhan entity = new TiepNhan();
			entity.setTrangThai(0);
			
			BeanUtils.copyProperties(dto, entity);
			long date = System.currentTimeMillis();
			entity.setNgayTN(new Date(date));
			//luu id benh nhan
			Patient patient = new Patient();
			patient.setIdBenhNhan(dto.getIdBenhNhan());
			entity.setPatient(patient);
			
			//luu id benh nhan
			ServiceExam serviceExam= new ServiceExam();		
			serviceExam.setIdService(dto.getIdService());
			entity.setService_exam(serviceExam);
			
			tiepnhanService.save(entity);

	
			return new ModelAndView("redirect:/admin/tiepnhans/list", model);
		}
		// xoa danh sach tiep nhan
		@GetMapping("delete/{idTiepNhan}")
		public ModelAndView delete(ModelMap model, @PathVariable("idTiepNhan") int idTiepNhan) {
			tiepnhanService.deleteById(idTiepNhan);
			model.addAttribute("message", "Bệnh nhân đã được xóa!");
			return new ModelAndView("forward:/admin/tiepnhans/list", model);
		}
		
		// Tra ve danh sach
		@RequestMapping("list")
		public String list(ModelMap model) {
			List<TiepNhan> list = tiepnhanService.findAll();

			model.addAttribute("tiepnhans", list);
			return "admin/tiepnhans/list";
		}

}
