/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;

import cmd.entidade.Construcao;
import cmd.entidade.Material;
import java.math.BigDecimal;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class MaterialControle {

    public void cadastrar(Construcao construcao, String descricao, String nomeUnidade, String constanteMetro, String precoUnitario, Boolean ehOpcional, Integer qualidade, String tipo, Integer quantidadeMinima) {
        Material m = new Material();
        BigDecimal BigDecimalConstM = new BigDecimal(constanteMetro);
        BigDecimal BigDecimalPUni = new BigDecimal(precoUnitario);
        
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
        
        
        
    }
}
