package liliana.session_8.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter@Setter
public class DishDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String status;
    private MultipartFile image;
}
