package liliana.session_2.service.ex5;

import jakarta.persistence.EntityNotFoundException;
import liliana.session_2.entity.ex3.Movie;
import liliana.session_2.repository.ex4.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IService<Movie, Long, Optional<Movie>> {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
      movieRepository.save(movie);
    }

    @Override
    public void update(Movie movie) {
            movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new EntityNotFoundException("Movie not found");
        }
        movieRepository.deleteById(id);
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
