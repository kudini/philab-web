package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.philabweb.entities.DateAndTime;
import pl.coderslab.philabweb.entities.DynamicMessage;
import pl.coderslab.philabweb.entities.Message;
import pl.coderslab.philabweb.service.DynamicMessageService;
import pl.coderslab.philabweb.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"user", "date_time"})
public class HomeController {
    private UserService userService;
    private DynamicMessageService dynamicMessageService;
    private DateAndTime dateAndTime = new DateAndTime();

    public HomeController(UserService userService, DynamicMessageService dynamicMessageService) {
        this.dynamicMessageService = dynamicMessageService;
        this.userService = userService;
    }

    @GetMapping("")
    public String indexPage(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("user", userService.findUserByEmail(principal.getName()));
            model.addAttribute("date_time", dateAndTime);
        }
        return "home/index";
    }

    @GetMapping("/aboutus")
    public String aboutUs(Model model) {
        DynamicMessage message = dynamicMessageService.findOneByName("about");
        List<Message> messageList = new ArrayList<>();
        if (message != null) {
            messageList = message.getMessages();
            if (messageList.size() != 0) {
                while (messageList.size() < 3) {
                    messageList.add(Message.builder().id(0L).message("").build());
                }
            } else {
                while (messageList.size() != 3) {
                    messageList.add(Message.builder().id(0L).message("").build());
                }
            }
        } else {
            messageList = new ArrayList<>();
            while (messageList.size() != 3) {
                messageList.add(Message.builder().id(0L).message("").build());
            }
        }
        model.addAttribute("messages", messageList);
        return "home/about_us";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        DynamicMessage message = dynamicMessageService.findOneByName("contact");
        if(message!=null){
            if (message.getMessages().size() != 0) {
                model.addAttribute("message", message.getMessages().get(0));
            }
        }
        else {
            model.addAttribute("message", "No message in database");
        }

        return "home/contact";
    }

    @GetMapping("/login")
    public String loginIntoApp() {
        return "home/login";
    }

}
