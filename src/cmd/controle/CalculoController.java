package cmd.controle;

import cmd.DAO.ConstrucaoDAO;
import cmd.entidade.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe de controle para realização de cálculos de tipologias drywall
 * @author ian-melo
 */
public class CalculoController {
    /**
     * Lista de paredes selecionadas
     */
    private List<Construcao> paredes;
    /**
     * Lista de forros selecionados
     */
    private List<Construcao> forros;
    /**
     * Lista de itens selecionados
     */
    private List<Construcao> itens;
    
    public List<Construcao> procurarTipologias(boolean ehSt, boolean ehRu, boolean ehRf, double altura) {
        ConstrucaoDAO cdao = new ConstrucaoDAO();
        List<Construcao> li, res = new ArrayList<>();
        li = cdao.listar();
        //System.out.println(li.size());//Teste
        Forro f;
        Parede p;
        for(Construcao c : li) {
            //Forro
            if(c.getForro() != null && c.getParede() == null) {
                //System.out.println("FORRO: " + c.getCodConstrucao());//Teste
                f = c.getForro();
                if(ehSt == true && ehRu == true && ehRf == true) {
                    if(f.getEhSt() == true && f.getEhRu() == true && f.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == true && ehRf == false) {
                    if(f.getEhSt() == true && f.getEhRu() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == false && ehRf == true) {
                    if(f.getEhSt() == true && f.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == false && ehRf == false) {
                    //System.out.println("Cliente pede forro ST");//Teste
                    if(f.getEhSt() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == true && ehRf == true) {
                    if(f.getEhRu() == true && f.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == true && ehRf == false) {
                    if(f.getEhRu() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == false && ehRf == true) {
                    if(f.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == false && ehRf == false) {
                    res.add(c);
                }
            //Parede
            } else if(c.getForro() == null && c.getParede() != null) {
                //System.out.println("PAREDE: " + c.getCodConstrucao());//Teste
                p = c.getParede();
                //Restrição de altura
                if(altura > p.getAlturaLimite().doubleValue()) {
                    //System.out.println(altura + " maior que " + p.getAlturaLimite().doubleValue());//Teste
                    continue;
                }
                if(ehSt == true && ehRu == true && ehRf == true) {
                    if(p.getEhSt() == true && p.getEhRu() == true && p.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == true && ehRf == false) {
                    if(p.getEhSt() == true && p.getEhRu() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == false && ehRf == true) {
                    if(p.getEhSt() == true && p.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == true && ehRu == false && ehRf == false) {
                    //System.out.println("Cliente pede parede ST");//Teste
                    if(p.getEhSt() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == true && ehRf == true) {
                    if(p.getEhRu() == true && p.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == true && ehRf == false) {
                    if(p.getEhRu() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == false && ehRf == true) {
                    if(p.getEhRf() == true)
                        res.add(c);
                } else if(ehSt == false && ehRu == false && ehRf == false) {
                    res.add(c);
                }
            }
        }
        //System.out.println("Tamanho res:" + res.size());//Teste
        return res;
    }
    
    public Item definirItem(double altura, double largura, double areaPorta, double areaJanela, Construcao c, List<Material> mOp, double fatorMultiplicacao) {
        //Vars
        double precoTotal = 0.0, preco, quantidade;
        Set<MaterialItem> materialItems = new LinkedHashSet<>();
        MaterialItem matItem;
        Item item = new Item();
        //MaterialItem
        Material m;
        for(Object o : c.getMaterials()) {
            m = (Material) o;
            //Verifica se é opcional
            if(m.getEhOpcional()) {
                for(Material m1 : mOp) {
                    //Caso seja o selecionado
                    if(m.equals(m1)) { //Funciona(?)
                        //Cálculos
                        quantidade = Math.ceil((m.getConstanteMetro().doubleValue()*altura*largura));
                        preco = quantidade * (m.getPrecoUnitario().doubleValue());
                        precoTotal += preco;
                        //MaterialItem
                        matItem = new MaterialItem();
                        matItem.setMaterial(m);
                        matItem.setItem(item);
                        matItem.setPrecoUnitario(BigDecimal.valueOf(preco));
                        matItem.setQuantidade((new Double(quantidade)).intValue());
                        matItem.setId(new MaterialItemId());
                        matItem.setXdead(false);
                        materialItems.add(matItem);
                        break;
                    }
                }
            //Obrigatório
            } else {
                //Cálculos
                quantidade = Math.ceil((m.getConstanteMetro().doubleValue()*altura*largura));
                preco = quantidade * (m.getPrecoUnitario().doubleValue());
                precoTotal += preco;
                //MaterialItem
                matItem = new MaterialItem();
                matItem.setMaterial(m);
                matItem.setItem(item);
                matItem.setPrecoUnitario(BigDecimal.valueOf(preco));
                matItem.setQuantidade((new Double(quantidade)).intValue());
                matItem.setId(new MaterialItemId());
                matItem.setXdead(false);
                materialItems.add(matItem);
            }
        }
        //Item
        item.setConstrucao(c);
        item.setAltura(BigDecimal.valueOf(altura));
        item.setLargura(BigDecimal.valueOf(largura));
        item.setAreaPorta(BigDecimal.valueOf(areaPorta));
        item.setAreaJanela(BigDecimal.valueOf(areaJanela));
        item.setPrecoTotal(BigDecimal.valueOf(precoTotal));
        item.setXdead(false);
        item.setMaterialItems(materialItems);
        return item;
    }
}
