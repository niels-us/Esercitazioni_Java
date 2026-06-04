package E11.A_Spring_Core_Configurazione_Java_based;

public class PaymentService14 {
    private final PaymentProcessor processor;
    private final TransactionLogger logger;

    public PaymentService14(PaymentProcessor processor, TransactionLogger logger) {
        this.processor = processor;
        this.logger = logger;
    }

    public void makePayment(double amount) {
        logger.log("Avvio pagamento di " + amount + " EUR");
        processor.processPayment(amount);
        logger.log("Pagamento completato di " + amount + " EUR");
    }
}
