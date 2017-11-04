/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author fe_mm
 */
public class ClienteTable 
{
    
    /*
    
    ============================================================================
    *****************ATENÇÃO ESTA CLASSE FOI APAGADA DO JAVAX*******************
    ============================================================================
    */
    
    
    
    
    
    private SimpleIntegerProperty id;
    private SimpleStringProperty nome;
    private SimpleStringProperty endereço;
    private SimpleStringProperty cpf;
    private SimpleStringProperty projeto;
    private SimpleIntegerProperty protocolo;
    private SimpleStringProperty telefone;
    private SimpleStringProperty email;
    
    public Integer Getid()
    {
        return id.getValue();
    }
    public String GetNome()
    {
        return nome.getValue();
    }
    public String GetEndereço()
    {
        return endereço.getValue();
    }
    public String GetCpf()
    {
        return cpf.getValue();
    }
    public String GetProjeto()
    {
        return projeto.getValue();
    }
    public Integer GetProtocolo()
    {
        return protocolo.getValue();
    }
    private String GetFone()
    {
        return telefone.getValue();
    }
    private String GetEmail()
    {
        return email.getValue();
    }

    public ClienteTable(int id, String nome, String endereço, String cpf, String projeto, Integer protocolo, String telefone, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.endereço = new SimpleStringProperty(endereço);
        this.cpf = new SimpleStringProperty(cpf);
        this.projeto = new SimpleStringProperty(projeto);
        this.protocolo = new SimpleIntegerProperty(protocolo);
        this.telefone = new SimpleStringProperty(telefone);
        this.email = new SimpleStringProperty(email);
    }
    
    
    
    
}
