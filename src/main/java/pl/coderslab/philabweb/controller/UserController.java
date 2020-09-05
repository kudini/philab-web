package pl.coderslab.philabweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.philabweb.dto.UserRegistrationDto;
import pl.coderslab.philabweb.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/myprofile")
    public String showMyUserProfile(Model model, Principal principal){
        model.addAttribute("user",userService.findUserByEmail(principal.getName()));
        return "user/profile";
    }
    @GetMapping("/profile")
    public String showUserProfile(){
        return "user/profile";
    }

    @GetMapping("/edit")
    public String showEditForm() {
        return "user/edit";
    }

    @PostMapping("/edit")
    public String editUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/profile?success";
    }
}
