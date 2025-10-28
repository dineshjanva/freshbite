package com.smartworkWithApiandwebservice.Apiandwebservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Cart;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Contact;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Product;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.ContactService;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.ProductService;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.CartService;
import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;




@Controller
public class HomeWebController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products =productService.top4();
        model.addAttribute("products",products);
        return "index";
    }
    @GetMapping("offer")
    public String offer() {
        return "offers";
    }
    @GetMapping("about")
    public String about() {
        return "about";
    }
    @GetMapping("/error")
    public String error() {
        return "error";
    }
    
    @GetMapping("contact")
    public String contact(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("contact")
    public String contectdata(@Valid @ModelAttribute Contact contact, BindingResult br,Model model,RedirectAttributes ra) {
        // System.out.println(entity);
        if(br.hasErrors()){
            model.addAttribute("contact", contact);
            return "contact";
        }
        System.out.println(contact);
        contactService.savefeedback(contact);
        return "redirect:/contact";
    }
   
    
    @GetMapping("menu")
    public String menu(@RequestParam(required = false) String search,@RequestParam(required = false, defaultValue = "all") String category,Model model) {
        List<String> categories = List.of("all", "burger", "pizza", "sushi", "salad", "dessert", "drink");
        model.addAttribute("categories", categories);
        model.addAttribute("selectedCategory", category != null ? category : "all");
       System.out.println(category);
        // List<MenuItem> items;
      if (search != null && !search.isEmpty()) {
            model.addAttribute("search",search);
            return "menu";
      }
       else if (!"all".equalsIgnoreCase(category)) {
        }
        else{
            System.out.println("All");
        }
    List<Product> products=productService.findAll();
    model.addAttribute("products", products);
    return "menu";
    } 


    @GetMapping("profile")
    public String profile(HttpSession session,Model model) {
        if(session.getAttribute("loginUser")==null){
            return "redirect:/login";
        }
        User user=(User) session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("cart")
    public String cart(HttpSession session,Model model) {
        User loginuser = (User) session.getAttribute("loginUser");
        List<Cart> cart=cartService.findByUserId(loginuser.getId()); 
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("cart")
    public String cartData(@RequestParam long id,HttpSession session) {
        // System.out.println(id);
        Object loginObject= session.getAttribute("loginUser");
        if(loginObject==null){
            return "redirect:/login";
        }
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/menu";
        }
        // System.out.println(product.getDiscountPrice());
        User userId = (User) loginObject;
       
        cartService.addProductToCart(userId, product, 1);
        return "redirect:/cart";
    }
    
  
    

    // @GetMapping("")
    // public String getMethodName(@RequestParam String param) {
    //     return new String();
    // }
    
    
    
}
