package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class MockProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Simulazione pagamento di " + amount + " EUR");
    }
}
