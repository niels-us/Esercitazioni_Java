package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.context.annotation.Bean;

public interface IPaymentProcessor {
    String processPayment(double amount);
}
