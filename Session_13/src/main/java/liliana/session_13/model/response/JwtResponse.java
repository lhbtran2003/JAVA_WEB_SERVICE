package liliana.session_13.model.response;

import liliana.session_13.entity.User;
import lombok.*;

@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private final String type = "Bearer Token";
    private String accessToken;
    private User user;
}
