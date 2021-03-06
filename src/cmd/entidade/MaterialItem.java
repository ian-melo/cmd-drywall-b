package cmd.entidade;
// Generated 29/10/2017 11:08:24 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * MaterialItem generated by hbm2java
 */
public class MaterialItem  implements java.io.Serializable {


     private MaterialItemId id;
     private Item item;
     private Material material;
     private Integer quantidade;
     private BigDecimal precoUnitario;
     private Boolean xdead;

    public MaterialItem() {
    }

	
    public MaterialItem(MaterialItemId id, Item item, Material material) {
        this.id = id;
        this.item = item;
        this.material = material;
    }
    public MaterialItem(MaterialItemId id, Item item, Material material, Integer quantidade, BigDecimal precoUnitario, Boolean xdead) {
       this.id = id;
       this.item = item;
       this.material = material;
       this.quantidade = quantidade;
       this.precoUnitario = precoUnitario;
       this.xdead = xdead;
    }
   
    public MaterialItemId getId() {
        return this.id;
    }
    
    public void setId(MaterialItemId id) {
        this.id = id;
    }
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    public Integer getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public BigDecimal getPrecoUnitario() {
        return this.precoUnitario;
    }
    
    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    public Boolean getXdead() {
        return this.xdead;
    }
    
    public void setXdead(Boolean xdead) {
        this.xdead = xdead;
    }




}


