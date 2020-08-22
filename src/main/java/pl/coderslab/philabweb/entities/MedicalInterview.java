package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity
public class MedicalInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp dateOfVisit;
    private String characterOfTheAilment;
    private String localizationOfPain;
    private String strengthOfPain;
    private String deformationsOfBody;
//    private Tests[] executedTests; albo jakis collection albo kurcze nie wiem ;/

}
