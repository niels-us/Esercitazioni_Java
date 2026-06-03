package E10.D_Approfondimenti_e_applicazioni;

public class PaymentServiceManual {
    TransactionLogger transactionLogger = new TransactionLogger();
    private final IPaymentProcessor paymentProcessor = new CreditCardProcessor(transactionLogger);

    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
//versione è più rigida perché PaymentServiceManual crea direttamente il processore e non è facile
// sostituirlo nei test o in produzione.
