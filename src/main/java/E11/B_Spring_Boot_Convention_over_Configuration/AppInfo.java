package E11.B_Spring_Boot_Convention_over_Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class AppInfo {
    @Value("${app.name}")
    private String appName;

    public String getAppName() {
        return appName;
    }
}
