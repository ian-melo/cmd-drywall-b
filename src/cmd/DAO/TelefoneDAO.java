//TODO: Testar
package cmd.DAO;

import cmd.entidade.Telefone;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Telefone
 * @author ian-melo
 */
public class TelefoneDAO implements DAO<Telefone> {

    @Override
    public boolean inserir(Telefone item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch(HibernateException e) {
            System.out.println("__________________________________________ " + e);
            return false;
        }
    }

    @Override
    public boolean alterar(Telefone item) {
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
    public boolean excluir(Telefone item) {
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

    /**
     * Busca item
     * @param consulta Parâmetro de busca, necessário estar no modelo
     * "codCliente,numero"
     * @return item encontrado
     */
    @Override
    public Telefone buscar(String consulta) {
        try {
            String[] vals = consulta.split(",");
            Telefone t;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            t = (Telefone) (s.createQuery("from Telefone where CodCliente = :cod and Numero = :num")
                .setInteger("cod", Integer.parseInt(vals[0]))
                .setInteger("num", Integer.parseInt(vals[1])).list().get(0));
            s.getTransaction().commit();
            s.close();
            return t;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Telefone> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Telefone").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
