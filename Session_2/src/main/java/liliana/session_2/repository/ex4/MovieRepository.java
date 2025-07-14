package liliana.session_2.repository.ex4;

import liliana.session_2.entity.ex3.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // tìm theo tên phim ko phân biệt hoa thường
    List<Movie> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT count(m) > 0 FROM Movie m WHERE m.title = :title")
    boolean existByTitle(@Param("title") String title);
}
