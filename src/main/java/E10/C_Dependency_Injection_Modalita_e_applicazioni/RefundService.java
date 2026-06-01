package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class RefundService{
    private final IPaymentProcessor paymentProcessor;
    private final TransactionLogger transactionLogger;

    public RefundService(IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }

    public void makeRefund(double amount) {
        transactionLogger.log("RefundService pagamento di " + amount + " EUR");
        paymentProcessor.processPayment(amount);
        transactionLogger.log("RefundService completato di " + amount + " EUR");
    }
}
