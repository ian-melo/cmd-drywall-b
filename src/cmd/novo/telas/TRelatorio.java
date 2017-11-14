/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.telas;
import cmd.conexao.ConnectionFactory;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.*;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRResultSetDataSource;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;
public class TRelatorio extends javax.swing.JInternalFrame {

    public static TRelatorio relatorioT;

    public static TRelatorio getInstancia() {
        if (relatorioT == null) {
            relatorioT = new TRelatorio();
        }
        return relatorioT;
    }

    /**
     * Creates new form RelatorioT
     */
    public TRelatorio() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_rel1 = new javax.swing.JButton();
        bt_rel2 = new javax.swing.JButton();
        bt_rel3 = new javax.swing.JButton();
        bt_rel4 = new javax.swing.JButton();
        bt_rel5 = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");

        bt_rel1.setBackground(new java.awt.Color(153, 153, 255));
        bt_rel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_rel1.setText("Relatórios 01");
        bt_rel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rel1ActionPerformed(evt);
            }
        });

        bt_rel2.setBackground(new java.awt.Color(153, 153, 255));
        bt_rel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_rel2.setText("Relatórios 02");
        bt_rel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rel2ActionPerformed(evt);
            }
        });

        bt_rel3.setBackground(new java.awt.Color(153, 153, 255));
        bt_rel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_rel3.setText("Relatórios 03");
        bt_rel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rel3ActionPerformed(evt);
            }
        });

        bt_rel4.setBackground(new java.awt.Color(153, 153, 255));
        bt_rel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_rel4.setText("Relatórios 04");
        bt_rel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rel4ActionPerformed(evt);
            }
        });

        bt_rel5.setBackground(new java.awt.Color(153, 153, 255));
        bt_rel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_rel5.setText("Relatórios 05");
        bt_rel5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rel5ActionPerformed(evt);
            }
        });

        btn_sair.setBackground(new java.awt.Color(153, 153, 255));
        btn_sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sair.setText("Sair");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bem-Vindo a Área de Relaórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_rel5)
                            .addComponent(bt_rel4)
                            .addComponent(bt_rel3)
                            .addComponent(bt_rel2)
                            .addComponent(bt_rel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btn_sair)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_rel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_rel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_rel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_rel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_rel5)
                .addGap(18, 18, 18)
                .addComponent(btn_sair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_rel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rel1ActionPerformed
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
//        try
//        { 
//            stat = con.prepareStatement("SELECT * from material");
//            rs = stat.executeQuery();
//            JRResultSetDataSource relatresult = new JRResultSetDataSource(rs);
//            JasperPrint print = JasperFillManager.fillReport("caminho a ser colocado", new HashMap(), relatresult);
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            view.toFront();
//        }
//        catch(JRException e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o relatorio: \n" + e );
//        }
//        finally
//        {
//            ConnectionFactory.fecharConexao(con,stat);
//        }
    }//GEN-LAST:event_bt_rel1ActionPerformed

    private void bt_rel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rel2ActionPerformed
              Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
//        try
//        { 
//            stat = con.prepareStatement("SELECT * from material");
//            rs = stat.executeQuery();
//            JRResultSetDataSource relatresult = new JRResultSetDataSource(rs);
//            JasperPrint print = JasperFillManager.fillReport("caminho a ser colocado", new HashMap(), relatresult);
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            view.toFront();
//        }
//        catch(JRException e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o relatorio: \n" + e );
//        }
//        finally
//        {
//            ConnectionFactory.fecharConexao(con,stat);
//        }
    }//GEN-LAST:event_bt_rel2ActionPerformed

    private void bt_rel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rel3ActionPerformed
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
//        try
//        { 
//            stat = con.prepareStatement("SELECT * from material");
//            rs = stat.executeQuery();
//            JRResultSetDataSource relatresult = new JRResultSetDataSource(rs);
//            JasperPrint print = JasperFillManager.fillReport("caminho a ser colocado", new HashMap(), relatresult);
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            view.toFront();
//        }
//        catch(JRException e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o relatorio: \n" + e );
//        }
//        finally
//        {
//            ConnectionFactory.fecharConexao(con,stat);
//        }
    }//GEN-LAST:event_bt_rel3ActionPerformed

    private void bt_rel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rel4ActionPerformed
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
//        try
//        { 
//            stat = con.prepareStatement("SELECT * from material");
//            rs = stat.executeQuery();
//            JRResultSetDataSource relatresult = new JRResultSetDataSource(rs);
//            JasperPrint print = JasperFillManager.fillReport("caminho a ser colocado", new HashMap(), relatresult);
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            view.toFront();
//        }
//        catch(JRException e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o relatorio: \n" + e );
//        }
//        finally
//        {
//            ConnectionFactory.fecharConexao(con,stat);
//        }
    }//GEN-LAST:event_bt_rel4ActionPerformed

    private void bt_rel5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rel5ActionPerformed
        Connection con = ConnectionFactory.getConexao();
        PreparedStatement stat = null;
        ResultSet rs = null;
        
//        try
//        { 
//            stat = con.prepareStatement("SELECT * from material");
//            rs = stat.executeQuery();
//            JRResultSetDataSource relatresult = new JRResultSetDataSource(rs);
//            JasperPrint print = JasperFillManager.fillReport("caminho a ser colocado", new HashMap(), relatresult);
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            view.toFront();
//        }
//        catch(JRException e)
//        {
//            JOptionPane.showMessageDialog(rootPane, "Erro ao chamar o relatorio: \n" + e );
//        }
//        finally
//        {
//            ConnectionFactory.fecharConexao(con,stat);
//        }
    }//GEN-LAST:event_bt_rel5ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_rel1;
    private javax.swing.JButton bt_rel2;
    private javax.swing.JButton bt_rel3;
    private javax.swing.JButton bt_rel4;
    private javax.swing.JButton bt_rel5;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
