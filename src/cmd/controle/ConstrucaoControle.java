//TODO: Testar
package cmd.controle;

import cmd.DAO.ConstrucaoDAO;
import cmd.DAO.ForroDAO;
import cmd.DAO.ParedeDAO;
import cmd.entidade.Construcao;
import cmd.entidade.Forro;
import cmd.entidade.Parede;

/**
 * Classe de controle para CRUD de construção
 * @author voce
 */
public class ConstrucaoControle {
    
    /**
     * Insere um forro
     * @param f Forro a ser inserido
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean inserirForro(Forro f) {
        //Verifica se os dados existem
        if(f == null || f.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = f.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ForroDAO fDao = new ForroDAO();
        if(!cDao.inserir(c))
            return false;
        if(!fDao.inserir(f))
            return false;
        return true;
    }
    
    /**
     * Altera um forro
     * @param f Forro a ser alterado
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean alterarForro(Forro f) {
        //Verifica se os dados existem
        if(f == null || f.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = f.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ForroDAO fDao = new ForroDAO();
        if(!cDao.alterar(c))
            return false;
        if(!fDao.alterar(f))
            return false;
        return true;
    }
    
    /**
     * Exclui um forro
     * @param f Forro a ser excluído
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean excluirForro(Forro f) {
        //Verifica se os dados existem
        if(f == null || f.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = f.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ForroDAO fDao = new ForroDAO();
        if(!cDao.excluir(c))
            return false;
        if(!fDao.excluir(f))
            return false;
        return true;
    }
    
    /**
     * Busca um forro
     * @param codigo Código do forro a ser buscado
     * @return Forro, caso encontre<br/>null, caso contrário
     */
    public Forro buscarForro(String codigo) {
        //Verifica se o dado existe
        if(codigo.equals(""))
            return null;
        try {
            Integer.parseInt(codigo);
        } catch(NumberFormatException ex) {
            return null;
        }
        //Processo de execução das DAOs
        Construcao c;
        Forro f;
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ForroDAO fDao = new ForroDAO();
        c = cDao.buscar(codigo);
        if(c == null)
            return null;
        f = fDao.buscar(codigo);
        if(f == null)
            return null;
        f.setConstrucao(c);
        c.setForro(f);
        c.setParede(null);
        return f;
    }
    
    /**
     * Insere uma parede
     * @param p Parede a ser inserida
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean inserirParede(Parede p) {
        //Verifica se os dados existem
        if(p == null || p.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = p.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ParedeDAO pDao = new ParedeDAO();
        if(!cDao.inserir(c))
            return false;
        if(!pDao.inserir(p))
            return false;
        return true;
    }
    
    /**
     * Altera uma parede
     * @param p Parede a ser alterada
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean alterarParede(Parede p) {
        //Verifica se os dados existem
        if(p == null || p.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = p.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ParedeDAO pDao = new ParedeDAO();
        if(!cDao.alterar(c))
            return false;
        if(!pDao.alterar(p))
            return false;
        return true;
    }
    
    /**
     * Exclui uma parede
     * @param p Parede a ser excluída
     * @return true, caso a operação seja concluída<br/>false, caso contrário
     */
    public boolean excluirParede(Parede p) {
        //Verifica se os dados existem
        if(p == null || p.getConstrucao() == null)
            return false;
        //Processo de execução das DAOs
        Construcao c = p.getConstrucao();
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ParedeDAO pDao = new ParedeDAO();
        if(!cDao.excluir(c))
            return false;
        if(!pDao.excluir(p))
            return false;
        return true;
    }
    
    /**
     * Busca uma parede
     * @param codigo Código da parede a ser buscado
     * @return Parede, caso encontre<br/>null, caso contrário
     */
    public Parede buscarParede(String codigo) {
        //Verifica se o dado existe
        if(codigo.equals(""))
            return null;
        try {
            Integer.parseInt(codigo);
        } catch(NumberFormatException ex) {
            return null;
        }
        //Processo de execução das DAOs
        Construcao c;
        Parede p;
        ConstrucaoDAO cDao = new ConstrucaoDAO();
        ParedeDAO pDao = new ParedeDAO();
        c = cDao.buscar(codigo);
        if(c == null)
            return null;
        p = pDao.buscar(codigo);
        if(p == null)
            return null;
        p.setConstrucao(c);
        c.setParede(p);
        c.setForro(null);
        return p;
    }
}
