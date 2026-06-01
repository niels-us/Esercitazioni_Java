package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class testJava {
    public static void main(String[] args) {
        System.out.println("1. creditCardProcessor ------------------------");
        PaymentService paymentService1 = new PaymentService(new CreditCardProcessor());
        paymentService1.makePayment(100);

        System.out.println("2.  Isolare la dipendenza --------------------");
        paymentService1.makePayment(200);
        //Revisare Interfaccia IPaymentProcessor

        System.out.println("3. Analizzare l’accoppiamento --------------------");
        // Il codice è ancora rigido perché PaymentService crea direttamente la dipendenza con new.
        // Questo rende difficile sostituire CreditCardProcessor con un'altra implementazione senza modificare la classe.
        // Il problema del "new" è che lega PaymentService a una classe concreta invece di usare solo l'interfaccia.

        System.out.println("4. Spostare la creazione all’esterno -------------");
        IPaymentProcessor processor = new CreditCardProcessor();
        PaymentService paymentService4 = new PaymentService(processor);
        paymentService4.makePayment(400);

        System.out.println("5. Simulare un container IoC ---------------------");
        AppContainer container = new AppContainer(false);
        PaymentService paymentService5 = container.createPaymentService();
        paymentService4.makePayment(500);

        System.out.println("6. Comprendere l’Inversione del Controllo --------------------");
        // Prima il controllo era dentro PaymentService, che creava direttamente CreditCardProcessor con new.
        // Ora la creazione e il collegamento degli oggetti sono gestiti da AppContainer, che costruisce le dipendenze dall'esterno.

        System.out.println("7. Introdurre una nuova implementazione -----------------------");
        paymentService4.makePayment(700);

        System.out.println("8. Sostituzione a runtime ----------------------------------------");
        boolean usePayPal = true;
        AppContainer container8 = new AppContainer(usePayPal);
        PaymentService paymentService3 = container8.createPaymentService();
        paymentService3.makePayment(800);
        usePayPal = false;
        AppContainer container9 = new AppContainer(usePayPal);
        PaymentService paymentService2 = container9.createPaymentService();
        paymentService2.makePayment(800);

        System.out.println("9. Simulare un test ----------------------------------------------");
        IPaymentProcessor mockProcessor = new MockProcessor();
        PaymentService paymentService = new PaymentService(mockProcessor);
        paymentService.makePayment(900);

        IPaymentProcessor mockProcessorDue = new MockProcessorDue();
        PaymentService paymentService9 = new PaymentService(mockProcessorDue);
        paymentService9.makePayment(901);

        //main() crea mockProcessor y se lo pasa a PaymentService por el constructor.
        //El constructor guarda esa referencia en this.paymentProcessor.
        //Luego makePayment(900) llama paymentProcessor.processPayment(900), y como ahí está el mock,
        // se ejecuta el método del mock.

        System.out.println("10. Commento finale --------------------------------------------------");
        // Con l'Inversione del Controllo, PaymentService non crea più direttamente i suoi oggetti dipendenti.
        // Le dipendenze arrivano dall'esterno, quindi il codice è meno accoppiato e più facile da modificare,
        // testare e sostituire.





    }
}
