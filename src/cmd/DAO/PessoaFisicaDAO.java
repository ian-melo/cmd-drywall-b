//TODO: Testar
package cmd.DAO;

import cmd.entidade.PessoaFisica;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Pessoa Física
 * @author ian-melo
 */
public class PessoaFisicaDAO implements DAO<PessoaFisica> {

    Session s = null;

    @Override
    public boolean inserir(PessoaFisica item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (HibernateException e) {
            System.out.println("__ " + e);
            return false;
        }
    }

    @Override
    public boolean alterar(PessoaFisica item) {
        try {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            s.update(item);
            s.getTransaction().commit();
            s.close();
            return true;
        } catch (HibernateException e) {
            return false;
        } catch (Exception ex) {
            System.out.println("_" + ex);
            return false;
        }
    }

    @Override
    public boolean excluir(PessoaFisica item) {
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
    public PessoaFisica buscar(String consulta) {
        try {
            PessoaFisica pf;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            pf = (PessoaFisica) (s.createQuery("from PessoaFisica where CodCliente = :cod")
                    .setInteger("cod", Integer.parseInt(consulta)).list().get(0));
            s.getTransaction().commit();
            s.close();
            return pf;
        } catch (HibernateException e) {
            System.out.println("_" + e);
            return null;
        } catch (Exception ex) {
            System.out.println("_pfisica_" + ex);
            return null;
        }
    }

    public PessoaFisica buscarCPF(String consulta) {
        try {
            PessoaFisica pf;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            pf = (PessoaFisica) (s.createQuery("from PessoaFisica where Cpf = :cod")
                    .setString("cod", consulta).list().get(0));
            s.getTransaction().commit();
            s.close();
            return pf;
        } catch (HibernateException e) {
            System.out.println("_cpf_" + e);
            return null;
        } catch (Exception ex) {
            System.out.println("_cpf_ex_" + ex);
            return null;
        }
    }

    @Override
    public List<PessoaFisica> listar() {
        try {
            List li;
            s = HibernateUtil.getSessionFactory().openSession();
            System.out.println("--Pessoa-Fisica--");
            s.beginTransaction();
            li = s.createQuery("from PessoaFisica").list();
            s.getTransaction().commit();
            //s.close();
            return li;
        } catch (HibernateException e) {
            System.out.println("_" + e);
            return null;
        } catch (Exception ex) {
            System.out.println("_" + ex);
            return null;
        }
    }

    public void fecharListar() {
        s.close();
    }
}
