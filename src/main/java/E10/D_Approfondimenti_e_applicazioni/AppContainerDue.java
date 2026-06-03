package E10.D_Approfondimenti_e_applicazioni;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class AppContainerDue {
    private final Map<String, String> config;

    public AppContainerDue() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.config = mapper.readValue(new File("src/main/resources/config.json"), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Errore nel caricamento del JSON", e);
        }
    }

    public Object createBean(String name) {
        try {
            String className = config.get(name);
            Class<?> clazz = Class.forName(className);

            if (clazz == CreditCardProcessor.class) {
                TransactionLogger logger = (TransactionLogger) createBean("transactionLogger");
                return clazz.getDeclaredConstructor(TransactionLogger.class).newInstance(logger);
            }

            return clazz.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new RuntimeException("Errore nella creazione del bean: " + name, e);
        }
    }
}
