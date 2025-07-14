package liliana.sessio_4.service.ex2;

import liliana.sessio_4.entity.ex2.Flight;
import liliana.sessio_4.repository.ex2.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository repo;

    public Page<Flight> findAll (String departure, String destination, int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }
}
