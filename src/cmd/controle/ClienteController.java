/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.controle;

import cmd.DAO.ClienteDAO;
import cmd.DAO.EnderecoDAO;
import cmd.DAO.PessoaFisicaDAO;
import cmd.DAO.PessoaJuridicaDAO;
import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;

/**
 *
 * @author voce
 */
public class ClienteController {

    public boolean inserirCliente(Cliente c) {
        if (c == null || (c.getPessoaFisica() == null && c.getPessoaJuridica() == null)) {
            return false;
        }

        //Processo de execução das DAOs
        PessoaFisica pFi = c.getPessoaFisica();
        PessoaJuridica pJu = c.getPessoaJuridica();
        Endereco end = c.getEndereco();

        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();

        ClienteDAO cliDao = new ClienteDAO();

        if ((c.getEndereco() != null) && (!endDAO.inserir(end))) {
            return false;
        }

        if (!cliDao.inserir(c)) {
            return false;
        }

        if ((c.getPessoaFisica() != null) && (!pFiDAO.inserir(pFi))) {
            return false;
        }
        if ((c.getPessoaJuridica() != null) && (!pJuDAO.inserir(pJu))) {
            return false;
        }

        return true;
    }
}
