package liliana.session_12.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter@Setter
public class FormLogin {
    private String username;
    private String password;
}
