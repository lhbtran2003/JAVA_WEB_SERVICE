package liliana.sessio_4.dto.ex2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookingRequest {
    private Long flightId;
    private String customerName;
    private String customerPhone;

}
