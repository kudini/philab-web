package pl.coderslab.philabweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.philabweb.repositories.UserRepository;
import pl.coderslab.philabweb.entities.User;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("")
    public String indexPage() {
        return "index";
    }
    @GetMapping("/test")
    public String testPage() {
        userRepository.save(new User().setEmail("aaaa").setFirstName("Adam").setLastName("Nowak").setPassword("aaaaa"));
        return "index";
    }

    @GetMapping("/login")
    public String loginIntoApp() {
        for (int i = 0; i < 1; i++) {
            if (i % 3 == 0) {
            }
        }

        return "login";
    }

    @GetMapping("/signup")
    public String registerIntoApp() {
        return "register";
    }
}
