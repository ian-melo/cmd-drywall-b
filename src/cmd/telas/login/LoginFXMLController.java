/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.telas.login;


import cmd.conexao.ConnectionFactory;
import cmd.DAO.UsuárioDAO;
import cmd.entidade.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fe_mm
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField txt_nome;
    @FXML
    private PasswordField txt_senha;
    @FXML
    private Button bt_login;
    @FXML
    private Button bt_sair;
    @FXML
    private Button bt_registrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ConnectionFactory.getConexao();
    }

    

    @FXML
    private void ActionLogin(ActionEvent event) throws IOException {
        UsuárioDAO dao = new UsuárioDAO();
        
        if(dao.CheckLogin(txt_nome.getText(), new String(txt_senha.getText()).trim()))
        {
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
            dialogo.setTitle("C.M.D");
            dialogo.setHeaderText("C.M.D Informa!!!");
            dialogo.setContentText("Seja Bem-Vindo a Áres Principal: \n");
            dialogo.showAndWait();
            Parent funcionario_parent = FXMLLoader.load(getClass().getResource("/cmd/fxml/PrincipalFXML.fxml"));
            Scene funcionario_scene = new Scene(funcionario_parent);
            Stage app_tela = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_tela.setScene(funcionario_scene);
            app_tela.show();
        }
        else
        {
            Alert dialogo = new Alert(Alert.AlertType.ERROR);
            dialogo.setTitle("C.M.D");
            dialogo.setHeaderText("C.M.D Informa!!!");
            dialogo.setContentText("Usuário ou Senha incorretos: \n");
            txt_nome.setText("");
            txt_senha.setText("");
            dialogo.showAndWait();
        }
    }

    @FXML
    private void ActionRegistrar(ActionEvent event) throws IOException, Exception {
       Parent funcionario_parent = FXMLLoader.load(getClass().getResource("/cmd/fxml/FuncionarioFXML.fxml"));
       Scene funcionario_scene = new Scene(funcionario_parent);
       Stage app_tela = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_tela.setScene(funcionario_scene);
       app_tela.show();
    }

    @FXML
    private void ActionSair(ActionEvent event) throws IOException 
    {
          Parent funcionario_parent = FXMLLoader.load(getClass().getResource("/cmd/fxml/LoginFXML.fxml"));
       Scene funcionario_scene = new Scene(funcionario_parent);
       Stage app_tela = (Stage) ((Node) event.getSource()).getScene().getWindow();
       app_tela.setScene(funcionario_scene);
       app_tela.close();
    }

}
