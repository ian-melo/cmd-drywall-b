package cmd.controle;

import cmd.DAO.DAO;
import cmd.DAO.MaterialDAO;
import cmd.entidade.Material;
import java.util.List;

/**
 * Classe de controle para CRUD de materiais
 *
 * @author Usuario, ian-melo
 */
public class MaterialController {

    /**
     * Realiza a inserção de um material
     *
     * @param m Material
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean inserirMaterial(Material m) {
        DAO mdao = new MaterialDAO();
        m.setXdead(false);
        return mdao.inserir(m);
    }

    /**
     * Realiza a alteração de um material
     *
     * @param m Material
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean alterarMaterial(Material m) {
        DAO mdao = new MaterialDAO();
        m.setXdead(false);
        return mdao.alterar(m);
    }

    /**
     * Realiza a exclusão de um material
     *
     * @param m Material
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean excluirMaterial(Material m) {
        DAO mdao = new MaterialDAO();
        m.setXdead(true);
        return mdao.excluir(m);
    }

    /**
     * Realiza a busca de um material
     *
     * @param codigo Código do material
     * @return true, se realizado<br>false, caso contrário
     */
    public Material buscarMaterial(String codigo) {
        DAO mdao = new MaterialDAO();
        return (Material) mdao.buscar(codigo);
    }

    /**
     * Realiza a listagem de materiais
     *
     * @return lista de materiais
     */
    public List<Material> listarMateriais() {
        DAO mdao = new MaterialDAO();
        return mdao.listar();
    }
}
