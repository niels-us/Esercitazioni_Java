package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class MockProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Simulazione pagamento di " + amount + " EUR");
    }
}
