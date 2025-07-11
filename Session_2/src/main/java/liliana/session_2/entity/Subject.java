package liliana.session_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subject {
    @Id
    private String subjectCode;
    private String subjectName;

}
