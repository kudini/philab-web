package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.service.PatientCardService;
import pl.coderslab.philabweb.service.UserService;

@Controller
public class MedicController {
    PatientCardService patientCardService;
    UserService userService;

    public MedicController(PatientCardService patientCardService, UserService userService) {
        this.patientCardService = patientCardService;
        this.userService = userService;
    }


    @GetMapping("/medic/{medicId}/patients")
    public String patientsCardsByMedic(@PathVariable Long medicId, Model model){
        model.addAttribute("patientList",patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(medicId)));
       return "patient/patientlist";
    }


    @GetMapping("/medic/patient/card/add")
    public String patientCardAddGet(Model model){
        model.addAttribute("patient_card", new PatientCard());
        return "medic/patientCardAdd";
    }
    @PostMapping("/medic/patient/card/add")
    public String patientCardAddPost(PatientCard patientCard) {
            patientCardService.createPatientCardInDatabase(patientCard);
            return "redirect:/?success";
        }


    @GetMapping("/medic/patient/cards")
    @ResponseBody //stworzyc widok
    public String findAllPatientCard(@PathVariable Long userId, Model model){
        model.addAttribute("patientCards",patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(userId)));
        return "view";
    }
}
