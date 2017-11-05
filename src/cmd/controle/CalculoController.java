//TODO: Implementar
//TODO: Testar
package cmd.controle;

import cmd.entidade.Construcao;
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
    
    public List<Construcao> definirItens(boolean ehSt, boolean ehRu, boolean ehRf,
            double altura, double largura) {
        return null;
    }
    
    private void procurarTipologias(boolean ehSt, boolean ehRu, boolean ehRf,
            double altura) {
        
    }
}
