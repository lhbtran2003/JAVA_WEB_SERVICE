package liliana.session_2.entity.ex3;

import jakarta.persistence.*;

@Entity
public class ScreenRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;
}
