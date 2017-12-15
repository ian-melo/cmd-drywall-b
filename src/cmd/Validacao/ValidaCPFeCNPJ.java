package cmd.Validacao;

import java.util.InputMismatchException;

/**
 * Classe de validação de CPF e CNPJ
 *
 * @author Usuario
 */
public class ValidaCPFeCNPJ {

    /**
     * Verifica se é um CPF válido
     *
     * @param CPF CPF a ser validado
     * @return true caso válido,<br/>false caso contrário
     */
    public static boolean isCPF(String CPF) {
        //Considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            //Cálculo do 1º Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                /*Converte o n-ésimo caractere do CPF em um numero:
                  Por exemplo, transforma o caractere '0' no inteiro 0         
                  (48 é a posicao de '0' na tabela ASCII)*/
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                //Converte no respectivo caractere numerico
                dig10 = (char) (r + 48);
            }

            //Cálculo do 2º Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            //Verifica se os digitos calculados conferem com os digitos informados
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    /**
     * Exibe o CPF com pontos e separadores
     *
     * @param CPF CPF a ser formatado (somente números)
     * @return CPF formatado
     */
    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    /**
     * Verifica se é um CNPJ válido
     *
     * @param CNPJ CNPJ a ser validado
     * @return true caso válido,<br/>false caso contrário
     */
    public static boolean isCNPJ(String CNPJ) {
        //Considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;
        try {
            //Cálculo do 1º Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                /*Converte o n-ésimo caractere do CNPJ em um número:
                  Por exemplo, transforma o caractere '0' no inteiro 0
                  (48 é a posição de '0' na tabela ASCII)*/
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }
            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            //Cálculo do 2º Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            //Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    /**
     * Exibe o CNPJ com pontos e separadores
     *
     * @param CNPJ CNPJ a ser formatado (somente números)
     * @return CNPJ formatado
     */
    public static String imprimeCNPJ(String CNPJ) {
        //Máscara do CNPJ: 99.999.999.9999-99
        return (CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "."
                + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-"
                + CNPJ.substring(12, 14));
    }

}
