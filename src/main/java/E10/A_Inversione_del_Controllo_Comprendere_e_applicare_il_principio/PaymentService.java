package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class PaymentService {
    private final IPaymentProcessor paymentProcessor;

    public PaymentService(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        //CreditCardProcessor creditCardProcessor = new CreditCardProcessor();
        //IPaymentProcessor creditCardProcessor = new CreditCardProcessor();
        // Il codice è ancora rigido perché PaymentService crea direttamente la dipendenza con new.
        // Questo rende difficile sostituire CreditCardProcessor con un'altra implementazione senza modificare la classe.
        // Il problema del "new" è che lega PaymentService a una classe concreta invece di usare solo l'interfaccia.

        //creditCardProcessor.processPayment(amount);
        paymentProcessor.processPayment(amount);
    }

    // Con l'Inversione del Controllo, PaymentService non crea più direttamente i suoi oggetti dipendenti.
    // Le dipendenze arrivano dall'esterno, quindi il codice è meno accoppiato e più facile da modificare,
    // testare e sostituire.
}
