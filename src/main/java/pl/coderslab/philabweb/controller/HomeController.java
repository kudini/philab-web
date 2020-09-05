package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.service.UserService;

import java.security.Principal;

@Controller
@SessionAttributes("user")
public class HomeController {
    UserService userService;
    public User userDetails(Principal principal) {
        return userService.findUserByEmail("anna");
    }
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String indexPage(Model model,Principal principal) {
        if (principal!=null){
            model.addAttribute("user",userService.findUserByEmail(principal.getName()));
        }
        return "home/index";
    }

    @GetMapping("/aboutus")
    public String aboutUs(){
        return "home/about_us";
    }

    @GetMapping("/login")
    public String loginIntoApp() {
        return "home/login";
    }
    @GetMapping("/test")
//    @ModelAttribute("user")
    public String loginAddData(){
//        model.addAttribute("user",userService.findUserByEmail(principal.getName()));
        return "test";
    }
}
