package cmd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe de conexão com banco de dados (BD) MySQL/MariaDB JDBC
 *
 * @author fe_mm
 */
public class ConnectionFactory {

    /**
     * Driver de conexão
     */
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * URL de conexão
     */
    private static final String URL = "jdbc:mysql://localhost:3306/drywall";
    /**
     * Usuário de conexão
     */
    private static final String USER = "root";
    /**
     * Senha de conexão
     */
    private static final String PASS = "TCC";

    /**
     * Abre e obtém conexão com o BD
     *
     * @return Conexão com o BD
     */
    public static Connection getConexao() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }

    }

    /**
     * Fecha conexão com o BD
     *
     * @param con Conexão a fechar
     */
    public static void fechaConexão(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha conexão com o BD
     *
     * @param con Conexão com BD
     * @param stat Gatilho de comando no BD
     */
    public static void fechaConexão(Connection con, PreparedStatement stat) {
        fechaConexão(con);
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fecha conexão com o BD
     *
     * @param con Conexão com BD
     * @param stat Gatilho de comando no BD
     * @param rs Resultado de comando no BD
     */
    public static void fechaConexão(Connection con, PreparedStatement stat, ResultSet rs) {
        fechaConexão(con, stat);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
