package pl.coderslab.philabweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.entities.User;

import java.util.List;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {
    List<PatientCard> findAllByPatient(User patient);
    List<PatientCard> findAllByInvolvedPeopleIsContaining(User user);
}
