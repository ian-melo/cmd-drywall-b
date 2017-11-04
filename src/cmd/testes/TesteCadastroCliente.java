/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.testes;

import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import cmd.entidade.TelefoneId;
import cmd.novo.controle.CadClientesControle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TesteCadastroCliente {

    public static void main(String[] args) {
        TesteCadastro();
    }

    public static void TesteCadastro() {
        /*
         HashSet<Dog> dset = new HashSet<Dog>();
         dset.add(new Dog(2));
         dset.add(new Dog(1));
         dset.add(new Dog(3));
         dset.add(new Dog(5));
         dset.add(new Dog(4));
        
         Iterator<Dog> iterator = dset.iterator();
         while (iterator.hasNext()) {
         System.out.print(iterator.next() + " ");

         Saída: 5 3 2 1 4
         */

        CadClientesControle cadCliC = new CadClientesControle();
        //CadEnderecoControle cadEndC = new CadEnderecoControle();
        //CadTelefoneControle cadTelC = new CadTelefoneControle();

        cadCliC = new CadClientesControle();
        Cliente cli = new Cliente();
        Endereco end = new Endereco();
        PessoaJuridica pJur = new PessoaJuridica();
        Telefone tel = new Telefone();

        HashSet<Telefone> tels = new HashSet<>();

        TelefoneId telId = new TelefoneId();

        end.setCodEndereco(2);
        end.setBairro("Bairro_5_Tes");
        end.setCep("04233-010");
        end.setCidade("Cidade_5_Tes");
        end.setComplemento("Complemento_5_Tes");
        end.setLogradouro("Logradouro_5_Tes");
        end.setNumero("10");
        end.setUf("55");
        end.setXdead(false);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = new Date();
        String dS = "11/01/2005";
        try {
            dataDate = formato.parse(dS);
            System.out.println(dataDate);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

// 78.846.292/0001-75
// 52.852.698/0001-77
// 79.664.724/0001-90
        pJur.setCnpj("78.846.292/0001-75");
        pJur.setDataFundacao(dataDate);
        pJur.setRamoAtuacao("Ramo_5_Atuac");
        pJur.setRazaoSocial("Razao_5_Soci");
        pJur.setXdead(false);

        telId.setNumero("(11)9898-0909");
        tel.setId(telId);

        tels.add(tel);

        telId.setNumero("(11)1111-8888");
        tel.setId(telId);

        tels.add(tel);
        

        cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setPessoaJuridica(pJur);
        cli.setTelefones((Set) tels);//Quando for verificar o pq não esta cadastrando mais tel no BD começar por AQUI é um vetor
        cli.setXdead(true);

//        if (cadTelC.Cadastrar(tel) == true) {
//            JOptionPane.showMessageDialog(null, "Cadastrado Telefone");
//
//        }
//
//        if (cadEndC.Cadastrar(end) == true) {
//            JOptionPane.showMessageDialog(null, "Cadastrado Endereco");
//
//        }
        if (cadCliC.CadastrarClienteEnderecoTelefone(cli) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado Varios");

        }
    }
}
