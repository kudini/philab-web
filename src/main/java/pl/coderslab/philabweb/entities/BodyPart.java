package pl.coderslab.philabweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BodyPart {
    @Id
    private Long id;
    private String bodyPartName;
}
