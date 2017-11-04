package cmd.entidade;
// Generated 29/10/2017 11:08:24 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PessoaFisica generated by hbm2java
 */
public class PessoaFisica  implements java.io.Serializable {


     private int codCliente;
     private Cliente cliente;
     private String cpf;
     private String nome;
     private Date dataNascimento;
     private Boolean xdead;

    public PessoaFisica() {
    }

	
    public PessoaFisica(Cliente cliente) {
        this.cliente = cliente;
    }
    public PessoaFisica(Cliente cliente, String cpf, String nome, Date dataNascimento, Boolean xdead) {
       this.cliente = cliente;
       this.cpf = cpf;
       this.nome = nome;
       this.dataNascimento = dataNascimento;
       this.xdead = xdead;
    }
   
    public int getCodCliente() {
        return this.codCliente;
    }
    
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public Boolean getXdead() {
        return this.xdead;
    }
    
    public void setXdead(Boolean xdead) {
        this.xdead = xdead;
    }




}


