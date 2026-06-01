package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class AppContainer {
    private final boolean usePayPal;
    private final String TypePago = null;

    public AppContainer(boolean usePayPal) {
        this.usePayPal = usePayPal;
    }

    public IPaymentProcessor createProcessor() {
        if (usePayPal) {
            System.out.println("PayPalProcessor: " + usePayPal);
            return new PayPalProcessor();
        }

        System.out.println("CreditCardProcessor: " + usePayPal);
        return new CreditCardProcessor(); // oppure new CreditCardProcessor();
    }

    //public CreditCardProcessor createProcessor() {
    //    return new CreditCardProcessor();
    //}

    public PaymentService createPaymentService() {
        return new PaymentService(createProcessor());
    }
}
