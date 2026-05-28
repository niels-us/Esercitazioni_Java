package E9.B_Statement_e_comandi_SQL_di_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JavaJDBCTest {
    public static void main() throws SQLException {
        System.out.println("11 – Creare una tabella ---------------------------------");
        String Table = "autori";
        String sql = "CREATE TABLE IF NOT EXISTS " + Table + " (" +
                "autori_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(50) NOT NULL, " +
                "email VARCHAR(50) NOT NULL " +
                ")";
        Script_SQL(sql);
        showTable("Select * from " + Table);

        System.out.println("12 – Inserire un record con Statement -------------------");
        Script_SQL("Insert Into " + Table + " (nome, email) Values ('Ada','ada@x.com')");
        showTable("Select * from " + Table);

        System.out.println("13 – Verifica rischio SQL Injection ----------------------");
        Script_SQL("Insert Into " + Table + " (nome, email) Values ('O'Connor','ada@x.com')");
        //Errore nella execution SQL: You have an error in your SQL syntax; check the manual
        // that corresponds to your MariaDB server version for the right syntax to use near
        // 'Connor','ada@x.com')' at line 1

        System.out.println("14. Esercizio 14 – Eseguire una SELECT --------------------");
        SelectAutori("SELECT * FROM autori LIMIT 3");

        System.out.println("15 – SELECT con filtro -------------------------------------");
        showTable(("Select nome from " + Table + " WHERE autori_id=1"));

        System.out.println("16 – UPDATE con Statement ---------------------------------");
        Script_SQL("UPDATE " + Table + " SET email='nuovo@example.com' WHERE autori_id=1");
        showTable(("Select * from " + Table + " WHERE autori_id=1"));

        System.out.println("17 – DELETE con Statement ----------------------------------");
        Script_SQL("DELETE FROM " + Table + " WHERE autori_id = 3");
        showTable(("Select * from " + Table + " LIMIT 3"));

        System.out.println("18 – Gestione delle eccezioni SQL -------------------------");




    }

   /* public static void testExecute() {
        String sql = "SELECT * FROM autori";

        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            boolean hasResultSet = stmt.execute(sql);

            if (hasResultSet) {
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    System.out.println(
                            "ID: " + rs.getInt("autore_id") +
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
    }*/

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
            throw new RuntimeException(e);
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
