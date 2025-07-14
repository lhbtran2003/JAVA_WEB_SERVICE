package liliana.session_3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
// nhớ cái setter nha má, ko thì éo binding đc đâu :))))
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private double salary;
    @Temporal(TemporalType.DATE)
    private LocalDate create_at;
}
