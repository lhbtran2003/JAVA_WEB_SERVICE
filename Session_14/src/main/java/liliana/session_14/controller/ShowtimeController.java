package liliana.session_14.controller;

import liliana.session_14.entity.Showtime;
import liliana.session_14.service.ShowtimeServicde;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ShowtimeController {
    private final ShowtimeServicde showtimeServicde;

    @GetMapping("/showtimes")
    public ResponseEntity<List<Showtime>> getAllMovies() {
        return new ResponseEntity<>(showtimeServicde.getShowtimes(), HttpStatus.OK);
    }

    @PostMapping("/admin/showtimes")
    public ResponseEntity<Showtime> add(@RequestBody Showtime showtime) {
        return new ResponseEntity<>(showtimeServicde.addShowtime(showtime),  HttpStatus.CREATED);
    }
}
