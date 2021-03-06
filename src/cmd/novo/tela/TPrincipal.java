/*
 * Deixai toda esperança, ó vós que entrais!
 */
package cmd.novo.tela;

import cmd.novo.GerenteDeJanelas;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * Tela inicial
 *
 * @author Usuario Tela principal
 */
public class TPrincipal extends javax.swing.JFrame {

    TCarregamento tCar = new TCarregamento(null, true);

    GerenteDeJanelas gerenteDeJanelas;

    /**
     * Creates new form PrincipalT
     *
     * @param nomeL Utiliza para passar a pessoa q esta logada
     */
    public TPrincipal(String nomeL) {
        initComponents();
        getContentPane().setBackground(Color.BLUE);

        pnl_botoes.setBackground(new Color(153, 153, 255));
        pnl_APP.setBackground(new Color(153, 153, 255));
        pnl_funcionarios.setBackground(new Color(153, 153, 255));
        pnl_gerenciamentoItens.setBackground(new Color(153, 153, 255));
        pnl_orcamento.setBackground(new Color(153, 153, 255));
        pnl_relatorios.setBackground(new Color(153, 153, 255));

        pnl_funcionarios.setVisible(false);

        this.gerenteDeJanelas = new GerenteDeJanelas(jDesktopPane1);

        if (nomeL != null) {
            lb_logado.setText(nomeL);
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

        pnl_botoes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lb_logado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_gerenciamentoItens = new javax.swing.JPanel();
        btn_cadMateriais = new javax.swing.JButton();
        btn_cadConstrucao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnl_orcamento = new javax.swing.JPanel();
        btn_cadClientes = new javax.swing.JButton();
        btn_calOrcamentoPrj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pnl_APP = new javax.swing.JPanel();
        btn_solicitacaoOrcamento = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pnl_funcionarios = new javax.swing.JPanel();
        btn_cadFuncionarios = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pnl_relatorios = new javax.swing.JPanel();
        btn_relatorios = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/cmd/imagens/logo.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image, 0,0,getWidth(),getHeight(),this);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jLabel1.setText("Logado como:");

        lb_logado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_logado.setText("NULL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("v0.22");

        pnl_gerenciamentoItens.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));

        btn_cadMateriais.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadMateriais.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadMateriais.setText("Registro de Materiais");
        btn_cadMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadMateriaisActionPerformed(evt);
            }
        });

        btn_cadConstrucao.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadConstrucao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadConstrucao.setText("Registro de Construção");
        btn_cadConstrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadConstrucaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Gerenciamento itens");

        javax.swing.GroupLayout pnl_gerenciamentoItensLayout = new javax.swing.GroupLayout(pnl_gerenciamentoItens);
        pnl_gerenciamentoItens.setLayout(pnl_gerenciamentoItensLayout);
        pnl_gerenciamentoItensLayout.setHorizontalGroup(
            pnl_gerenciamentoItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cadMateriais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_cadConstrucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_gerenciamentoItensLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_gerenciamentoItensLayout.setVerticalGroup(
            pnl_gerenciamentoItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_gerenciamentoItensLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btn_cadConstrucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cadMateriais)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_orcamento.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));

        btn_cadClientes.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadClientes.setText("Registro de Clientes");
        btn_cadClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadClientesActionPerformed(evt);
            }
        });

        btn_calOrcamentoPrj.setBackground(new java.awt.Color(255, 255, 255));
        btn_calOrcamentoPrj.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_calOrcamentoPrj.setText("Orçamento do Projeto");
        btn_calOrcamentoPrj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calOrcamentoPrjActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Orçamento");

        javax.swing.GroupLayout pnl_orcamentoLayout = new javax.swing.GroupLayout(pnl_orcamento);
        pnl_orcamento.setLayout(pnl_orcamentoLayout);
        pnl_orcamentoLayout.setHorizontalGroup(
            pnl_orcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cadClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_calOrcamentoPrj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_orcamentoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_orcamentoLayout.setVerticalGroup(
            pnl_orcamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_orcamentoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(btn_cadClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_calOrcamentoPrj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_APP.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));

        btn_solicitacaoOrcamento.setBackground(new java.awt.Color(255, 255, 255));
        btn_solicitacaoOrcamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_solicitacaoOrcamento.setText("Solicitações de Orçamento");
        btn_solicitacaoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solicitacaoOrcamentoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("APP");

        javax.swing.GroupLayout pnl_APPLayout = new javax.swing.GroupLayout(pnl_APP);
        pnl_APP.setLayout(pnl_APPLayout);
        pnl_APPLayout.setHorizontalGroup(
            pnl_APPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_solicitacaoOrcamento, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
            .addGroup(pnl_APPLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_APPLayout.setVerticalGroup(
            pnl_APPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_APPLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(btn_solicitacaoOrcamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_funcionarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));

        btn_cadFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadFuncionarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadFuncionarios.setText("Cadastrar Funcionários");
        btn_cadFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadFuncionariosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Gerência Funcionários");

        javax.swing.GroupLayout pnl_funcionariosLayout = new javax.swing.GroupLayout(pnl_funcionarios);
        pnl_funcionarios.setLayout(pnl_funcionariosLayout);
        pnl_funcionariosLayout.setHorizontalGroup(
            pnl_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_cadFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_funcionariosLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_funcionariosLayout.setVerticalGroup(
            pnl_funcionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_funcionariosLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cadFuncionarios)
                .addGap(12, 12, 12))
        );

        pnl_relatorios.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));

        btn_relatorios.setBackground(new java.awt.Color(255, 255, 255));
        btn_relatorios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_relatorios.setText("Relatórios");
        btn_relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relatoriosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Relatórios");

        javax.swing.GroupLayout pnl_relatoriosLayout = new javax.swing.GroupLayout(pnl_relatorios);
        pnl_relatorios.setLayout(pnl_relatoriosLayout);
        pnl_relatoriosLayout.setHorizontalGroup(
            pnl_relatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_relatoriosLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btn_relatorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_relatoriosLayout.setVerticalGroup(
            pnl_relatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_relatoriosLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(btn_relatorios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_botoesLayout = new javax.swing.GroupLayout(pnl_botoes);
        pnl_botoes.setLayout(pnl_botoesLayout);
        pnl_botoesLayout.setHorizontalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_botoesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_logado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnl_funcionarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_relatorios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_APP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_orcamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_gerenciamentoItens, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnl_botoesLayout.setVerticalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_logado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_gerenciamentoItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_orcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_APP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_funcionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1097, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadFuncionariosActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TFuncionario.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TFuncionario.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_cadFuncionariosActionPerformed

    private void btn_solicitacaoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solicitacaoOrcamentoActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TSolicaoOrcamento.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TSolicaoOrcamento.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_solicitacaoOrcamentoActionPerformed

    private void btn_cadMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadMateriaisActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TMaterial.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TMaterial.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();

    }//GEN-LAST:event_btn_cadMateriaisActionPerformed

    private void btn_calOrcamentoPrjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calOrcamentoPrjActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TOrcamento.getInstancia(true));
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TOrcamento.getInstancia(true));
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_calOrcamentoPrjActionPerformed

    private void btn_cadClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadClientesActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TCliente.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TCliente.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_cadClientesActionPerformed

    private void btn_relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relatoriosActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TRelatorio.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TRelatorio.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_relatoriosActionPerformed

    private void btn_cadConstrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadConstrucaoActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TConstrucao.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TConstrucao.getInstancia());
                }
                janelaCarregamentoFecha();
            }
        };
        t.start();
        janelaCarregamentoAbre();
    }//GEN-LAST:event_btn_cadConstrucaoActionPerformed

    private void janelaCarregamentoAbre() {
        tCar.setVisible(true);
    }

    private void janelaCarregamentoFecha() {
        tCar.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TPrincipal(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadClientes;
    private javax.swing.JButton btn_cadConstrucao;
    private javax.swing.JButton btn_cadFuncionarios;
    private javax.swing.JButton btn_cadMateriais;
    private javax.swing.JButton btn_calOrcamentoPrj;
    private javax.swing.JButton btn_relatorios;
    private javax.swing.JButton btn_solicitacaoOrcamento;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lb_logado;
    private javax.swing.JPanel pnl_APP;
    private javax.swing.JPanel pnl_botoes;
    private javax.swing.JPanel pnl_funcionarios;
    private javax.swing.JPanel pnl_gerenciamentoItens;
    private javax.swing.JPanel pnl_orcamento;
    private javax.swing.JPanel pnl_relatorios;
    // End of variables declaration//GEN-END:variables
}
