package E10.C_Dependency_Injection_Modalita_e_applicazioni;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.reflect.Field;

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
            bean = new PaymentService();
        } else if ("refundService".equals(name)) {
            PaymentService service = new PaymentService();
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
            bean = new PaymentService();
            ((PaymentService) bean).setPaymentProcessor((IPaymentProcessor) getBean("paymentProcessor"));

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

    public IPaymentProcessor getProcessorForAmount(double amount) {
        if (amount > 500) {
            return new PayPalProcessor();
        }
        return new CreditCardProcessor();
    }

    public void injectDependencies(Object target) {
        //Recorre los campos del objeto target.
        for (Field field : target.getClass().getDeclaredFields()) {
            System.out.println("field: " + field.getName() + " -> " + Inject.class.getSimpleName());
            //Si encuentra un campo anotado con @Inject
            if (field.isAnnotationPresent(Inject.class)) {
                Object dependency = null;
                //crea la dependencia correspondiente y la asigna automáticamente
                // a ese campo usando reflexión.
                if (field.getType() == IPaymentProcessor.class) {
                    dependency = getProcessor("paypal"); // o "creditcard"
                } else if (field.getType() == NotificationService.class) {
                    dependency = new NotificationService();
                } else if (field.getType() == TransactionLogger.class) {
                    dependency = new TransactionLogger();
                }

                try {
                    field.setAccessible(true);
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Errore nell'iniezione automatica", e);
                }
            }
        }
    }

    public void injectAndInit(Object target) {
        injectDependencies(target);

        if (target instanceof PaymentService service) {
            service.init();
        }
    }

    public void destroy(Object target) {
        if (target instanceof PaymentService service) {
            service.destroy();
        }
    }
}
