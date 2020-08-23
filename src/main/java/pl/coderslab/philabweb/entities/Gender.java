package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gender {
    @Id
    private Long id;
    private String name;
}
