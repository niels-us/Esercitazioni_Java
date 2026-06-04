package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.stereotype.Component;

@Component
public class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Elaborazione pagamento di " + amount + " EUR via PayPal.");
    }
}
