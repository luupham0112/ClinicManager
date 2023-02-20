package com.phanmemquanly.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.PatientDto;
import com.phanmemquanly.model.ThuocDto;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.ThuocService;

@Controller
@RequestMapping("patients")
public class PatientController {
	// Them benh nhan
	@Autowired
	PatientService patientService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("patient", new PatientDto());
		return "admin/patients/form";
	}

	// Luu va chuyen huong den danh sach
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, PatientDto dto) {
		Patient entity = new Patient();

		BeanUtils.copyProperties(dto, entity);

		patientService.save(entity);

		model.addAttribute("message", "Bệnh nhân đã được lưu! ");
		return new ModelAndView("forward:/patients/list", model);
	}

	// Sua thong tin
	@GetMapping("edit/{idBenhNhan}")
	public ModelAndView edit(ModelMap model, @PathVariable("idBenhNhan") int idBenhNhan) {
		Optional<Patient> optional = patientService.findById(idBenhNhan);
		PatientDto dto = new PatientDto();
		if (optional.isPresent()) {
			Patient entity = optional.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("patient", dto);
			return new ModelAndView("admin/patients/form", model);
		}
		model.addAttribute("message", "Bệnh nhân khong ton tai");
		return new ModelAndView("redirect:/patients", model);
	}

	// Tra ve danh sach
	@RequestMapping("list")
	public String list(ModelMap model) {
		List<Patient> list = patientService.findAll();

		model.addAttribute("patients", list);
		return "admin/patients/list";
	}

	// Xoa du lieu
	@GetMapping("delete/{idBenhNhan}")
	public ModelAndView delete(ModelMap model, @PathVariable("idBenhNhan") int idBenhNhan) {
		patientService.deleteById(idBenhNhan);
		model.addAttribute("message", "Bệnh nhân đã được xóa!");
		return new ModelAndView("forward:/patients/list", model);
	}

	// Tìm kiếm thuốc theo tên

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "hotenBN", required = false) String hotenBN) {
		List<Patient> list = null;

		if (StringUtils.hasText(hotenBN)) {
			list = patientService.findByHotenBNContaining(hotenBN);
		} else {
			list = patientService.findAll();
		}
		model.addAttribute("patients", list);
		return "admin/patients/list";
	}

}
