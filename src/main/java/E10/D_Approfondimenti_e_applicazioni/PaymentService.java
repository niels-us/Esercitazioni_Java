package E10.D_Approfondimenti_e_applicazioni;

public class PaymentService {
    private final IPaymentProcessor paymentProcessor;
    private final TransactionLogger transactionLogger;

    public PaymentService(IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }

    public void makePayment(double amount) {
        transactionLogger.log("Avvio pagamento di " + amount + " EUR");
        paymentProcessor.processPayment(amount);
        transactionLogger.log("Pagamento completato di " + amount + " EUR");
    }

}


