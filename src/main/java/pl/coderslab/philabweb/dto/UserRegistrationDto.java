package pl.coderslab.philabweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roles;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
