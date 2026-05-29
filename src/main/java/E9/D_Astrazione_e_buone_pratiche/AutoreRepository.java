package E9.D_Astrazione_e_buone_pratiche;

import java.sql.*;

public class AutoreRepository implements IAutoreRepository {
    public void create(String nome, String email, String username, String password) {
        String sql = "INSERT INTO utente (nome, email,username,password) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, email);
            ps.setString(4, email);
            ps.executeUpdate();
            System.out.println("create: " + ps);
        } catch (SQLException e) {
            throw new RuntimeException("Errore nella creazione dell'autore", e);
        }
    }

    public void readAll() {
        String sql = "SELECT * FROM utente LIMIT 3";
        System.out.println("readAll: " + sql);

        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("utente_id") +
                                ", Nome: " + rs.getString("nome") +
                                ", Email: " + rs.getString("email")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException("Errore nella lettura degli autori", e);
        }
    }

    public void update(String nuovoNome, String email) {
        String sql = "UPDATE utente SET nome = ? WHERE email = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuovoNome);
            ps.setString(2, email);
            ps.executeUpdate();
            System.out.println("update: " + ps);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'aggiornamento dell'autore", e);
        }
    }

    public void delete(String email) {
        String sql = "DELETE FROM utente WHERE email = ?";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.executeUpdate();

            System.out.println("delete: " + ps);

        } catch (SQLException e) {
            throw new RuntimeException("Errore nell'eliminazione dell'autore", e);
        }
    }

    public void Script_SQL(String sql) {
        try (Connection conn = E9.C_PreparedStatement_e_sicurezza.DBConfig.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Sql con successo." + sql);
        } catch (SQLException e) {
            System.out.println("Errore nella execution SQL: " + e.getMessage());
        }
    }

    public void showTable(String sql) {
        try {
            Connection conn = E9.C_PreparedStatement_e_sicurezza.DBConfig.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            System.out.println("📋 Lista Table:" + sql);
            printResultSet(rs);
            conn.close(); // Chiudiamo la connessione
        } catch (SQLException e) {
            System.out.println("Errore nella execution SQL: " + e.getMessage());
        }
    }

    public void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + ": " + rs.getObject(i) + " | ");
            }
            System.out.println();
        }
    }

    public void inserisciDueAutoriInTransazione() {
        String sql1 = "INSERT INTO utente (nome, email) VALUES (?, ?)";
        String sql2 = "INSERT INTO utente (nome, email) VALUES (?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps1 = conn.prepareStatement(sql1);
             PreparedStatement ps2 = conn.prepareStatement(sql2)) {

            conn.setAutoCommit(false);
            //setAutoCommit(false); desactiva el commit automático.
            //Así, los cambios quedan pendientes hasta que llames a commit() o rollback().

            ps1.setString(1, "utente 1");
            ps1.setString(2, "autore1@example.com");
            ps1.executeUpdate();

            ps2.setString(1, "utente 2");
            ps2.setString(2, "utente2@example.com");
            ps2.executeUpdate();

            conn.commit();
            //commit() confirma definitivamente las operaciones realizadas dentro de una transacción.
            //Se usa después de desactivar autoCommit para aplicar todos los cambios juntos.
            //Si algo falla antes del commit(), se puede hacer rollback() para deshacerlos.

        } catch (SQLException e) {
            throw new RuntimeException("Errore nella transazione", e);
        }
    }

    public void inserisciConRollback() {
        String sql = "INSERT INTO utente (nome, email) VALUES (?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement ps1 = conn.prepareStatement(sql);
             PreparedStatement ps2 = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            try {
                ps1.setString(1, "Autore 1");
                ps1.setString(2, "autore1@example.com");
                ps1.executeUpdate();

                throw new RuntimeException("Errore simulato tra le due INSERT");

                // ps2.setString(1, "Autore 2");
                // ps2.setString(2, "autore2@example.com");
                // ps2.executeUpdate();

                // conn.commit();
            } catch (Exception e) {
                conn.rollback();
                DBUtils.handleSQLException(new SQLException("Transazione annullata", e));
            }

        } catch (Exception e) {
            DBUtils.handleSQLException(new SQLException("Transazione annullata", e));
        }
    }

}
