package liliana.session_2.repository.ex4;

import liliana.session_2.entity.ex3.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    // tìm kiếm theo movie
    List<Showtime> findByMovieId(Long movieId);
    // tìm kiếm theo phòng chiếu
    List<Showtime> findByScreenRoomId(Long screenRoomId);
    
}
