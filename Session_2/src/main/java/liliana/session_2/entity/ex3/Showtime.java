package liliana.session_2.entity.ex3;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;
    private int numberSeatEmpty;

}
