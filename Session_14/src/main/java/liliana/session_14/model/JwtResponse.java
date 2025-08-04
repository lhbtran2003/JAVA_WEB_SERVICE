package liliana.session_14.model;


import liliana.session_14.entity.User;
import liliana.session_14.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private final String type = "Bearer Token";
    private String accessToken;
    private User user;
}
