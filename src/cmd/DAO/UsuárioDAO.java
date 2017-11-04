/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.DAO;

/**
 *
 * @author fe_mm
 */
import cmd.conexao.ConnectionFactory;
import cmd.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class UsuárioDAO {

    public boolean CheckLogin(String nome, String senha) {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stat = con.prepareStatement("SELECT * from funcionario WHERE Login = ? and Senha = ?");
            stat.setString(1, nome);
            stat.setString(2, senha);
            rs = stat.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuárioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fechaConexão(con, stat, rs);
        }
        return check;
    }

    public void create(Funcionario u) {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement("INSERT INTO funcionario(CodFuncionario,Login,Senha) VALUES(NULL,?,?)");
            stat.setString(1, u.getLogin());
            stat.setString(2, u.getSenha());
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso", "C.M.D Informa!!!", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso", "C.M.D Informa!!!", 1);
        } finally {
            ConnectionFactory.fechaConexão(con, stat);
        }

    }

}
