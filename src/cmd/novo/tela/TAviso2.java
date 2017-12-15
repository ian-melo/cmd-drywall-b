/*
 * Deixai toda esperança, ó vós que entrais!
 */
package cmd.novo.tela;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Usuario
 */
public class TAviso2 extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog Aviso padrão de quando for necessario
     * consultar o guia
     */
    public TAviso2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Toolkit.getDefaultToolkit().beep();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_aviso = new javax.swing.JPanel();
        lb_info = new javax.swing.JLabel();
        btn_OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pn_aviso.setBackground(new java.awt.Color(255, 255, 255));

        lb_info.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_info.setText("<html><center>CONSULTE A TABELA DE PREÇOS <br> PARA SABER O VALOR CORRENTE</center></html>");

        btn_OK.setBackground(new java.awt.Color(153, 153, 255));
        btn_OK.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_OK.setText("OK");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });
        btn_OK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_OKKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pn_avisoLayout = new javax.swing.GroupLayout(pn_aviso);
        pn_aviso.setLayout(pn_avisoLayout);
        pn_avisoLayout.setHorizontalGroup(
            pn_avisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_avisoLayout.createSequentialGroup()
                .addGroup(pn_avisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_avisoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_avisoLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btn_OK)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_avisoLayout.setVerticalGroup(
            pn_avisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_avisoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_OK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_aviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_aviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btn_OKActionPerformed

    private void btn_OKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_OKKeyPressed
        //A barra de espaço tambem funciona, é padrão, mas com esse codigo o enter tambem funciona
        //- Para fechar o JDialog
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_OK.doClick();
        }
    }//GEN-LAST:event_btn_OKKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_OK;
    private javax.swing.JLabel lb_info;
    private javax.swing.JPanel pn_aviso;
    // End of variables declaration//GEN-END:variables
}
