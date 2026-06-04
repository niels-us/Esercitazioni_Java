import E11.B_Spring_Boot_Convention_over_Configuration.PaymentApplication;
import E11.B_Spring_Boot_Convention_over_Configuration.PaymentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = PaymentApplication.class)
public class PaymentTests {
    @Autowired
    private PaymentService service;

    @Test
    void contextLoads() {
        assertNotNull(service);
    }
}
