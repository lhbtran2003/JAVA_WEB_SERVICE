package liliana.session_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "student_name", nullable = false, length = 50)
    private String name;
    @Column(name = "student_email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "student_phone", nullable = false, length = 15)
    private String phone;
    private String address;
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    private boolean sex;

    @ManyToOne
    @JoinColumn(name = "class_code")
    private Class classes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_subject",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_code"))
    private Set<Subject> subjects;
}
