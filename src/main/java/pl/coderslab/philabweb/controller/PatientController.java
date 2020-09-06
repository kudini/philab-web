package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.service.PatientCardService;
import pl.coderslab.philabweb.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    PatientCardService patientCardService;
    UserService userService;

    public PatientController(PatientCardService patientCardService, UserService userService) {
        this.patientCardService = patientCardService;
        this.userService = userService;
    }

    @GetMapping("/{userId}/cards")
    @ResponseBody //stworzyc widok
    public String findAllPatientCard(@PathVariable Long userId, Model model){
        List<PatientCard> patientCardsByHealthProfessionUser = patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(userId));
        model.addAttribute("patientCards", patientCardsByHealthProfessionUser);
       return patientCardsByHealthProfessionUser.toString();
    }
    @GetMapping("/scheduled")
    public String scheduled( ){
        return "patient/scheduled";
    }
    @GetMapping("/training")
    public String training( ){
        return "patient/training";
    }
    @GetMapping("/reservation")
    public String reservationGet( ){
        return "patient/reservation";
    }
    @PostMapping("/reservation")
    public String reservationPost(HttpServletRequest request) {
        //docelowo model rejestracji musze zrobic i hmm wywiad po przycisku
        return "redirect:/reservation?success";
    }
    @GetMapping("/{patientId}/history")
    public String historyOfPatientVisits(@PathVariable Long patientId, Model model){
        model.addAttribute("patientList",patientCardService.findAllPatientCardsByPatient(userService.findUserbyId(patientId)));
        return "patient/patientlist";
    }
}
