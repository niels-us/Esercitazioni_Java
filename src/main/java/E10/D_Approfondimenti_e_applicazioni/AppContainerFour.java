package E10.D_Approfondimenti_e_applicazioni;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AppContainerFour {
    private final Map<String, Object> cache = new HashMap<>();
    private final Map<String, String> config;

    public AppContainerFour() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.config = mapper.readValue(new File("src/main/resources/config.json"), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nel caricamento del JSON", e);
        }
    }


    public Object createBean(String name) {
        if (cache.containsKey(name)) {
            return cache.get(name);
        }

        try {
            String className = config.get(name);

            if (className == null || className.isBlank()) {
                System.out.println("Errore: nessuna classe configurata per il bean '" + name + "'");
                return null;
            }

            Class<?> clazz = Class.forName(className);

            Object bean;
            if (clazz == CreditCardProcessor.class) {
                TransactionLogger logger = (TransactionLogger) createBean("transactionLogger");
                bean = clazz.getDeclaredConstructor(TransactionLogger.class).newInstance(logger);
            } else {
                bean = clazz.getDeclaredConstructor().newInstance();
            }

            cache.put(name, bean);
            return bean;

        } catch (ClassNotFoundException e) {
            System.out.println("Errore: classe non trovata per il bean '" + name + "'");
            return null;
        } catch (NoSuchMethodException e) {
            System.out.println("Errore: costruttore non trovato per il bean '" + name + "'");
            return null;
        } catch (Exception e) {
            System.out.println("Errore nella creazione del bean '" + name + "': " + e.getMessage());
            return null;
        }
    }
}
