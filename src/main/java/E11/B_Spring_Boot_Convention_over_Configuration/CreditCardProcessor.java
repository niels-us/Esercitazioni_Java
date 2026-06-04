package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.stereotype.Component;

@Component
public class CreditCardProcessor implements IPaymentProcessor{
    @Override
    public String processPayment(double amount) {
        return "Procesando pago con tarjeta: " + amount + " EUR";
    }
}
