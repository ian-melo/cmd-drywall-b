package cmd.controle;

import cmd.DAO.EnderecoDAO;
import cmd.entidade.Endereco;
import java.util.List;

/**
 * Controle de registro de Endereço
 *
 * @author Usuario
 */
public class EnderecoController {

    /**
     * Insere um Endereço
     *
     * @param end Endereço
     * @return true caso feito,<br>false caso contrário
     */
    public boolean inserirEndereco(Endereco end) {
        if (end == null) {
            return false;
        }

        EnderecoDAO endDAO = new EnderecoDAO();
        if (!endDAO.inserir(end)) {
            return false;
        }
        return true;
    }

    /**
     * Busca um Endereço
     *
     * @param cod Código do Endereço
     * @return Endereço, se encontrado
     */
    public Endereco buscar(String cod) {
        if ("".equals(cod) || cod == null) {
            return null;
        }

        EnderecoDAO endDAO = new EnderecoDAO();
        return endDAO.buscar(cod);
    }

    /**
     * Lista Endereço
     *
     * @return Lista de endereços
     */
    public List<Endereco> Lista() {
        EnderecoDAO endDAO = new EnderecoDAO();
        return endDAO.listar();
    }
}
