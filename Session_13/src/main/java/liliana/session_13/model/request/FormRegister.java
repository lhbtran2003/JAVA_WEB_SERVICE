package liliana.session_13.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FormRegister {
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean status;
}
