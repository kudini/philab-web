package pl.coderslab.philabweb.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dynamic")
@Getter
@Setter

public class DynamicMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//todo dac unique
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "dynamic_message",
            joinColumns = @JoinColumn(
                    name = "dynamic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "message_id", referencedColumnName = "id"))
    private List<Message> messages = new ArrayList<>();

    @Override
    public String toString() {
        return "DynamicMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                '}';
    }
}
