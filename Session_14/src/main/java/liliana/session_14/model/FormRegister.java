package liliana.session_14.model;

import liliana.session_14.entity.Role;
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