//TODO: Testar
package cmd.DAO;

import cmd.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
import cmd.entidade.Cliente;
import org.hibernate.HibernateException;


/**
 * Classe DAO para Cliente
 * @author ian-melo
 */
public class ClienteDAO implements DAO<Cliente> {
    
    @Override
    public boolean inserir(Cliente item) {
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
    public boolean alterar(Cliente item) {
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
    public boolean excluir(Cliente item) {
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
    public Cliente buscar(String consulta) {
        try {
            Cliente c;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            c = (Cliente) (s.createQuery("from Cliente where CodCliente = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return c;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Cliente> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Cliente").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
}
