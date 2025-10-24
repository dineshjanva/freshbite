package com.smartworkWithApiandwebservice.Apiandwebservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import com.smartworkWithApiandwebservice.Apiandwebservice.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("page", "login");
        return "login";
    }

    @PostMapping("login")
    public String loginData(@RequestParam String email,
    @RequestParam String password, 
    HttpSession session,
    // BindingResult br,
    RedirectAttributes redirectAttributes) {

        User user = userService.findByEmail(email);

        if(user==null){
            redirectAttributes.addFlashAttribute("errorMessage","No user found with this email!");
            return "redirect:/login";
        }
        if(!user.getPassword().equals(password)){
             redirectAttributes.addFlashAttribute("errorMessage", "Invalid password!");
        return "redirect:/login";
        }

        session.setAttribute("loginUser", user);
        redirectAttributes.addFlashAttribute("successMessage", "Welcome " + user.getFirstName() + "!");
        return "redirect:/";
    }
    
    @GetMapping("register")
    public String register(Model model) {
          model.addAttribute("page", "register");
          model.addAttribute("user", new User());
        return "register";
    }
    
    
    @PostMapping("/register")
    public String registerData(@Valid @ModelAttribute("user") User user, BindingResult br, Model model, RedirectAttributes redirectAttributes,HttpSession session) {

    if(br.hasErrors()){
        model.addAttribute("user",user);
        return "register";
    }

    userService.createUser(user);
    session.setAttribute("loginUser", user);
    redirectAttributes.addFlashAttribute("successMessage", "User register successfully!");

    return "redirect:/home";
}

@GetMapping("home")
public String getMethodName(Model model,HttpSession session) {
    Object loginauserObject=session.getAttribute("loginUser");
    if(loginauserObject==null){
        return "redirect:/login";
    }
    model.addAttribute("userLogin",loginauserObject);
    return "home";
}


@GetMapping("logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
}





// @PostMapping("register")
// public String registerdata(@ModelAttribute User user,Model model) {
//     try {
//     userService.saveUser(user);
//     model.addAttribute("successMessage", "User registered successfully!");
//     return "register"; 
// } catch (DataIntegrityViolationException e) {
//     // This is triggered on duplicate key (email or phone)
//     model.addAttribute("errorMessage", "Email or Phone already exists!");
//     model.addAttribute("user", user); // so user data stays in the form
//     return "register"; // send back to form
// }

// }

//     @PostMapping("/register")
// public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
//     try {
//         userService.saveUser(user);
//         redirectAttributes.addFlashAttribute("successMessage", "User registered successfully!");
//         return "redirect:/register"; // Redirect to the same page to show success
//     } catch (DuplicateFormatFlagsException e) {
//         redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
//         return "redirect:/register"; // Redirect back with error
//     } catch (Exception e) {
//         redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong!");
//         return "redirect:/register";
//     }
// }
}
