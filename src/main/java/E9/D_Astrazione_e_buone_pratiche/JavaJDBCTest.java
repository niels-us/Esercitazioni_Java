package E9.D_Astrazione_e_buone_pratiche;

import java.sql.*;

public class JavaJDBCTest {
    public static void main(String[] args) {
        //AutoreRepository repo = new AutoreRepository();
        IAutoreRepository repo = new AutoreRepository();

        System.out.println("31 – Creare una classe Repository ---------------------------------");
        String Table = "utente";
        String sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "utente_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50), " +
                "email VARCHAR(50), " +
                "username VARCHAR(50), " +
                "password VARCHAR(50) " +
                ")";
        repo.Script_SQL(sql);
        repo.create("Niels300", "niels@example.com", "nielsus","123456");
        repo.showTable("Select * From " + Table + " Where nome Like '%20%' LIMIT 2");
        repo.update("Niels Updated", "niels@example.com");
        repo.readAll();//Hai Limit Di tree
        repo.delete("niels@example.com");
        repo.showTable("Select * From " + Table + " Where email='niels@example.com' LIMIT 2");

        System.out.println("32 – Interfaccia astratta ---------------------------------");
        //src/main/java/E9/D_Astrazione_e_buone_pratiche/IAutoreRepository.java

        System.out.println("33 – Decoupling con interfaccia ----------------------------");
        //IAutoreRepository repo = new AutoreRepository();

        System.out.println("34 – Gestione delle risorse centralizzata ------------------");
        //Revisar

        System.out.println(" 35 – Logging delle query ----------------------------------");
        //Listo System.out.println("readAll: " + sql);

        System.out.println("36 – Transazioni -------------------------------------------");
        repo.inserisciDueAutoriInTransazione();
        repo.showTable("Select * From " + Table + " Where email='utente2@example.com' LIMIT 2");
        // Revisare: conn.setAutoCommit(false);
        // Revisare: conn.commit();

        System.out.println("37 – Rollback -------------------------------------------------");
        repo.inserisciConRollback();

        System.out.println("38 – Gestione degli errori centralizzata -----------------------");
        // Revisare DBUtils.handleSQLException(new SQLException("Transazione annullata", e));

        System.out.println(" 39 – Test di portabilità --------------------------------------");
        // Il codice Java resta identico perché legge tutto da DBConfig; cambia solo l’URL e,
        // se serve, la dipendenza del driver PostgreSQL.

        System.out.println("40 – Mini applicazione finale -----------------------------------");
        Table = "persone";
        sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "persone_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50), " +
                "email VARCHAR(50), " +
                "username VARCHAR(50), " +
                "password VARCHAR(50) " +
                ")";
        repo.Script_SQL(sql);
        repo.Script_SQL("Insert Into " + Table + " (nome,email,username,password) Values ('Mario','Mario@gamil.com','Mariosus','789456') ");
        repo.showTable("Select * From " + Table + " LIMIT 5");
        repo.Script_SQL("Update " + Table + " Set nome='Juan Modified',email='JuanModified@outlook.com',username='JuansusModified',password='123Modified' Where persone_id=2 ");
        repo.showTable("Select * From " + Table + " LIMIT 5");
        repo.Script_SQL("Delete From " + Table + " Where persone_id=3 ");
        repo.showTable("Select * From " + Table + " LIMIT 5");
    }
}
