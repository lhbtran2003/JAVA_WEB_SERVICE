package liliana.session_6.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class DataResponse<T> {
    private String key;
    private T data;
}
