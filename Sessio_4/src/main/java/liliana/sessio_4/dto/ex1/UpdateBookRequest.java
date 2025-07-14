package liliana.sessio_4.dto.ex1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookRequest {
    private String title;
    private String author;
    private String publisher;
    private String year;
}
