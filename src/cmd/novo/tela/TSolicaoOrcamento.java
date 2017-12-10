/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.tela;

import cmd.DAO.PedidosDAO;
import java.awt.Color;
import cmd.email.SwingEmailSender;
import cmd.entidade.Pedidos;
import cmd.novo.GerenteDeJanelas;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class TSolicaoOrcamento extends javax.swing.JInternalFrame {

    //public static Pedidos ped = new Pedidos();
    public Pedidos ped = new Pedidos();

    GerenteDeJanelas gerenteDeJanelas;

    //Controla a quantidade de Janelas abertas
    public static TSolicaoOrcamento solicaoOrcamento;

    public static TSolicaoOrcamento getInstancia() {
        if (solicaoOrcamento == null) {
            solicaoOrcamento = new TSolicaoOrcamento();
        }
        return solicaoOrcamento;
    }

    /**
     * Creates new form SolicaoOrcamento
     */
    public TSolicaoOrcamento() {
        initComponents();
        gerenteDeJanelas = new GerenteDeJanelas(TPrincipal.jDesktopPane1);

        getContentPane().setBackground(Color.WHITE);
        pn_conteudo.setBackground(Color.WHITE);
        DefaultTableModel modelo = (DefaultTableModel) tb_orcamento.getModel();
        tb_orcamento.setRowSorter(new TableRowSorter(modelo));
        ReadTable();

    }

    public void ReadTable() {
        DefaultTableModel modelo = (DefaultTableModel) tb_orcamento.getModel();
        PedidosDAO p = new PedidosDAO();
        modelo.setNumRows(0);

        for (Pedidos pe : p.Read()) {
            modelo.addRow(new Object[]{
                pe.getId(),
                pe.getAltura(),
                pe.getLargura(),
                pe.getQtd_paredes(),
                pe.getEmail(),
                pe.getValor(),
                pe.getAmbiente(),
                pe.getPossui_porta(),
                pe.getPossui_janela(),
                pe.getQtd_porta(),
                pe.getQtd_janela(),
                pe.getAltura_porta(),
                pe.getLargura_porta(),
                pe.getAltura_janela(),
                pe.getLargura_janela(),
                pe.getMao_obra()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_enviarEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        pn_conteudo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_orcamento = new javax.swing.JTable();
        bt_atualizar = new javax.swing.JButton();
        btn_envioInfo = new javax.swing.JButton();

        setClosable(true);
        setTitle("Solicitação de Orçamentos");

        btn_enviarEmail.setBackground(new java.awt.Color(153, 153, 255));
        btn_enviarEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_enviarEmail.setText("Enviar email ao cliente");
        btn_enviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarEmailActionPerformed(evt);
            }
        });

        tb_orcamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_orcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Altura", "Largura", "Quantidade de Paredes", "Email", "Valor disponivel/desejado", "Ambiente", "Possui Portas", "Possui Janela", "Quantidade de Portas (Se houver)", "Quantidade Janelas (Se houver)", "Altura da Porta", "Largura da Porta", "Altura da Janela", "Largura da Janela", "Mao de Obra"
            }
        ));
        tb_orcamento.setPreferredSize(new java.awt.Dimension(1250, 48));
        tb_orcamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_orcamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_orcamento);

        javax.swing.GroupLayout pn_conteudoLayout = new javax.swing.GroupLayout(pn_conteudo);
        pn_conteudo.setLayout(pn_conteudoLayout);
        pn_conteudoLayout.setHorizontalGroup(
            pn_conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1885, Short.MAX_VALUE)
        );
        pn_conteudoLayout.setVerticalGroup(
            pn_conteudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pn_conteudo);

        bt_atualizar.setBackground(new java.awt.Color(153, 153, 255));
        bt_atualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_atualizar.setText("Atualizar Tabela");
        bt_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_atualizarActionPerformed(evt);
            }
        });

        btn_envioInfo.setBackground(new java.awt.Color(153, 153, 255));
        btn_envioInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_envioInfo.setText("<html><center>Enviar Informação <br /> selecionada <br/> para 'Novo orçamento'</html>");
        btn_envioInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envioInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_enviarEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_atualizar)
                        .addGap(55, 55, 55)
                        .addComponent(btn_envioInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 410, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(btn_enviarEmail))
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_envioInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarEmailActionPerformed
        SwingEmailSender email = new SwingEmailSender();
        email.show();
    }//GEN-LAST:event_btn_enviarEmailActionPerformed

    private void bt_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_atualizarActionPerformed
        ReadTable();
    }//GEN-LAST:event_bt_atualizarActionPerformed

    private void btn_envioInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envioInfoActionPerformed
        if (tb_orcamento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção");
            return;
        }
        int linha = tb_orcamento.getSelectedRow();

        try {

            //ped = new Pedidos();
            
             if ((float) tb_orcamento.getValueAt(linha, 1) > 0) {
                  ped.setAltura((float) tb_orcamento.getValueAt(linha, 1) / 100);
             }
             
              if ((float) tb_orcamento.getValueAt(linha, 2) > 0) {
                  ped.setLargura((float) tb_orcamento.getValueAt(linha, 2)  / 100);
              }
            
            ped.setQtd_paredes((int) tb_orcamento.getValueAt(linha, 3));
            ped.setEmail((String) tb_orcamento.getValueAt(linha, 4));
            ped.setValor((float) tb_orcamento.getValueAt(linha, 5));
            ped.setAmbiente((String) tb_orcamento.getValueAt(linha, 6));
            ped.setPossui_porta((String) tb_orcamento.getValueAt(linha, 7));
            ped.setPossui_janela((String) tb_orcamento.getValueAt(linha, 8));
            ped.setQtd_porta((int) tb_orcamento.getValueAt(linha, 9));
            ped.setQtd_janela((int) tb_orcamento.getValueAt(linha, 10));

            if ((float) tb_orcamento.getValueAt(linha, 11) <= 0) {
                ped.setAltura_porta((float) tb_orcamento.getValueAt(linha, 11));
            } else {
                ped.setAltura_porta((float) tb_orcamento.getValueAt(linha, 11) / 100);
            }
            if ((float) tb_orcamento.getValueAt(linha, 12) <= 0) {
                ped.setLargura_porta((float) tb_orcamento.getValueAt(linha, 12));
            } else {
                ped.setLargura_porta((float) tb_orcamento.getValueAt(linha, 12) / 100);
            }
            if ((float) tb_orcamento.getValueAt(linha, 13) <= 0) {
                ped.setAltura_janela((float) tb_orcamento.getValueAt(linha, 13));
            } else {
                ped.setAltura_janela((float) tb_orcamento.getValueAt(linha, 13) / 100);
            }
            if ((float) tb_orcamento.getValueAt(linha, 14) <= 0) {
                ped.setLargura_janela((float) tb_orcamento.getValueAt(linha, 14));
            } else {
                ped.setLargura_janela((float) tb_orcamento.getValueAt(linha, 14) / 100);
            }

            ped.setMao_obra((String) tb_orcamento.getValueAt(linha, 15));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro: " + e);
            System.err.println(e);
        }
        try {
            gerenteDeJanelas.abrirJanelas(TCalculo.getInstancia(ped));
        } catch (IllegalArgumentException e) {
            gerenteDeJanelas.abrirJanelas(TCalculo.getInstancia(ped));
            //System.err.println(e);//ERRO ! - Erro - contornado.... retirar todo o try
        }


    }//GEN-LAST:event_btn_envioInfoActionPerformed

    private void tb_orcamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_orcamentoMouseClicked
        int linha;
        if (evt.getClickCount() == 1) {
            linha = tb_orcamento.getSelectedRow();

            //Enviar info para TCalculo, enviar o cliente para TOrcamento
        }
    }//GEN-LAST:event_tb_orcamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_atualizar;
    private javax.swing.JButton btn_enviarEmail;
    private javax.swing.JButton btn_envioInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pn_conteudo;
    private javax.swing.JTable tb_orcamento;
    // End of variables declaration//GEN-END:variables
}
