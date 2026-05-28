package E7.DataBase;

import java.sql.*;

public class conecctionMysql {

    public static void main() throws SQLException {
        System.out.println("1. Inserimento di autori. ----------------");
        String Table = "utentisssssss";
        String sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50) NOT NULL, " +
                "email VARCHAR(50) NOT NULL UNIQUE" +
                ")";
        CreateTable(sql);
        InsertTable("INSERT INTO " + Table + " (nome, email) VALUES ('niels', 'niels@gmail.com')");
        showTable("SELECT * FROM " + Table);

        System.out.println("2. Inserimento di autoriInserimento di articoli associati. --------");
        String Table1 = "autoriiii";
        String Table2 = "articoliiii";
        String sql1 = "CREATE TABLE IF NOT EXISTS " + Table1 + " (" +
                "autori_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50) NOT NULL, " +
                "email VARCHAR(50) NOT NULL " +
                ")";
        String sql2 = "CREATE TABLE IF NOT EXISTS " + Table2 + " (" +
                "articoli_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "titolo VARCHAR(50) NOT NULL, " +
                "contenuto VARCHAR(50) NOT NULL, " +
                "data_pubblicazione TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "autore_fk INT, " +
                "FOREIGN KEY (autore_fk) REFERENCES " + Table1 + " (autori_id) " +
                ")";
        CreateTable(sql1);
        CreateTable(sql2);
        InsertTable("INSERT INTO " + Table1 + " (nome, email) VALUES ('niels', 'niels@gmail.com')");
        InsertTable("INSERT INTO " + Table2 + " (titolo, contenuto, autore_fk) VALUES ('Titulo1', 'contenuto1', 1)");
        showTable("SELECT * FROM " + Table1);
        showTable("SELECT * FROM " + Table2);
        showTable("SELECT titolo, data_pubblicazione FROM " + Table2);

        System.out.println("3. Inserimento errato e vincoli. ---------------------------------");
        InsertTable("INSERT INTO " + Table2 + " (contenuto, autore_fk) VALUES ('contenuto1', 1)");
        //Errore nella Insert della tabella: Field 'titolo' doesn't have a default value

        System.out.println("4. Inserimento implicito. --------");
        InsertTable("INSERT INTO " + Table2 + " (titolo, contenuto, autore_fk) VALUES ('Titulo2', 'contenuto2', 2)");
        //Errore nella Insert della tabella: Column count doesn't match value count at row 1

        System.out.println("5. Inserimento in tabella con chiave esterna. --------------------");
        InsertTable("INSERT INTO " + Table2 + " (titolo, contenuto, autore_fk) VALUES ('Titulo2', 'contenuto2', 1000)");
        //Errore nella Insert della tabella: Cannot add or update a child row: a foreign key constraint fails (`miodb`.`articoliiii`, CONSTRAINT `articoliiii_ibfk_1` FOREIGN KEY (`autore_fk`) REFERENCES `autoriiii` (`autori_id`))

        System.out.println("6. Aggiornamento di dati specifici. --------------------");
        UpdateTable("UPDATE " + Table1 + " SET nome='Ada Lovelace', email='ada.lovelace@history.com' WHERE autori_id=1");
        showTable("Select * From " + Table1 + " LIMIT 3");

        System.out.println("7. Aggiornamento multiplo ------------------------------");
        UpdateTable("UPDATE " + Table2 + " SET titolo='titolo modified', contenuto='contenuto modified' WHERE articoli_id=2");
        showTable("Select * From " + Table2 + " LIMIT 3");

        System.out.println("8. Aggiornamento condizionale ------------------------------");
        UpdateTable("UPDATE " + Table2 + " SET titolo='titolo modified Aggiornato', contenuto='contenuto', autore_fk=1");
        showTable("Select titolo, data_pubblicazione From " + Table2 + " ORDER BY data_pubblicazione DESC LIMIT 3 ");

        System.out.println("9. Aggiornamento con filtro testuale --------------------------------");
        InsertTable("INSERT INTO " + Table1 + " (nome, email) VALUES ('Ana', 'Ana@gmail.com')");
        showTable("Select * From " + Table1 + " WHERE nome LIKE 'A%' LIMIT 3");
        UpdateTable("UPDATE " + Table1 + " SET nome='Ana-Storico' WHERE nome LIKE 'A%'");
        showTable("Select * From " + Table1 + " WHERE nome LIKE 'A%' LIMIT 3");

        System.out.println("10. Aggiornamento con intervallo --------------------------------");
        Table = "prodottiiii";
        sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "prodoti_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50), " +
                "prezzo DECIMAL(10,2), " +
                "descripcione VARCHAR(50)" +
                ")";
        CreateTable(sql);
        InsertTable("INSERT INTO " + Table + " (nome, prezzo, descripcione) VALUES ('USB', 20.20, 'descripcione USB')");
        InsertTable("INSERT INTO " + Table + " (nome, prezzo, descripcione) VALUES ('Schermo', 50.20, 'descripcione Schermo')");
        InsertTable("INSERT INTO " + Table + " (nome, prezzo, descripcione) VALUES ('Mouse',30.12, 'descripcione Mouse')");
        showTable("Select * From " + Table + " WHERE prezzo BETWEEN 5 AND 15");

        System.out.println("11. Eliminazione controllata. -------------------------------------");
        Table = "autoriiii";
        InsertTable("INSERT INTO " + Table + " (nome, email, autori_id) VALUES ('Eliminar1', 'Eliminar1@gmail',42)");
        showTable("Select * From " + Table + " WHERE nome LIKE 'E%' LIMIT 5");
        EliminarData("DELETE FROM " + Table + " WHERE autori_id=42");
        //EliminarData("DELETE FROM " + Table + " WHERE autori_id=1");
        //Errore nella Eliminar della tabella: Cannot delete or update a parent row: a foreign key constraint fails (`miodb`.`articoliiii`, CONSTRAINT `articoliiii_ibfk_1` FOREIGN KEY (`autore_fk`) REFERENCES `autoriiii` (`autori_id`))
        showTable("Select * From " + Table + " WHERE nome LIKE 'E%' LIMIT 5");

        System.out.println("12. Eliminazione multipla ------------------------------------------");
        Table = "articoliiii";
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto) VALUES ('Titulo1', 'contenuto1')");
        showTable("Select * From " + Table + " ORDER BY data_pubblicazione DESC LIMIT 5");
        EliminarData("DELETE FROM " + Table + " WHERE data_pubblicazione='2026-05-27 15:43:18.0'");
        showTable("Select * From " + Table + " ORDER BY data_pubblicazione DESC LIMIT 5");

        System.out.println("13. Eliminazione per condizione testuale ------------------------------------------");
        Table = "autoriiii";
        InsertTable("INSERT INTO " + Table + " (nome, email, autori_id) VALUES ('Eliminar1', 'Eliminar1@test',42)");
        showTable("Select * From " + Table + " WHERE email LIKE '%test%'");
        EliminarData("DELETE FROM " + Table + " WHERE email LIKE '%test%'");
        showTable("Select * From " + Table + " WHERE email LIKE '%test%'");

        System.out.println("14. Eliminazione senza WHERE (analisi del rischio) --------------------------------");
        //-- Senza WHERE cancella tutti i record: molto pericoloso in produzione.
        //DELETE FROM articoli;

        System.out.println("15. Eliminazione selettiva tramite IN  --------------------------------");
        Table = "clientiii";
        sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50) NOT NULL, " +
                "email VARCHAR(50) NOT NULL" +
                ")";
        CreateTable(sql);
        InsertTable("INSERT INTO " + Table + " (nome, email, id) VALUES ('niels', 'niels@gmail.com',2)");
        showTable("SELECT * FROM " + Table);
        EliminarData("DELETE FROM " + Table + " WHERE id in (2)");
        showTable("SELECT * FROM " + Table);

        System.out.println("16. Selezione di tutte le colonne --------------------------------------");
        Table = "articoliiii";
        showTable("SELECT * FROM " + Table + " LIMIT 3");
        showTable("SELECT titolo, data_pubblicazione, autore_fk FROM " + Table + " LIMIT 3");
        System.out.println("17. Selezione filtrata -------------------------------------------------");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Notebook', 'contenuto Notebook',3)");
        showTable("SELECT * FROM " + Table + " WHERE autore_fk=3 ORDER BY data_pubblicazione ASC LIMIT 3");

        System.out.println("18. Selezione con più condizioni --------------------------------------");
        showTable("SELECT * FROM " + Table + " WHERE autore_fk=1 AND data_pubblicazione<'2026-05-27 15:43:18.0' LIMIT 3");

        System.out.println("19. Selezione con OR ----------------------------------------------------");
        Table = "autoriiii";
        InsertTable("INSERT INTO " + Table + " (nome, email) VALUES ('Ada Lovelace', 'AdaLovelace@test')");
        InsertTable("INSERT INTO " + Table + " (nome, email) VALUES ('Alan Turing', 'AlanTuring@test')");
        showTable("SELECT * FROM " + Table + " WHERE nome='Ada Lovelace' OR nome='Alan Turing' ORDER BY nome DESC LIMIT 5");

        System.out.println("20. Selezione con IN -------------------------------------------------");
        Table = "articoliiii";
        showTable("SELECT * FROM " + Table + " WHERE autore_fk IN (2, 3, 5) ORDER BY autore_fk, data_pubblicazione ASC LIMIT 3");

        System.out.println("21. Selezione con BETWEEN -------------------------------------------------");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('SQL', 'contenuto Notebook',3)");
        showTable("SELECT * FROM " + Table + " WHERE titolo LIKE '%SQL%' LIMIT 3");

        System.out.println("23. Selezione con NOT -----------------------------------------------------");
        Table = "autoriiii";
        showTable("SELECT * FROM " + Table + " WHERE nome NOT LIKE 'A%' ORDER BY nome DESC LIMIT 5");

        System.out.println("24. Ordinamento crescente ------------------------------------------------------");
        showTable("SELECT nome FROM " + Table + " ORDER BY nome ASC LIMIT 5");

        System.out.println("25. Ordinamento decrescente -------------------------------------------------");
        Table = "articoliiii";
        showTable("SELECT * FROM " + Table + " ORDER BY data_pubblicazione ASC LIMIT 3");

        System.out.println("26. Ordinamento multiplo --------------------------------------------------------");
        showTable("SELECT * FROM " + Table + " ORDER BY autore_fk ASC, data_pubblicazione DESC LIMIT 3");

        System.out.println("27. Selezione con operatori di confronto -----------------------");
        showTable("SELECT * FROM " + Table + " WHERE articoli_id>5 LIMIT 3");
        showTable("SELECT * FROM " + Table + " WHERE articoli_id>=5 LIMIT 3");

        System.out.println("28. Combinazione di operatori ----------------------------------");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Java Book', 'contenuto Notebook',3)");
        showTable("SELECT * FROM " + Table + " WHERE articoli_id>2 AND titolo LIKE '%Java%' LIMIT 3");

        System.out.println("29. Verifica della consistenza dei dati -------------------------------");
        Table1 = "autoriiii";
        Table2 = "articoliiii";
        showTable("SELECT a.* FROM " + Table2 + " a " +
                "LEFT JOIN " + Table1 + " au ON a.autore_fk = au.autori_id " +
                "WHERE au.autori_id IS NULL");

        System.out.println("30. Aggiornamento e verifica -----------------------------------------------------");
        UpdateTable("UPDATE " + Table2 + " SET titolo='IA' WHERE articoli_id=1 LLIMIT 3");
        showTable("SELECT * FROM " + Table2);

        System.out.println("30. Aggiornamento e verifica -----------------------------------------------------");
        UpdateTable("UPDATE " + Table2 + " SET titolo='IA' WHERE articoli_id=1 LLIMIT 3");
        showTable("SELECT * FROM " + Table2);

        System.out.println("31. Inserimento e selezione combinata -------------------------------------------");
        Table = "autoriiii";
        InsertTable("INSERT INTO " + Table + " (nome, email) VALUES ('Nuovo Autore', 'AutoreNueovo@gmail.com')");
        showTable("SELECT * FROM " + Table + " WHERE email='AutoreNueovo@gmail.com' LIMIT 5");

        System.out.println("32. Inserimento multiplo e filtro con LIKE -------------------------------------------");
        Table = "articoliiii";
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Java1 Guida', 'contenuto Notebook1',5)");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Java2 Guida', 'contenuto Notebook2',5)");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Java3 Guida', 'contenuto Notebook3',5)");
        showTable("SELECT * FROM " + Table + " WHERE titolo LIKE '%Guida%' LIMIT 5");

        System.out.println("33. Cancellazione logica simulata ---------------------------------------------------------");
        Table = "articoliiii";
        //AlterTable("ALTER TABLE " + Table + " ADD COLUMN stato ENUM('pubblicato', 'archiviato') NOT NULL DEFAULT 'pubblicato'");
        UpdateTable("UPDATE " + Table + " SET stato='archiviato' WHERE data_pubblicazione>'2026-05-27 12:01:45.0'");
        showTable("SELECT * FROM " + Table + " WHERE stato='archiviato' LIMIT 5");

        System.out.println("34. Analisi di valori NULL ------------------------------------------------------------");
        AlterTable("ALTER TABLE " + Table + " MODIFY contenuto VARCHAR(50) NULL");
        InsertTable("INSERT INTO " + Table + " (titolo, contenuto, autore_fk) VALUES ('Java3 Guida', NULL,5)");
        showTable("SELECT * FROM " + Table + " WHERE contenuto IS NULL LIMIT 5");
        EliminarData("DELETE FROM " + Table + " WHERE contenuto IS NULL");
        AlterTable("ALTER TABLE " + Table + " MODIFY contenuto VARCHAR(50) NOT NULL");


    }


    public static Connection conecction() {
        String url = "jdbc:mysql://localhost:3306/miodb";
        String user = "root";
        String password = "";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connessione riuscita al database!");
            return conn;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showTable(String sql) throws SQLException {
        try {
            Connection conn = conecction();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            System.out.println("📋 Lista Table:" + sql);
            printResultSet(rs);
            conn.close(); // Chiudiamo la connessione
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void CreateTable(String sqlCreate) throws SQLException {
        try (Connection conn = conecction();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlCreate);
            System.out.println("Tabella creata con successo." + sqlCreate);
        } catch (SQLException e) {
            System.out.println("Errore nella creazione della tabella: " + e.getMessage());
        }
    }

    public static void InsertTable(String sqlInsert) {
        try (Connection conn = conecction();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlInsert);
            System.out.println("Data Insert con successo." + sqlInsert);
        } catch (SQLException e) {
            System.out.println("Errore nella Insert della tabella: " + e.getMessage());
        }
    }


    public static void AlterTable(String sqlInsert) {
        try (Connection conn = conecction();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlInsert);
            System.out.println("Data AlterTable con successo." + sqlInsert);
        } catch (SQLException e) {
            System.out.println("Errore nella AlterTable della tabella: " + e.getMessage());
        }
    }

    public static void UpdateTable(String sqlInsert) {
        try (Connection conn = conecction();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlInsert);
            System.out.println("Data Updtae con successo." + sqlInsert);
        } catch (SQLException e) {
            System.out.println("Errore nella Update della tabella: " + e.getMessage());
        }
    }

    public static void EliminarData(String sqlInsert) {
        try (Connection conn = conecction();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlInsert);
            System.out.println("Data Eliminar con successo." + sqlInsert);
        } catch (SQLException e) {
            System.out.println("Errore nella Eliminar della tabella: " + e.getMessage());
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + ": " + rs.getObject(i) + " | ");
            }
            System.out.println();
        }
    }
}
