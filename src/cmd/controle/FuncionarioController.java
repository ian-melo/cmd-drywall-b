//TODO: Implementar
//TODO: Testar
package cmd.controle;

import cmd.entidade.Funcionario;

/**
 * Classe de controle para CRUD de funcionário
 * @author ian-melo
 */
public class FuncionarioController {
    
    /**
     * Realiza a inserção de um funcionário
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código - código do funcionário (não necessário)<br>
     * - Login - nome de acesso<br>
     * - Senha - senha de acesso
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean inserirFuncionario(String[] input) {
        return false;
    }
    
    
    /**
     * Realiza a alteração de um funcionário
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código - código do funcionário<br>
     * - Login - nome de acesso<br>
     * - Senha - senha de acesso
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean alterarFuncionario(String[] input) {
        return false;
    }
    
    /**
     * Realiza a exclusão de um funcionário
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código - código do funcionário<br>
     * - Login - nome de acesso<br>
     * - Senha - senha de acesso
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean excluirFuncionario(String[] input) {
        return false;
    }
    
    /**
     * Realiza a busca de um funcionário
     * @param codigo Código do funcionário
     * @return funcionário, se realizado<br>null, caso contrário
     */
    public Funcionario buscarFuncionario(String codigo) {
        return null;
    }
}
