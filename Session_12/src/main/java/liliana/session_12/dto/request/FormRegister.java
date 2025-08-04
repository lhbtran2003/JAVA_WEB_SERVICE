package liliana.session_12.dto.request;

import lombok.Data;

@Data
public class FormRegister {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
