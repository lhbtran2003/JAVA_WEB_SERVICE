package liliana.session_9.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
@Getter@Setter
public class MovieDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private MultipartFile posterImage;
}
