package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genders {
    @Id
    private Long id;
    private String name;
}
