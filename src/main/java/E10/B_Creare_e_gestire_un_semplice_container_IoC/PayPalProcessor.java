package E10.B_Creare_e_gestire_un_semplice_container_IoC;

public class PayPalProcessor implements IPaymentProcessor {
        @Override
        public void processPayment(double amount) {
                System.out.println("Pagamento di " + amount + " EUR tramite PayPal");
        }
}
