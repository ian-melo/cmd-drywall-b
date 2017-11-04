//TODO: Testar
package cmd.DAO;

import cmd.entidade.Orcamento;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Orçamento
 * @author ian-melo
 */
public class OrcamentoDAO implements DAO<Orcamento> {

    @Override
    public boolean inserir(Orcamento item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch(HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean alterar(Orcamento item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch(HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean excluir(Orcamento item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch(HibernateException e) {
            return false;
        }
    }

    @Override
    public Orcamento buscar(String consulta) {
        try {
            Orcamento o;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            o = (Orcamento) (s.createQuery("from Orcamento where CodOrcamento = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return o;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Orcamento> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Orcamento").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
