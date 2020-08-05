package pl.coderslab.philabweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.philabweb.entities.User;

@Controller
public class HomeController {
    @GetMapping("")
    public String indexPage() {
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
