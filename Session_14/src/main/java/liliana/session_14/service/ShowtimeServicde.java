package liliana.session_14.service;

import liliana.session_14.entity.Movie;
import liliana.session_14.entity.Showtime;
import liliana.session_14.repository.MovieRepository;
import liliana.session_14.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeServicde {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    public List<Showtime> getShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime addShowtime(Showtime movie) {
        return showtimeRepository.save(movie);
    }

    public Showtime updateShowtime(Long id,Showtime movie) throws Exception{
        if(!showtimeRepository.existsById(id)){
            throw new Exception("No such movie");
        }
        return showtimeRepository.save(movie);
    }

    public void deleteShowtime(Long id) {
        showtimeRepository.deleteById(id);
    }
}
