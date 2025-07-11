package liliana.session_2.service.ex5;

import liliana.session_2.entity.ex3.Seat;
import liliana.session_2.repository.ex4.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService implements IService<Seat, Long, Seat> {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void save(Seat seat) {
seatRepository.save(seat);
    }

    @Override
    public void update(Seat seat) {
    seatRepository.save(seat);
    }

    @Override
    public Seat findById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {

    }
}
