package E10.D_Approfondimenti_e_applicazioni;

public class testjava {
    public static void main(String[] args){
        TransactionLogger logger = new TransactionLogger();
        System.out.println("31. Singleton e Prototype ------------------------------------");
        AppContainer singletonContainer = new AppContainer(true);
        IPaymentProcessor p1 = singletonContainer.getProcessor(logger,310);
        IPaymentProcessor p2 = singletonContainer.getProcessor(logger,310);
        //Singleton reduce duplicación porque devuelve la misma instancia.
        System.out.println(p1 == p2); // true

        AppContainer prototypeContainer = new AppContainer(false);
        IPaymentProcessor p3 = prototypeContainer.getProcessor(logger,310);
        IPaymentProcessor p4 = prototypeContainer.getProcessor(logger,310);
        //Prototype da más independencia porque crea una instancia nueva en cada petición.
        System.out.println(p3 == p4); // false
        //Que un objeto puede reutilizarse siempre el mismo o crearse nuevo cada vez según la configuración.
        System.out.println("32. Iniezione annidata ---------------------------------------");
        AppContainer container32 = new AppContainer(true);
        IPaymentProcessor processor32 = container32.getProcessor(logger,310);
        processor32.processPayment(100);
        //Que el container puede inyectar dependencias dentro de otras dependencias.
        //Primero crea TransactionLogger y luego lo pasa a CreditCardProcessor.
        //Si cambias la firma del metodo, también debes cambiar sus llamadas.
        System.out.println("33. Dipendenza circolare --------------------------------------");
        //Que una dependencia circular bloquea la creación automática: A necesita B y B necesita A.
        //El container no puede resolverlo si no existe un orden de construcción o una forma de romper el ciclo.
        //Esto muestra un límite importante de la inyección de dependencias.
        System.out.println("34. Iniezione condizionata avanzata ---------------------------");
        AppContainer container = new AppContainer(true);
        IPaymentProcessor processor = container.getProcessor(logger, 340);
        processor.processPayment(340);
        //Que declarar un campo no basta: si no lo asignas, queda null.
        //Si una clase depende de otra, debes inyectarla por constructor o setter.
        //Si no, al llamar a sus métodos aparece un NullPointerException.
        System.out.println("35. Lettura da file JSON ----------------------------------------");
        AppContainerDue container35 = new AppContainerDue();
        //createBean(...) devuelve Object
        //IPaymentProcessor te permite usar el metodo processPayment()
        IPaymentProcessor processor35 = (IPaymentProcessor) container35.createBean("paymentProcessor");
        //el cast es necesario para tratar el objeto como interfaz concreta
        processor35.processPayment(100);

        TransactionLogger logger35 = (TransactionLogger) container35.createBean("transactionLogger");
        logger35.log("Test log");
        //Que la configuración externa decide qué clase se crea sin cambiar el código Java.
        //Con config.json puedes sustituir implementaciones solo modificando el archivo.
        //Eso hace el sistema más flexible y desacoplado.

        //Que el container puede crear clases desde configuración usando reflexión.
        //Si una clase depende de otra, primero debe resolver esa dependencia.
        //Así puedes cambiar implementaciones sin modificar el main.

        //Reflexión es cuando Java analiza y usa clases en tiempo de ejecución.

        System.out.println("36. Aggiunta di cache dei bean ----------------------------------------");
        AppContainerTree appContainerTree= new AppContainerTree();
        Object bean1 = appContainerTree.createBean("paymentProcessor");
        Object bean2 = appContainerTree.createBean("paymentProcessor");
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean1 == bean2);

        Object logger1 = appContainerTree.createBean("transactionLogger");
        Object logger2 = appContainerTree.createBean("transactionLogger");
        System.out.println(logger1);
        System.out.println(logger2);
        System.out.println(logger1 == logger2);

        IPaymentProcessor processor36 = (IPaymentProcessor) appContainerTree.createBean("paymentProcessor");
        processor.processPayment(100);

        //Caché = reutilizar objetos y evitar recrearlos, lo que mejora rendimiento cuando son caros o repetidos.

        System.out.println("37. Gestione delle eccezioni -----------------------------------------");
        AppContainerFour appContainerFour = new AppContainerFour();
        Object bean = appContainerFour.createBean("paymentProcessor");
        System.out.println("Bean creato: " + bean);

        Object logger37 = appContainerFour.createBean("transactionLogger");
        System.out.println("Logger creato: " + logger);

        Object wrong = appContainerFour.createBean("classeCheNonEsiste");
        System.out.println("Risultato bean errato: " + wrong);

        //Que el container debe manejar fallos de configuración y de instanciación de forma clara.
        //Si falta una clase o un constructor, el programa no debe romperse sin explicación.
        //Eso hace el sistema más robusto y fácil de depurar.

        System.out.println("38. Rimozione di tutte le istanze manuali ----------------------------");
        // Nessuna istanza deve essere creata manualmente fuori dal container.
        // Tutti gli oggetti vengono richiesti al container, che centralizza creazione e gestione delle
        // dipendenze.
        // In questo modo il codice resta più pulito, modulare e facile da modificare.
        System.out.println("39. Confronto finale -------------------------------------------------");
        //Para la versión manual:
        PaymentServiceManual service = new PaymentServiceManual();
        service.makePayment(100);
        //Para la version con inyeccion:
        IPaymentProcessor processor39 = new CreditCardProcessor(logger);
        PaymentServiceInjected service39 = new PaymentServiceInjected(processor39);
        service39.makePayment(100);

        //Que crear la dependencia dentro de la clase la vuelve rígida y difícil de probar.
        //Si la dependencia se inyecta desde fuera, el código es más flexible y fácil de mantener.
        //La inyección permite cambiar implementaciones sin tocar la clase principal.

        System.out.println("40. Mini-progetto finale --------------------------------------------");
        AppContainerFive appContainerFive = new AppContainerFive();
        PaymentService paymentService = appContainerFive.getPaymentService();
        paymentService.makePayment(300);
















    }
}
