//package com.phanmemquanly.controller.admin;
//
//import java.security.Principal;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.phanmemquanly.domain.Cart;
//import com.phanmemquanly.domain.Thuoc;
//import com.phanmemquanly.service.CartService;
//import com.phanmemquanly.service.ThuocService;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//@Controller
//@RequestMapping("admin")
//public class CartController {
////	 @Autowired
////	    private CustomerService customerService;
//
//	    @Autowired
//	    private CartService cartService;
//
//	    @Autowired
//	    private ThuocService thuocService;
//
//	    @GetMapping("donthuocs")
//	    public String cart(Model model, HttpSession session){     
//	        Cart cart = new Cart();
//	        if(cart == null){
//	            model.addAttribute("check", "No item in your cart");
//	        }
//	        session.setAttribute("totalItems", cart.getTotalItems());
//	        model.addAttribute("subTotal", cart.getTotalPrices());
//	        model.addAttribute("shoppingCart", cart);
//	        return "admin/donthuoc/form2";
//	    }
//
//
//	    @PostMapping("/add-to-cart")
//	    public String addItemToCart(
//	            @RequestParam("id") int idThuoc,
//	            @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,         
//	            HttpServletRequest request){
//
//	        Thuoc thuoc = thuocService.findById(idThuoc);
//	    
//	        ShoppingCart cart = cartService.addItemToCart(thuoc, quantity);
//	        return "redirect:" + request.getHeader("Referer");
//
//	    }
//
//
////	    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=update")
////	    public String updateCart(@RequestParam("quantity") int quantity,
////	                             @RequestParam("id") Long ThuocId,
////	                             Model model,
////	                             Principal principal
////	                             ){
////
////	        if(principal == null){
////	            return "redirect:/login";
////	        }else{
////	            String username = principal.getName();
////	            Customer customer = customerService.findByUsername(username);
////	            Thuoc Thuoc = ThuocService.getThuocById(ThuocId);
////	            ShoppingCart cart = cartService.updateItemInCart(Thuoc, quantity, customer);
////
////	            model.addAttribute("shoppingCart", cart);
////	            return "redirect:/cart";
////	        }
////
////	    }
////
////
////	    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=delete")
////	    public String deleteItemFromCart(@RequestParam("id") Long ThuocId,
////	                                     Model model,
////	                                     Principal principal){
////	        if(principal == null){
////	            return "redirect:/login";
////	        }else{
////	            String username = principal.getName();
////	            Customer customer = customerService.findByUsername(username);
////	            Thuoc Thuoc = ThuocService.getThuocById(ThuocId);
////	            ShoppingCart cart = cartService.deleteItemFromCart(Thuoc, customer);
////	            model.addAttribute("shoppingCart", cart);
////	            return "redirect:/cart";
////	        }
////
////	    }
////
//
//
//
//}
