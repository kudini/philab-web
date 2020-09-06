package pl.coderslab.philabweb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.philabweb.entities.User;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class UserRegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private int genderId;
    private String placeOfResidence;
    private long pesel;
    private Date dateCreated;

    public UserRegistrationDto(Long id, String firstName, String lastName, String email, String password, LocalDate birthDate, int genderId, String placeOfResidence, long pesel, Date dateCreated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.genderId = genderId;
        this.placeOfResidence = placeOfResidence;
        this.pesel = pesel;
        this.dateCreated = dateCreated;
    }

    public UserRegistrationDto() {

    }
    public static UserRegistrationDto userToUserDTO(User user){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setId(user.getId());
        userRegistrationDto.setFirstName(user.getFirstName());
        userRegistrationDto.setLastName(user.getLastName());
        userRegistrationDto.setEmail(user.getEmail());
        userRegistrationDto.setPassword(user.getPassword());
        userRegistrationDto.setBirthDate(user.getBirthDate());
        userRegistrationDto.setGenderId(user.getGenderId());
        userRegistrationDto.setPlaceOfResidence(user.getPlaceOfResidence());
        userRegistrationDto.setPesel(user.getPesel());
        userRegistrationDto.setDateCreated(user.getDateCreated());
        return userRegistrationDto;
    }


    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
