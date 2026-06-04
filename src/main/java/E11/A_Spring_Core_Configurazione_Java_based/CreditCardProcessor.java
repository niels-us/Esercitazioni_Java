package E11.A_Spring_Core_Configurazione_Java_based;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Elaborazione Pagamento di " + amount + " EUR via CreditCard");
    }
}