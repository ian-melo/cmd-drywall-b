package cmd.testes;

import cmd.DAO.ClienteDAO;
import cmd.DAO.DAO;
import cmd.controle.ClienteController;
import cmd.entidade.Cliente;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import java.util.Iterator;
import java.util.List;

public class TesteCliente {

    public static void main(String[] args) {
        //imprimeDetlhesPelaDAO();
        //imprimeDetlhesPeloControle();
        //imprimeDetlhesPeloControleModificado();
        imprimeDetlhesPeloControleModificadoPessoaJuridica();

        System.exit(0);
    }

    
    private static void imprimeDetlhesPeloControleModificadoPessoaJuridica() {

        ClienteController cliC = new ClienteController();
        List<PessoaJuridica> pJuridicas = cliC.ListaPessoaJuridica();

        for (PessoaJuridica c : pJuridicas) {
            if (c.getCnpj()!= null) {
                System.err.println("=================2=================");
                System.out.println(c.getCnpj());
                System.out.println(c.getRazaoSocial());
                System.out.println(c.getCliente().getDataInscricao());
                System.out.println(c.getCliente().getEndereco().getUf());
                
                
                Iterator<Telefone> iterator = c.getCliente().getTelefones().iterator();
                //while (iterator.hasNext()) {
                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }
                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }

                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }

                // System.out.println("_" + iterator.next().getId().getNumero());
            }

        }
        //cDao.fecharListar();

    }
    
    
    
    
    
    private static void imprimeDetlhesPeloControleModificado() {

        ClienteController cliC = new ClienteController();
        List<PessoaFisica> pessoaFisicas = cliC.ListaPessoaFisicas();

        for (PessoaFisica c : pessoaFisicas) {
            if (c.getCpf() != null) {
                System.err.println("=================3=================");
                System.out.println(c.getCpf());
                System.out.println(c.getNome());
                System.out.println(c.getCliente().getDataInscricao());
                System.out.println(c.getCliente().getEndereco().getUf());
                
                
                
                
                Iterator<Telefone> iterator = c.getCliente().getTelefones().iterator();
                //while (iterator.hasNext()) {
                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }
                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }

                if (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
                }

                // System.out.println("_" + iterator.next().getId().getNumero());
            }

        }
        //cDao.fecharListar();

    }

    private static void imprimeDetlhesPeloControle() {

        ClienteController cliC = new ClienteController();
        List<PessoaFisica> pessoaFisicas = cliC.ListaPessoaFisicas();

        for (PessoaFisica c : pessoaFisicas) {
            if (c.getCpf() != null) {
                System.err.println("==================================");
                System.out.println(c.getCpf());
                System.out.println(c.getNome());
                System.out.println(c.getCliente().getDataInscricao());
                System.out.println(c.getCliente().getEndereco().getUf());
                //System.out.println(c.getCliente().getTelefones().g);

                //List<Telefone> telefones = (List<Telefone>) c.getCliente().getTelefones();
                Iterator<Telefone> iterator = c.getCliente().getTelefones().iterator();
                while (iterator.hasNext()) {
                    System.out.println("_" + iterator.next().getId().getNumero());
//                    tt = iterator.next();//Separa objeto telefone em yma variavel
//                    tt.getId().setCodCliente(valor);//Força o valor q retorna do Hibernate, no codCliente do objeto Telefone

                }

            }

        }
        //cDao.fecharListar();

    }

    private static void imprimeDetlhesPelaDAO() {

        ClienteDAO cDao = new ClienteDAO();
        List<Cliente> clientes = cDao.listar();

        for (Cliente c : clientes) {
            if (c.getPessoaJuridica() != null) {
                System.out.println(c.getPessoaJuridica().getRazaoSocial());
            }
            if (c.getPessoaFisica() != null) {
                System.out.println(c.getPessoaFisica().getNome());
            }
            System.out.println(c.getEndereco().getLogradouro());

        }
        cDao.fecharListar();

    }
}
