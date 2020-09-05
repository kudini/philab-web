package pl.coderslab.philabweb.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class PatientCard {
    @ManyToMany
    private final List<User> involvedPeople = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User patient;
    @OneToOne
    private MedicalInterview medicalInterview;
    @OneToOne
    private MedicalOperations medicalOperations;

    public PatientCard(User patient) {
        this.patient = patient;
    }

    public PatientCard() {

    }

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

    public String getDateOfVisit() {
        if(this.medicalInterview==null){
            return "No date";
        }
        if(this.medicalInterview.getDateOfVisit()==null){
            return "No date";
        }
        return this.medicalInterview.getDateOfVisit().toString();
    }
}
