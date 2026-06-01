package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class PayPalProcessor implements IPaymentProcessor {
        @Override
        public void processPayment(double amount) {
                System.out.println("Pagamento di " + amount + " EUR tramite PayPal");
        }
}
