package liliana.session_6.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AddBookRequest {
    private String title;
    private String author;
    private double price;
}
