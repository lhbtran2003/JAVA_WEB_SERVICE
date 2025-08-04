package liliana.session_10.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter@Setter
public class ApiResponse<T> {
    private String message;
    private T data;
}
