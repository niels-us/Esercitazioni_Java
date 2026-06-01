package E10.B_Creare_e_gestire_un_semplice_container_IoC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppContainer {

    private final Map<String, Object> beans = new HashMap<>();
    private final Map<String, Object> beansNew = new HashMap<>();
    private final Properties config = new Properties();

    private final boolean usePayPal;

    public AppContainer(boolean usePayPal) {
        this.usePayPal = usePayPal;
    }

    public Object getBean(String name) {


        if (beans.containsKey(name)) return beans.get(name);
        Object bean = null;
        if ("paymentProcessor".equals(name)) {
            bean = usePayPal ? new PayPalProcessor() : new CreditCardProcessor();
        } else if ("transactionLogger".equals(name)) {
            bean = new TransactionLogger();
        } else if ("paymentService".equals(name)) {
            bean = new PaymentService(
                    (IPaymentProcessor) getBean("paymentProcessor"),
                    (TransactionLogger) getBean("transactionLogger")
            );
        } else if ("refundService".equals(name)) {
            PaymentService service = new PaymentService(
                    (IPaymentProcessor) getBean("paymentProcessor"),
                    (TransactionLogger) getBean("transactionLogger")
            );
            service.initialize();
            bean = service;
        }
        if (bean != null) {
            beans.put(name, bean);
            System.out.println("Guardado en beans: " + name + " -> " + bean);
            System.out.println("beans size: " + beans.size());
        }

        return bean;
    }

    public <T> T getBeanNew(Class<T> type) {
        for (Object bean : beansNew.values()) {
            if (type.isInstance(bean)) return type.cast(bean);
        }
        System.out.println("Not found the class: " + type.getSimpleName() + " in getBeanNew");
        Object bean = null;
        if (type == IPaymentProcessor.class) {
            bean = getBean("paymentProcessor");
        } else if (type == TransactionLogger.class) {
            bean = getBean("transactionLogger");
        } else if (type == PaymentService.class) {
            PaymentService service = new PaymentService(
                    (IPaymentProcessor) getBean("paymentProcessor"),
                    (TransactionLogger) getBean("transactionLogger")
            );
            service.initialize();
            bean = service;
        } else if (type == RefundService.class) {
            bean = new RefundService(
                    (IPaymentProcessor) getBean("paymentProcessor"),
                    (TransactionLogger) getBean("transactionLogger")
            );
        }
        if (bean != null) {
            beansNew.put(type.getSimpleName(), bean);
            System.out.println("Guardado en beansNew: " + type.getSimpleName() + " -> " + bean);
            System.out.println("beansNew size: " + beansNew.size());
            return type.cast(bean);
        }
        return null;
    }


    public PaymentService createPaymentService() {
        return (PaymentService) getBean("paymentService");
    }

    public IPaymentProcessor getProcessor(String name) {
        if ("paypal".equalsIgnoreCase(name)) return new PayPalProcessor();
        if ("creditcard".equalsIgnoreCase(name)) return new CreditCardProcessor();

        try (FileInputStream in = new FileInputStream("src/main/resources/config.properties")) {
            config.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento di config.properties", e);
        }
        String processor = config.getProperty("payment.processor");
        if ("paypal".equalsIgnoreCase(processor)) {
            return new PayPalProcessor();
        }
        return new CreditCardProcessor();
        //throw new IllegalArgumentException("Processor sconosciuto: " + name);
    }

    public void printBeans() {
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void close() {
        PaymentService service = (PaymentService) beans.get("paymentService");
        if (service != null) {
            service.shutdown();
        }
    }
}
