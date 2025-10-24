package com.smartworkWithApiandwebservice.Apiandwebservice.config;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;


@ControllerAdvice
public class GlobalController {


    @ModelAttribute
      public void addUserToModel(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
       
        model.addAttribute("user", loginUser);
    }
}
