package E9.C_PreparedStatement_e_sicurezza;

import java.sql.*;

public class JavaJDBCTest {
    public static void main() throws SQLException {
        System.out.println(("21 – Creare un PreparedStatement per inserimento ----------"));
        InsertAutore("Niels1", "nuevonielgs1@gmail.com");
        cercaAutorePerEmail("Niels1", "nuevonielgs1@gmail.com");

        System.out.println("22 – PreparedStatement per ricerca --------------------------");
        cercaAutorePerEmail("Niels", "nuevonielgs@gmail.com");

        System.out.println(" 23 – PreparedStatement per aggiornamento ---------------)");
        aggiornaNomePerEmail("Niels2000", "nuevonielgs@gmail.com");
        cercaAutorePerEmail("Niels2000", "nuevonielgs@gmail.com");

        System.out.println("24 – PreparedStatement per eliminazione -------------------------");
        eliminaAutorePerEmail("nuevonielgs@gmail.com");
        cercaAutorePerEmail("Niels2000", "nuevonielgs@gmail.com");

        System.out.println("25 – PreparedStatement con LIKE ---------------------------------");
        cercaAutoriPerDominio("nuevo");

        System.out.println("26 – Evitare SQL Injection --------------------------------------");
        System.out.println(login("Niels", "niels@outlook.com"));

        System.out.println("27 – Batch di PreparedStatement --------------------------------------");
        inserisciAutoriBatch();
        cercaAutorePerEmail("Mario Rossi", "mario@example.com");

        System.out.println("28 – Lettura sicura con ResultSet ---------------------------------------)");
        System.out.println("29 – Login sicuro         ---------------------------------------)");
        String Table = "utente";
        String sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "utente_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50), " +
                "email VARCHAR(50), " +
                "username VARCHAR(50), " +
                "password VARCHAR(50) " +
                ")";
        Script_SQL(sql);
        Script_SQL("Insert Into " + Table + "(nome,email,username,password) Values ('Niels','niels@hotmail.com','nielsus','123456')");
        showTable("Select * From " + Table + " LIMIT 1");
        boolean Status = checkLogin("nielsus","123456");
        System.out.println("CkeckLogin e " + Status);

        System.out.println("30 – Riuso del PreparedStatement -----------------------------------------");
        inserisci5Autori();
        showTable("Select * From autori  Where email Like '%exampless%' LIMIT 5");


    }

    public static void inserisci5Autori() {
        String sql = "INSERT INTO autori (nome, email) VALUES (?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 1; i <= 5; i++) {
                ps.setString(1, "Autore " + i);
                ps.setString(2, "autore" + i + "@exampless.com");
                ps.addBatch();
            }

            int[] risultati = ps.executeBatch();
            System.out.println("Righe aggiunte: " + risultati.length);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'inserimento dei 5 record", e);
        }
    }

    public static boolean checkLogin(String u, String p) {
        String sql = "SELECT 1 FROM utente WHERE username = ? AND password = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, u);
            ps.setString(2, p);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nel login sicuro", e);
        }
    }

    public static void inserisciAutoriBatch() {
        String sql = "INSERT INTO autori (nome, email) VALUES (?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "Mario Rossi");
            ps.setString(2, "mario@example.com");
            ps.addBatch();

            ps.setString(1, "Luca Bianchi");
            ps.setString(2, "luca@example.com");
            ps.addBatch();

            ps.setString(1, "Giulia Verdi");
            ps.setString(2, "giulia@example.com");
            ps.addBatch();

            int[] risultati = ps.executeBatch();
            System.out.println("Inseriti " + risultati.length + " autori.");

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'inserimento batch degli autori", e);
        }
    }

    public static boolean login(String nome, String email) {
        String sql = "SELECT * FROM autori WHERE nome = ? AND email = ?";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            System.out.println("PS" + ps);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Errore nel login", e);
        }
    }

    public static void cercaAutoriPerDominio(String email) {
        String sql = "SELECT * FROM autori WHERE email LIKE ? LIMIT 3";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + email + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            "ID: " + rs.getInt("autori_id") +
                                    ", Nome: " + rs.getString("nome") +
                                    ", Email: " + rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nella ricerca con LIKE", e);
        }
    }

    public static void eliminaAutorePerEmail(String email) {
        String sql = "DELETE FROM autori WHERE email = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Eliminazione riuscita. Righe eliminate: " + rowsDeleted + " - " + sql);
            } else {
                System.out.println("Nessun autore trovato con questa email.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'eliminazione dell'autore", e);
        }
    }

    public static void aggiornaNomePerEmail(String nome, String email) {
        String sql = "UPDATE autori SET nome = ? WHERE email = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setString(2, email);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Aggiornamento riuscito. Righe modificate: " + rowsUpdated + " - " + sql);
            } else {
                System.out.println("Nessun autore trovato con questa email.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'aggiornamento dell'autore", e);
        }
    }

    public static void cercaAutorePerEmail(String nome, String email) {
        String sql = "SELECT * FROM autori WHERE nome=? And email = ? LIMIT 3";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.println(sql);

            ps.setString(1, nome);
            ps.setString(2, email);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                            "ID: " + rs.getInt("autori_id") +
                                    ", Nome: " + rs.getString("nome") +
                                    ", Email: " + rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nella ricerca dell'autore per email", e);
        }
    }

    public static void InsertAutore(String nome, String email) {
        String sql = "INSERT INTO autori (nome, email) VALUES (?, ?)";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            //ps.setInt(1, 10);
            ps.setString(1, nome);
            ps.setString(2, email);
            int righe = ps.executeUpdate();
            System.out.println("Righe inserite: " + righe + " - " + sql);
        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'inserimento dell'autore", e);
        }
    }

    public static void testExecute(String sql) {
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            boolean hasResultSet = stmt.execute(sql);

            if (hasResultSet) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    System.out.println(
                            "ID: " + rs.getInt("autori_id") +
                                    ", Nome: " + rs.getString("nome") +
                                    ", Email: " + rs.getString("email")
                    );
                }
            } else {
                System.out.println("La query non ha restituito un ResultSet.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'uso di execute()", e);
        }
    }

    public static void SelectAutori(String sql) {
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("autori_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore nella lettura degli autori: " + e.getMessage(), e);
        }
    }

    public static void showTable(String sql) throws SQLException {
        try {
            Connection conn = DBConfig.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            System.out.println("📋 Lista Table:" + sql);
            printResultSet(rs);
            conn.close(); // Chiudiamo la connessione
        } catch (SQLException e) {
            System.out.println("Errore nella execution SQL: " + e.getMessage());
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

    public static void Script_SQL(String sql) throws SQLException {
        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Sql con successo." + sql);
        } catch (SQLException e) {
            System.out.println("Errore nella execution SQL: " + e.getMessage());
        }
    }


}
