package E9.A_Architettura_e_configurazione_JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JavaJDBC {
    public static void main() throws SQLException {
        System.out.println("1 – Comprendere il ruolo di JDBC ------------------------");
        /**
         Contesto: hai un’applicazione Java che deve accedere a un database MySQL.
         Obiettivo: scrivi un breve commento (in un file JDBCIntro.java) che descriva, con tue parole, la differenza tra JDBC e il driver MySQL.
         Verifica: il commento deve menzionare che JDBC è una specifica e il driver un’implementazione concreta.
         **/
        // JDBC è una specifica Java che definisce come un programma può connettersi e lavorare con un database.
        // Il driver MySQL è un’implementazione concreta di JDBC per comunicare con MySQL.
        // In pratica, JDBC dice cosa fare, mentre il driver MySQL realizza davvero la connessione e l’esecuzione delle query.

        System.out.println("6 – Stampare i metadati del driver Obiettivo: --------------------");
        DatabaseMetaData meta = DBConfig.getConnection().getMetaData();
        System.out.println("Driver: " + meta.getDriverName());
        System.out.println("Versione driver: " + meta.getDriverVersion());
        System.out.println("7 – Gestione errori di connessione -------------------------------");
        System.out.println("8 – File di configurazione esterno -------------------------------");
        //Obiettivo: salva le credenziali in un file db.properties.
        //Indicazioni: usa Properties per leggere url, user, password.
        //Verifica: la connessione si apre senza modificare il codice Java.
        System.out.println("9 – Parametri centralizzati -------------------------------");
        System.out.println("getPassword:" + DBConfig.getPassword() + " getUrl:" + DBConfig.getUrl() + " getUser:" + DBConfig.getUser());
        System.out.println("10 – Caricamento esplicito del driver -------------------------------");
        // In passato era necessario caricare esplicitamente il driver JDBC con Class.forName.
        // Oggi è opzionale perché il driver MySQL si registra automaticamente tramite il meccanismo SPI.
        //Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
