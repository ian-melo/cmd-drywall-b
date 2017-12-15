package cmd.DAO;

import cmd.conexao.ConnectionFactory;
import cmd.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe de DAO para Usuário (Funcionário)
 *
 * @author fe_mm
 */
public class UsuárioDAO {

    /**
     * Verifica as credenciais de Usuário (Funcionário) para fazer login
     *
     * @param nome Login do Usuário
     * @param senha Senha do Usuário
     * @return true caso aceito,<br/>false caso contrário
     */
    public boolean CheckLogin(String nome, String senha) {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stat = con.prepareStatement("SELECT * from Funcionario WHERE Login = ? and Senha = ?");
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

    /**
     * Registra um Usuário (Funcionário)
     *
     * @param u Usuário a registrar
     */
    public void create(Funcionario u) {
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement("INSERT INTO Funcionario(CodFuncionario,Login,Senha) VALUES(NULL,?,?)");
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
