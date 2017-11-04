//TODO: Testar
package cmd.DAO;

import cmd.entidade.PessoaJuridica;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Pessoa Jurídica
 * @author ian-melo
 */
public class PessoaJuridicaDAO implements DAO<PessoaJuridica> {

    @Override
    public boolean inserir(PessoaJuridica item) {
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
    public boolean alterar(PessoaJuridica item) {
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
    public boolean excluir(PessoaJuridica item) {
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
    public PessoaJuridica buscar(String consulta) {
        try {
            PessoaJuridica pj;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            pj = (PessoaJuridica) (s.createQuery("from PessoaJuridica where CodCliente = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return pj;
        } catch(HibernateException e) {
            return null;
        }
    }
    
    @Override
    public List<PessoaJuridica> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from PessoaJuridica").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
