package E10.D_Approfondimenti_e_applicazioni;

public class AppContainerFive {
    private final TransactionLogger transactionLogger;
    private final IPaymentProcessor paymentProcessor;
    private final PaymentService paymentService;

    public AppContainerFive() {
        this.transactionLogger = new TransactionLogger();
        this.paymentProcessor = new CreditCardProcessor(transactionLogger);
        this.paymentService = new PaymentService(paymentProcessor, transactionLogger);
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}
