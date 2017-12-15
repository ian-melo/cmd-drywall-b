/*
 * Deixai toda esperança, ó vós que entrais!
 */
package cmd.testes;

import cmd.controle.ClienteController;
import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import cmd.entidade.TelefoneId;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TesteCadastroCliente {

    public static void main(String[] args) {
        TesteCadastro();
        //TesteCadastroPessoaJuridicaApenas();

        //TesteListarPessoaJuridica();
        TesteCadastroPessoaJuridicaApenas_1();

        System.exit(0);
    }

    private static void TesteListarPessoaJuridica() {
        ClienteController cleC = new ClienteController();

        for (PessoaJuridica jx : cleC.listarPessoasJuridicas()) {
            System.out.println("------------------------------------------------");
            System.out.println("CodCliente                 = " + jx.getCodCliente());
            System.out.println("Cnpj                       = " + jx.getCnpj());
            System.out.println("RazaoSocial                = " + jx.getRazaoSocial());
            System.out.println("RamoAtuacao                = " + jx.getRamoAtuacao());
            System.out.println("DataFundacao               = " + jx.getDataFundacao());
//            System.out.println("Cliente.DataInscricao      = " + jx.getCliente().getDataInscricao());
//            System.out.println("Cliente.Endereco.Cep       = " + jx.getCliente().getEndereco().getCep());
//            System.out.println("Cliente.Endereco.Logradouro= " + jx.getCliente().getEndereco().getLogradouro());
//            System.out.println("Cliente.Endereco.Numero    = " + jx.getCliente().getEndereco().getNumero());
//            System.out.println("Cliente.Endereco.Cidade    = " + jx.getCliente().getEndereco().getCidade());
//            System.out.println("Cliente.Endereco.Bairro    = " + jx.getCliente().getEndereco().getBairro());
//            System.out.println("Cliente.Endereco.Uf        = " + jx.getCliente().getEndereco().getUf());

        }
    }

    private static void TesteCadastroPessoaJuridicaApenas_1() {
        //CadPessoaJuridica cPjur = new CadPessoaJuridica();

        PessoaJuridica pJu = new PessoaJuridica();
        //PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();//hhhhhhhhhhh
        Cliente cli = new Cliente();
        Endereco end = new Endereco();

        ClienteController cliC = new ClienteController();

        Telefone tel;
        HashSet<Telefone> tels = new HashSet<>();
        TelefoneId telId;

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = new Date();
        String dS = "10/01/2011";
        try {
            dataDate = formato.parse(dS);
            System.out.println(dataDate);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        //end.setCodEndereco(2);
        //end.setClientes();
        end.setBairro("_Bairro");
        end.setCep("05255-050");
        end.setCidade("_Cidade_");
        end.setComplemento("__Complemento");
        end.setLogradouro("__Logradouro");
        end.setNumero("190");
        end.setUf("PP");
        end.setXdead(false);

        tel = new Telefone();
        telId = new TelefoneId();
        telId.setNumero("(00)1000-2005");
        //telId.setCodCliente(75);//--------------------------
        tel.setId(telId);
        tel.setCliente(cli);
        tel.setXdead(false);
        tels.add(tel);

        
        tel = new Telefone();
        telId = new TelefoneId();
        telId.setNumero("(00)10000-2006");
        //telId.setCodCliente(75);//---------------------------
        tel.setId(telId);
        tel.setCliente(cli);
        tel.setXdead(false);
        tels.add(tel);

        //cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setTelefones(tels);
        cli.setPessoaJuridica(pJu);
        cli.setXdead(false);

        pJu.setCliente(cli);
        pJu.setCnpj("45.331.323/3333-23");
        pJu.setCodCliente(37);
        pJu.setDataFundacao(dataDate);
        pJu.setRamoAtuacao("ramoAt_2");
        pJu.setRazaoSocial("razaoSo_2");
        pJu.setXdead(false);

        JOptionPane.showMessageDialog(null, cliC.inserirPessoaJuridica(pJu));
        //JOptionPane.showMessageDialog(null, cliC.inserirCliente(cli));
        //JOptionPane.showMessageDialog(null, pJuDAO.inserir(pJu));

    }

    private static void TesteCadastroPessoaJuridicaApenas() {
       
        PessoaJuridica pJu = new PessoaJuridica();
        Cliente cli = new Cliente();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = new Date();
        String dS = "10/01/2010";
        try {
            dataDate = formato.parse(dS);
            System.out.println(dataDate);
        } catch (ParseException ex) {
            System.out.println(ex);
        }

        //46.031.223/0001-17
        //03.846.168/0001-00
        //17.849.785/0001-74
        //54.272.918/0001-19
        pJu.setCnpj("46.031.223/0001-17");
        pJu.setDataFundacao(dataDate);
        pJu.setRamoAtuacao("Ramo _1_Atuacao");
        pJu.setRazaoSocial("Razao_1_Social");
        pJu.setXdead(false);
        pJu.setCodCliente(2);

        cli.setCodCliente(2);//------------------AQUI

        pJu.setCliente(cli);

        //if (cPjur.Cadastrar(pJu) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado PESSOA JURIDICA");

        //}
    }

    private static void TesteCadastro() {
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

//        CadClientesControle cadCliC = new CadClientesControle();
        //CadEnderecoControle cadEndC = new CadEnderecoControle();
        //CadTelefoneControle cadTelC = new CadTelefoneControle();

        //cadCliC = new CadClientesControle();
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
        String dS = "11/01/2006";
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
        //if (cadCliC.CadastrarClientePJuridicoEnderecoTelefone(cli) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado Varios");

        //}
    }
}
