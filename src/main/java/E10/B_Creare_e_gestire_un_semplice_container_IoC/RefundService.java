package E10.B_Creare_e_gestire_un_semplice_container_IoC;

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
