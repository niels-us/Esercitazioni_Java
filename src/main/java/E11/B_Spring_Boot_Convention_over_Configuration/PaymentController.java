package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("/pay/{amount}")
    public String pay(@PathVariable double amount) {
        String response = service.makePayment(amount);
        return response;
    }
}
