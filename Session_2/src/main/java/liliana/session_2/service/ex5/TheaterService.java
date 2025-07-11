package liliana.session_2.service.ex5;

import liliana.session_2.entity.ex3.Theater;
import liliana.session_2.repository.ex4.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService implements IService<Theater,Long, Theater> {
    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public void save(Theater theater) {
      theaterRepository.save(theater);
    }

    @Override
    public void update(Theater theater) {
        theaterRepository.save(theater);
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        theaterRepository.deleteById(id);
    }
}
