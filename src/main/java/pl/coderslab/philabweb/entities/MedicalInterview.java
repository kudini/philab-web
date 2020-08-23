package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity
@Getter
@Setter
public class MedicalInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp dateOfVisit;
    private String characterOfTheAilment;
    private String localizationOfPain;
    private String strengthOfPain;
    private String deformationsOfBody;

    @Override
    public String toString() {
        return "MedicalInterview{" +
                "id=" + id +
                ", dateOfVisit=" + dateOfVisit +
                ", characterOfTheAilment='" + characterOfTheAilment + '\'' +
                ", localizationOfPain='" + localizationOfPain + '\'' +
                ", strengthOfPain='" + strengthOfPain + '\'' +
                ", deformationsOfBody='" + deformationsOfBody + '\'' +
                '}';
    }
//    private Tests[] executedTests; albo jakis collection albo kurcze nie wiem ;/
}
