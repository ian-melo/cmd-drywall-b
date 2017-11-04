/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class Validacao {

    public boolean validarVazio(String val) {
        if ("".equals(val.trim())) {
            return true;
        }
        return false;
    }

    public boolean validarSenha(String senha) {
        if (senha == null || validarVazio(senha) == true) {
            senha = "";
        }
//      Foi modificado para 6
        return (senha.length() >= 6 && senha.length() <= 16);
    }

    public boolean validarTelefone(String telefone) {
        if (telefone == null || validarVazio(telefone) == true) {
            telefone = "";
        }
        return Pattern.matches("(\\(\\d{2}\\))(\\d{4,5})-(\\d{4})", telefone);
    }

    public boolean validarCpf(String cpf) {
        if (cpf == null || validarVazio(cpf) == true) {
            cpf = "";
        }
        return Pattern.matches("(\\d{3}).(\\d{3}).(\\d{3})-([0-9X]{2})", cpf);
    }

    public boolean validarCnpj(String cnpj) {
        if (cnpj == null || validarVazio(cnpj) == true) {
            cnpj = "";
        }
        return Pattern.matches("(\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2})", cnpj);
    }

    public boolean validarCep(String cep) {
        if (cep == null || validarVazio(cep) == true) {
            cep = "";
        }
        return Pattern.matches("(\\d{5})-(\\d{3})", cep);
    }

    public boolean validarNumero(String numero) {
        if (numero == null || validarVazio(numero) == true) {
            numero = "";
        }
        return Pattern.matches("^[0-9]*\\d+[0-9]*$", numero);
    }

//    public boolean validarData(String data) {
//        if (data == null || validarVazio(data) == true) {
//            data = "";
//        }
//        return Pattern.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$", data);
//    }
    
    //Retorna NULL se não for data
    public Date validarData(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(dataString);
        } catch (ParseException ex) {
            Logger.getLogger(Validacao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return dataDate;

    }

    public boolean validarEstado(String estado) {
        if (estado == null || validarVazio(estado) == true) {
            estado = "";
        }
        return Pattern.matches("([A-Z]{2})", estado);
    }

    //Testar: http://tools.lymas.com.br/regexp_br.php
}
