package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Setter
public class UserGroup {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    private String roleName;
    // todo jakie role i jak to
}
