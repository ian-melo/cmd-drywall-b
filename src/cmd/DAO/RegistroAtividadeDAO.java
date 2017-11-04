//TODO: Testar
package cmd.DAO;

import cmd.entidade.RegistroAtividade;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Registro de Atividade (geral)
 * @author ian-melo
 */
public class RegistroAtividadeDAO implements DAO<RegistroAtividade> {

    @Override
    public boolean inserir(RegistroAtividade item) {
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
    public boolean alterar(RegistroAtividade item) {
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
    public boolean excluir(RegistroAtividade item) {
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
    public RegistroAtividade buscar(String consulta) {
        try {
            RegistroAtividade r;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            r = (RegistroAtividade) (s.createQuery("from RegistroAtividade where CodRegistro = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return r;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<RegistroAtividade> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from RegistroAtividade").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
