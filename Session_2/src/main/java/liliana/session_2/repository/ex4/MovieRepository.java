package liliana.session_2.repository.ex4;

import liliana.session_2.entity.ex3.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // tìm theo tên phim ko phân biệt hoa thường
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
