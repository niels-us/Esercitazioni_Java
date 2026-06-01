package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class PayPalProcessor implements IPaymentProcessor{
        @Override
        public void processPayment(double amount) {
                System.out.println("Pagamento di " + amount + " EUR tramite PayPal");
        }
}
