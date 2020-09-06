package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.service.PatientCardService;
import pl.coderslab.philabweb.service.UserService;

import java.util.List;

@Controller
public class PatientController {
    PatientCardService patientCardService;
    UserService userService;

    public PatientController(PatientCardService patientCardService, UserService userService) {
        this.patientCardService = patientCardService;
        this.userService = userService;
    }

    @GetMapping("/patient/{userId}/cards")
    @ResponseBody //stworzyc widok
    public String findAllPatientCard(@PathVariable Long userId, Model model){
        List<PatientCard> patientCardsByHealthProfessionUser = patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(userId));
        model.addAttribute("patientCards", patientCardsByHealthProfessionUser);
       return patientCardsByHealthProfessionUser.toString();
    }
}
