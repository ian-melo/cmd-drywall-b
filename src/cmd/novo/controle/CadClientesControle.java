/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;

import cmd.DAO.ClienteDAO;
import cmd.DAO.EnderecoDAO;
import cmd.DAO.TelefoneDAO;
import cmd.entidade.Cliente;
import cmd.entidade.Telefone;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CadClientesControle {

    public boolean CadastrarClienteEnderecoTelefone(Cliente item) {

        ClienteDAO cliDao = new ClienteDAO();
        EnderecoDAO endDao = new EnderecoDAO();
        TelefoneDAO telDao = new TelefoneDAO();

        Iterator<Telefone> iterator = item.getTelefones().iterator();
        while (iterator.hasNext()) {
            if (telDao.inserir(iterator.next())) {
                System.out.println("Telefone Cadastrado");//Remover
            } else {
                System.out.println("Telefone NÃO Cadastrado");//Remover
               
            }
        }

        if (endDao.inserir(item.getEndereco())) {
            System.out.println("Endereco Cadastrado");//Remover
        } else {
            System.out.println("Endereco NÃO Cadastrado");//Remover
            return false;
        }

        if (cliDao.inserir(item)) {
            System.out.println("Cliente Cadastrado");//Remover
            return true;
        }
        System.out.println("Cliente NÃO Cadastrado");//Remover
        return false;

    }

    public boolean alterar(Cliente item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean excluir(Cliente item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente buscar(String consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
