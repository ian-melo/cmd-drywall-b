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
 * Controle para registro de Cliente
 *
 * @author Usuario
 */
public class ClienteController {

    /**
     * Insere uma Pessoa Jurídica
     *
     * @param pJ Pessoa Jurídica
     * @return true caso realizado com sucesso,<br>false caso contrário
     */
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
        //Pega o valor que retorna do Hibernate
        int valor = pJ.getCliente().getCodCliente();
        JOptionPane.showMessageDialog(null, "Código do cliente: " + valor);

        Telefone tt;
        Iterator<Telefone> iterator = pJ.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {
            tt = iterator.next();
            tt.getId().setCodCliente(valor);//Força o valor que retorna do Hibernate; codCliente do objeto Telefone
            if (!telDAO.inserir(tt)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Insere uma Pessoa Física
     *
     * @param pF Pessoa Física
     * @return true caso realizado com sucesso,<br>false caso contrário
     */
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
        //Pega o valor que retorna do Hibernate
        int valor = pF.getCliente().getCodCliente();
        JOptionPane.showMessageDialog(null, "Código do cliente: " + valor);

        Telefone tt;
        Iterator<Telefone> iterator = pF.getCliente().getTelefones().iterator();
        while (iterator.hasNext()) {
            tt = iterator.next();
            tt.getId().setCodCliente(valor);//Força o valor que retorna do Hibernate; codCliente do objeto Telefone
            if (!telDAO.inserir(tt)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se CPF da Pessoa Física já existe em registro
     *
     * @param pFi Pessoa Física
     * @return true caso exista,<br>false caso contrário
     */
    public boolean verificarCpf(PessoaFisica pFi) {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        if (pFi == null) {
            return false;
        }
        return (pFiDAO.buscarCPF(pFi.getCpf()) == null);
    }

    /**
     * Verifica se CNPJ da Pessoa Jurídica já existe em registro
     *
     * @param pJu Pessoa Jurídica
     * @return true caso exista,<br>false caso contrário
     */
    public boolean verificarCnpj(PessoaJuridica pJu) {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        if (pJu == null) {
            return false;
        }
        return (pJuDAO.buscarCNPJ(pJu.getCnpj()) == null);
    }

    /**
     * Valida o CPF da Pessoa Física
     *
     * @param pFi Pessoa Física
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarCpf(PessoaFisica pFi) {
        if (pFi == null) {
            return false;
        }

        String cpf = pFi.getCpf();
        cpf = cpf.substring(0, 3) + cpf.substring(4, 7)
                + cpf.substring(8, 11) + cpf.substring(12, 14);
        return ValidaCPFeCNPJ.isCPF(cpf);
    }

    /**
     * Valida o CNPJ da Pessoa Jurídica
     *
     * @param pJu Pessoa Jurídica
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarCnpj(PessoaJuridica pJu) {
        if (pJu == null || "".equals(pJu.getCnpj())) {
            return false;
        }

        String cnpj = pJu.getCnpj();
        cnpj = cnpj.substring(0, 2) + cnpj.substring(3, 6)
                + cnpj.substring(7, 10) + cnpj.substring(11, 15) + cnpj.substring(16, 18);
        return ValidaCPFeCNPJ.isCNPJ(cnpj);
    }

    /**
     * Altera uma Pessoa Física
     *
     * @param pF Pessoa Física
     * @return true caso realizado com sucesso,<br>false caso contrário
     */
    public boolean alterarPessoaFisica(PessoaFisica pF) {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();

        pF.setCodCliente(pFiDAO.buscarCPF(pF.getCpf()).getCodCliente());
        pF.getCliente().getEndereco().setCodEndereco(pF.getCodCliente());
        if (pFiDAO.alterar(pF)) {
            if (endDAO.alterar(pF.getCliente().getEndereco())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Altera uma Pessoa Jurídica
     *
     * @param pJ Pessoa Jurídica
     * @return true caso realizado com sucesso,<br>false caso contrário
     */
    public boolean alterarPessoaJuridica(PessoaJuridica pJ) {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();

        pJ.setCodCliente(pJuDAO.buscarCNPJ(pJ.getCnpj()).getCodCliente());
        pJ.getCliente().getEndereco().setCodEndereco(pJ.getCodCliente());
        if (pJuDAO.alterar(pJ)) {
            if (endDAO.alterar(pJ.getCliente().getEndereco())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lista as Pessoas Jurídicas
     *
     * @return Lista de Pessoas Jurídicas
     */
    public List<PessoaJuridica> listarPessoasJuridicas() {
        PessoaJuridicaDAO pJuDAO = new PessoaJuridicaDAO();
        List<PessoaJuridica> pj = pJuDAO.listar();
        return pj;
    }

    /**
     * Lista as Pessoas Físicas
     *
     * @return Lista de Pessoas Físicas
     */
    public List<PessoaFisica> listarPessoasFisicas() {
        PessoaFisicaDAO pFiDAO = new PessoaFisicaDAO();
        List<PessoaFisica> pf = pFiDAO.listar();
        return pf;
    }
}
