package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig11 {
    @Bean
    @Primary
    public PaymentProcessor paymentProcessor() {
    return new PayPalProcessor();
    }
    @Bean
    public PaymentProcessor creditCardProcessor() {
        return new CreditCardProcessor();
    }
    //Eso significa que Spring crea y guarda un PaymentProcessor usando PayPalProcessor.

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(paymentProcessor());
    }
}


