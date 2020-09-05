package pl.coderslab.philabweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.philabweb.entities.PatientCard;
import pl.coderslab.philabweb.entities.User;

import java.util.List;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {
    List<PatientCard> findAllByPatient(User patient);
    List<PatientCard> findAllByInvolvedPeopleIsContaining(User user);
    @Modifying
    @Query("update PatientCard p set p = :updatedPatientCard where p.id = :patientCardId")
    void updateUserSetStatusForName(@Param("updatedPatientCard") PatientCard updatedPatientCard, @Param("patientCardId") long patientCardId);
}
