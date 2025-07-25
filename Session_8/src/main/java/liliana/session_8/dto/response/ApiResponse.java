package liliana.session_8.dto.response;

import lombok.Builder;

@Builder
public class ApiResponse<T> {
    private Boolean status;
    private String message;
    private T data;
}
