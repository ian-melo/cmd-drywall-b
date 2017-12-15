package cmd.DAO;

import cmd.entidade.Material;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Materiais de uma construção
 *
 * @author ian-melo
 */
public class MaterialDAO implements DAO<Material> {

    @Override
    public boolean inserir(Material item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean alterar(Material item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean excluir(Material item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.delete(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public Material buscar(String consulta) {
        try {
            Material m;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            m = (Material) (s.createQuery("from Material where CodMaterial = :cod")
                    .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return m;
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Material> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Material").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch (HibernateException e) {
            return null;
        }
    }

}
