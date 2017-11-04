/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fe_mm
 */
public class ConnectionFactory 
{
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/drywall";
    private static final String USER = "root";
    private static  final String PASS = "TCC";
    
    public static Connection getConexao()
    {
        try 
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
        
    }
    
    public static void fechaConexão(Connection con) 
    {
            try 
            {
               if(con != null)
                   con.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void fechaConexão(Connection con, PreparedStatement stat) 
    {
           fechaConexão(con);
            try 
            {
               if(stat != null)
                   stat.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     public static void fechaConexão(Connection con, PreparedStatement stat, ResultSet rs) 
    {
           fechaConexão(con, stat);
            try 
            {
               if(rs != null)
                   rs.close();
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}