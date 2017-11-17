package cmd.novo.tela;

import cmd.DAO.EnderecoDAO;
import cmd.controle.ClienteController;
import cmd.controle.EnderecoController;
import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.Item;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;
import cmd.novo.GerenteDeJanelas;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TOrcamento extends javax.swing.JInternalFrame {
    private List<Cliente> clientes = null;
    private List<Endereco> enderecos = null;
    private List<Item> itens = null;
    private int linCliente = -1;
    private int linEndereco = -1;
    
    TCarregamento tCarregamento = new TCarregamento(null, true);
    GerenteDeJanelas gerenteDeJanelas;
    
    public static TOrcamento tCalculoOrcamento;
    public static TOrcamento getInstancia() {
        if (tCalculoOrcamento == null) {
            tCalculoOrcamento = new TOrcamento();
        }
        tCalculoOrcamento.carregarPessoaFisica();
        tCalculoOrcamento.exibirDataAtual();
        return tCalculoOrcamento;
    }
    
    /**
     * Creates new form TCalculoOrcamento
     */
    public TOrcamento() {
        initComponents();
        gerenteDeJanelas = new GerenteDeJanelas(TPrincipal.jDesktopPane1);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_clientes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_enderecos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_itens = new javax.swing.JTable();
        btn_cadastrarOrca = new javax.swing.JButton();
        btn_cadCliente = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lb_dataHora = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_valorFinal = new javax.swing.JLabel();
        cmb_cliente = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Calculo do Orçamento");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bem-Vindo a Área de Orçamentos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Selecione o Cliente:");

        tb_clientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Data", "Data de Inscrição"
            }
        ));
        tb_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_clientes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Selecione o local de entrega (Está vinculado ao Cliente selecionado):");

        tb_enderecos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_enderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cep", "Logradouro", "Numero", "Complemento", "Bairro", "UF"
            }
        ));
        tb_enderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_enderecosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_enderecos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Itens do orçamento são listados abaixo:");

        tb_itens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_itens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód. construção", "Tipo construção", "Altura (m)", "Largura (m)", "Área da porta (m²)", "Área da janela (m²)", "Preço total"
            }
        ));
        jScrollPane3.setViewportView(tb_itens);

        btn_cadastrarOrca.setBackground(new java.awt.Color(153, 153, 255));
        btn_cadastrarOrca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadastrarOrca.setText("Novo orçamento...");
        btn_cadastrarOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarOrcaActionPerformed(evt);
            }
        });

        btn_cadCliente.setBackground(new java.awt.Color(153, 153, 255));
        btn_cadCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cadCliente.setText("Cadastrar um Cliente");
        btn_cadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadClienteActionPerformed(evt);
            }
        });

        btn_salvar.setBackground(new java.awt.Color(153, 153, 255));
        btn_salvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_salvar.setText("Salvar");

        btn_limpar.setBackground(new java.awt.Color(153, 153, 255));
        btn_limpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_limpar.setText("Limpar");

        btn_sair.setBackground(new java.awt.Color(153, 153, 255));
        btn_sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sair.setText("Sair");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Data:");

        lb_dataHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_dataHora.setText("##/##/#### - ##:##");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Valor Final:");

        lb_valorFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_valorFinal.setText("###,##");

        cmb_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_cliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pessoa Fisica", "Pessoa Juridica" }));
        cmb_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_dataHora)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)
                                .addComponent(btn_cadCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_limpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_valorFinal)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sair)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cadastrarOrca)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cadCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lb_dataHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmb_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_cadastrarOrca, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lb_valorFinal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_salvar)
                        .addComponent(btn_limpar)
                        .addComponent(btn_sair)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadClienteActionPerformed
        try {
            gerenteDeJanelas.abrirJanelas(TCliente.getInstancia());
        } catch (IllegalArgumentException e) {
            gerenteDeJanelas.abrirJanelas(TCliente.getInstancia());
            //System.err.println(e);//ERRO ! - Erro - contornado.... retirar todo o try
        }
    }//GEN-LAST:event_btn_cadClienteActionPerformed

    private void btn_cadastrarOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarOrcaActionPerformed
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gerenteDeJanelas.abrirJanelas(TCalculo.getInstancia());
                } catch (IllegalArgumentException e) {
                    gerenteDeJanelas.abrirJanelas(TCalculo.getInstancia());
                    //System.err.println(e);//ERRO ! - Erro - contornado.... retirar todo o try
                }
                abrirJanelaCarregamentoFecha();
            }
        };
        t.start();
        abrirJanelaCarregamento();
    }//GEN-LAST:event_btn_cadastrarOrcaActionPerformed

    private void cmb_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clienteActionPerformed
        if (cmb_cliente.getSelectedIndex() == 0) {//Pessoa Fisica
            carregarPessoaFisica();
        }
        if (cmb_cliente.getSelectedIndex() == 1) {//Pessoa Juridica
            carregarPessoaJuridica();
        }
    }//GEN-LAST:event_cmb_clienteActionPerformed

    private void tb_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientesMouseClicked
        if (evt.getClickCount() == 1) {
            linCliente = tb_clientes.getSelectedRow();
            carregarEndereco();
        }
    }//GEN-LAST:event_tb_clientesMouseClicked

    private void tb_enderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_enderecosMouseClicked
        if (evt.getClickCount() == 1) {
            linEndereco = tb_enderecos.getSelectedRow();
        }
    }//GEN-LAST:event_tb_enderecosMouseClicked
    
    private void abrirJanelaCarregamento() {
        tCarregamento.setVisible(true);
    }
    
    private void abrirJanelaCarregamentoFecha() {
        tCarregamento.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    private void carregarPessoaFisica() {
        linCliente = -1;
        linEndereco = -1;
        clientes = new ArrayList<>();
        
        ClienteController ccont = new ClienteController();
        List<PessoaFisica> lisPf = ccont.listarPessoasFisicas();
        
        Vector tableHeaders = new Vector();
        tableHeaders.add("Cód. cliente");
        tableHeaders.add("CPF");
        tableHeaders.add("Nome");
        tableHeaders.add("Data de Nascimento");
        tableHeaders.add("Data da inscrição");
        
        Vector tableData = new Vector();
        Vector reg;
        for (PessoaFisica pf : lisPf) {
            clientes.add(pf.getCliente());
            reg = new Vector();
            reg.add(pf.getCodCliente());
            reg.add(pf.getCpf());
            reg.add(pf.getNome());
            reg.add(pf.getDataNascimento().toString());
            reg.add(pf.getCliente().getDataInscricao().toString());
            tableData.add(reg);
        }
        tb_clientes.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    private void carregarPessoaJuridica() {
        linCliente = -1;
        linEndereco = -1;
        clientes = new ArrayList<>();
        
        ClienteController ccont = new ClienteController();
        List<PessoaJuridica> cli = ccont.listarPessoasJuridicas();
        
        Vector tableHeaders = new Vector();
        tableHeaders.add("Cód. cliente");
        tableHeaders.add("CNPJ");
        tableHeaders.add("Razão social");
        tableHeaders.add("Data de fundação");
        tableHeaders.add("Data da inscrição");
        
        Vector tableData = new Vector();
        Vector reg;
        for (PessoaJuridica pj : cli) {
            clientes.add(pj.getCliente());
            reg = new Vector();
            reg.add(pj.getCodCliente());
            reg.add(pj.getCnpj());
            reg.add(pj.getRazaoSocial());
            reg.add(pj.getDataFundacao().toString());
            reg.add(pj.getCliente().getDataInscricao().toString());
            tableData.add(reg);
        }
        tb_clientes.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    private void carregarEndereco() {
        if(linCliente < 0)
            return;
        linEndereco = -1;
        enderecos = new ArrayList<>();
        
        Endereco en = clientes.get(linCliente).getEndereco();
        enderecos.add(en);
        
        Vector tableHeaders = new Vector();
        tableHeaders.add("CEP");
        tableHeaders.add("Logradouro");
        tableHeaders.add("Número");
        tableHeaders.add("Complemento");
        tableHeaders.add("Bairro");
        tableHeaders.add("UF");
        
        Vector reg = new Vector();
        reg.add(en.getCep());
        reg.add(en.getLogradouro());
        reg.add(en.getNumero());
        reg.add(en.getComplemento());
        reg.add(en.getBairro());
        reg.add(en.getUf());
        
        tb_enderecos.setModel(new DefaultTableModel(new Vector(reg), tableHeaders));
    }
    
    @SuppressWarnings("unchecked")
    public void preencherItens(List<Item> li) {
        itens = li;
        
        Vector tableHeaders = new Vector();
        tableHeaders.add("Cód. construção");
        tableHeaders.add("Tipo construção");
        tableHeaders.add("Altura (m)");
        tableHeaders.add("Largura (m)");
        tableHeaders.add("Área da porta (m²)");
        tableHeaders.add("Área da janela (m²)");
        tableHeaders.add("Preço total");
        
        Vector tableData = new Vector();
        Vector reg;
        for (Item it : itens) {
            reg = new Vector();
            reg.add(it.getConstrucao().getCodConstrucao());
            if (it.getConstrucao().getParede() != null && it.getConstrucao().getForro() == null) {
                reg.add("Parede");
            } else if (it.getConstrucao().getParede() == null && it.getConstrucao().getForro() != null) {
                reg.add("Forro");
            } else {
                reg.add("Desconhecido");
            }
            reg.add(it.getAltura());
            reg.add(it.getLargura());
            reg.add(it.getAreaPorta());
            reg.add(it.getAreaJanela());
            reg.add(it.getPrecoTotal());
            tableData.add(reg);
        }
        tb_itens.setModel(new DefaultTableModel(tableData, tableHeaders));
    }
    
    private void exibirDataAtual() {
        try {
            SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            lb_dataHora.setText(fData.format(new Date(System.currentTimeMillis())));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadCliente;
    private javax.swing.JButton btn_cadastrarOrca;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox cmb_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_dataHora;
    private javax.swing.JLabel lb_valorFinal;
    private javax.swing.JTable tb_clientes;
    private javax.swing.JTable tb_enderecos;
    private javax.swing.JTable tb_itens;
    // End of variables declaration//GEN-END:variables
}
