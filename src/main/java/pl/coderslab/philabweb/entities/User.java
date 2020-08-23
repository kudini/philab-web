package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    @NotEmpty
    private String password;
    @Embedded
    private UserDetails userDetails;
    @OneToMany
    private List<UserGroup> userGroup;
    private Date dateCreated;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }

    public String retrieveFullName() {
        return userDetails.getFirstName() + " " + userDetails.getLastName();
    }
}
