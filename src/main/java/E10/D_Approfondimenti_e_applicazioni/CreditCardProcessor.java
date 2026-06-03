package E10.D_Approfondimenti_e_applicazioni;

public class CreditCardProcessor implements IPaymentProcessor {
    private final TransactionLogger transactionLogger;

    public CreditCardProcessor(TransactionLogger transactionLogger) {
        this.transactionLogger = transactionLogger;
    }

    @Override
    public void processPayment(double amount) {
        transactionLogger.log("Avvio pagamento con carta di " + amount + " EUR");
        System.out.println("Addebito di " + amount + " EUR su carta di credito");
        transactionLogger.log("Pagamento con carta completato di " + amount + " EUR");
    }
}
