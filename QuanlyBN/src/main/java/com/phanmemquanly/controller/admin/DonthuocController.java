package com.phanmemquanly.controller.admin;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.domain.Item;
import com.phanmemquanly.domain.KhamBenh;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.domain.TiepNhan;
import com.phanmemquanly.model.KhamBenhDto;
import com.phanmemquanly.service.DonthuocDetailService;
import com.phanmemquanly.service.DonthuocService;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.ThuocService;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/donthuoc")
public class DonthuocController {
	@Autowired
	private PatientService patientService;

	@Autowired
	private DonthuocService donthuocService;

	@Autowired
	private DonthuocDetailService donthuocDetailService;

	@Autowired
	private ThuocService thuocService;

	@RequestMapping("list")
	public String listThuoc(ModelMap model) {
		List<Thuoc> list = thuocService.findAll();

		model.addAttribute("thuocs", list);
		return "admin/donthuoc/list";
	}
//
	@GetMapping("")
	public String Index(ModelMap modelMap,HttpSession session) {
//		modelMap.put("total", total(session));
		return "admin/donthuoc/form";
	}
//
	@GetMapping("add/{idThuoc}")
	public String add(@PathVariable("idThuoc") int idThuoc, HttpSession session) {
		if (session.getAttribute("donthuoc") == null) {
			List<Item> dto = new ArrayList<Item>();
			session.setAttribute("donthuoc", dto);
			
		} else {
			List<Item> dto = (List<Item>) session.getAttribute("donthuoc");
			int index = isExists(idThuoc, dto);
			if (index == -1) {
				dto.add(new Item(thuocService.getById(idThuoc), 1));

			} else {
				int sl = dto.get(index).getSoluong() + 1;
				dto.get(index).setSoluong(sl);

			}
			session.setAttribute("donthuoc", dto);
		}
		return "redirect:/admin/donthuoc";
	}
//
//
//
	@GetMapping("remove/{idThuoc}")
	public String remove(ModelMap model, @PathVariable("idThuoc") int idThuoc,
			HttpSession session) {
		List<Item> dto = (List<Item>) session.getAttribute("donthuoc");
		int index = isExists(idThuoc, dto);
		dto.remove(index);
		session.setAttribute("donthuoc", dto);
		return "redirect:/admin/donthuoc";
		
	}
	@PostMapping("update")
	public String update(HttpServletRequest request, HttpSession session) {
		String[] quantities= request.getParameterValues("soluong");
	    List<Item> dto = (List<Item>) session.getAttribute("donthuoc");
	    for(int i=0; i<dto.size();i++) {
	    	dto.get(i).setSoluong(Integer.parseInt(quantities[i]));
	    }
	    session.setAttribute("donthuoc", dto);
		return "redirect:/admin/donthuoc";
		
	}
//	@GetMapping("checkout")
//	public String checkout(HttpSession session){
//		//add new order
//		Donthuoc donthuoc= new Donthuoc();
//		donthuoc.setName("New order");
//		donthuoc.setNgayTao(new Date());
//		donthuoc.setStatus(false);
//		int idDonthuoc=donthuocService.create(donthuoc).getIdDonthuoc();
//	
//		//add order detail
//		List<Item> dto = (List<Item>) session.getAttribute("donthuoc");
//		for (Item item : dto) {
//			DonthuocDetail donthuocDetail= new DonthuocDetail();
//			donthuocDetail.setIdonthuocDetailid(new Don);
//			donthuocDetail.setSoluong(item.getSoluong());
//			donthuocDetailService.save(donthuocDetail);
//		}
//		// delete cart
//		session.removeAttribute("donthuoc");
//		return "admin/donthuoc/form";
//	}
//
	private int isExists(int id, List<Item> dto) {
		for (int i = 0; i < dto.size(); i++) {
			if (dto.get(i).getThuoc().getIdThuoc() == id) {
				return i;
			}
		}
		return -1;
	}
//	private double total(HttpSession session) {
//		List<Item> dto = (List<Item>) session.getAttribute("donthuoc");
//		double s=0;
//		if(dto!=null) {
//			for (Item Item : dto) {
//				s+=Item.getSoluong()*Item.getThuoc().getDongia();
//			}
//		}
//		return s;
//	}
	// Xem chi tiet benh an
		@GetMapping("toathuoc/{id}")
		public ModelAndView show(ModelMap model, @PathVariable("id") int idDonthuoc) {
			Optional<Donthuoc> optional = donthuocService.findById(idDonthuoc);
//			KhamBenhDto dto = new KhamBenhDto();
			Donthuoc entity = optional.get();
			model.addAttribute("donthuoc", entity);
			
			// hien thi danh sach thuoc trong don thuoc
			List<DonthuocDetail> list= donthuocDetailService.getDonthuocDetailbyDonthuoc(idDonthuoc);
			model.addAttribute("donthuocdetails", list);
			return new ModelAndView("admin/donthuoc/toathuoc", model);
		}
		// Xem chi tiet benh an
				@GetMapping("xetnghiem/{id}")
				public ModelAndView showXN(ModelMap model, @PathVariable("id") int idDonthuoc) {
					Optional<Donthuoc> optional = donthuocService.findById(idDonthuoc);
//					KhamBenhDto dto = new KhamBenhDto();
					Donthuoc entity = optional.get();
					model.addAttribute("donthuoc", entity);
					
					// hien thi danh sach thuoc trong don thuoc
					List<DonthuocDetail> list= donthuocDetailService.getDonthuocDetailbyDonthuoc(idDonthuoc);
					model.addAttribute("donthuocdetails", list);
					return new ModelAndView("admin/donthuoc/toathuoc", model);
				}
		@GetMapping("in/{id}")
		public ModelAndView print(ModelMap model, @PathVariable("id") int idDonthuoc) {
			Optional<Donthuoc> optional = donthuocService.findById(idDonthuoc);
//			KhamBenhDto dto = new KhamBenhDto();
			Donthuoc entity = optional.get();
			model.addAttribute("donthuoc", entity);
			
			// hien thi danh sach thuoc trong don thuoc
			List<DonthuocDetail> list= donthuocDetailService.getDonthuocDetailbyDonthuoc(idDonthuoc);
			model.addAttribute("donthuocdetails", list);
			return new ModelAndView("admin/form/toathuoc", model);
		}
		// Tra ve danh sach
		@RequestMapping("lists")
		public String list(ModelMap model) {
			List<Donthuoc> list = donthuocService.findAll();
			model.addAttribute("donthuocs", list);
			model.addAttribute("patients", patientService.findAll());
			return "admin/donthuoc/lists";
		}
		// Xoa du lieu kham benh
		@GetMapping("delete/{id}")
		public ModelAndView delete(ModelMap model, @PathVariable("id") int idDonthuoc) {
			donthuocService.deleteById(idDonthuoc);
			model.addAttribute("message", "Đơn thuốc đã được xóa!");
			return new ModelAndView("forward:/admin/donthuoc/lists", model);
		}
		
		// tim theo ten bac si
		@GetMapping("search")
		public String search(ModelMap model, @RequestParam(name = "bacsi", required = false)String bacsi) {
			List<Donthuoc> list = null;
			
			if (StringUtils.hasText(bacsi)) {
				 
				list =donthuocService.findByBacsi(bacsi);
				
			} else {
				list = donthuocService.findAll();
				model.addAttribute("message","Không tìm thấy thông tin");
			}
			model.addAttribute("donthuocs", list);
			return "admin/donthuoc/lists";
		}

}
