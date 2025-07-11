package liliana.session_2.entity.ex3;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "screen_room_id")
    private ScreenRoom screenRoom;

}
