package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypesOfTreatment {
    @Id
    private Long id;
    private String treatmentName;
}
