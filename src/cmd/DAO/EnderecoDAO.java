//TODO: Testar
package cmd.DAO;

import cmd.entidade.Endereco;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Endereço
 * @author ian-melo
 */
public class EnderecoDAO implements DAO<Endereco> {

    @Override
    public boolean inserir(Endereco item) {
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
    public boolean alterar(Endereco item) {
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
    public boolean excluir(Endereco item) {
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
    public Endereco buscar(String consulta) {
        try {
            Endereco en;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            en = (Endereco) (s.createQuery("from Endereco where CodEndereco = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return en;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Endereco> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Endereco").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
