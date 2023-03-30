package com.phanmemquanly.controller.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.KhamBenh;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.PatientDto;
import com.phanmemquanly.model.ThuocDto;
import com.phanmemquanly.service.DonthuocService;
import com.phanmemquanly.service.KhamBenhService;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.ThuocService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/patients")
public class PatientController {
	// Them benh nhan
	@Autowired
	PatientService patientService;

	@Autowired
	KhamBenhService khamBenhService;
	
	@Autowired
	DonthuocService donthuocService;

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("patient", new PatientDto());
		return "admin/patients/form";
	}

	// Luu va chuyen huong den danh sach
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("patient") PatientDto dto,
			BindingResult result) {

		// kiem tra validate
		if (result.hasErrors()) {
			return new ModelAndView("admin/patients/form");
		}
		Patient entity = new Patient();
		
		BeanUtils.copyProperties(dto, entity);
		patientService.save(entity);
		model.addAttribute("message", "Bệnh nhân đã được lưu! ");
		return new ModelAndView("forward:/admin/patients/list", model);
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
		return new ModelAndView("redirect:/admin/patients", model);
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
		return new ModelAndView("forward:/admin/patients/list", model);
	}

	// Tìm kiếm thuốc theo tên

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "hotenBN", required = false) String hotenBN) {
		List<Patient> list = null;

		if (StringUtils.hasText(hotenBN)) {
			list = patientService.findByHotenBNContaining(hotenBN);
		} else {
			model.addAttribute("message1","Không tìm thấy thông tin");
			list = patientService.findAll();
		}
		model.addAttribute("patients", list);
		return "admin/patients/list";
	}

////	Phân trang
//	@GetMapping("searchpage")
//	public String search(ModelMap model,
//			@RequestParam(name = "hotenBN",required=false) String hotenBN,
//			@RequestParam("page") Optional<Integer> page,
//			@RequestParam("size") Optional<Integer> size) {
//		int currentPage=page.orElse(1);
//		int pageSize=size.orElse(5);
//		Pageable pageable =PageRequest.of(currentPage -1, pageSize/*,Sort.by("nameThuoc")*/);
//		Page<Patient> resultPage = null;
//		if(StringUtils.hasText(hotenBN)) {
//			resultPage=patientService.findByHotenBNContaining(hotenBN, pageable);
//		}
//		else {
//			resultPage=patientService.findAll(pageable);
//		}
//		int totalPages = resultPage.getTotalPages();
//		if(totalPages>0) {
//			int start = Math.max(1, currentPage -2);
//			int end = Math.min(currentPage+2, totalPages);
//			if(totalPages>1) {
//				if(end==totalPages) {
//					start=end-5;
//				} else if(start==1){
//					end=start +5;			
//				}
//			}
//			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
//					.boxed()
//					.collect(Collectors.toList());
//			model.addAttribute("pageNumbers", pageNumbers);
//		}
//		model.addAttribute("patientPage", resultPage);
//		return "admin/thuocs/list";	
//	}

	// xem chi tiet benh nhan
	@GetMapping("view/{idBenhNhan}")
	public String getProductsInCategory(@PathVariable("idBenhNhan") int idBenhNhan, Model model) {
		Optional<Patient> optional = patientService.findById(idBenhNhan);
		PatientDto dto = new PatientDto();

		Patient entity = optional.get();
		BeanUtils.copyProperties(entity, dto);

		model.addAttribute("patient", dto);
		// hien thi danh sach benh an
		List<KhamBenh> lists = khamBenhService.getKhambenhinPatient(idBenhNhan);
		model.addAttribute("khambenhs", lists);
		
		// hien thi danh sach don thuoc
		List<Donthuoc> list= donthuocService.getDonthuocinPatient(idBenhNhan);
		model.addAttribute("donthuocs", list);
		return "admin/patients/chitietbn";
	}

}
