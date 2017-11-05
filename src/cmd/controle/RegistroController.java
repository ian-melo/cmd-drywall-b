//TODO: Implementar
//TODO: Testar
package cmd.controle;

/**
 * Classe de controle para registro de atividades
 * @author ian-melo
 */
public class RegistroController {
    
    /**
     * Registra uma envolvendo manipulação de dados orçamentais. Entidades:<br>
     *  Orcamento, Cliente, e relacionadas (exceto as de construção)
     * @param atividade Atividade feita - 'insercao', 'alteracao', 'exclusao'
     * @param tabelas Tabelas afetadas (separe com vírgula)
     * @param detalhe Detalhes adicionais (Ex.: login, data/hora, etc; opcional)
     * @return true, se registrado<br>false, caso contrário
     */
    public boolean registrarOrcamento(String atividade, String tabelas, String detalhe) {
        return false;
    }
    
    /**
     * Registra uma envolvendo manipulação de dados de construção. Entidades:<br>
     *  Construção (Forro, Parede), Material
     * @param atividade Atividade feita - 'insercao', 'alteracao', 'exclusao'
     * @param tabelas Tabelas afetadas (separe com vírgula)
     * @param detalhe Detalhes adicionais (Ex.: login, data/hora, etc; opcional)
     * @return true, se registrado<br>false, caso contrário
     */
    public boolean registrarConstrucao(String atividade, String tabelas, String detalhe) {
        return false;
    }
}
