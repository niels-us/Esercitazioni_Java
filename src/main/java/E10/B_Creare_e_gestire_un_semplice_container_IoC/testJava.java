package E10.B_Creare_e_gestire_un_semplice_container_IoC;

public class testJava {
    public static void main(String[] args) {
        System.out.println("11. Creare una struttura di container --------------------------");
        boolean usePayPal = true;
        AppContainer container1 = new AppContainer(usePayPal);
        PaymentService paymentService1 = container1.createPaymentService();
        paymentService1.makePayment(100);
        System.out.println("12. Evitare la duplicazione -----------------------------------");
        usePayPal = true;
        AppContainer container2 = new AppContainer(usePayPal);
        PaymentService paymentService2 = container2.createPaymentService();
        paymentService2.makePayment(200);
        System.out.println("13. Gestire dipendenze multiple ---------------------------------");
        AppContainer container3 = new AppContainer(true);
        PaymentService paymentService3 = container3.createPaymentService();
        paymentService3.makePayment(300);
        System.out.println("14. Implementare la ricerca per tipo ----------------------------");
        AppContainer container4 = new AppContainer(true);
        PaymentService paymentService4 = container4.getBeanNew(PaymentService.class);
        paymentService4.makePayment(400);
        System.out.println("15. Creare più servizi ------------------------------------------");
        AppContainer container5 = new AppContainer(true);
        PaymentService paymentService5 = container5.getBeanNew(PaymentService.class);
        paymentService5.makePayment(400);
        RefundService refundService5 = container5.getBeanNew(RefundService.class);
        refundService5.makeRefund(500);
        refundService5 = container5.getBeanNew(RefundService.class);
        refundService5.makeRefund(600);
        refundService5 = container5.getBeanNew(RefundService.class);
        refundService5.makeRefund(700);
        System.out.println("16. Gestire più implementazioni ----------------------------------");
        AppContainer container6 = new AppContainer(true);
        IPaymentProcessor processor = container6.getProcessor("paypal");
        processor.processPayment(160);
        processor = container6.getProcessor("creditcard");
        processor.processPayment(161);
        processor = container6.getProcessor("Altro");
        processor.processPayment(162);
        System.out.println("17. Implementare un semplice file di configurazione ----------------");
        AppContainer container7 = new AppContainer(true);
        IPaymentProcessor processor7 = container7.getProcessor("paypal");
        processor7.processPayment(160);
        processor7 = container6.getProcessor("creditcard");
        processor7.processPayment(161);
        processor7 = container6.getProcessor("Altro");
        processor7.processPayment(162);
        System.out.println("18. Simulare il ciclo di vita degli oggetti ----------------------");
        AppContainer container8 = new AppContainer(true);
        PaymentService paymentService8 = container8.getBeanNew(PaymentService.class);
        paymentService8.makePayment(180);
        System.out.println("19. Simulare la distruzione -------------------------------------");
        AppContainer container = new AppContainer(true);
        container.getBean("paymentService");
        container.close();
        System.out.println("20. Confronto finale ---------------------------------------------");
        // *Con i new manuali, ogni classe crea da sola le proprie dipendenze e il codice è più rigido.
        // *Con il container, le dipendenze vengono create e collegate dall'esterno, quindi il codice è
        //      più flessibile e modulare.
        // *L'IoC (Inversion of Control.) riduce l'accoppiamento e rende più semplice sostituire, testare
        //      e riusare i componenti.
    }
}
