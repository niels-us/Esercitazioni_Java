package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class PaymentService {
    private final IPaymentProcessor paymentProcessor;
    private final TransactionLogger transactionLogger;

    public PaymentService(IPaymentProcessor paymentProcessor, TransactionLogger transactionLogger) {
        this.paymentProcessor = paymentProcessor;
        this.transactionLogger = transactionLogger;
    }

    public void makePayment(double amount) {
        //CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        //IPaymentProcessor creditCardProcessor = new CreditCardProcessor();
        // Il codice è ancora rigido perché PaymentService crea direttamente la dipendenza con new.
        // Questo rende difficile sostituire CreditCardProcessor con un'altra implementazione senza modificare la classe.
        // Il problema del "new" è che lega PaymentService a una classe concreta invece di usare solo l'interfaccia.

        //creditCardProcessor.processPayment(amount);
        transactionLogger.log("Avvio pagamento di " + amount + " EUR");
        paymentProcessor.processPayment(amount);
        transactionLogger.log("Pagamento completato di " + amount + " EUR");
    }

    // Con l'Inversione del Controllo, PaymentService non crea più direttamente i suoi oggetti dipendenti.
    // Le dipendenze arrivano dall'esterno, quindi il codice è meno accoppiato e più facile da modificare,
    // testare e sostituire.

    public void initialize(){
        System.out.println("initialize(): PaymentService");
    }

    public void shutdown(){
        System.out.println("shutdown(): PaymentService");

    }
}
