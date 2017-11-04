//TODO: Testar
package cmd.DAO;

import cmd.entidade.RegistroConstrucao;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Registro de atividade envolvendo orçamento
 * @author ian-melo
 */
public class RegistroConstrucaoDAO implements DAO<RegistroConstrucao> {

    @Override
    public boolean inserir(RegistroConstrucao item) {
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
    public boolean alterar(RegistroConstrucao item) {
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
    public boolean excluir(RegistroConstrucao item) {
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
    public RegistroConstrucao buscar(String consulta) {
        try {
            RegistroConstrucao r;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            r = (RegistroConstrucao) (s.createQuery("from RegistroConstrucao where CodRegistro = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return r;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<RegistroConstrucao> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from RegistroConstrucao").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
