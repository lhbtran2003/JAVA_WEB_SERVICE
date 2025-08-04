package liliana.session_15.model;

import liliana.session_15.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormRegister {
    private String username;
    private String password;
    private String email;
    private Role role;
    private boolean status;
}