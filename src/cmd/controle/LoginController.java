package cmd.controle;

/**
 * Classe de controle para login
 * @author ian-melo
 */
public class LoginController {
    /**
     * Realiza login
     * @param input Valores inputados pelo usuário <br>
     * Na ordem:<br>
     * - Login - nome de acesso<br>
     * - Senha - senha de acesso
     * @return true, se é permitido acesso<br>false, caso contrário
     * @deprecated Sem uso
     */
    public boolean fazerLogin(String[] input) {
        return false;
    }
    
    /**
     * Realiza logout
     * @return true, se feito<br>false, caso contrário
     * @deprecated Sem uso
     */
    public boolean fazerLogout() {
        return true;
    }
}
