/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;

import cmd.DAO.PessoaJuridicaDAO;
import cmd.entidade.PessoaJuridica;

/**
 *
 * @author Usuario
 */
public class CadPessoaJuridica {

    public boolean Cadastrar(PessoaJuridica item) {
        PessoaJuridicaDAO pJurDao = new PessoaJuridicaDAO();

        if (pJurDao.inserir(item)) {
            return true;
        }
        return false;
    }
}
