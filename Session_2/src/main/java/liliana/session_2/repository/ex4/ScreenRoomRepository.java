package liliana.session_2.repository.ex4;

import liliana.session_2.entity.ex3.ScreenRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRoomRepository extends JpaRepository<ScreenRoom, Long> {
    // tìm theo tên phòng ko phân biệt hoa thường (tương đối)
    List<ScreenRoom> findByNameContainingIgnoreCase(String name);
    // tìm theo rạp (TheaterId => theater.id)
    // theater: tên thuộc tính của ScreenRoom
    // id: tên thuộc tính của Theater
    List<ScreenRoom> findByTheaterId(Long theaterId);
}
