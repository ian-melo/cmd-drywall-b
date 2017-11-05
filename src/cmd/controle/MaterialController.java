//TODO: Implementar
//TODO: Testar
package cmd.controle;

import cmd.entidade.Material;
import java.util.List;

/**
 * Classe de controle para CRUD de materiais
 * @author ian-melo
 */
public class MaterialController {
    
    /**
     * Realiza a inserção de um material
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código do material (não necessário)<br>
     * - Código da construção<br>
     * - Descrição - descrição do material<br>
     * - Unidade métrica - unidade métrica usada para medição<br>
     * - Constante por metro - constante utilizada para cálculo de orçamento<br>
     * - Preço unitário - preço unitário do material<br>
     * - Opcional? - Se o material é opcional - 'true' ou 'false'<br>
     * - Tipo - tipo do material (ex.: placa, parafuso, rebite...)<br>
     * - Quantidade mínima - quantidade mínima para uso no cálculo de orçamento<br><br>
     * NOTA: Se o campo estiver vazio, pode-se preencher com ""
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean inserirMaterial(String[] input) {
        return false;
    }
    
    /**
     * Realiza a alteração de um material
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código do material<br>
     * - Código da construção<br>
     * - Descrição - descrição do material<br>
     * - Unidade métrica - unidade métrica usada para medição<br>
     * - Constante por metro - constante utilizada para cálculo de orçamento<br>
     * - Preço unitário - preço unitário do material<br>
     * - Opcional? - Se o material é opcional - 'true' ou 'false'<br>
     * - Tipo - tipo do material (ex.: placa, parafuso, rebite...)<br>
     * - Quantidade mínima - quantidade mínima para uso no cálculo de orçamento<br><br>
     * NOTA: Se o campo estiver vazio, pode-se preencher com ""
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean alterarMaterial(String[] input) {
        return false;
    }
    
    /**
     * Realiza a exclusão de um material
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Código do material<br>
     * - Código da construção<br>
     * - Descrição - descrição do material<br>
     * - Unidade métrica - unidade métrica usada para medição<br>
     * - Constante por metro - constante utilizada para cálculo de orçamento<br>
     * - Preço unitário - preço unitário do material<br>
     * - Opcional? - Se o material é opcional - 'true' ou 'false'<br>
     * - Tipo - tipo do material (ex.: placa, parafuso, rebite...)<br>
     * - Quantidade mínima - quantidade mínima para uso no cálculo de orçamento<br><br>
     * NOTA: Se o campo estiver vazio, pode-se preencher com ""
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean excluirMaterial(String[] input) {
        return false;
    }
    
    /**
     * Realiza a busca de um material
     * @param codigo Código do material
     * @return material, se encontrado<br>null, caso contrário
     */
    public Material buscarMaterial(String codigo) {
        return null;
    }
    
    /**
     * Realiza a listagem de materiais
     * @return lista Lista de materiais
     */
    public List<Material> listarMaterial() {
        return null;
    }
}
