package pl.coderslab.philabweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.service.PatientCardService;
import pl.coderslab.philabweb.service.UserService;

@Controller
@RequestMapping("/medic")
public class MedicController {
    PatientCardService patientCardService;
    UserService userService;

    public MedicController(PatientCardService patientCardService, UserService userService) {
        this.patientCardService = patientCardService;
        this.userService = userService;
    }


    @GetMapping("/{medicId}/cards")
    public String patientsCardsByMedic(@PathVariable Long medicId, Model model){
        model.addAttribute("patient_cards",patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(medicId)));
       return "medic/patientcards";
    }
    @GetMapping("/{medicId}/patients")
    public String patientsByMedic(@PathVariable Long medicId, Model model){
        model.addAttribute("patient_lists",userService.findAllPatientsByMedic(userService.findUserbyId(medicId)));
       return "medic/patientlist";
    }


    @GetMapping("/card/add")
    public String patientCardAddGet(Model model){
        model.addAttribute("patient_card", new PatientCard());
        return "medic/patientCardAdd";
    }
    @PostMapping("/card/add")
    public String patientCardAddPost(PatientCard patientCard) {
            patientCardService.createPatientCardInDatabase(patientCard);
            return "redirect:/?success";
        }


    @GetMapping("/cards")
    @ResponseBody //stworzyc widok
    public String findAllPatientCard(@PathVariable Long userId, Model model){
        model.addAttribute("patientCards",patientCardService.findAllPatientCardsByHealthProfessionUser(userService.findUserbyId(userId)));
        return "view";
    }
}
