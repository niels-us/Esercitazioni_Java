package E11.B_Spring_Boot_Convention_over_Configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final IPaymentProcessor paymentProcessor;

    @Value("${app.name}")
    private String appName;


    public PaymentService(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }


    public String makePayment(double amount) {
        return paymentProcessor.processPayment(amount);
    }

    @PostConstruct
    public void init() {
        System.out.println("PaymentService inizializzato!");
    }


}
