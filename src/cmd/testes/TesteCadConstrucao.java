/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.testes;

import cmd.DAO.ConstrucaoDAO;
import cmd.DAO.ForroDAO;
import cmd.DAO.MaterialDAO;
import cmd.controle.ConstrucaoController;
import cmd.entidade.Construcao;
import cmd.entidade.Forro;
import cmd.entidade.Material;
import cmd.entidade.Parede;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TesteCadConstrucao {

    public static void main(String[] args) {
        //cadastroConstrucao();//Funciona

        //cadForroViaControlerConstrucao();//Funciona
        
        cadParedeViaControlerConstrucao();

        System.exit(0);
    }

    public static void cadParedeViaControlerConstrucao() {

        ConstrucaoController conC = new ConstrucaoController();
        Construcao con = new Construcao();
  
        Parede par = new Parede();

        par.setAlturaLimite(BigDecimal.valueOf(Double.parseDouble("100")));
        par.setMontante(BigDecimal.valueOf(Double.parseDouble("1000")));
        par.setEhRf(true);
        par.setEhRu(false);
        par.setEhSt(true);
        par.setXdead(false);
        par.setConstrucao(con);

        con.setDescricao("D_____");
        con.setDetalhes("D_____");
        con.setQualidade(52);
        con.setXdead(false);
        
        con.setParede(par);

        if (conC.inserirParede(par) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado PAREDE");
        } else {
            JOptionPane.showMessageDialog(null, "Não cad FORRO");
        }

    }
    
    
    
    public static void cadForroViaControlerConstrucao() {

        ConstrucaoController conC = new ConstrucaoController();
        Construcao con = new Construcao();
        Forro forro = new Forro();

        forro.setEhRf(true);
        forro.setEhRu(false);
        forro.setEhSt(true);
        forro.setXdead(false);
        forro.setConstrucao(con);

        con.setDescricao("Dcccccc");
        con.setDetalhes("Detcches");
        con.setQualidade(51);
        con.setXdead(false);
        con.setForro(forro);

        if (conC.inserirForro(forro) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado FORRO");
        } else {
            JOptionPane.showMessageDialog(null, "Não cad FORRO");
        }

    }

    public static void cadastroConstrucao() {
        ConstrucaoDAO conDAO = new ConstrucaoDAO();
        Construcao con = new Construcao();

        ForroDAO forDAO = new ForroDAO();
        Forro forro = new Forro();

        forro.setEhRf(true);
        forro.setEhRu(false);
        forro.setEhSt(true);
        forro.setXdead(false);
        forro.setConstrucao(con);

        con.setDescricao("Dcccccccccccccccicao");
        con.setDetalhes("Detcccccccches");
        con.setQualidade(50);
        con.setXdead(false);
        con.setForro(forro);

        if (forDAO.inserir(forro) == true) {//Cadastra automatico o forro
            JOptionPane.showMessageDialog(null, "Cadastrado FORRO");
        } else {
            JOptionPane.showMessageDialog(null, "Não cad FORRO");
        }

//
//        if (conDAO.inserir(con) == true) {
//            JOptionPane.showMessageDialog(null, "Cadastrado Construcao");
//        } else {
//            JOptionPane.showMessageDialog(null, "Não cadastrado");
//        }
    }
}
