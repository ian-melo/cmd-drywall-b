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
import cmd.Validacao.ValidaCPFeCNPJ;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author voce
 */
public class ClienteController {

    public boolean inserirClientePessoaJuridica(PessoaJuridica pJ) {
//        if (c == null || (c.getPessoaFisica() == null && c.getPessoaJuridica() == null)) {
//            return false;
//        }

        if (pJ == null || pJ.getCliente() == null) {
            return false;
        }

        //Processo de execução das DAOs
//        PessoaFisica pFi = c.getPessoaFisica();
//        PessoaJuridica pJu = c.getPessoaJuridica();
//        Endereco end = c.getEndereco();
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();

        EnderecoDAO endDAO = new EnderecoDAO();
        TelefoneDAO telDAO = new TelefoneDAO();

        //ClienteDAO cliDao = new ClienteDAO();
        if ((pJ.getCliente().getEndereco() != null) && (!endDAO.inserir(pJ.getCliente().getEndereco()))) {
            return false;
        }

//        if (!cliDao.inserir(c)) {
//            return false;
//        }
        if ((pJ.getCliente() != null) && (!pJuDAO.inserir(pJ))) {
            return false;
        }

        int valor = pJ.getCliente().getCodCliente();//pega o valor q retornar do Hibernate
        JOptionPane.showMessageDialog(null, "CodCliente=" + valor);

        //pJ.getCliente().getTelefones().iterator().hasNext();
        Telefone tt = new Telefone();
        Iterator<Telefone> iterator = pJ.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {

            tt = iterator.next();//Separa objeto telefone em yma variavel
            tt.getId().setCodCliente(valor);//Força o valor q retorna do Hibernate, no codCliente do objeto Telefone

            //if (telDAO.inserir(iterator.next())) {
            if (telDAO.inserir(tt)) {
                System.out.println("Telefone Cadastrado_cadTel");//Remover
            } else {
                //System.out.println("_2_ " + iterator.next().getId().getNumero());
                System.out.println("Telefone NÃO Cadastrado_cadTel");//Remover
                return false;
            }
        }

//        if ((pJ.getCliente() != null) && (!pJuDAO.inserir(pJ))) {
//            return false;
//        }
        return true;
    }

    public boolean inserirClientePessoaFisica(PessoaFisica pF) {

        if (pF == null || pF.getCliente() == null) {
            return false;
        }

        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();

        EnderecoDAO endDAO = new EnderecoDAO();
        TelefoneDAO telDAO = new TelefoneDAO();

        if ((pF.getCliente().getEndereco() != null) && (!endDAO.inserir(pF.getCliente().getEndereco()))) {
            return false;
        }

        if ((pF.getCliente() != null) && (!pFiDAO.inserir(pF))) {
            return false;
        }

        //JOptionPane.showMessageDialog(null, "CodCliente=" + pF.getCliente().getCodCliente());
        Iterator<Telefone> iterator = pF.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {
            if (telDAO.inserir(iterator.next())) {
                System.out.println("Telefone Cadastrado_cadTel");//Remover
            } else {
                //System.out.println("_2_ " + iterator.next().getId().getNumero());
                System.out.println("Telefone NÃO Cadastrado_cadTel");//Remover
                return false;
            }
        }

        return true;
    }

    public boolean verificaCPFemBD(PessoaFisica pFi) {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        if (pFi == null) {
            return false;
        }

        if (pFiDAO.buscarCPF(pFi.getCpf()) == null) {
            return true;
        }

        return false;
    }

    public boolean verificaCNPJemBD(PessoaJuridica pJu) {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        if (pJu == null) {
            return false;
        }

        if (pJuDAO.buscarCNPJ(pJu.getCnpj()) == null) {
            return true;
        }

        return false;
    }

    public boolean validaCPF(PessoaFisica pFi) {
        if (pFi == null) {
            return false;
        }

        String cpf = pFi.getCpf();
//Quabra a string em partes e retira a pontuação
        cpf = cpf.substring(0, 3) + cpf.substring(4, 7)
                + cpf.substring(8, 11) + cpf.substring(12, 14);

        return ValidaCPFeCNPJ.isCPF(cpf);
    }

    public boolean validaCNPJ(PessoaJuridica pJu) {
        if (pJu == null || "".equals(pJu.getCnpj())) {
            return false;
        }

        String cnpj = pJu.getCnpj();

        //Quabra a string em partes e retira a pontuação
        cnpj = cnpj.substring(0, 2) + cnpj.substring(3, 6)
                + cnpj.substring(7, 10) + cnpj.substring(11, 15) + cnpj.substring(16, 18);

        return ValidaCPFeCNPJ.isCNPJ(cnpj);
    }

    public List<PessoaJuridica> ListaPessoaJuridica() {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        System.out.println("------------Cliente-Controle-----pJuridica-------");
        List<PessoaJuridica> pj = pJuDAO.listar();
        //pFiDAO.fecharListar();
        return pj;
    }

    public List<PessoaFisica> ListaPessoaFisicas() {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        System.out.println("------------Cliente-Controle-----pFisica-------");
        List<PessoaFisica> pf = pFiDAO.listar();
        //pFiDAO.fecharListar();
        return pf;
    }

}
