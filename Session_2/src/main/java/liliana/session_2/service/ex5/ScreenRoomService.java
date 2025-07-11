package liliana.session_2.service.ex5;

import liliana.session_2.entity.ex3.ScreenRoom;
import liliana.session_2.repository.ex4.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenRoomService implements IService<ScreenRoom, Long, ScreenRoom> {
    @Autowired
    private ScreenRoomRepository screenRoomRepository;

    @Override
    public void save(ScreenRoom screenRoom) {
        screenRoomRepository.save(screenRoom);
    }

    @Override
    public void update(ScreenRoom screenRoom) {
        screenRoomRepository.save(screenRoom);
    }

    @Override
    public ScreenRoom findById(Long id) {
        return screenRoomRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        screenRoomRepository.deleteById(id);
    }
}
