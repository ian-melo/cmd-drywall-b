package cmd.Validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Classe de validação de texto geral
 *
 * @author Usuario
 */
public class Validar {

    /**
     * Verifica se o valor é vazio
     *
     * @param val Valor a ser validado
     * @return true caso vazio,<br>false caso contrário
     */
    public boolean validarVazio(String val) {
        if ("".equals(val.trim())) {
            return true;
        }
        return false;
    }

    /**
     * Valida formato da senha
     *
     * @param senha Senha a ser validada
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarSenha(String senha) {
        if (senha == null || validarVazio(senha) == true) {
            senha = "";
        }
        return (senha.length() >= 6 && senha.length() <= 16);
    }

    /**
     * Valida formato do telefone
     *
     * @param telefone Telefone a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarTelefone(String telefone) {
        if (telefone == null || validarVazio(telefone) == true) {
            telefone = "";
        }
        return Pattern.matches("(\\(\\d{2}\\))(\\d{4,5})-(\\d{4})", telefone);
    }

    /**
     * Valida formato do CPF
     *
     * @param cpf CPF a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarCpf(String cpf) {
        if (cpf == null || validarVazio(cpf) == true) {
            cpf = "";
        }
        return Pattern.matches("(\\d{3}).(\\d{3}).(\\d{3})-([0-9X]{2})", cpf);
    }

    /**
     * Valida formato do CNPJ
     *
     * @param cnpj CNPJ a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarCnpj(String cnpj) {
        if (cnpj == null || validarVazio(cnpj) == true) {
            cnpj = "";
        }
        return Pattern.matches("(\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2})", cnpj);
    }

    /**
     * Valida formato do CEP
     *
     * @param cep CEP a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarCep(String cep) {
        if (cep == null || validarVazio(cep) == true) {
            cep = "";
        }
        return Pattern.matches("(\\d{5})-(\\d{3})", cep);
    }

    /**
     * Valida formato do número do logradouro
     *
     * @param numero Número a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarNumero(String numero) {
        if (numero == null || validarVazio(numero) == true) {
            numero = "";
        }
        return Pattern.matches("^[0-9]*\\d+[0-9]*$", numero);
    }

    /**
     * Valida formato do número do logradouro<br>
     * Obs.: desconsidera-se vazio
     *
     * @param numero Número a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarNumeroSendoVazio(String numero) {
        return Pattern.matches("^[0-9]*\\d+[0-9]*$", numero);
    }

    /**
     * Valida formato do e-mail
     *
     * @param email E-mail a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarEmail(String email) {
        if (email == null) {
            email = "";
        }
        return Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email);
    }

    /**
     * Valida formato da data
     *
     * @param dataString Data a ser validada
     * @return true caso válido,<br>false caso contrário
     */
    public Date validarData(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(dataString);
        } catch (ParseException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return dataDate;
    }

    /**
     * Valida formato de Estado como Unidade Feredativa (UF)
     *
     * @param estado Estado a ser validado
     * @return true caso válido,<br>false caso contrário
     */
    public boolean validarEstado(String estado) {
        if (estado == null || validarVazio(estado) == true) {
            estado = "";
        }
        return Pattern.matches("([A-Z]{2})", estado);
    }

}
