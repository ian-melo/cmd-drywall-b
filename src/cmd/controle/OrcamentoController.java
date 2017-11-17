//TODO: Implementar
//TODO: Testar
package cmd.controle;

import cmd.DAO.DAO;
import cmd.DAO.ItemDAO;
import cmd.DAO.MaterialItemDAO;
import cmd.DAO.OrcamentoDAO;
import cmd.entidade.*;
import java.util.List;

/**
 * Classe de controle para gerenciamento de orçamentos
 * @author ian-melo
 */
public class OrcamentoController {
    
    /**
     * Realiza a inserção de um orçamento
     * @param input orçamento a ser inserido
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean inserirOrcamento(Orcamento input) {
        DAO oDao = new OrcamentoDAO();
        DAO iDao = new ItemDAO();
        DAO miDao = new MaterialItemDAO();
        
        if(!oDao.inserir(input))
            return false;
        for(Object o : input.getItems()) {
            if(!iDao.inserir((Item) o))
                return false;
//            for(Object o2 : ((Item) o).getMaterialItems()) {
//                if(!miDao.inserir((MaterialItem) o2))
//                return false;
//            }
        }
        return true;
    }
    
    /**
     * Realiza a alteração de um orçamento
     * @param input orçamento a ser inserido
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean alterarOrcamento(Orcamento input) {
        return false;
    }
    
    /**
     * Realiza a exclusão de um orçamento
     * @param input orçamento a ser inserido
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean excluirOrcamento(Orcamento input) {
        return false;
    }
    
    /**
     * Realiza a busca de um orcamento
     * @param codigo Código do orçamento
     * @return orçamento, se encontrado<br>null, caso contrário
     */
    public Orcamento buscarOrcamento(String codigo) {
        return null;
    }
    
    /**
     * Realiza a listagem de orçamentos
     * @return lista Lista de orçamentos
     */
    public List<Orcamento> listarOrcamento() {
        return null;
    }
}
