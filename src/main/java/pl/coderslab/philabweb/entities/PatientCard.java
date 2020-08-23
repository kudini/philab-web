package pl.coderslab.philabweb.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User patient;
    @OneToMany
    private final List<User> involvedPeople = new ArrayList<>();
    @OneToOne
    private MedicalInterview medicalInterview;
    @OneToOne
    private MedicalOperations medicalOperations;

    @Override
    public String toString() {
        return "PatientCard{" +
                "id=" + id +
                ", patient=" + patient +
                ", involvedPeople=" + involvedPeople +
                ", medicalInterview=" + medicalInterview +
                ", medicalOperations=" + medicalOperations +
                '}';
    }

    public PatientCard(User patient) {
        this.patient = patient;
    }

    public PatientCard() {

    }

    public User retrievePatient() {
        return patient;// powinna byc immutable
    }

    public List<User> getInvolvedPeople() {
        return this.involvedPeople.stream().collect(Collectors.toUnmodifiableList());
    }
//todo zastanowic sie czy specyfikacja kiedys nie moglaby sie zmienic i zamiast obslugi medycznej nie wystepowal by opiekun
    public void addPeople(User byId) {
        this.involvedPeople.add(byId);
    }
}
