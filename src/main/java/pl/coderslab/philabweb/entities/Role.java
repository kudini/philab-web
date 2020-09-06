package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //todo tez zrobic unique
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

//    @ManyToMany
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
//    private Collection<Privilege> privileges;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + "}";
    }

    public Role(String role_user) {
        this.name=role_user;
    }
    public Role() {
    }
}