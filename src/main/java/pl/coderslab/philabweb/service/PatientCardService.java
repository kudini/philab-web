package pl.coderslab.philabweb.service;

import org.springframework.stereotype.Service;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.repositories.PatientCardRepository;

import java.util.List;
@Service
public class PatientCardService {
    private final PatientCardRepository patientCardRepository;

    public PatientCardService(PatientCardRepository patientCardRepository) {
        this.patientCardRepository = patientCardRepository;
    }
    public List<PatientCard> findAllPatientCardsByPatient(User patient){
        return patientCardRepository.findAllByPatient(patient);
    }
    public List<PatientCard> findAllPatientCardsByHealthProfessionUser(User user){
        return patientCardRepository.findAllByInvolvedPeopleIsContaining(user);
    }
}
