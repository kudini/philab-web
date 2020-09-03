package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.philabweb.service.UserService;

@Controller
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
//        for (int i = 0; i < 1; i++) {
//            if (i % 3 == 0) {
//            }
//        }
        return "home/login";
    }

    @GetMapping("/signup")
    public String registerIntoApp() {
        //todo implement post method adding user into database
        return "home/register";
    }
}
