package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {

    @Bean
    public CreditCardProcessor paymentProcessor() {
        return new CreditCardProcessor();
    }

}
