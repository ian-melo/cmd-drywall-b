/*
 * Deixai toda esperança, ó vós que entrais!
 */
package cmd.testes;

import cmd.DAO.TelefoneDAO;
import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.Telefone;
import cmd.entidade.TelefoneId;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class TesteCadApenasTelefone {

    public static void main(String[] args) {
        //testeCadastroTelefoneUnitario();

        //testeCadastroTelefoneComCliente();
        testeCadastroTel();
        System.exit(0);
    }

    private static void testeCadastroTel() {
        Telefone tel = new Telefone();
        TelefoneDAO telDAO = new TelefoneDAO();
        TelefoneId telId = new TelefoneId();

        telId.setNumero("(11)1000-1001");
        telId.setCodCliente(40);//IMPORTANTE
        tel.setId(telId);
        tel.setCliente(null);
        tel.setXdead(true);
        

        if(telDAO.inserir(tel)){
            JOptionPane.showMessageDialog(null, "Cadastrado");
        }else{
            JOptionPane.showMessageDialog(null, "NÃO Cad");
        }

//        tels.add(tel);
//
//        tel = new Telefone();
//        telId = new TelefoneId();
//        telId.setNumero("(11)1000-1018");
//        telId.setCodCliente(9);//IMPORTANTE
//        tel.setId(telId);
//        tel.setCliente(null);
//        tel.setXdead(true);
//
//        tels.add(tel);
//
//        tel = new Telefone();
//        telId = new TelefoneId();
//        telId.setNumero("(11)1000-1019");
//        telId.setCodCliente(9);//IMPORTANTE
//        tel.setId(telId);
//        tel.setCliente(null);
//        tel.setXdead(true);
//
//        tels.add(tel);
//
        

    }

    private static void testeCadastroTelefoneComCliente() {
//       
//
//        cadCliC = new CadClientesControle();
//        Cliente cli = new Cliente();
//        Endereco end = new Endereco();
//        //PessoaJuridica pJur = new PessoaJuridica();
//
//        HashSet<Telefone> tels = new HashSet<>();
//
//        end.setCodEndereco(3);
//        end.setBairro("Bairro_5_Tes");
//        end.setCep("04233-010");
//        end.setCidade("Cidade_5_Tes");
//        end.setComplemento("Complemento_5_Tes");
//        end.setLogradouro("Logradouro_5_Tes");
//        end.setNumero("10");
//        end.setUf("55");
//        end.setXdead(false);
//
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date dataDate = new Date();
//        String dS = "11/01/2011";
//        try {
//            dataDate = formato.parse(dS);
//            System.out.println(dataDate);
//        } catch (ParseException ex) {
//            System.out.println(ex);
//        }
//
//        /*
//         78.846.292/0001-75
//         52.852.698/0001-77
//         79.664.724/0001-90
//         */
////        pJur.setCnpj("78.846.292/0001-75");
////        pJur.setDataFundacao(dataDate);
////        pJur.setRamoAtuacao("Ramo_5_Atuac");
////        pJur.setRazaoSocial("Razao_5_Soci");
////        pJur.setXdead(false);
//        Telefone tel = new Telefone();
//        TelefoneId telId = new TelefoneId();
//
//        telId.setNumero("(11)1000-1017");
//        telId.setCodCliente(9);//IMPORTANTE
//        tel.setId(telId);
//        tel.setCliente(null);
//        tel.setXdead(true);
//
//        tels.add(tel);
//
//        tel = new Telefone();
//        telId = new TelefoneId();
//        telId.setNumero("(11)1000-1018");
//        telId.setCodCliente(9);//IMPORTANTE
//        tel.setId(telId);
//        tel.setCliente(null);
//        tel.setXdead(true);
//
//        tels.add(tel);
//
//        tel = new Telefone();
//        telId = new TelefoneId();
//        telId.setNumero("(11)1000-1019");
//        telId.setCodCliente(9);//IMPORTANTE
//        tel.setId(telId);
//        tel.setCliente(null);
//        tel.setXdead(true);
//
//        tels.add(tel);
//
//        Iterator<Telefone> iterator = tels.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(">>>>>>>>>>>>> " + iterator.next().getId().getNumero());
//
//        }
//
//        cli.setCodCliente(null);
//        cli.setOrcamentos(null);
//        cli.setDataInscricao(dataDate);
//        cli.setEndereco(end);
//        //cli.setEndereco(null);
//        //cli.setPessoaJuridica(pJur);
//        cli.setPessoaJuridica(null);
//        cli.setTelefones(tels);
//        cli.setXdead(false);
//
//        if (cadCliC.CadastrarClientePJuridicoEnderecoTelefone(cli) == true) {
//            JOptionPane.showMessageDialog(null, "Cadastrado Varios");
//
//        }

    }

    private static void testeCadastroTelefoneUnitario() {
      
        Telefone tel = new Telefone();
        TelefoneId tId = new TelefoneId();
//=======================================
//        Não cadastra valores repetidos
//        Não cadastra em CodCliente q não existe        
//=======================================
        tId.setNumero("(11)4441-3333");
        tId.setCodCliente(7);//IMPORTANTE

        tel.setId(tId);
        tel.setCliente(null);
        tel.setXdead(true);

//        if (cTelc.Cadastrar(tel) == true) {
//            System.out.println("tel Cadastrado");
//        } else {
//            System.out.println("tel NÃO cadastrado");
//        }

    }
}
