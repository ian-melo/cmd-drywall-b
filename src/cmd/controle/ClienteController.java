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

    public boolean inserirPessoaJuridica(PessoaJuridica pJ) {
        if (pJ == null || pJ.getCliente() == null) {
            return false;
        }

        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        TelefoneDAO telDAO = new TelefoneDAO();

        if ((pJ.getCliente().getEndereco() != null) && (!endDAO.inserir(pJ.getCliente().getEndereco()))) {
            return false;
        }
        if ((pJ.getCliente() != null) && (!pJuDAO.inserir(pJ))) {
            return false;
        }

        int valor = pJ.getCliente().getCodCliente();//pega o valor q retornar do Hibernate
        JOptionPane.showMessageDialog(null, "Código do cliente: " + valor);

        Telefone tt;
        Iterator<Telefone> iterator = pJ.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {
            tt = iterator.next();//Separa objeto telefone em yma variavel
            tt.getId().setCodCliente(valor);//Força o valor q retorna do Hibernate, no codCliente do objeto Telefone

            if (telDAO.inserir(tt)) {
                //System.out.println("Telefone Cadastrado_cadTel");//Teste
            } else {
                //System.out.println("_2_ " + iterator.next().getId().getNumero());//Teste
                //System.out.println("Telefone NÃO Cadastrado_cadTel");//Teste
                return false;
            }
        }

//        if ((pJ.getCliente() != null) && (!pJuDAO.inserir(pJ))) {
//            return false;
//        }
        return true;
    }

    public boolean inserirPessoaFisica(PessoaFisica pF) {
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

        int valor = pF.getCliente().getCodCliente();//pega o valor q retornar do Hibernate
        JOptionPane.showMessageDialog(null, "Código do cliente: " + valor);

        Telefone tt;
        Iterator<Telefone> iterator = pF.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {
            tt = iterator.next();//Separa objeto telefone em uma variavel
            tt.getId().setCodCliente(valor);//Força o valor q retorna do Hibernate, no codCliente do objeto Telefone

            if (telDAO.inserir(tt)) {
                //System.out.println("Telefone Cadastrado_cadTel");//Teste
            } else {
                //System.out.println("_2_ " + iterator.next().getId().getNumero());//Teste
                //System.out.println("Telefone NÃO Cadastrado_cadTel");//Teste
                return false;
            }
        }
        return true;
    }

    public boolean verificarCpf(PessoaFisica pFi) {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        if (pFi == null) {
            return false;
        }

        return (pFiDAO.buscarCPF(pFi.getCpf()) == null);
    }

    public boolean verificarCnpj(PessoaJuridica pJu) {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        if (pJu == null) {
            return false;
        }

        return (pJuDAO.buscarCNPJ(pJu.getCnpj()) == null);
    }

    public boolean validarCpf(PessoaFisica pFi) {
        if (pFi == null) {
            return false;
        }

        String cpf = pFi.getCpf();
        //Quabra a string em partes e retira a pontuação
        cpf = cpf.substring(0, 3) + cpf.substring(4, 7)
                + cpf.substring(8, 11) + cpf.substring(12, 14);

        return ValidaCPFeCNPJ.isCPF(cpf);
    }

    public boolean validarCnpj(PessoaJuridica pJu) {
        if (pJu == null || "".equals(pJu.getCnpj())) {
            return false;
        }

        String cnpj = pJu.getCnpj();

        //Quabra a string em partes e retira a pontuação
        cnpj = cnpj.substring(0, 2) + cnpj.substring(3, 6)
                + cnpj.substring(7, 10) + cnpj.substring(11, 15) + cnpj.substring(16, 18);

        return ValidaCPFeCNPJ.isCNPJ(cnpj);
    }

    public boolean alterarPessoaFisica(PessoaFisica pF) {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();

         pF.setCodCliente(pFiDAO.buscarCPF(pF.getCpf()).getCodCliente());//Necessaro quebrarb em 2 linhas - Busca pelo CNPJ para recuperar o Cod
        
        return pFiDAO.alterar(pF);
    }

    public boolean alterarPessoaJuridica(PessoaJuridica pJ) {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        //int cod = 0;

        pJ.setCodCliente(pJuDAO.buscarCNPJ(pJ.getCnpj()).getCodCliente());//Necessaro quebrarb em 2 linhas - Busca pelo CNPJ para recuperar o Cod

        return pJuDAO.alterar(pJ);
    }

    public List<PessoaJuridica> listarPessoasJuridicas() {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        //System.out.println("------------Cliente-Controle-----pJuridica-------");//Teste
        List<PessoaJuridica> pj = pJuDAO.listar();
        //pFiDAO.fecharListar();
        return pj;
    }

    public List<PessoaFisica> listarPessoasFisicas() {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        //System.out.println("------------Cliente-Controle-----pFisica-------");//Teste
        List<PessoaFisica> pf = pFiDAO.listar();
        //pFiDAO.fecharListar();
        return pf;
    }
}
