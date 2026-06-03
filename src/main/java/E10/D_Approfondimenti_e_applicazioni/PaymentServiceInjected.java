package E10.D_Approfondimenti_e_applicazioni;

public class PaymentServiceInjected {
    private final IPaymentProcessor paymentProcessor;

    public PaymentServiceInjected(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
//La seconda è più testabile e manutenibile perché la dipendenza arriva dall’esterno
// e può essere cambiata senza modificare la classe.
