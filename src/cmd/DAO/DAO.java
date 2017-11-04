package cmd.DAO;

/**
 * Interface DAO para persistência de dados
 * @author ian-melo
 * @param <K> Genérico de item a ser atuado na persistência
 */
public interface DAO <K> {
    /**
     * Insere item
     * @param item Item a ser inserido
     * @return true, se inserido<br>false, caso contrário
     */
    public boolean inserir(K item);
    /**
     * Altera item
     * @param item Item a ser alterado
     * @return true, se alterado<br>false, caso contrário
     */
    public boolean alterar(K item);
    /**
     * Exclui item
     * @param item Item a ser excluído
     * @return true, se excluído<br>false, caso contrário
     */
    public boolean excluir(K item);
    /**
     * Busca item
     * @param consulta Parâmetro de busca
     * @return item encontrado
     */
    public K buscar(String consulta);
    /**
     * Lista itens
     * @return lista de itens
     */
    public java.util.List<K> listar();
}
