
import E11.A_Spring_Core_Configurazione_Java_based.AppConfig;
import E11.A_Spring_Core_Configurazione_Java_based.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AppConfigTest {
    @Test
    void paymentServiceBeanExists() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            assertNotNull(context.getBean(PaymentService.class));
        }
    }
}
