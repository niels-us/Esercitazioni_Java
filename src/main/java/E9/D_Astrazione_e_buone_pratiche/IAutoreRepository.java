package E9.D_Astrazione_e_buone_pratiche;

import java.sql.*;

public interface IAutoreRepository {

    void create(String nome, String email, String username, String password);

    void readAll();

    void update(String email, String nuovoNome);

    void delete(String email);

    void Script_SQL(String sql);

    void showTable(String sql);

    void printResultSet(ResultSet rs) throws SQLException;

    void inserisciDueAutoriInTransazione();

    void inserisciConRollback();
}


