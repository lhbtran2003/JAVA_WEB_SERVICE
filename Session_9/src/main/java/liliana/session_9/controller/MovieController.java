package liliana.session_9.controller;

import liliana.session_9.exception.BadRequestException;
import liliana.session_9.service.MovieService;
import liliana.session_9.entity.Movie;
import liliana.session_9.model.MovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieDto request) throws BadRequestException {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new BadRequestException("Tiêu đề phim không được để trống");
        }

        return new ResponseEntity<Movie>( movieService.add(request), HttpStatus.CREATED);

    }
}
