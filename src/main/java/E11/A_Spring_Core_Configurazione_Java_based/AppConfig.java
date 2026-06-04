package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /**@Bean
    public PaymentProcessor paymentProcessor() {
        return new PayPalProcessor();
    }**/
    @Bean
    public PaymentProcessor paymentProcessor() {
        return new CreditCardProcessor();
    }
    //Eso significa que Spring crea y guarda un PaymentProcessor usando PayPalProcessor.

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(paymentProcessor());
    }
}


