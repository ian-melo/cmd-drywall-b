//TODO: Testar
package cmd.DAO;

import cmd.entidade.RegistroOrcamento;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Registro de atividade envolvendo orçamento
 * @author ian-melo
 */
public class RegistroOrcamentoDAO implements DAO<RegistroOrcamento> {

    @Override
    public boolean inserir(RegistroOrcamento item) {
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
    public boolean alterar(RegistroOrcamento item) {
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
    public boolean excluir(RegistroOrcamento item) {
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
    public RegistroOrcamento buscar(String consulta) {
        try {
            RegistroOrcamento r;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            r = (RegistroOrcamento) (s.createQuery("from RegistroOrcamento where CodRegistro = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return r;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<RegistroOrcamento> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from RegistroOrcamento").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
