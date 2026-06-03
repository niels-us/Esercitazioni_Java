package E10.D_Approfondimenti_e_applicazioni;

import E10.C_Dependency_Injection_Modalita_e_applicazioni.Inject;

import java.util.HashMap;
import java.util.Map;

public class AppContainer {

    private final Map<String, Object> singletons = new HashMap<>();
    private final boolean singletonMode;
    PayPalProcessor payPalProcessor;

    public AppContainer(boolean singletonMode) {
        this.singletonMode = singletonMode;
    }

    public IPaymentProcessor getProcessor(TransactionLogger logger, double amount) {
        if (amount < 100) {
            if (singletonMode) {
                if (singletons.containsKey("paymentProcessor")) {
                    return (IPaymentProcessor) singletons.get("paymentProcessor");
                }

                IPaymentProcessor processor = new PayPalProcessor(logger);
                singletons.put("paymentProcessor", processor);
                return processor;
            }

            return new PayPalProcessor(logger);
        }

        return new CreditCardProcessor(logger);
    }

    /**public class A {
        private final B b;

        public A(B b) {
            this.b = b;
        }
    }
    public class B {
        private final A a;

        public B(A a) {
            this.a = a;
        }
    }**/
}