package E9.C_PreparedStatement_e_sicurezza;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConfig {
    private static final Properties props = new Properties();

    static {
        try (FileInputStream in = new FileInputStream("src/main/resources/db.properties")) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Errore nel caricamento di db.properties", e);
        }
    }

    public static String getUrl() {
        return props.getProperty("url");
    }

    public static String getUser() {
        return props.getProperty("user");
    }

    public static String getPassword() {
        return props.getProperty("password");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }
}
