package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class testJava {
    public static void main(String[] args) {
        System.out.println("21. Iniezione tramite costruttore --------------------------");
        //IPaymentProcessor creditCardProcessor = new CreditCardProcessor();
        //PaymentService service = new PaymentService(creditCardProcessor, transactionLogger);
        //service.makePayment(100);
        //Constructor: la dependencia entra obligatoriamente al crear el objeto y queda más controlada.
        System.out.println("22. Iniezione tramite metodo setter -------------------------");
        PaymentService service22 = new PaymentService();
        service22.setPaymentProcessor(new CreditCardProcessor());
        service22.makePayment(220);
        //Setter: la dependencia se asigna después y puede cambiarse más tarde.
        System.out.println("23. Iniezione tramite campo ----------------------------------");
        PaymentService service23 = new PaymentService();
        service23.paymentProcessor = new CreditCardProcessor();
        service23.makePayment(230);
        //Campo público: cualquiera puede asignarla directamente, por eso es la opción más débil y menos segura.
        System.out.println("24. Iniezione condizionale -----------------------------------");
        AppContainer container24 = new AppContainer(true);
        IPaymentProcessor processor24 = container24.getProcessorForAmount(240);
        System.out.println("Menor a 500 me trae em metodo " + processor24.getClass());
        PaymentService service24 = new PaymentService();
        service24.setPaymentProcessor(processor24);
        service24.makePayment(240);
        processor24 = container24.getProcessorForAmount(2400);
        System.out.println("Meyor a 500 me trae em metodo " + processor24.getClass());
        PaymentService service = new PaymentService();
        service.setPaymentProcessor(processor24);
        service.makePayment(2400);
        //getProcessorForAmount(240) decide qué procesador usar•
        //makePayment(240) sigue recibiendo el importe para ejecutarlo•
        //si quieres centralizar todo, el container debe devolverte ya el PaymentService configurado
        System.out.println("25. Simulazione di test unitario ------------------------------");
        IPaymentProcessor mockProcessor = new MockProcessor();
        PaymentService service25 = new PaymentService();
        service25.setPaymentProcessor(mockProcessor);
        service25.makePayment(100);
        System.out.println("Test eseguito senza errori");
        //mockProcessor simula el comportamiento real•
        //setPaymentProcessor(...) inyecta esa simulación•
        //makePayment(100) usa el mock sin cambiar PaymentService
        //Lo que se aprende aquí es que la clase queda desacoplada y testable.
        System.out.println("26. Aggiungere più servizi -------------------------------------");
        PaymentService service26 = new PaymentService();
        //CreditCardProcessor está siendo inyectado en PaymentService.
        service26.setPaymentProcessor(new CreditCardProcessor());
        //inyecta NotificationService en PaymentService
        service26.setNotificationService(new NotificationService());
        service26.makePayment(100);
        //Que una dependencia no inyectada queda en null y provoca error.
        //Hay que asignarla antes de usarla.
        //Un chequeo null puede evitar el fallo, pero no sustituye la inyección correcta.
        //  inyección de dependencias por setter.
        //con inyección: PaymentService recibe objetos desde fuera
        //sin inyección: PaymentService los crea dentro y queda más rígido
        //La idea de IoC es justamente evitar ese new dentro de la clase.
        System.out.println("27. Dipendenze opzionali -------------------------------------------");
        PaymentService service27 = new PaymentService();
        service27.setPaymentProcessor(new CreditCardProcessor());
        service27.makePayment(270);
        System.out.println("28. Simulare un’iniezione automatica -------------------------------");
        AppContainer container28= new AppContainer(true);
        PaymentService service28 = new PaymentService();
        service28.setPaymentProcessor(new CreditCardProcessor());
        container28.injectDependencies(service28);
        service28.makePayment(100);
        //@Inject marca el campo para que el container sepa que debe rellenarlo.
        //Inject.class es lo que el código usa para detectar esa marca con reflexión.
        //Sin @Inject, el container no sabe qué campo debe inyectar.
        //La idea es justamente esa: no instanciar la dependencia dentro de la misma clase.
        //El container la crea afuera y la inserta automáticamente en el campo marcado con @Inject.
        System.out.println("29. Gestire cicli di vita complessi ----------------------------------");
        AppContainer container29 = new AppContainer(true);
        PaymentService service29 = new PaymentService();
        container29.injectAndInit(service29);
        service29.destroy();
        //Que el container puede manejar el ciclo de vida del objeto: inyectarlo, inicializarlo y destruirlo.
        //init() se ejecuta después de la inyección y destroy() antes de cerrar.
        //Así el objeto no solo se crea, sino que también se prepara y se libera de forma controlada.
        System.out.println("30. Mini test d’integrazione -----------------------------------------");
        AppContainer container30 = new AppContainer(true);
        PaymentService service30 = container30.getBeanNew(PaymentService.class);
        service30.makePayment(100);
        container30.destroy(service);
        //Que el contenedor debe devolver el objeto ya completamente preparado, con sus dependencias inyectadas.
        //Si una dependencia queda en null, el servicio falla al usarla.
        //También aprendes que el main no debe crear ni configurar nada a mano: solo pedir el bean al container.





    }


}
