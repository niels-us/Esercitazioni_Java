package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class PayPalProcessor implements  IPaymentProcessor{
    @Override
    public String processPayment(double amount) {
        return "Procesando pago con PayPal: " + amount + " EUR";
    }
}
