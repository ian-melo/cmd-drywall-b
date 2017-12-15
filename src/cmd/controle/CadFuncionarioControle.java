package cmd.controle;

import cmd.entidade.Funcionario;
import cmd.DAO.UsuárioDAO;

/**
 * Classe de controle para registro de funcionários
 *
 * @author Usuario
 */
public class CadFuncionarioControle {

    /**
     * Cadastra um Funcionário
     *
     * @param nome Nome do funcionário
     * @param senha Senha do funcionário
     * @return true se realizado com sucesso,<br>false caso contrário
     */
    public boolean cadastrarFuncionario(String nome, String senha) {
        try {
            Funcionario u = new Funcionario();
            UsuárioDAO dao = new UsuárioDAO();
            u.setLogin(nome);
            u.setSenha(senha);
            dao.create(u);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Altera um Funcionário
     *
     * @param nome Nome do funcionário
     * @param senha Senha do funcionário
     * @return true se realizado com sucesso,<br>false caso contrário
     * @deprecated Sem uso
     */
    public boolean alterarFuncionario(String nome, String senha) {
        return false;
    }

    /**
     * Exclui um Funcionário
     *
     * @param nome Nome do funcionário
     * @param senha Senha do funcionário
     * @return true se realizado com sucesso,<br>false caso contrário
     * @deprecated Sem uso
     */
    public boolean deletarFuncionario(String nome, String senha) {
        return false;
    }

}
