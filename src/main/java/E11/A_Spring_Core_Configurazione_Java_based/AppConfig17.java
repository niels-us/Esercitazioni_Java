package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "E11.A_Spring_Core_Configurazione_Java_based")
public class AppConfig17 {

    public PaymentProcessor paymentProcessor() {
        return new PayPalProcessor();
    }

    public PaymentService paymentService() {
        return new PaymentService(paymentProcessor());
    }
}


