package liliana.session_2.service.ex5;

import liliana.session_2.entity.ex3.Showtime;
import liliana.session_2.repository.ex4.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowTimeService implements IService<Showtime, Long, Showtime> {
    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Override
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public void update(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        showtimeRepository.deleteById(id);
    }
}
