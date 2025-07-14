package liliana.sessio_4.entity.ex2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private String customerName;
    private String customerPhone;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime bookingTime;

    private Status status;
}
