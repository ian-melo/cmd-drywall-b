/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;

import cmd.DAO.TelefoneDAO;
import cmd.entidade.Telefone;

/**
 *
 * @author Usuario
 */
public class CadTelefoneControle {

    public boolean Cadastrar(Telefone item) {
        TelefoneDAO telDAO = new TelefoneDAO();

        if (telDAO.inserir(item) == true) {
            System.out.println("Telefone Cadastrado_");
            return true;
        } else {
            System.out.println("Telefone não Cadastrado_");
            return false;
        }
    }

}
