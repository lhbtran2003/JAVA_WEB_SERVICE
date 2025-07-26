package liliana.session_9.service;

import liliana.session_9.entity.Movie;
import liliana.session_9.model.MovieDto;
import liliana.session_9.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public Movie add(MovieDto request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setReleaseDate(request.getReleaseDate());
        MultipartFile file = request.getPosterImage();
        if (file != null && !file.isEmpty()) {
            movie.setPoster(cloudinaryService.uploadImage(file));
        }
        return movieRepository.save(movie);
    }
}
