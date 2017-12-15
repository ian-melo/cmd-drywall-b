package cmd.DAO;

import cmd.entidade.Item;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Item (derivado de Construção; referente a Orçamento)
 *
 * @author ian-melo
 */
public class ItemDAO implements DAO<Item> {

    @Override
    public boolean inserir(Item item) {
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
    public boolean alterar(Item item) {
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
    public boolean excluir(Item item) {
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
    public Item buscar(String consulta) {
        try {
            Item i;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            i = (Item) (s.createQuery("from Item where CodItem = :cod")
                    .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return i;
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Item> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Item").list();
            s.getTransaction().commit();
            return li;
        } catch (HibernateException e) {
            System.out.println("_" + e);
            return null;
        } catch (Exception e) {
            System.out.println("__" + e);
            return null;
        }
    }

    /**
     * Lista itens a partir pessoa física(?)
     *
     * @param cod Código do Orçamento
     * @return Lista de itens
     * @deprecated Suscetível a erros; use listar ao invés
     */
    public List<Item> listarFisica(String cod) {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = (List) s.createQuery("from Orcamento where CodOrcamento = :cod")
                    .setInteger("cod", Integer.parseInt(cod)).list().get(0);

            s.getTransaction().commit();
            return li;
        } catch (HibernateException e) {
            System.out.println("_" + e);
            return null;
        } catch (Exception e) {
            System.out.println("__" + e);
            return null;
        }
    }

    /**
     * Lista itens a partir pessoa jurídica(?)
     *
     * @return Lista de itens
     * @deprecated Desnecessário; use listar ao invés
     */
    public List<Item> listarJuridica() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Item").list();
            s.getTransaction().commit();
            //s.close();
            return li;
        } catch (HibernateException e) {
            System.out.println("_" + e);
            return null;
        } catch (Exception e) {
            System.out.println("__" + e);
            return null;
        }
    }

}
