package E11.A_Spring_Core_Configurazione_Java_based;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service //@Service marca la clase para que Spring la gestione como bean de negocio.
public class PaymentService {
    private final PaymentProcessor processor;

    @Autowired //@Autowired hace la inyección automática de dependencias.
    public PaymentService(@Qualifier("creditCardProcessor")PaymentProcessor processor) {
        //@Qualifier elige cuál bean usar cuando hay más de uno del mismo tipo.
        this.processor = processor;
    }

    @PostConstruct
    public void init() {
        System.out.println("PaymentService inizializzato");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PaymentService in distruzione");
    }

    public void makePayment(double amount) {
        processor.processPayment(amount);
    }
}
