//TODO: Testar
package cmd.controle;

import cmd.entidade.Construcao;
import cmd.entidade.Material;
import java.math.BigDecimal;
import java.util.List;

/**
 * Classe de controle para CRUD de materiais
 * @author Usuario, ian-melo
 */
public class MaterialController {

    /**
     * Realiza a inserção de um material
     * @param construcao Construção ao qual o material pertence
     * @param descricao Descrição do material
     * @param nomeUnidade Unidade métrica usada para medição
     * @param constanteMetro Constante utilizada para cálculo de orçamento
     * @param precoUnitario Preço unitário do material
     * @param qualidade Nota de qualidade aferida ao material
     * @param ehOpcional Se o material é opcional
     * @param tipo Tipo do material (ex.: placa, parafuso, rebite...)
     * @param quantidadeMinima Quantidade mínima para uso no cálculo de orçamento
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean inserirMaterial(Construcao construcao, String descricao, String nomeUnidade, 
            String constanteMetro, String precoUnitario, Boolean ehOpcional, Integer qualidade, 
            String tipo, Integer quantidadeMinima) {
        //Instanciamento de material
        Material m = new Material();
        m.setCodMaterial(null);//Preenche aqui
        m.setConstanteMetro(new BigDecimal(constanteMetro));
        m.setConstrucao(null);
        m.setDescricao(descricao);
        m.setEhOpcional(ehOpcional);
        m.setMaterialItems(null);
        m.setNomeUnidade(nomeUnidade);
        m.setPrecoUnitario(new BigDecimal(precoUnitario));
        m.setQualidade(qualidade);
        m.setQuantidadeMinima(quantidadeMinima);
        m.setTipo(tipo);
        m.setXdead(false);
        
        return false;
    }
    
    /**
     * Realiza a alteração de um material
     * @param construcao Construção ao qual o material pertence
     * @param descricao Descrição do material
     * @param nomeUnidade Unidade métrica usada para medição
     * @param constanteMetro Constante utilizada para cálculo de orçamento
     * @param precoUnitario Preço unitário do material
     * @param qualidade Nota de qualidade aferida ao material
     * @param ehOpcional Se o material é opcional
     * @param tipo Tipo do material (ex.: placa, parafuso, rebite...)
     * @param quantidadeMinima Quantidade mínima para uso no cálculo de orçamento
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean alterarMaterial(Construcao construcao, String descricao, String nomeUnidade, 
            String constanteMetro, String precoUnitario, Boolean ehOpcional, Integer qualidade, 
            String tipo, Integer quantidadeMinima) {
        Material m = new Material();
        BigDecimal BigDecimalConstM = new BigDecimal(constanteMetro);
        BigDecimal BigDecimalPUni = new BigDecimal(precoUnitario);
        
        //Instanciamento de material
        m.setCodMaterial(null);//Preenche aqui
        m.setConstanteMetro(BigDecimalConstM);
        m.setConstrucao(null);
        m.setDescricao(descricao);
        m.setEhOpcional(ehOpcional);
        m.setMaterialItems(null);
        m.setNomeUnidade(nomeUnidade);
        m.setPrecoUnitario(BigDecimalPUni);
        m.setQualidade(qualidade);
        m.setQuantidadeMinima(quantidadeMinima);
        m.setTipo(tipo);
        m.setXdead(false);//Preenche aqui
        
        return false;
    }
    
    /**
     * Realiza a exclusão de um material
     * @param construcao Construção ao qual o material pertence
     * @param descricao Descrição do material
     * @param nomeUnidade Unidade métrica usada para medição
     * @param constanteMetro Constante utilizada para cálculo de orçamento
     * @param precoUnitario Preço unitário do material
     * @param qualidade Nota de qualidade aferida ao material
     * @param ehOpcional Se o material é opcional
     * @param tipo Tipo do material (ex.: placa, parafuso, rebite...)
     * @param quantidadeMinima Quantidade mínima para uso no cálculo de orçamento
     * @return true, se realizado<br>false, caso contrário
     */
    public boolean excluirMaterial(Construcao construcao, String descricao, String nomeUnidade, 
            String constanteMetro, String precoUnitario, Boolean ehOpcional, Integer qualidade, 
            String tipo, Integer quantidadeMinima) {
        Material m = new Material();
        BigDecimal BigDecimalConstM = new BigDecimal(constanteMetro);
        BigDecimal BigDecimalPUni = new BigDecimal(precoUnitario);
        
        //Instanciamento de material
        m.setCodMaterial(null);//Preenche aqui
        m.setConstanteMetro(BigDecimalConstM);
        m.setConstrucao(null);
        m.setDescricao(descricao);
        m.setEhOpcional(ehOpcional);
        m.setMaterialItems(null);
        m.setNomeUnidade(nomeUnidade);
        m.setPrecoUnitario(BigDecimalPUni);
        m.setQualidade(qualidade);
        m.setQuantidadeMinima(quantidadeMinima);
        m.setTipo(tipo);
        m.setXdead(false);//Preenche aqui
        
        return false;
    }
    
    /**
     * Realiza a inserção de um material
     * @param codigo Código do material
     * @return true, se realizado<br>false, caso contrário
     */
    public Material buscarMaterial(String codigo) {
//        Material m = new Material();
//        BigDecimal BigDecimalConstM = new BigDecimal(constanteMetro);
//        BigDecimal BigDecimalPUni = new BigDecimal(precoUnitario);
//        
//        //Instanciamento de material
//        m.setCodMaterial(null);//Preenche aqui
//        m.setConstanteMetro(BigDecimalConstM);
//        m.setConstrucao(null);
//        m.setDescricao(descricao);
//        m.setEhOpcional(ehOpcional);
//        m.setMaterialItems(null);
//        m.setNomeUnidade(nomeUnidade);
//        m.setPrecoUnitario(BigDecimalPUni);
//        m.setQualidade(qualidade);
//        m.setQuantidadeMinima(quantidadeMinima);
//        m.setTipo(tipo);
//        m.setXdead(false);//Preenche aqui
        
        return null;
    }
    
    /**
     * Realiza a listagem de materiais
     * @return lista de materiais
     */
    public List<Material> listarMateriais() {
        Material m = new Material();
//        BigDecimal BigDecimalConstM = new BigDecimal(constanteMetro);
//        BigDecimal BigDecimalPUni = new BigDecimal(precoUnitario);
//        
//        //Instanciamento de material
//        m.setCodMaterial(null);//Preenche aqui
//        m.setConstanteMetro(BigDecimalConstM);
//        m.setConstrucao(null);
//        m.setDescricao(descricao);
//        m.setEhOpcional(ehOpcional);
//        m.setMaterialItems(null);
//        m.setNomeUnidade(nomeUnidade);
//        m.setPrecoUnitario(BigDecimalPUni);
//        m.setQualidade(qualidade);
//        m.setQuantidadeMinima(quantidadeMinima);
//        m.setTipo(tipo);
//        m.setXdead(false);//Preenche aqui
        
        return null;
    }
}
