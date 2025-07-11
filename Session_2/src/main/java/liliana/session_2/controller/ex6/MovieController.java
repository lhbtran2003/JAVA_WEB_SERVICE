package liliana.session_2.controller.ex6;

import liliana.session_2.entity.ex3.Movie;
import liliana.session_2.service.ex5.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String getMovies(Model model) {
        model.addAttribute("listMovie", movieService.findAll());
        return "ex7/movie-list";
    }

    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "ex7/movie-add";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isEmpty()){
            return "redirect:/404";
        }
        model.addAttribute("movieId", movie.get().getId());
        model.addAttribute("movie", movie.get());
        return "ex7/movie-edit";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}
