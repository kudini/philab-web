package pl.coderslab.philabweb.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.philabweb.repositories.RoleRepository;
import pl.coderslab.philabweb.service.UserService;

import java.security.Principal;

@Controller
public class Test {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public String test(Principal principal) {
        userService.findUserByEmail("anna").getRoles().contains(roleRepository.findByName("ROLE_MEDIC"));
        return userService.findUserByEmail(principal.getName()).toString();
    }

}
