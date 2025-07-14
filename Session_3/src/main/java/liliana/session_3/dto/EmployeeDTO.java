package liliana.session_3.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private double salary;
}
