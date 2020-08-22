package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class MedicalOperations {
    @Id
    private Long id;
    private Long bodyPartsId;
    private String visitDescription;
    private Long treatmentId;
    private Timestamp dateOfTreatment;

}
