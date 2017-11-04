package cmd.testes;

import cmd.DAO.*;
import cmd.entidade.*;
import java.math.BigDecimal;

public class TesteDAO {
    
    public static void main(String[] args) {
//        //Funcionário        
//        Funcionario f = new Funcionario();
//        f.setCodFuncionario(4);
//        f.setLogin("fun_teste21");
//        f.setSenha("fun_senha21");
//        f.setXdead(Boolean.FALSE);
//        f.setRegistroAtividades(null);
//        DAO dao = new FuncionarioDAO();
//        dao.alterar(f);
//        Funcionario f2 = (Funcionario) dao.buscar("1");
//        System.out.println(f2.getLogin());
        
        //Construção-Forro-Parede
        Forro f = new Forro();
        Parede p = new Parede();
        Construcao c = new Construcao();
        
        p.setAlturaLimite(BigDecimal.valueOf(10));
        p.setEhRf(Boolean.TRUE);
        p.setEhRu(Boolean.FALSE);
        p.setEhSt(Boolean.TRUE);
        p.setMontante(BigDecimal.valueOf(0.038));
        p.setXdead(false);
        
        f.setEhRf(true);
        f.setEhRu(false);
        f.setEhSt(true);
        f.setXdead(Boolean.FALSE);
        
        c.setCodConstrucao(1);
        c.setDescricao("con_teste11");
        c.setDetalhes("con_teste11");
        c.setQualidade(10);
        c.setXdead(Boolean.FALSE);
        
        c.setForro(f);
        c.setParede(p);
        f.setConstrucao(c);
        p.setConstrucao(c);
        
        DAO dao = new ConstrucaoDAO();
        DAO daof = new ForroDAO();
        DAO daop = new ParedeDAO();
        
        daop.excluir(p);
        //dao.inserir(c);
        //Construcao c2 = (Construcao) dao.buscar("1");
        //System.out.println(c2.getDescricao());

        System.exit(0);
    }
}
