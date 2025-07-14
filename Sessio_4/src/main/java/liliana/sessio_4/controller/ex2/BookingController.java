package liliana.sessio_4.controller.ex2;

import liliana.sessio_4.dto.ex2.AddBookingRequest;
import liliana.sessio_4.service.ex2.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public String addBooking(@ModelAttribute("bookingRequest") AddBookingRequest bookingRequest,
                             Model model) {
        bookingService.addBooking(bookingRequest);
        return "redirect:/flights";
    }

    @GetMapping
    public String getBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAll());
        return "ex2/list-booking";
    }

    @GetMapping("/cancel/{id}")
    public String cancelBooking(@PathVariable("id") Long id) {
        bookingService.cancelBooking(id);
        return "redirect:/bookings";
    }
}
