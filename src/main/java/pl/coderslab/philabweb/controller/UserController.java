package pl.coderslab.philabweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.philabweb.dto.UserRegistrationDto;
import pl.coderslab.philabweb.service.UserService;

import java.security.Principal;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/myprofile")
    public String showMyUserProfile(Model model, Principal principal){
        model.addAttribute("user",userService.findUserByEmail(principal.getName()));
        return "user/profile";
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
    @GetMapping("/profile")
    public String showUserProfile(){
        return "user/profile";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, Principal principal) {
        model.addAttribute("userDTO",UserRegistrationDto.userToUserDTO(userService.findUserByEmail(principal.getName())));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String editUserAccount(Model model, UserRegistrationDto registrationDto) {
        userService.edit(registrationDto);
        model.addAttribute("user",userService.findUserbyId(registrationDto.getId()));
        return "redirect:/user/profile?success";
    }
}
