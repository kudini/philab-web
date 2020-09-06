package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.philabweb.dto.UserRegistrationDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;


@Getter
@Setter
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String email;
    @NotEmpty
    private String password;

    @Past
    private LocalDate birthDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection<Role> roles;

    private int genderId;
    private String placeOfResidence;
//    @PESEL
    private long pesel;
    private Date dateCreated;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + retrieveFullName() +
                ", ROLES=" + getRoles() +
                '}';
    }
    @Transient
    public boolean isMedic(){
        if (this.roles.stream().map(Role::getName).anyMatch(rol -> rol.equals("ROLE_MEDIC"))) {
            return true;
        } else {
            return false;
        }
    }
    public String retrieveFullName() {
        return firstName + " " + lastName;
    }
    public void UserDTOToUser(UserRegistrationDto userRegistrationDto){
        this.firstName=userRegistrationDto.getFirstName();
        this.lastName=userRegistrationDto.getLastName();
        this.email=userRegistrationDto.getEmail();
        this.password=userRegistrationDto.getPassword();
    }
}
