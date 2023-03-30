package com.phanmemquanly.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.phanmemquanly.domain.KhamBenh;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.domain.TiepNhan;
import com.phanmemquanly.model.KhamBenhDto;
import com.phanmemquanly.model.PatientDto;
import com.phanmemquanly.model.TiepNhanDto;
import com.phanmemquanly.service.KhamBenhService;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.TiepNhanService;
import com.phanmemquanly.util.FileUploadUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/khambenhs")
public class KhamBenhController {
	
	@Autowired
	PatientService patientService;

	@Autowired
	TiepNhanService tiepnhanService;

	@Autowired
	KhamBenhService khamBenhService;

	@ModelAttribute("patients")
	public List<PatientDto> getPatients() {
		return patientService.findAll().stream().map(item -> {
			PatientDto dto = new PatientDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}

	// hien thi form kham benh
	@GetMapping("")
	public String add(Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("patients", patientService.findAll());// luu y
		model.addAttribute("khambenh", new KhamBenhDto());
		return "admin/khambenhs/form";
	}

	// kham benh
	@GetMapping("{idBenhNhan}")
	public ModelAndView tiepnhans(ModelMap model, @PathVariable("idBenhNhan") int idBenhNhan) {
		Optional<Patient> optional = patientService.findById(idBenhNhan);

		PatientDto dto = new PatientDto();
		Patient entity = optional.get();// lay doi tuong benh nhan theo id
		BeanUtils.copyProperties(entity, dto);

		// an benh nhan khoi danh sach cho
		Optional<TiepNhan> opt = tiepnhanService.findById(idBenhNhan);
		TiepNhan tiepNhan = opt.get();
		tiepNhan.setTrangThai(1);
		tiepnhanService.save(tiepNhan);

		model.addAttribute("patient", dto);
		model.addAttribute("khambenh", new KhamBenhDto());
		return new ModelAndView("admin/khambenhs/form", model);
	}


	@PostMapping("saveOrUpdate")
	public String saveOrUpdate(@Valid @ModelAttribute("khambenh") KhamBenhDto dto,
			BindingResult result, 
			@RequestParam("ketqua")MultipartFile[] filemultipaths
			) throws IOException {

//				//kiem tra validate
//				if(result.hasErrors()) {
//					return new ModelAndView("admin/tiepnhans/form");
//				}	
		KhamBenh entity = new KhamBenh();
		BeanUtils.copyProperties(dto, entity);
		//luu ngay kham benh
		long date = System.currentTimeMillis();
		entity.setNgayKB(new Date(date));
		
		
		// luu id benh nhan
		Patient patient = new Patient();
		patient.setIdBenhNhan(dto.getIdBenhNhan());
		entity.setPatient(patient);
		
		// luu file anh
		int count =0;
		for (MultipartFile multipartFile : filemultipaths) {
			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			if(count==0) entity.setKetqua1(fileName);
			if(count==1) entity.setKetqua2(fileName);
			if(count==2) entity.setKetqua3(fileName);
			if(count==3) entity.setKetqua4(fileName);
			count++;
		}
		
		KhamBenh saveKB= khamBenhService.save(entity);
		String uploadDir="/imageKetqua/"+ saveKB.getIdKhamBenh();
		
		for (MultipartFile multipartFiles : filemultipaths) {
			String fileNames= StringUtils.cleanPath(multipartFiles.getOriginalFilename());
			FileUploadUtil.saveFile(uploadDir, multipartFiles, fileNames);
		}
		
		return "redirect:/admin/khambenhs/list";

	}

	// Tra ve danh sach
	@RequestMapping("list")
	public String list(ModelMap model) {
		List<KhamBenh> list = khamBenhService.findAll();
		model.addAttribute("khambenhs", list);
		model.addAttribute("patients", patientService.findAll());
		return "admin/khambenhs/list";
	}

	// Xoa du lieu kham benh
	@GetMapping("delete/{idKhamBenh}")
	public ModelAndView delete(ModelMap model, @PathVariable("idKhamBenh") int idKhamBenh) {
		khamBenhService.deleteById(idKhamBenh);
		model.addAttribute("message", "Bệnh án đã được xóa!");
		return new ModelAndView("forward:/admin/khambenhs/list", model);
	}
	
	// Xem chi tiet benh an
	@GetMapping("benhan/{id}")
	public ModelAndView show(ModelMap model, @PathVariable("id") int idKhamBenh) {
		Optional<KhamBenh> optional = khamBenhService.findById(idKhamBenh);
		KhamBenhDto dto = new KhamBenhDto();
		KhamBenh entity = optional.get();
		model.addAttribute("khambenh", entity);
		return new ModelAndView("admin/khambenhs/benhan", model);
	}
	@GetMapping("xetnghiem/{id}")
	public ModelAndView showXN(ModelMap model, @PathVariable("id") int idKhamBenh) {
		Optional<KhamBenh> optional = khamBenhService.findById(idKhamBenh);
		KhamBenhDto dto = new KhamBenhDto();
		KhamBenh entity = optional.get();
		model.addAttribute("khambenh", entity);
		return new ModelAndView("admin/khambenhs/xetnghiem", model);
	}

	@GetMapping("in/{id}")
	public ModelAndView print(ModelMap model, @PathVariable("id") int idKhamBenh) {
		Optional<KhamBenh> optional = khamBenhService.findById(idKhamBenh);
		KhamBenhDto dto = new KhamBenhDto();
		KhamBenh entity = optional.get();
		model.addAttribute("khambenh", entity);
		return new ModelAndView("admin/form/benhan", model);
	}
//	@GetMapping("list")
//	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
//		Pageable pageable= PageRequest.of(p.orElse(0),9);
//		Page<KhamBenh> kPage= khamBenhService.findAll(pageable);
//		model.addAttribute("khambenhpage", kPage);
//		model.addAttribute("first",0);
//		return "admin/khambenhs/list";
//		
//	}
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "bacsi", required = false)String bacsi) {
		List<KhamBenh> list = null;
		
		if (StringUtils.hasText(bacsi)) {
			 
			list = khamBenhService.findByBacSi(bacsi);
			
		} else {
			list = khamBenhService.findAll();
			model.addAttribute("message","Không tìm thấy thông tin");
		}
		model.addAttribute("khambenhs", list);
		return "admin/khambenhs/list";
	}

}
