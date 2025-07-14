package liliana.sessio_4.controller.ex2;

import liliana.sessio_4.dto.ex2.AddBookingRequest;
import liliana.sessio_4.service.ex2.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public String getFlights(Model model,
                             @RequestParam(required = true, defaultValue = "") String departure,
                             @RequestParam(required = true, defaultValue = "") String destination,
                             @RequestParam(required = false, defaultValue = "0") int page) {
        model.addAttribute("bookingRequest", new AddBookingRequest());
        model.addAttribute("flights", flightService.findAll(departure, destination, page));
        return "ex2/list-flight";
    }


}
