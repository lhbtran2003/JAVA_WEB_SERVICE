package liliana.session_15.model;


import liliana.session_15.entity.User;
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
