/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.controle;


import cmd.DAO.EnderecoDAO;
import cmd.entidade.Endereco;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CadEnderecoControle {

    public boolean Cadastrar(Endereco item) {
       
        
        EnderecoDAO endDao = new EnderecoDAO();
        
        if(endDao.inserir(item)){
            return true;
        }
        return false;
        
        
    }

 
    public boolean alterar(Endereco item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public boolean excluir(Endereco item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public Endereco buscar(String consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Endereco> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
