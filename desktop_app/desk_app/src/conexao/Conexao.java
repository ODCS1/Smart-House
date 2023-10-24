package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    // Conexao com o banco de dados 
    // Nesse arquivo se conecta com o banco de dados

    // private static final String url = "jdbc:sqlserver://regulus.cotuca.unicamp.br;databaseName=BD23623;schema=teste_bd;";
    // private static final String user = "BD23623";
    // private static final String password = "BD23623";

    private static final String url = "jdbc:mysql://localhost:3306/teste_bd";
    private static final String user = "root";
    private static final String password = "root";

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
