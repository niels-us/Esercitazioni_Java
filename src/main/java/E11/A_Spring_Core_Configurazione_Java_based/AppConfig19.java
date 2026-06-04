package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig19 {

    public PaymentProcessor paymentProcessor() {
        return new PayPalProcessor();
    }

    public PaymentService paymentService() {
        return new PaymentService(paymentProcessor());
    }
}


