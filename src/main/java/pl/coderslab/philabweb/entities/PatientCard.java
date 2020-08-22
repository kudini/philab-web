package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long medicalInterviewId;
    private Long medicalOperationsId;

}
