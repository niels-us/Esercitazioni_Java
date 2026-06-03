package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class PaymentService {
    @Inject
    public IPaymentProcessor paymentProcessor;

    //@Inject marca el campo para que el container sepa que debe rellenarlo.
    @Inject
    private NotificationService notificationService;

    public void setPaymentProcessor(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
        if (notificationService != null) {
            notificationService.send("Pagamento completato di " + amount + " EUR");
        } else {
            System.out.println("NotificationService non disponibile");
        }

    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void init() {
        System.out.println("init(): PaymentService");
    }

    public void destroy() {
        System.out.println("destroy(): PaymentService");
    }

}


