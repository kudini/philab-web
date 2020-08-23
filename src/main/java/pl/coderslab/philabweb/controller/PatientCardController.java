package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.philabweb.service.PatientCardService;
import pl.coderslab.philabweb.service.UserService;

@Controller
public class PatientCardController {
    PatientCardService patientCardService;
    UserService userService;

    public PatientCardController(PatientCardService patientCardService, UserService userService) {
        this.patientCardService = patientCardService;
        this.userService = userService;
    }

    @GetMapping("/all/patient-card/{userId}")
    @ResponseBody //todo zaedytowac to zeby przekazywalo model do sesji
    public String findAllPatientCard(@PathVariable Long userId){
       return patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(userId)).toString();
    }

    }
