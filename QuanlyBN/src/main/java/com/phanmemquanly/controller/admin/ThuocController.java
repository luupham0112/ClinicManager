package com.phanmemquanly.controller.admin;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.ThuocDto;
import com.phanmemquanly.service.ThuocService;

@Controller
@RequestMapping("admin/thuocs")
//Thêm thuốc
public class ThuocController {
	@Autowired
	ThuocService thuocService;
	
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("thuoc",new ThuocDto());	
		return "admin/thuocs/form";	
	}
	
   //Sửa thông tin	
	@GetMapping("edit/{idThuoc}")
	public ModelAndView edit(ModelMap model, @PathVariable("idThuoc") int idThuoc) {
		Optional<Thuoc> optional = thuocService.findById(idThuoc);
		ThuocDto dto= new ThuocDto();
		
		if(optional.isPresent()) {
			Thuoc entity =optional.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("thuoc", dto);
		
			return new ModelAndView("admin/thuocs/form",model);
		}
		model.addAttribute("message","Thuốc đã được lưu");
		return new ModelAndView("redirect:/thuocs",model);
		
	}

	
	// Xoa du lieu
	@GetMapping("delete/{idThuoc}")
	public ModelAndView delete(ModelMap model, @PathVariable("idThuoc") int idThuoc) {
		thuocService.deleteById(idThuoc);
		model.addAttribute("message", "Thuốc đã được xóa!");
		return new ModelAndView("redirect:/admin/thuocs/searchpage",model)	;
	}
	
	//Lưu và chuyển hướng đến trang danh sách
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, ThuocDto dto) {
		Thuoc entity = new Thuoc();
		
		BeanUtils.copyProperties(dto, entity);
			
		thuocService.save(entity);
		
		model.addAttribute("message", "Thuốc đã được lưu!");
		return new ModelAndView( "redirect:/admin/thuocs/searchpage",model);	
	}
	// Trả về danh sách thuốc
	@RequestMapping("searchpage")
	public String list(ModelMap model) {
		List<Thuoc> list = thuocService.findAll();
		
		model.addAttribute("thuocs",list);	
		return "admin/thuocs/searchpage";	
	}
	
//	// Tìm kiếm thuốc theo tên
//	
//	@GetMapping("search")
//	public String search(ModelMap model, @RequestParam(name = "nameThuoc",required=false) String nameThuoc) {
//		List<Thuoc> list=null;
//		
//		if(StringUtils.hasText(nameThuoc)) {
//			list=thuocService.findByNameThuocContaining(nameThuoc);
//		}
//		else {
//			list=thuocService.findAll();
//		}
//		model.addAttribute("thuocs", list);
//		return "admin/thuocs/list";	
//	}
	
//	Phân trang
	@GetMapping("searchpage")
	public String search(ModelMap model,
			@RequestParam(name = "nameThuoc",required=false) String nameThuoc,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage=page.orElse(1);
		int pageSize=size.orElse(5);
		Pageable pageable =PageRequest.of(currentPage -1, pageSize/*,Sort.by("nameThuoc")*/);
		Page<Thuoc> resultPage = null;
		if(StringUtils.hasText(nameThuoc)) {
			resultPage=thuocService.findByNameThuocContaining(nameThuoc, pageable);
		}
		else {
			resultPage=thuocService.findAll(pageable);
		}
		int totalPages = resultPage.getTotalPages();
		if(totalPages>0) {
			int start = Math.max(1, currentPage -2);
			int end = Math.min(currentPage+2, totalPages);
			if(totalPages>1) {
				if(end==totalPages) {
					start=end-5;
				} else if(start==1){
					end=start +5;			
				}
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		model.addAttribute("thuocPage", resultPage);
		return "admin/thuocs/searchpage";	
	}
	
	

}
