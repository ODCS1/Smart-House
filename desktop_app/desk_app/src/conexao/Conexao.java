package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // Conexao com o banco de dados 
    // Nesse arquivo se conecta com o banco de dados

    // private static final String url = "jdbc:mysql://localhost:3306/teste_bd";
    // private static final String user = "root";
    // private static final String password = "root";

    private static final String url = "jdbc:mysql://db4free.net/sistema_casa";
    private static final String user = "root_adv";
    private static final String password = "12345678";

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
