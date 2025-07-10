package liliana.session_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "classes")
@Table(name = "classes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Class {
    @Id
    private String classCode;
    private String className;
    private boolean status;
}
