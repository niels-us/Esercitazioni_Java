package E9.D_Astrazione_e_buone_pratiche;

import java.sql.SQLException;

public class DBUtils {
    public static void handleSQLException(SQLException e) {
        System.err.println("Errore SQL: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("ErrorCode: " + e.getErrorCode());
        //e.printStackTrace();
    }
}
