package liliana.session_8.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter@Setter
public class IngredianDto {
    private Long id;
    private String name;
    private Integer stock;
    private LocalDate expiry;
    private MultipartFile image;
}
