//package com.phanmemquanly.controller.admin;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.phanmemquanly.domain.DonthuocDetail;
//import com.phanmemquanly.domain.Patient;
//import com.phanmemquanly.model.DonthuocDetailDto;
//import com.phanmemquanly.model.DonthuocDto;
//import com.phanmemquanly.model.PatientDto;
//import com.phanmemquanly.model.ThuocDto;
//import com.phanmemquanly.service.DonthuocDetailService;
//import com.phanmemquanly.service.DonthuocService;
//import com.phanmemquanly.service.PatientService;
//import com.phanmemquanly.service.ThuocService;
//
//@Controller
//@RequestMapping("/orderController")
//public class OrderControllerh {
//
//	@Autowired
//	private PatientService patientService;
//
//	@Autowired
//	private ThuocService thuocService;
//
//	@Autowired
//	private DonthuocService donthuocService;
//
//	@Autowired
//	private DonthuocDetailService donthuocDetailService;
//
//	@GetMapping("/load")
//	public ModelAndView showHome(@ModelAttribute("patient") PatientDto thePatient,
//			@RequestParam(name = "orderHeaderNumber", required = false) String donthuocNumber) {
//
//		ModelAndView model3 = new ModelAndView();
//
//		DonthuocDto oh = null;
//
//		List<DonthuocDetailDto> donthuocDetails;
//
//		List<String> orderStatusList = new ArrayList();
//
//		if (donthuocNumber == null) {
//
//			String nextOrderNumber = donthuocService.getNextDonthuocNumber();
//			oh = new DonthuocDto();
//
//			oh.setNumber(nextOrderNumber);
//
//			orderStatusList.add("New");
//
//		} else {
//			
//		    oh=donthuocService.getDonthuocByNumber(donthuocNumber);
//			
//			orderStatusList.clear();
//			orderStatusList.add("Proccessing");
//
//			donthuocDetails = donthuocDetailService.getOrderLineByOrderHeaderID(oh.getIdDonthuoc());
//			oh.setDonthuocDetailDtos(donthuocDetails.toArray(new DonthuocDetailDto[0]));
//
//		}
//
//		
//
//		List<PatientDto> patients = patientService.getPatient();
//
//		List<ThuocDto> thuocs = thuocService.getThuocs();
//
//		model3.setViewName("order");
//		model3.addObject("formdonthuoc", oh);
//		model3.addObject("orderStatusList", orderStatusList);
//		model3.addObject("thuocs", thuocs);
//		model3.addObject("patients", patients);
//
//		return model3;
//	}
//
//	@PostMapping("/saveOrderHeader")
//	public String saveOrderHeader(@ModelAttribute("formdonthuoc") DonthuocDto oh, BindingResult result,
//			ModelMap model) {
//		donthuocService.saveDonthuoc(oh);
//
//		return "redirect:/orderController/load?orderHeaderNumber=" + oh.getNumber();
//	}
//
//	@GetMapping("/delete")
//	public String deleteOrderLine(@RequestParam("orderLineId") int theId,
//			@RequestParam("orderHeaderNumber") String number) {
//
//		// delete the product
//		donthuocDetailService.deleteDonthuocDetail(theId);
//		
//		return "redirect:/orderController/load?orderHeaderNumber=" + number;
//	}
//
////	@GetMapping("/checkout")
////	public String checkoutOrder(@RequestParam("orderNumber") String orderNumber) {
////
////		List<String> orderStatusList = new ArrayList();
////		orderStatusList.clear();
////		orderStatusList.add("Complete");
////
////		orderHeaderService.checkout(orderNumber);
////
////		return "redirect:/orderController/load?orderHeaderNumber=" + orderNumber;
////	}
//}