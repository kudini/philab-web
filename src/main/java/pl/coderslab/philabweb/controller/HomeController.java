package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.philabweb.service.UserService;

@Controller
@SessionAttributes("user")
public class HomeController {
    UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String indexPage() {
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
}
