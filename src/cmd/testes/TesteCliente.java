package cmd.testes;

import cmd.DAO.ClienteDAO;
import cmd.DAO.DAO;
import cmd.entidade.Cliente;
import java.util.List;

public class TesteCliente {
    public static void main(String[] args) {
        ClienteDAO cDao = new ClienteDAO();
        List<Cliente> clientes = cDao.listar();
        
        for(Cliente c : clientes) {
            if(c.getPessoaJuridica() != null)
                System.out.println(c.getPessoaJuridica().getRazaoSocial());
            if(c.getPessoaFisica() != null)
                System.out.println(c.getPessoaFisica().getNome());
            System.out.println(c.getEndereco().getLogradouro());
        }
        cDao.fecharListar();
        System.exit(0);
    }
}
