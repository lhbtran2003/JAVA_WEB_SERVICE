package liliana.session_6.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AddEmployeeRequest {
    private String name;
    private String email;
    private String position;
    private Double salary;
}
