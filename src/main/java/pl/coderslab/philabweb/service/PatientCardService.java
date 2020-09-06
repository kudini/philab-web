package pl.coderslab.philabweb.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.entities.User;
import pl.coderslab.philabweb.repositories.PatientCardRepository;

import java.util.List;

@Service
@Transactional
public class PatientCardService {
    private final PatientCardRepository patientCardRepository;

    public PatientCardService(PatientCardRepository patientCardRepository) {
        this.patientCardRepository = patientCardRepository;
    }

    public PatientCard findCardById(long cardId) {
        return patientCardRepository.findById(cardId).orElse(null);
    }

    public List<PatientCard> findAllPatientCardsByPatient(User patient) {
        return patientCardRepository.findAllByPatient(patient);
    }

    public List<PatientCard> findAllPatientCardsByHealthProfessionUser(User user) {
        return patientCardRepository.findAllByInvolvedPeopleIsContaining(user);
    }

    public void updatePatientCardInDatabase(PatientCard patientCard) {
        patientCardRepository.save(patientCard);
    }

    public void createPatientCardInDatabase(PatientCard patientCard) {
        patientCardRepository.save(patientCard);
    }
}
