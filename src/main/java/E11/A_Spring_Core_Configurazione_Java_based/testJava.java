package E11.A_Spring_Core_Configurazione_Java_based;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testJava {
    public static void main(String[] args) {
        System.out.println("1. Creazione dell’interfaccia base ---------------------------------------");
        PaymentProcessor processor1 = new CreditCardProcessor();
        processor1.processPayment(100);
        System.out.println("2. Implementazione concreta PayPalProcessor ------------------------------");
        PaymentProcessor processor2 = new PayPalProcessor();
        processor2.processPayment(100);
        System.out.println("3. Implementazione alternativa ------------------------------------------");
        PaymentProcessor paypal = new PayPalProcessor();
        paypal.processPayment(100);
        PaymentProcessor creditCard = new CreditCardProcessor();
        creditCard.processPayment(100);
        System.out.println("4. Creazione del servizio PaymentService --------------------------------");
        PaymentProcessor processor4 = new CreditCardProcessor();
        PaymentService paymentService = new PaymentService(processor4);
        paymentService.makePayment(100);
        processor4 = new PayPalProcessor();
        paymentService = new PaymentService(processor4);
        paymentService.makePayment(100);
        //Que PaymentService no crea la dependencia por sí mismo: la recibe desde fuera por el
        // constructor.
        //Eso lo hace más flexible, porque puedes pasarle PayPalProcessor o CreditCardProcessor.
        //También queda más fácil de probar porque puedes inyectar otra implementación.

        System.out.println("5. Creazione di una classe di configurazione ----------------------------");
        //Que para usar @Configuration necesitas tener Spring agregado al proyecto.
        //Si Maven no está disponible en la terminal, puedes compilar desde IntelliJ o usar mvnw si existe.
        //AppConfig sirve para decirle a Spring cómo crear y organizar los beans de la aplicación.
        //En resumen:
        //centraliza la configuración
        //reemplaza XML por código Java
        //permite definir objetos que Spring gestionará automáticamente
        //Si quieres, te explico también la diferencia entre @Configuration y @Component.
        System.out.println("6. Definizione del primo bean --------------------------------------------");
        //@Bean le dice a Spring: “este metodo crea un objeto que Spring debe gestionar”.
        //En resumen:
        //el metodo devuelve un objeto
        //Spring lo registra como bean en el contenedor
        //luego puedes inyectarlo en otras clases
        System.out.println("7. Definizione di un bean dipendente ------------------------------------");
        //Que un bean puede depender de otro bean definido en la misma configuración.
        //Spring resuelve esa relación y construye primero la dependencia necesaria.
        //Así centralizas la creación y el cableado de objetos en AppConfig.
        System.out.println("8. Avvio del container Spring ------------------------------------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean(PaymentService.class));
        PaymentService service = context.getBean(PaymentService.class);
        service.makePayment(150);
        context.close();
        //Que Spring construye y conecta los objetos por ti desde AppConfig.
        //PaymentService recibe el PaymentProcessor que tú le indiques.
        //La implementación usada depende del bean que referencias explícitamente.

        //Un @Bean es un objeto que Spring crea y gestiona.
        //Sirve para registrar componentes en el contenedor.
        //Luego otros beans pueden usarlo por inyección.
        System.out.println("9. Verifica del comportamento Singleton --------------------------------");
        AnnotationConfigApplicationContext context9 = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentProcessor p1 = context9.getBean(PaymentProcessor.class);
        PaymentProcessor p2 = context9.getBean(PaymentProcessor.class);
        System.out.println(p1 == p2);
        //Spring reutiliza la misma instancia de un bean por defecto, eso es comportamiento singleton.
        //En este ejemplo falló porque había dos beans del mismo tipo y Spring no sabía cuál elegir.
        //Se aprende que el singleton vale por bean, pero si hay varios del mismo tipo hay que especificar cuál usar.
        System.out.println("10. Sostituzione di implementazione -----------------------------------");
        AnnotationConfigApplicationContext context10 = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context10.getBean(PaymentService.class));
        PaymentService service10 = context10.getBean(PaymentService.class);
        service10.makePayment(150);
        context10.close();
        //antes: PaymentService recibía PayPalProcessor
        //ahora: PaymentService recibe CreditCardProcessor
        //el servicio sigue igual, cambia solo el cableado en AppConfig

        //Cambiar PaymentService sería editar su código interno.
        //Cambiar AppConfig solo cambia qué implementación se le inyecta.
        //La lección muestra que Spring permite sustituir comportamiento sin tocar la clase del servicio.
        System.out.println("11. Aggiunta di più bean dello stesso tipo -------------------------------");
        AnnotationConfigApplicationContext context11 = new AnnotationConfigApplicationContext(AppConfig11.class);
        PaymentProcessor paypal11 = (PaymentProcessor) context11.getBean("paymentProcessor");
        PaymentProcessor card11 = (PaymentProcessor) context11.getBean("creditCardProcessor");
        paypal11.processPayment(100);
        card11.processPayment(100);
        context11.close();
        //Que Spring puede tener varios beans del mismo tipo.
        //Si pides uno por tipo y hay más de uno, aparece ambigüedad.
        //Para evitarlo, debes pedir el bean por nombre y elegir explícitamente la implementación.
        System.out.println("12. Risoluzione di ambiguità ------------------------------------------------");
        AnnotationConfigApplicationContext context12 = new AnnotationConfigApplicationContext(AppConfig11.class);
        PaymentProcessor processor = context12.getBean(PaymentProcessor.class);
        processor.processPayment(100);
        context12.close();
        //Que @Primary indica cuál bean Spring debe usar por defecto cuando hay varios del mismo tipo.
        //Así se resuelve la ambigüedad sin tener que pedir el bean por nombre.
        //La anotación solo marca una implementación como la preferida.
        System.out.println("13. Selezione tramite @Qualifier --------------------------------------------");
        AnnotationConfigApplicationContext context13 = new AnnotationConfigApplicationContext(AppConfig.class);
        PaymentService service13 = context13.getBean(PaymentService.class);
        service13.makePayment(100);
        context13.close();
        //Que @Qualifier permite elegir explícitamente qué implementación inyectar cuando hay varias del mismo tipo.
        //@Autowired hace la inyección automática, pero @Qualifier decide cuál bean concreto usar.
        //Así evitas ambigüedades sin depender de @Primary.
        System.out.println("14. Aggiunta di un logger ---------------------------------------------------");
        PaymentProcessor processor14 = new PayPalProcessor();
        TransactionLogger logger14 = new TransactionLogger();
        PaymentService14 service14 = new PaymentService14(processor14, logger14);
        service14.makePayment(100);
        //Que una clase puede depender de más de un objeto y recibirlos por el constructor.
        //Así PaymentService no solo procesa el pago, también registra el evento con TransactionLogger.
        //La lección muestra cómo combinar varias dependencias sin crear objetos dentro del servicio.
        //Así PaymentService solo lo usa, no lo instancia.Eso es inyección de dependencias.
        System.out.println("15. Uso di @PostConstruct -------------------------------------------------");
        AnnotationConfigApplicationContext context15 = new AnnotationConfigApplicationContext(AppConfig11.class);
        PaymentService service15 = context15.getBean(PaymentService.class);
        service15.makePayment(150);
        context15.close();
        //Que @PostConstruct ejecuta un metodo justo después de crear e inyectar el bean.
        //Eso permite inicializar el objeto antes de usarlo.
        //El contenedor Spring llama ese ciclo automáticamente al arrancar el contexto.
        System.out.println("16. Uso di @PreDestroy ----------------------------------------------------");
        AnnotationConfigApplicationContext context16 = new AnnotationConfigApplicationContext(AppConfig11.class);
        PaymentService service16 = context16.getBean(PaymentService.class);
        service16.makePayment(150);
        context16.close();
        //Que @PreDestroy se ejecuta al cerrar el contexto para hacer limpieza del bean.
        //Spring maneja el ciclo de vida completo: inicialización con @PostConstruct y destrucción con @PreDestroy.
        //Así puedes liberar recursos o mostrar mensajes antes de que el bean desaparezca.
        System.out.println("17. Introduzione di @Component -------------------------------------------");
        AnnotationConfigApplicationContext context17 = new AnnotationConfigApplicationContext(AppConfig17.class);
        PaymentProcessor processor17 = context17.getBean(PaymentProcessor.class);
        processor17.processPayment(100);
        context17.close();
        //Que @Bean registra objetos manualmente en AppConfig, mientras @Component permite que Spring detecte clases automáticamente con scan.
        //Con @Bean controlas explícitamente qué se crea; con @Component Spring lo encuentra solo.
        //Aprendes la diferencia entre configuración manual y detección automática de beans.
        //Que @Component permite que Spring detecte una clase automáticamente sin definirla con @Bean.
        //Spring la registra como bean durante el component scan.
        //Si usas @Component y también @Bean para la misma clase, puedes crear duplicados y ambigüedad.
        //Que Spring puede tener varios beans del mismo tipo y entonces aparece ambigüedad.
        //Si pides por tipo, Spring solo funciona cuando hay un único bean; si hay varios, debes elegir por nombre o usar @Primary.
        //La lección muestra que la configuración debe estar limpia para evitar duplicados innecesarios.
        System.out.println("18. Attivare la scansione automatica --------------------------------------");
        AnnotationConfigApplicationContext context18 = new AnnotationConfigApplicationContext(AppConfig17.class);
        PaymentProcessor processor18 = context18.getBean(PaymentProcessor.class);
        processor18.processPayment(100);
        context18.close();
        //Que @ComponentScan activa la búsqueda automática de clases anotadas con @Component.
        //Spring las detecta y las registra como beans sin necesidad de definirlas con @Bean.
        //Así entiendes la diferencia entre registrar beans manualmente y descubrirlos automáticamente.
        System.out.println("19. Iniezione automatica con @Autowired ------------------------------------");
        AnnotationConfigApplicationContext context19 = new AnnotationConfigApplicationContext(AppConfig17.class);
        PaymentProcessor processor19 = context19.getBean(PaymentProcessor.class);
        processor19.processPayment(100);
        context19.close();
        //Que Spring puede inyectar dependencias automáticamente por constructor con @Autowired.
        //Así ya no necesitas crear ni cablear PaymentService manualmente en AppConfig.
        //Aprendes a delegar la creación y conexión de objetos al contenedor de Spring.
        //con @ComponentScan, Spring descubre los componentes
        //sin @ComponentScan, Spring solo conoce los beans que declares explícitamente con @Bean
        System.out.println("20. Test di configurazione ------------------------------------------------");
        //Que puedes verificar la configuración de Spring con un test JUnit.
        //El test confirma que el bean existe y se instancia correctamente.
        //Así validas la configuración sin ejecutar toda la aplicación.





    }
}
