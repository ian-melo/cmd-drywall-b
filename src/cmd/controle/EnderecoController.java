/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.controle;

import cmd.DAO.EnderecoDAO;
import cmd.DAO.PessoaFisicaDAO;
import cmd.DAO.PessoaJuridicaDAO;
import cmd.DAO.TelefoneDAO;
import cmd.entidade.Endereco;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EnderecoController {

    public boolean inserirEndereco(Endereco end) {

        if (end == null) {
            return false;
        }

        EnderecoDAO endDAO = new EnderecoDAO();

        if (!endDAO.inserir(end)) {
            return false;
        }

        return true;
    }

    public Endereco buscar(String cod) {
        if("".equals(cod) || cod == null){
            return null;
        }
        
        EnderecoDAO endDAO = new EnderecoDAO();

        return endDAO.buscar(cod);
    }

    public List<Endereco> Lista() {
        EnderecoDAO endDAO = new EnderecoDAO();

        return endDAO.listar();
    }

}
