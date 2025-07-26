package liliana.session_9.controller;

import liliana.session_9.exception.BadRequestException;
import liliana.session_9.service.MovieService;
import liliana.session_9.entity.Movie;
import liliana.session_9.model.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDto request) throws BadRequestException {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            log.error("Invalid title: {}", request.getTitle());
            throw new BadRequestException("Tiêu đề phim không được để trống");
        }
        Movie movie = movieService.add(request);
        log.info("Add movie successfully: {}, lúc: {}", movie.getTitle(), LocalDateTime.now());
        return new ResponseEntity<Movie>( movie, HttpStatus.CREATED);

    }
}
