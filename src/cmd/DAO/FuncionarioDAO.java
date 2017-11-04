//TODO: Estabilizar
package cmd.DAO;

import cmd.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
import cmd.entidade.Funcionario;
import org.hibernate.HibernateException;


/**
 * Classe DAO para Funcionario
 * @author ian-melo
 */
public class FuncionarioDAO implements DAO<Funcionario> {

    @Override
    public boolean inserir(Funcionario item) {
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
    public boolean alterar(Funcionario item) {
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
    public boolean excluir(Funcionario item) {
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
    public Funcionario buscar(String consulta) {
        try {
            Funcionario f;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            f = (Funcionario) (s.createQuery("from Funcionario where CodFuncionario = :cod")
                .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return f;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<Funcionario> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from Funcionario").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
