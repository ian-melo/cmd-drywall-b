/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.DAO;

import cmd.conexao.ConnectionFactory;
import cmd.entidade.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fe_mmo
 */
public class PedidosDAO 
{
    public List<Pedidos>Read()
   {
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Pedidos> eq = new ArrayList<>();
        try 
        {
            stat = con.prepareStatement("SELECT * FROM pedido_orcamento");
            rs = stat.executeQuery();
            
            while(rs.next())
            {
                Pedidos e = new Pedidos();
                e.setId(rs.getInt("Id"));
                e.setAltura(rs.getFloat("Altura"));
                e.setLargura(rs.getFloat("Largura"));
                e.setQtd_paredes(rs.getInt("Qtd_paredes"));
                e.setEmail(rs.getString("Email"));
                e.setValor(rs.getFloat("Valor"));
                e.setAmbiente(rs.getString("Ambiente"));
                e.setPossui_porta(rs.getString("Possui_porta"));
                e.setPossui_janela(rs.getString("Possui_janela"));
                e.setQtd_porta(rs.getInt("Qtd_porta"));
                e.setQtd_janela(rs.getInt("Qtd_janela"));
                e.setAltura_porta(rs.getFloat("Altura_porta"));
                e.setLargura_porta(rs.getFloat("Largura_porta"));
                e.setAltura_janela(rs.getFloat("Altura_janela"));
                e.setLargura_janela(rs.getFloat("Largura_janela"));
                e.setMao_obra(rs.getString("Mao_obra"));
                eq.add(e);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.fechaConexão(con, stat, rs);
        }
        return eq;
   }
}
