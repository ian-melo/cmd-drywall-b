package cmd.entidade;
// Generated 29/10/2017 11:08:24 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Item generated by hbm2java
 */
public class Item  implements java.io.Serializable {


     private Integer codItem;
     private Construcao construcao;
     private Orcamento orcamento;
     private BigDecimal altura;
     private BigDecimal largura;
     private BigDecimal areaPorta;
     private BigDecimal areaJanela;
     private BigDecimal precoTotal;
     private Boolean xdead;
     private Set materialItems = new HashSet(0);

    public Item() {
    }

    public Item(Construcao construcao, Orcamento orcamento, BigDecimal altura, BigDecimal largura, BigDecimal areaPorta, BigDecimal areaJanela, BigDecimal precoTotal, Boolean xdead, Set materialItems) {
       this.construcao = construcao;
       this.orcamento = orcamento;
       this.altura = altura;
       this.largura = largura;
       this.areaPorta = areaPorta;
       this.areaJanela = areaJanela;
       this.precoTotal = precoTotal;
       this.xdead = xdead;
       this.materialItems = materialItems;
    }
   
    public Integer getCodItem() {
        return this.codItem;
    }
    
    public void setCodItem(Integer codItem) {
        this.codItem = codItem;
    }
    public Construcao getConstrucao() {
        return this.construcao;
    }
    
    public void setConstrucao(Construcao construcao) {
        this.construcao = construcao;
    }
    public Orcamento getOrcamento() {
        return this.orcamento;
    }
    
    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
    public BigDecimal getAltura() {
        return this.altura;
    }
    
    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }
    public BigDecimal getLargura() {
        return this.largura;
    }
    
    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }
    public BigDecimal getAreaPorta() {
        return this.areaPorta;
    }
    
    public void setAreaPorta(BigDecimal areaPorta) {
        this.areaPorta = areaPorta;
    }
    public BigDecimal getAreaJanela() {
        return this.areaJanela;
    }
    
    public void setAreaJanela(BigDecimal areaJanela) {
        this.areaJanela = areaJanela;
    }
    public BigDecimal getPrecoTotal() {
        return this.precoTotal;
    }
    
    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
    public Boolean getXdead() {
        return this.xdead;
    }
    
    public void setXdead(Boolean xdead) {
        this.xdead = xdead;
    }
    public Set getMaterialItems() {
        return this.materialItems;
    }
    
    public void setMaterialItems(Set materialItems) {
        this.materialItems = materialItems;
    }




}


