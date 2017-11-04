//TODO: Testar
package cmd.DAO;

import cmd.entidade.MaterialItem;
import cmd.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Classe de DAO para Materiais instanciados em um Item
 * @author ian-melo
 */
public class MaterialItemDAO implements DAO<MaterialItem> {

    @Override
    public boolean inserir(MaterialItem item) {
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
    public boolean alterar(MaterialItem item) {
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
    public boolean excluir(MaterialItem item) {
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
     * "codMaterial,codItem"
     * @return item encontrado
     */
    @Override
    public MaterialItem buscar(String consulta) {
        try {
            String[] vals = consulta.split(",");
            MaterialItem o;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            o = (MaterialItem) (s.createQuery("from MaterialItem where CodMaterial = :codm and CodItem = :codi")
                .setInteger("codm", Integer.parseInt(vals[0]))
                .setInteger("codi", Integer.parseInt(vals[1])).list().get(0));
            s.getTransaction().commit();
            s.close();
            return o;
        } catch(HibernateException e) {
            return null;
        }
    }

    @Override
    public List<MaterialItem> listar() {
        try {
            List li;
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            li = s.createQuery("from MaterialItem").list();
            s.getTransaction().commit();
            s.close();
            return li;
        } catch(HibernateException e) {
            return null;
        }
    }
    
}
