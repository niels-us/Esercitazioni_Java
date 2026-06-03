package E10.D_Approfondimenti_e_applicazioni;

public class PayPalProcessor implements IPaymentProcessor {
        private final TransactionLogger transactionLogger;

        public PayPalProcessor(TransactionLogger transactionLogger) {
                this.transactionLogger = transactionLogger;
        }

        @Override
        public void processPayment(double amount) {
                transactionLogger.log("Avvio pagamento con PayPal di " + amount + " EUR");
                System.out.println("Pagamento di " + amount + " EUR tramite PayPal");
                transactionLogger.log("Pagamento con PayPal completato di " + amount + " EUR");
        }
}
