package E11.B_Spring_Boot_Convention_over_Configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupCheck implements CommandLineRunner {
    private final AppInfo appInfo;

    public StartupCheck(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    @Override
    public void run(String... args) {
        System.out.println("app.name = " + appInfo.getAppName());
    }

}
