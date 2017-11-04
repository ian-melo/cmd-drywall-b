/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.DAO;

import cmd.conexao.ConnectionFactory;
import cmd.entidade.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author fe_mm
 */
public class MaterialDAO 
{
    public void Create(Material M)
    {/*
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        
        try
        {
            stat = con.prepareStatement("INSERT INTO materiais(Id,Nome,Quantidade,Preco,Tipo,Unidade,Codigo_construl) VALUES(?,?,?,?,?,?,?)");
            stat.setInt(1, M.getId());
            stat.setString(2, M.getNome());
            stat.setInt(3, M.getQuantidade());
            stat.setFloat(4, M.getPreço());
            stat.setString(5, M.getTipo());
            stat.setString(6, M.getUnidade());
            stat.setInt(7, M.getCod_construl());
            stat.executeUpdate();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("C.M.D");
            alerta.setHeaderText("C.M.D Informa!!!");
            alerta.setContentText("Dados cadastrados com sucesso");
            alerta.showAndWait();
        }
        catch(SQLException e)
        {
            Alert alerta1 = new Alert(Alert.AlertType.INFORMATION);
            alerta1.setTitle("C.M.D");
            alerta1.setHeaderText("C.M.D Informa!!!");
            alerta1.setContentText("Dados não cadastrados com sucesso");
            alerta1.showAndWait();
            
        }
        finally
        {
            ConnectionFactory.fecharConexao(con, stat);
        }
    */}
    
    @SuppressWarnings("Unchecked")
    public List<Material> ListaMaterial()
    {/*
        List<Material> M = new ArrayList<>();
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        try
        {
            stat = con.prepareStatement("SELECT * from materiais");
            rs = stat.executeQuery();
            
            while(rs.next())
            {
                Material m = new Material();
                m.setId(rs.getInt("Id"));
                m.setNome(rs.getString("Nome"));
                m.setQuantidade(rs.getInt("Quantidade"));
                m.setPreço(rs.getFloat("Preco"));
                m.setTipo(rs.getString("Tipo"));
                m.setUnidade(rs.getString("Unidade"));
                m.setCod_construl(rs.getInt("Codigo_construl"));
                M.add(m);
            }
            
        }
        catch(SQLException e)
        {
            Alert alerta1 = new Alert(Alert.AlertType.INFORMATION);
            alerta1.setTitle("C.M.D");
            alerta1.setHeaderText("C.M.D Informa!!!");
            alerta1.setContentText("Erro ao listar" + e);
            alerta1.showAndWait();
        }
        finally
        {
           ConnectionFactory.fecharConexao(con, stat, rs);
        }
        return M;
    */ return null;}
    public void Update(Material m)
    {/*
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        
        try
        {
            stat = con.prepareStatement("UPDATE materiais SET Nome = ?, Quantidade = ?, Preco = ?, Tipo = ?, Unidade = ? Codigo_construl = ? WHERE Id = ? ");
            stat.setString(1, m.getNome());
            stat.setInt(2, m.getQuantidade());
            stat.setFloat(3, m.getPreço());
            stat.setString(4, m.getTipo());
            stat.setString(5, m.getUnidade());
            stat.setInt(6, m.getId());
            stat.setInt(7, m.getCod_construl());
            stat.setInt(8, m.getId());
            stat.executeUpdate();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("C.M.D");
            alerta.setHeaderText("C.M.D Informa!!!");
            alerta.setContentText("Dados alterados com sucesso");
            alerta.showAndWait();
        }
        catch(SQLException e)
        {
            Alert alerta1 = new Alert(Alert.AlertType.INFORMATION);
            alerta1.setTitle("C.M.D");
            alerta1.setHeaderText("C.M.D Informa!!!");
            alerta1.setContentText("Dados não alterados com sucesso");
            alerta1.showAndWait();
        }
        finally
        {
            ConnectionFactory.fecharConexao(con, stat);
        }
    */}
    
}
