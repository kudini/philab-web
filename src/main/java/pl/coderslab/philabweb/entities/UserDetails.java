package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class UserDetails {
    private String firstName;
    private String lastName;
    @Past
    private LocalDate birthDate;
//    private int genderId;
//    private String placeOfResidence;
//    @PESEL
//    private long pesel;


}
