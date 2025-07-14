package liliana.sessio_4.repository.ex2;

import liliana.sessio_4.entity.ex2.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
      List<Flight> findFlightByDepartureAndDestination(String departure, String destination);
}
