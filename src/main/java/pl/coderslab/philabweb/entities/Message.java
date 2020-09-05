package pl.coderslab.philabweb.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "message")
@Getter
@Builder
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String message;

    public Message() {

    }

    public Message(Long id,String message) {
        this.id=id;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

