package liliana.sessio_4.service.ex2;

import jakarta.persistence.EntityNotFoundException;
import liliana.sessio_4.dto.ex2.AddBookingRequest;
import liliana.sessio_4.entity.ex2.Booking;
import liliana.sessio_4.entity.ex2.Flight;
import liliana.sessio_4.entity.ex2.Status;
import liliana.sessio_4.repository.ex2.BookingRepository;
import liliana.sessio_4.repository.ex2.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public void addBooking(AddBookingRequest addBookingRequest) {
        Optional<Flight> flight = flightRepository.findById(addBookingRequest.getFlightId());
        if (flight.isEmpty()) {
            throw new EntityNotFoundException("Flight not found");
        }
        Booking booking = new Booking();
        booking.setCustomerName(addBookingRequest.getCustomerName());
        booking.setCustomerPhone(addBookingRequest.getCustomerPhone());
        booking.setFlight(flight.get());
        booking.setStatus(Status.BOOKED);
        bookingRepository.save(booking);
    }

    public List<Booking> findAll () {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long bookingId) {
        Optional<Booking> bookingCancel = bookingRepository.findById(bookingId);
        if (bookingCancel.isEmpty()) {
            throw new EntityNotFoundException("Booking not found");
        }
        Booking booking = bookingCancel.get();
        booking.setStatus(Status.CANCELED);
    }
}
