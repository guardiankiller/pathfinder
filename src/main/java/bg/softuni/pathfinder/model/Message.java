package bg.softuni.pathfinder.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_time", nullable = false)
    private Instant dateTime;

    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User recipient;
}
