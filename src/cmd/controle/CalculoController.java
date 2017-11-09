//TODO: Implementar
//TODO: Testar
package cmd.controle;

import cmd.entidade.*;
import java.util.List;

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
    
    public List<Item> definirItens(double altura, double largura, double areaPorta, double areaJanela) {
        return null;
    }
    
    public List<Construcao> procurarTipologias(boolean ehSt, boolean ehRu, boolean ehRf, double altura) {
        return null;
    }
    
    public Item definirItem(double altura, double largura, double areaPorta, double areaJanela, Construcao c, List<Material> mOp) {
        return null;
    }
}
