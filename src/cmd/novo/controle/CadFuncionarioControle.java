/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;

import cmd.entidade.Funcionario;
import cmd.DAO.UsuárioDAO;

/**
 *
 * @author Usuario
 */
public class CadFuncionarioControle {

    public boolean cadastrarFuncionario(String nome, String senha) {
        try {

            Funcionario u = new Funcionario();
            UsuárioDAO dao = new UsuárioDAO();
            u.setLogin(nome);
            u.setSenha(senha);
            dao.create(u);
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    public boolean alterarFuncionario(String nome, String senha) {

        return false;
    }
    
    public boolean deletarFuncionario(String nome, String senha) {

        return false;
    }

}
