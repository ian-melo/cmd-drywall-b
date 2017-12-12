/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo.tela;

import cmd.Validacao.Validar;
import cmd.controle.ClienteController;
import cmd.entidade.Cliente;
import cmd.entidade.Endereco;
import cmd.entidade.PessoaFisica;
import cmd.entidade.PessoaJuridica;
import cmd.entidade.Telefone;
import cmd.entidade.TelefoneId;
import cmd.cep.WebServiceCep;
import cmd.novo.painel.PnlJuridica;
import cmd.novo.painel.PnlFisica;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Usuario
 */
public class TCliente extends javax.swing.JInternalFrame {

    public static TCliente clienteT;
    PnlFisica pFi = new PnlFisica();
    PnlJuridica pJu = new PnlJuridica();
    private Timer timer;
    ClienteController cliC;

//    Thread tTempog = new Thread() {
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(30 * 1000); // aguarda 30 segundos
//                System.out.println("***Desbloqueado***");
//                tCEPg.interrupt();//Não consegui testar.....
//                habilitaCEP(true);//Libera apos 30 segundos de busca
//            } catch (InterruptedException ex) {
//                Logger.getLogger(TCliente.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (Exception e) {
//                System.out.println("_" + e);
//
//            }
//        }
//    };
    //private String Cep;
//    Thread tCEPg = new Thread() {
//        @Override
//        public void run() {
//
//            //new Thread(() -> {//Antigo
//            //Faz a busca para o cep 58043-280
//            WebServiceCep webServiceCep = WebServiceCep.searchCep(Cep);
//
//            //A ferramenta de busca ignora qualquer caracter que não seja numero.
//            //caso a busca ocorra bem, imprime os resultados.
//            if (webServiceCep.wasSuccessful()) {
//                txt_logradouro.setText(webServiceCep.getLogradouroFull());
//                txt_cidade.setText(webServiceCep.getCidade());
//                txt_bairro.setText(webServiceCep.getBairro());
//                txt_uf.setText(webServiceCep.getUf());
//                //txt_uf.setSelectedItem(webServiceCep.getUf());
//                System.out.println("Cep: " + webServiceCep.getCep());
//                System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
//                System.out.println("Bairro: " + webServiceCep.getBairro());
//                System.out.println("Cidade: "
//                        + webServiceCep.getCidade() + "/" + webServiceCep.getUf());
//                //caso haja problemas imprime as exceções.
//            } else {
//                //JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
//                JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
//            }
//            habilitaCEP(true);
//            try {
//
//                tTempog.interrupt();
//
//            } catch (Exception e) {
//                System.out.println("_" + e);
//            }
//
//            //}).start();//Antigo
//        }
//    };
    //PnlTelefone pTe = new PnlTelefone();
    public static TCliente getInstancia() {
        if (clienteT == null) {
            clienteT = new TCliente();
        }
        return clienteT;
    }

    /**
     * Creates new form ClienteT
     */
    public TCliente() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        pnl_escolha.setBackground(Color.WHITE);
        pnl_telefone.setBackground(Color.WHITE);
        pnl_botoes.setBackground(Color.WHITE);
        pnl_endereco.setBackground(Color.WHITE);
        pnl_cliente_pai.setBackground(Color.WHITE);
        pnl_metade.setBackground(Color.WHITE);
        pnl_baixo.setBackground(Color.WHITE);
        pnl_email.setBackground(Color.WHITE);

        pJuridica();//Inicai com Pessoa Juridica Selecionado
        colocaDataAtual();

//        
//        pnl_baixo.setLocation(10, 10);
//        pnl_baixo.setSize(10, 10);
//        int x = this.getHeight();
//        int y = this.getWidth();
//        this.setSize(y - 1, x - 1);
//        this.setSize(y, x);
        //pnl_scroll_telefone.removeAll();//remove cliente anterior
        //GridLayout gerente1 = new GridLayout(5, 1);//Mostra até 2 itens um em baixo do outro
        //pnl_scroll_telefone.setLayout(gerente1);//apenas um ajuste
        //pnl_scroll_telefone.add(pTe);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_escolha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmb_pessoa = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        lb_dataInscricao = new javax.swing.JLabel();
        pnl_endereco = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_logradouro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_numero = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_cidade = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_uf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_complemento = new javax.swing.JTextField();
        txt_cep = new javax.swing.JFormattedTextField();
        pnl_botoes = new javax.swing.JPanel();
        btn_Cadastrar = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_Sair = new javax.swing.JButton();
        btn_Limpar = new javax.swing.JButton();
        pnl_baixo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_FisicaEjuridica = new javax.swing.JTable();
        pnl_metade = new javax.swing.JPanel();
        pnl_cliente_pai = new javax.swing.JPanel();
        pnl_telefone = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_tel1 = new javax.swing.JFormattedTextField();
        txt_cel1 = new javax.swing.JFormattedTextField();
        txt_cel2 = new javax.swing.JFormattedTextField();
        pnl_email = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Cadastro de Clientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Bem-Vindo a Área de Cadastro de Clientes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Selecione pessoa física ou jurídica:");

        cmb_pessoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmb_pessoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pessoa Jurídica", "Pessoa Física" }));
        cmb_pessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pessoaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data de inscrição: ");

        lb_dataInscricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_dataInscricao.setText("##/##/####");

        javax.swing.GroupLayout pnl_escolhaLayout = new javax.swing.GroupLayout(pnl_escolha);
        pnl_escolha.setLayout(pnl_escolhaLayout);
        pnl_escolhaLayout.setHorizontalGroup(
            pnl_escolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_escolhaLayout.createSequentialGroup()
                .addGroup(pnl_escolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_escolhaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(pnl_escolhaLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(cmb_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_escolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnl_escolhaLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lb_dataInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_escolhaLayout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_escolhaLayout.setVerticalGroup(
            pnl_escolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_escolhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_escolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_dataInscricao)))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("CEP:");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Logradouro:");

        txt_logradouro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Numero:");

        txt_numero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numeroFocusLost(evt);
            }
        });

        txt_bairro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Bairro:");

        txt_cidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Cidade:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("UF:");

        txt_uf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Complemento");

        txt_complemento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            txt_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cepFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnl_enderecoLayout = new javax.swing.GroupLayout(pnl_endereco);
        pnl_endereco.setLayout(pnl_enderecoLayout);
        pnl_enderecoLayout.setHorizontalGroup(
            pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_enderecoLayout.createSequentialGroup()
                        .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_complemento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_logradouro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_enderecoLayout.createSequentialGroup()
                                .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txt_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_enderecoLayout.createSequentialGroup()
                                .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18)
                                    .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_numero, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cidade, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30))))
        );
        pnl_enderecoLayout.setVerticalGroup(
            pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(pnl_enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_logradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_Cadastrar.setBackground(new java.awt.Color(153, 153, 255));
        btn_Cadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        btn_Alterar.setBackground(new java.awt.Color(153, 153, 255));
        btn_Alterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Alterar.setText("Alterar");
        btn_Alterar.setEnabled(false);
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });

        btn_Sair.setBackground(new java.awt.Color(153, 153, 255));
        btn_Sair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Sair.setText("Sair");
        btn_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SairActionPerformed(evt);
            }
        });

        btn_Limpar.setBackground(new java.awt.Color(153, 153, 255));
        btn_Limpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Limpar.setText("Limpar");
        btn_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botoesLayout = new javax.swing.GroupLayout(pnl_botoes);
        pnl_botoes.setLayout(pnl_botoesLayout);
        pnl_botoesLayout.setHorizontalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_botoesLayout.createSequentialGroup()
                        .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_Cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_Limpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_botoesLayout.setVerticalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Limpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_Sair)
                .addContainerGap())
        );

        tb_FisicaEjuridica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_FisicaEjuridica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CNPJ", "Razão Social", "Ramo Atuação", "Telefone", "CEP", "Cidade"
            }
        ));
        tb_FisicaEjuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_FisicaEjuridicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_FisicaEjuridica);

        javax.swing.GroupLayout pnl_baixoLayout = new javax.swing.GroupLayout(pnl_baixo);
        pnl_baixo.setLayout(pnl_baixoLayout);
        pnl_baixoLayout.setHorizontalGroup(
            pnl_baixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnl_baixoLayout.setVerticalGroup(
            pnl_baixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_baixoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_cliente_paiLayout = new javax.swing.GroupLayout(pnl_cliente_pai);
        pnl_cliente_pai.setLayout(pnl_cliente_paiLayout);
        pnl_cliente_paiLayout.setHorizontalGroup(
            pnl_cliente_paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
        pnl_cliente_paiLayout.setVerticalGroup(
            pnl_cliente_paiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 141, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Telefone:*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Celular 1:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Celular 2:");

        try {
            txt_tel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_tel1FocusLost(evt);
            }
        });

        try {
            txt_cel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cel1FocusLost(evt);
            }
        });

        try {
            txt_cel2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_cel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cel2FocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("E-mail:*");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnl_emailLayout = new javax.swing.GroupLayout(pnl_email);
        pnl_email.setLayout(pnl_emailLayout);
        pnl_emailLayout.setHorizontalGroup(
            pnl_emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_emailLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 81, Short.MAX_VALUE))
            .addComponent(txt_email)
        );
        pnl_emailLayout.setVerticalGroup(
            pnl_emailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_emailLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_telefoneLayout = new javax.swing.GroupLayout(pnl_telefone);
        pnl_telefone.setLayout(pnl_telefoneLayout);
        pnl_telefoneLayout.setHorizontalGroup(
            pnl_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_telefoneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_telefoneLayout.createSequentialGroup()
                        .addGroup(pnl_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_cel1)
                    .addComponent(txt_cel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_telefoneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnl_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_telefoneLayout.setVerticalGroup(
            pnl_telefoneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_telefoneLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_cel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_metadeLayout = new javax.swing.GroupLayout(pnl_metade);
        pnl_metade.setLayout(pnl_metadeLayout);
        pnl_metadeLayout.setHorizontalGroup(
            pnl_metadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_metadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_cliente_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_metadeLayout.setVerticalGroup(
            pnl_metadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_metadeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_metadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_cliente_pai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_escolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_metade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_baixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_escolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl_metade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(pnl_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_baixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_SairActionPerformed

    private void cmb_pessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pessoaActionPerformed

        if (cmb_pessoa.getSelectedIndex() == 0) {//Pessoa Juridica
            LimparCampos();
            reformataCamposTelefone();

            pJuridica();
        }
        if (cmb_pessoa.getSelectedIndex() == 1) {//Pessoa Fisica
            LimparCampos();
            reformataCamposTelefone();

            pFisica();
        }

        //Atualiza form...pequeno erro grafico
        pequenoBug();//Corrige

    }//GEN-LAST:event_cmb_pessoaActionPerformed

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
//        if (verificaCamposEndereco() == false) {
//            JOptionPane.showMessageDialog(null, "Preencha todos os canpos referentes ao Endereço");
//        }
        if ("".equals(txt_tel1.getText().trim()) || "(  )     -    ".equals(txt_tel1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Preencha o Telefone");
            return;
        }

        if ("".equals(txt_email.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Preencha o E-mail");
            return;
        }

        if(validaEmail(txt_email.getText()) == false){
            JOptionPane.showMessageDialog(null, "Insira um e-mail valido, ex: e-mail@email.com");
            return;
        }
   
//----> A VERIFICAÇÃO ACIMA DEVE SER FEITO PARA AMBAS AS PESSOAS(CLIENTES)

//==============================================================================
//===========================PESSOA JURIDICA====================================
//==============================================================================
        if (cmb_pessoa.getSelectedIndex() == 0) {
            if (verificaPessoaJuridica() == false) {//verifica os campos
                return;
            }

            if (!salvaPjuridica()) {
                return;
            }
        }

//==============================================================================
//============================PESSOA FISICA=====================================
//==============================================================================
        if (cmb_pessoa.getSelectedIndex() == 1) {
            if (verificaPessoaFisica() == false) {//verifica os campos
                return;
            }
            if (!salvaPfisica()) {
                return;
            }
        }
        //LimparCampos();

//        //Exemplo de como funciona para pegar valores dentro do JTextField de outro JPanel
//        //Colocar igual ao exemplo do JOptionPane.showMessageDialog em baixo
//        //Ele pega no com um get q foi colocado no JPanel
//        if (cmb_pessoa.getSelectedIndex() == 0) {//Pessoa Juridica
//
//            JOptionPane.showMessageDialog(null, pJu.getTxt_cnpj_pnl());
//            JOptionPane.showMessageDialog(null, pJu.getTxt_razaoSocial_pnl());
//        }
//        if (cmb_pessoa.getSelectedIndex() == 1) {//Pessoa Fisica
//            JOptionPane.showMessageDialog(null, pFi.getTxt_cpf_pnl());
//            JOptionPane.showMessageDialog(null, pFi.getTxt_nome_pnl());
//        }

    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private boolean salvaPjuridica() {
        cliC = new ClienteController();

        Cliente cli = null;
        Endereco end = null;
        PessoaJuridica pJur = null;

        cli = new Cliente();
        end = new Endereco();
        pJur = new PessoaJuridica();

        HashSet<Telefone> tels = new HashSet<>();
//===============================ENDERECO=======================================
        end = preencheEnderecoVAL(end);//Preenche endereco
//==============================================================================

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(lb_dataInscricao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);

        }

        pJur.setCliente(cli);
        pJur.setCnpj(pJu.getTxt_cnpj_pnl());
        pJur.setDataFundacao(pJu.getTxt_datafundacao_pnl());
        pJur.setRamoAtuacao(pJu.getTxt_ramoAtuacao_pnl());
        pJur.setNomeReferencia(pJu.getTxt_nomeReferencia_pnl());
        pJur.setRazaoSocial(pJu.getTxt_razaoSocial_pnl());
        pJur.setXdead(false);

//===============================TELEFONE=======================================
        tels = preencheTelefoneVAL(tels, cli);
//==============================================================================

        cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setPessoaJuridica(pJur);
        cli.setEmail(txt_email.getText());
        cli.setTelefones(tels);
        cli.setXdead(false);

        if ((!cliC.validarCnpj(pJur)) || (!"  .   .   /    -  ".equals(pJu.getTxt_cnpj_pnl()))) {
            JOptionPane.showMessageDialog(null, "CNPJ, invalido");
            return false;
        }

        if (!cliC.verificarCnpj(pJur)) {
            JOptionPane.showMessageDialog(null, "CNPJ, já existe");
            return false;
        }

        if (cliC.inserirPessoaJuridica(pJur) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado");

        }
        preencheTabelaJuridico();//apenas atualiza atabela
        return true;
    }

    private boolean salvaPfisica() {
        cliC = new ClienteController();

        Cliente cli = null;
        Endereco end = null;
        PessoaFisica pFis = null;

        cli = new Cliente();
        end = new Endereco();
        pFis = new PessoaFisica();

        HashSet<Telefone> tels = new HashSet<>();

//===============================ENDERECO=======================================
        end = preencheEnderecoVAL(end);//Preenche endereco
        end.setCodEndereco(2);//ERRO!!!!!!!!!
//==============================================================================

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(lb_dataInscricao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);

        }

        pFis.setCliente(cli);
        pFis.setCpf(pFi.getTxt_cpf_pnl());
        pFis.setDataNascimento(pFi.getTxt_dataNasc_pnl());
        pFis.setNome(pFi.getTxt_nome_pnl());
        pFis.setXdead(false);

//===============================TELEFONE=======================================
        tels = preencheTelefoneVAL(tels, cli);
//==============================================================================

        cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setPessoaFisica(pFis);
        cli.setEmail(txt_email.getText());
        cli.setTelefones(tels);
        cli.setXdead(false);

        if ((!cliC.validarCpf(pFis)) || (!"   .   .   -  ".equals(pFi.getTxt_cpf_pnl()))) {
            JOptionPane.showMessageDialog(null, "CPF, invalido");
            return false;
        }

        if (!cliC.verificarCpf(pFis)) {
            JOptionPane.showMessageDialog(null, "CPF, já existe");
            return false;
        }

        if (cliC.inserirPessoaFisica(pFis) == true) {
            JOptionPane.showMessageDialog(null, "Cadastrado");

        }

        preencheTabelaFisica();//Apenas atualiza a tabela
        return true;
    }

    private void txt_cepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cepFocusLost
        Validar vali = new Validar();

        if (vali.validarCep(txt_cep.getText())) {

            buscaCep(txt_cep.getText());
        } else {
            JOptionPane.showMessageDialog(pnl_telefone, "Verifique o Cep");
        }

    }//GEN-LAST:event_txt_cepFocusLost

    private void txt_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numeroFocusLost
        Validar vali = new Validar();
        if (vali.validarNumero(txt_numero.getText())) {
            return;
        }

        JOptionPane.showMessageDialog(pnl_telefone, "Verifique o numero");
    }//GEN-LAST:event_txt_numeroFocusLost

    private void txt_tel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tel1FocusLost
        Validar vali = new Validar();
        if (vali.validarTelefone(txt_tel1.getText())) {
            return;
        }
        JOptionPane.showMessageDialog(pnl_telefone, "Verifique o Telefone");
    }//GEN-LAST:event_txt_tel1FocusLost

    private void txt_cel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cel1FocusLost
        Validar vali = new Validar();
        if (vali.validarTelefone(txt_cel1.getText())) {
            return;
        }
        JOptionPane.showMessageDialog(pnl_telefone, "Verifique o Celular 1");
    }//GEN-LAST:event_txt_cel1FocusLost

    private void txt_cel2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cel2FocusLost
        Validar vali = new Validar();
        if (vali.validarTelefone(txt_cel2.getText())) {
            return;
        }
        JOptionPane.showMessageDialog(pnl_telefone, "Verifique o Celular 2");
    }//GEN-LAST:event_txt_cel2FocusLost

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        mouseClicadoCNPJ(evt);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void tb_FisicaEjuridicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_FisicaEjuridicaMouseClicked
        int linha;
        if (evt.getClickCount() == 1) {
            linha = tb_FisicaEjuridica.getSelectedRow();

            if (cmb_pessoa.getSelectedIndex() == 0) {
                reformataCamposTelefone();
                LimparCampos();
                setInfoPJuridica(linha);
                habilitaBotoes(true);

            }

            if (cmb_pessoa.getSelectedIndex() == 1) {
                reformataCamposTelefone();
                LimparCampos();
                setInfoPFisica(linha);
                habilitaBotoes(true);

            }
        }
    }//GEN-LAST:event_tb_FisicaEjuridicaMouseClicked

    private void btn_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimparActionPerformed
        LimparCampos();
        reformataCamposTelefone();

    }//GEN-LAST:event_btn_LimparActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        LimparCampos();
        reformataCamposTelefone();
    }//GEN-LAST:event_formInternalFrameClosed

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        if (verificaCamposEndereco() == false) {
            JOptionPane.showMessageDialog(null, "Preencha todos os canpos referentes ao Endereço");
            return;
        }

        if (cmb_pessoa.getSelectedIndex() == 0) {//P Juridica
            if (verificaPessoaJuridica() == false) {//verifica os campos
                return;
            }
            alteraPessoaJuridica();
            habilitaBotoes(false);

            LimparCampos();
            reformataCamposTelefone();
            pJuridica();

        }

        if (cmb_pessoa.getSelectedIndex() == 1) {//P Fisica
            if (verificaPessoaFisica() == false) {//verifica os campos
                return;
            }
            alteraPessoaFisica();
            habilitaBotoes(false);

            LimparCampos();
            reformataCamposTelefone();
            pFisica();
        }
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusLost
        if(validaEmail(txt_email.getText()) == false){
            JOptionPane.showMessageDialog(null, "Insira um e-mail valido, ex: e-mail@email.com");
        }
    }//GEN-LAST:event_txt_emailFocusLost

    private void pequenoBug() {
        int x = this.getHeight();
        int y = this.getWidth();
        this.setSize(y - 1, x - 1);
        this.setSize(y, x);
    }

    private boolean validaEmail(String email) {
        Validar vali = new Validar();
        if (vali.validarEmail(email) == false) {
            return false;
        }
        return true;
    }

    private void alteraPessoaJuridica() {
        cliC = new ClienteController();

        Cliente cli = null;
        Endereco end = null;
        PessoaJuridica pJur = null;

        cli = new Cliente();
        end = new Endereco();
        pJur = new PessoaJuridica();

        HashSet<Telefone> tels = new HashSet<>();
//===============================ENDERECO=======================================
        end = preencheEnderecoVAL(end);//Preenche endereco
        //end.setCodEndereco(25);//ERRO!!!!!!!!!
//==============================================================================

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(lb_dataInscricao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);

        }

        pJur.setCliente(cli);
        pJur.setCnpj(pJu.getTxt_cnpj_pnl());
        pJur.setDataFundacao(pJu.getTxt_datafundacao_pnl());
        pJur.setRamoAtuacao(pJu.getTxt_ramoAtuacao_pnl());
        pJur.setNomeReferencia(pJu.getTxt_nomeReferencia_pnl());
        pJur.setRazaoSocial(pJu.getTxt_razaoSocial_pnl());
        pJur.setXdead(false);

//===============================TELEFONE=======================================
        tels = preencheTelefoneVAL(tels, cli);
//==============================================================================

        cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setPessoaJuridica(pJur);
        cli.setEmail(txt_email.getText());
        cli.setTelefones(tels);
        cli.setXdead(false);
        if (cliC.alterarPessoaJuridica(pJur) == false) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        } else {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        }

    }

    private void alteraPessoaFisica() {

        cliC = new ClienteController();

        Cliente cli = null;
        Endereco end = null;
        PessoaFisica pFis = null;

        cli = new Cliente();
        end = new Endereco();
        pFis = new PessoaFisica();

        HashSet<Telefone> tels = new HashSet<>();
//===============================ENDERECO=======================================
        end = preencheEnderecoVAL(end);//Preenche endereco
//==============================================================================

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = null;
        try {
            dataDate = formato.parse(lb_dataInscricao.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);

        }

        pFis.setCliente(cli);
        pFis.setCpf(pFi.getTxt_cpf_pnl());
        pFis.setDataNascimento(pFi.getTxt_dataNasc_pnl());
        pFis.setNome(pFi.getTxt_nome_pnl());
        pFis.setXdead(false);

//===============================TELEFONE=======================================
        tels = preencheTelefoneVAL(tels, cli);
//==============================================================================

        cli.setCodCliente(null);
        cli.setOrcamentos(null);
        cli.setDataInscricao(dataDate);
        cli.setEndereco(end);
        cli.setPessoaFisica(pFis);
        cli.setEmail(txt_email.getText());
        cli.setTelefones(tels);
        cli.setXdead(false);

        if (cliC.alterarPessoaFisica(pFis) == false) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar");
        } else {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        }

    }

    private void habilitaBotoes(boolean val) {
        btn_Alterar.setEnabled(val);
        btn_Cadastrar.setEnabled(!val);
        pJu.setEnabled_cnpj_pnl(!val);
        pFi.setEnabled_cnpj_pnl(!val);
    }

    private void reformataCamposTelefone() {//Corrige erro - parcialmente
        try {
            txt_tel1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
            txt_cel1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
            txt_cel2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)#####-####")));
        } catch (ParseException ex) {
            Logger.getLogger(TCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setInfoPJuridica(int linha) {

        PessoaJuridica peJu = (PessoaJuridica) tb_FisicaEjuridica.getValueAt(linha, 10);
        // Object obj = tb_FisicaEjuridica.getValueAt(linha, 5);

        pJu.setTxt_cnpj_pnl(peJu.getCnpj());
        pJu.setTxt_datafundacao_pnl(peJu.getDataFundacao());
        pJu.setTxt_ramoAtuacao_pnl(peJu.getRamoAtuacao());
        pJu.setTxt_razaoSocial_pnl(peJu.getRazaoSocial());

        txt_cep.setText(peJu.getCliente().getEndereco().getCep());
        txt_logradouro.setText(peJu.getCliente().getEndereco().getLogradouro());
        txt_numero.setText(peJu.getCliente().getEndereco().getNumero());
        txt_bairro.setText(peJu.getCliente().getEndereco().getBairro());
        txt_cidade.setText(peJu.getCliente().getEndereco().getCidade());
        txt_uf.setText(peJu.getCliente().getEndereco().getUf());
        txt_complemento.setText(peJu.getCliente().getEndereco().getComplemento());

        //  try {
        Iterator<Telefone> iterator = peJu.getCliente().getTelefones().iterator();
        if (iterator.hasNext()) {
            String val = iterator.next().getId().getNumero().toString();
            txt_tel1.setFormatterFactory(new DefaultFormatterFactory());
            txt_tel1.setText(val);

        }
        if (iterator.hasNext()) {
            String val = iterator.next().getId().getNumero().toString();
            txt_cel1.setFormatterFactory(new DefaultFormatterFactory());

            txt_cel1.setText(val);

        }

        if (iterator.hasNext()) {
            String val = iterator.next().getId().getNumero().toString();
            txt_cel2.setFormatterFactory(new DefaultFormatterFactory());

            txt_cel2.setText(val);

        }
        // } catch (Exception e) {
        //     System.out.println("___" + e);
        // }
    }

    private void setInfoPFisica(int linha) {
        PessoaFisica peFi = (PessoaFisica) tb_FisicaEjuridica.getValueAt(linha, 9);

        pFi.setTxt_nome_pnl(peFi.getNome());
        pFi.setTxt_cpf_pnl(peFi.getCpf());
        pFi.setTxt_dataNasc_pnl(peFi.getDataNascimento());

        txt_cep.setText(peFi.getCliente().getEndereco().getCep());
        txt_logradouro.setText(peFi.getCliente().getEndereco().getLogradouro());
        txt_numero.setText(peFi.getCliente().getEndereco().getNumero());
        txt_bairro.setText(peFi.getCliente().getEndereco().getBairro());
        txt_cidade.setText(peFi.getCliente().getEndereco().getCidade());
        txt_uf.setText(peFi.getCliente().getEndereco().getUf());
        txt_complemento.setText(peFi.getCliente().getEndereco().getComplemento());

        try {
            Iterator<Telefone> iterator = peFi.getCliente().getTelefones().iterator();
            if (iterator.hasNext()) {
                String val = iterator.next().getId().getNumero();
                txt_tel1.setFormatterFactory(new DefaultFormatterFactory());

                txt_tel1.setText(val);
                //txt_tel1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));

            }
            //txt_tel1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
            if (iterator.hasNext()) {
                String val = iterator.next().getId().getNumero();
                txt_cel1.setFormatterFactory(new DefaultFormatterFactory());
                //  if (val.length() == 13) {
                //txt_cel1.setText(val + "0");
                // } else {
                txt_cel1.setText(val);
                //txt_cel1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
                // }
            }

            if (iterator.hasNext()) {
                String val = iterator.next().getId().getNumero();
                //txt_cel2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat(""))));
                txt_cel2.setFormatterFactory(new DefaultFormatterFactory());
                        //if (val.length() == 13) {
                //  txt_cel2.setText(val + "0");

                // } else {
                txt_cel2.setText(val);
                //txt_cel2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
                //  }

            }
        } catch (Exception e) {
            System.out.println("___" + e);
        }
    }

//Preenche ENDEREÇO tanto de PessoaJuridica quanto de Pessoa Fisica
    private Endereco preencheEnderecoVAL(Endereco en) {
        en.setBairro(txt_bairro.getText());
        en.setCep(txt_cep.getText());
        en.setCidade(txt_cidade.getText());
        en.setComplemento(txt_complemento.getText());
        en.setLogradouro(txt_logradouro.getText());
        en.setNumero(txt_numero.getText());
        en.setUf(txt_uf.getText());
        en.setXdead(false);

        return en;
    }

//Preenche TELEFONE tanto de PessoaJuridica quanto de Pessoa Fisica
    private HashSet<Telefone> preencheTelefoneVAL(HashSet<Telefone> tes, Cliente cli) {
        Telefone tel = new Telefone();
        TelefoneId telId = new TelefoneId();

        telId.setNumero(txt_tel1.getText());
        //telId.setCodCliente(cli.getCodCliente());
        telId.setCodCliente(80);//Temporario
        tel.setId(telId);
        tel.setCliente(cli);
        tel.setXdead(false);

        tes.add(tel);

        if (!"(  )     -    ".equals(txt_cel1.getText())) {//só entra se estiver preenchido
            tel = new Telefone();
            telId = new TelefoneId();

            telId.setNumero(txt_cel1.getText());
            //telId.setCodCliente(cli.getCodCliente());
            telId.setCodCliente(1);//Temporario
            tel.setId(telId);
            tel.setCliente(null);
            tel.setXdead(false);

            tes.add(tel);
        }

        if (!"(  )     -    ".equals(txt_cel2.getText())) {//só entra se estiver preenchido
            tel = new Telefone();
            telId = new TelefoneId();

            telId.setNumero(txt_cel2.getText());
            //telId.setCodCliente(cli.getCodCliente());//ERRO!!!!!!!!!!!!!!!!!
            telId.setCodCliente(1);//Temporario
            tel.setId(telId);
            tel.setCliente(null);
            tel.setXdead(false);

            tes.add(tel);
        }

        return tes;
    }

    //Verifica se o campo foi preenchido
    public boolean verificaPessoaJuridica() {
//        if ("".equals(pJu.getTxt_cnpj_pnl().trim()) || "  .   .   /    -  ".equals(pJu.getTxt_cnpj_pnl().trim())) {
//            JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
//            return false;
//        }
        if ("".equals(pJu.getTxt_razaoSocial_pnl().trim())) {
            JOptionPane.showMessageDialog(null, "Preencha a Razão Social");
            return false;
        }
        
               if ("".equals(pJu.getTxt_nomeReferencia_pnl().trim())) {
            JOptionPane.showMessageDialog(null, "Preencha o nome para contato");
            return false;
        }
//        if (pJu.getTxt_datafundacao_pnl() == null) {
//            JOptionPane.showMessageDialog(null, "Preencha o <<<<<<<<<<<<<<<<");
//            return false;
//        }
//        Não obrigatorio?
//        if ("".equals(pJu.getTxt_ramoAtuacao_pnl().trim())) {
//            JOptionPane.showMessageDialog(null, "Preencha o Ramo de Atuação");
//            return;
//        }
        return true;
    }

    public boolean verificaPessoaFisica() {
//        if ("".equals(pFi.getTxt_cpf_pnl().trim()) || "   .   .   -  ".equals(pFi.getTxt_cpf_pnl().trim())) {
//            JOptionPane.showMessageDialog(null, "Preencha o CPF");
//            return false;
//        }
        if ("".equals(pFi.getTxt_nome_pnl().trim())) {
            JOptionPane.showMessageDialog(null, "Preencha o Nome");
            return false;
        }
//        if (pFi.getTxt_dataNasc_pnl() == null) {
//            JOptionPane.showMessageDialog(null, "Preencha a Data");
//            return false;
//        }

        return true;
    }

    public void buscaCep(String cep) {
        habilitaCEP(false);
        //Cep = cep;//Global
        Thread tCEP = new Thread() {
            @Override
            public void run() {

                //new Thread(() -> {//Antigo
                //Faz a busca para o cep 58043-280
                WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

                //A ferramenta de busca ignora qualquer caracter que não seja numero.
                //caso a busca ocorra bem, imprime os resultados.
                if (webServiceCep.wasSuccessful()) {
                    txt_logradouro.setText(webServiceCep.getLogradouroFull());
                    txt_cidade.setText(webServiceCep.getCidade());
                    txt_bairro.setText(webServiceCep.getBairro());
                    txt_uf.setText(webServiceCep.getUf());
                    //txt_uf.setSelectedItem(webServiceCep.getUf());
                    System.out.println("Cep: " + webServiceCep.getCep());
                    System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
                    System.out.println("Bairro: " + webServiceCep.getBairro());
                    System.out.println("Cidade: "
                            + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

                    //caso haja problemas imprime as exceções.
                } else {
                    //JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
                    JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
                }

                habilitaCEP(true);

                // tTempo.start();
                //}).start();//Antigo
            }

        };

        Thread tTempo = new Thread() {
            @Override
            public void run() {

                try {

                    Thread.sleep(30 * 1000); // aguarda 30 segundos
                    System.out.println("***Desbloqueado***");
                    tCEP.interrupt();//Não consegui testar.....
                    habilitaCEP(true);//Libera apos 30 segundos de busca

                } catch (InterruptedException ex) {
                    Logger.getLogger(TCliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        tCEP.start();
        tTempo.start();
        // tCEPg.start();//Global
        // tTempog.start();//Global

    }

    private void habilitaCEP(boolean val) {
        txt_logradouro.setEnabled(val);
        txt_cidade.setEnabled(val);
        txt_bairro.setEnabled(val);
        txt_uf.setEnabled(val);
    }

    private void pJuridica() {
        preencheTabelaJuridico();

        pnl_cliente_pai.removeAll();//remove cliente anterior

        FlowLayout gerente = new FlowLayout(1);

        pnl_cliente_pai.setLayout(gerente);//apenas um ajuste

        pnl_cliente_pai.add(pJu);
    }

    private void pFisica() {
        preencheTabelaFisica();

        pnl_cliente_pai.removeAll();//remove cliente anterior

        FlowLayout gerente = new FlowLayout(1);
        pnl_cliente_pai.setLayout(gerente);//apenas um ajuste

        pnl_cliente_pai.add(pFi);
    }

    private void colocaDataAtual() {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            lb_dataInscricao.setText(sdf.format(new Date(System.currentTimeMillis())));

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void preencheTabelaJuridico() {
        tb_FisicaEjuridica.removeAll();

        ClienteController cleC = new ClienteController();
        //Titulo
        Vector cabecalho = new Vector();
        cabecalho.add("CNPJ");
        cabecalho.add("Razão Social");
        cabecalho.add("Ramo Atual");
        cabecalho.add("Data Fundação");
        //cabecalho.add("Telefone");
        cabecalho.add("CEP");
        cabecalho.add("Logradouro");
        cabecalho.add("Numero");
        cabecalho.add("Bairro");
        cabecalho.add("Cidade");
        cabecalho.add("Estado");
        cabecalho.add("Objeto");

        //Itens
        Vector dados = new Vector();
        Vector item;

        for (PessoaJuridica jx : cleC.listarPessoasJuridicas()) {
            item = new Vector();
            item.add(jx.getCnpj());
            item.add(jx.getRazaoSocial());
            item.add(jx.getRamoAtuacao());
            item.add(jx.getDataFundacao());
            //item.add(jx.getCliente().getTelefones());
            item.add(jx.getCliente().getEndereco().getCep());
            item.add(jx.getCliente().getEndereco().getLogradouro());
            item.add(jx.getCliente().getEndereco().getNumero());
            item.add(jx.getCliente().getEndereco().getBairro());
            item.add(jx.getCliente().getEndereco().getCidade());
            item.add(jx.getCliente().getEndereco().getUf());
            item.add(jx);

            dados.add(item);
        }

        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.setDataVector(dados, cabecalho);
        tb_FisicaEjuridica.setModel(modeloTabela);

        tb_FisicaEjuridica.getColumnModel().getColumn(10).setMaxWidth(0);//     :)

    }

    private void preencheTabelaFisica() {
        tb_FisicaEjuridica.removeAll();

        ClienteController cleC = new ClienteController();
        //Titulo
        Vector cabecalho = new Vector();
        cabecalho.add("Nome");
        cabecalho.add("CPF");
        cabecalho.add("Data Nascimento");
        //cabecalho.add("Telefone");
        cabecalho.add("CEP");
        cabecalho.add("Logradouro");
        cabecalho.add("Numero");
        cabecalho.add("Bairro");
        cabecalho.add("Cidade");
        cabecalho.add("Estado");
        cabecalho.add("Objeto");

        //Itens
        Vector dados = new Vector();
        Vector item;

        for (PessoaFisica fx : cleC.listarPessoasFisicas()) {
            item = new Vector();
            item.add(fx.getNome());
            item.add(fx.getCpf());
            item.add(fx.getDataNascimento());
            //item.add(fx.getCliente().getTelefones());
            item.add(fx.getCliente().getEndereco().getCep());
            item.add(fx.getCliente().getEndereco().getLogradouro());
            item.add(fx.getCliente().getEndereco().getNumero());
            item.add(fx.getCliente().getEndereco().getBairro());
            item.add(fx.getCliente().getEndereco().getCidade());
            item.add(fx.getCliente().getEndereco().getUf());

            item.add(fx);//seta o objeto

            dados.add(item);
        }

        DefaultTableModel modeloTabela = new DefaultTableModel();
        modeloTabela.setDataVector(dados, cabecalho);
        tb_FisicaEjuridica.setModel(modeloTabela);

        tb_FisicaEjuridica.getColumnModel().getColumn(9).setMaxWidth(0);

    }

    private void LimparCampos() {

        //Limpa tudo dentro de endereço
        Component componentsEnd[] = pnl_endereco.getComponents();
        int i;
        for (i = 0; i < componentsEnd.length; i++) {
            if (componentsEnd[i] instanceof JTextField) {
                ((JTextField) componentsEnd[i]).setText("");
            }
        }

        Component componentsTel[] = pnl_telefone.getComponents();
        int j;
        for (j = 0; j < componentsTel.length; j++) {
            if (componentsTel[j] instanceof JTextField) {
                ((JTextField) componentsTel[j]).setText("");
            }
        }

        pJu.setTxt_cnpj_pnl("");
        pJu.setTxt_datafundacao_pnl(null);
        pJu.setTxt_ramoAtuacao_pnl("");
        pJu.setTxt_nomeReferencia_pnl("");
        pJu.setTxt_razaoSocial_pnl("");

        pFi.setTxt_cpf_pnl("");
        pFi.setTxt_dataNasc_pnl(null);
        pFi.setTxt_nome_pnl("");
        
        txt_email.setText("");

        habilitaCEP(true);
        habilitaBotoes(false);
    }

    private boolean verificaCamposEndereco() {
//Verifica se todos os campos JTetField q estão dentro do pnl_endereco
//estão sem nada exceto o campo txt_complemento q pode ficar sem nada
        Component components[] = pnl_endereco.getComponents();
        int i;
        for (i = 0; i < components.length; i++) {
            if (components[i] instanceof JTextField) {
                if (((JTextField) components[i]).getText().isEmpty()) {
                    if (i != 1) {//Este IF força que o componenete JTextField "TXT_COMPLEMENTO" possa ficar vazio

                        return false;//False se NAO preenchido algum campo do endereço(dentro do pnl_endereco)
                        //break;
                    }

                    //JOptionPane.showMessageDialog(null, "Preencher todos os campos");
                    //return false;//False ser preenchido algum campo do endereço
                    //break;
                }
            }
        }

        try {
            Integer.parseInt(txt_numero.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Digitar um numero no Campo Numero");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Limpar;
    private javax.swing.JButton btn_Sair;
    private javax.swing.JComboBox cmb_pessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_dataInscricao;
    private javax.swing.JPanel pnl_baixo;
    private javax.swing.JPanel pnl_botoes;
    private javax.swing.JPanel pnl_cliente_pai;
    private javax.swing.JPanel pnl_email;
    private javax.swing.JPanel pnl_endereco;
    private javax.swing.JPanel pnl_escolha;
    private javax.swing.JPanel pnl_metade;
    private javax.swing.JPanel pnl_telefone;
    private javax.swing.JTable tb_FisicaEjuridica;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JFormattedTextField txt_cel1;
    private javax.swing.JFormattedTextField txt_cel2;
    private javax.swing.JFormattedTextField txt_cep;
    private javax.swing.JTextField txt_cidade;
    private javax.swing.JTextField txt_complemento;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_logradouro;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JFormattedTextField txt_tel1;
    private javax.swing.JTextField txt_uf;
    // End of variables declaration//GEN-END:variables
private void mouseClicadoCNPJ(MouseEvent e) {
        if (e.getModifiersEx() == InputEvent.CTRL_DOWN_MASK) {
            txt_cep.requestFocus();
            txt_cep.setText("04344-020");

            txt_numero.requestFocus();
            txt_numero.setText("99");
        }
    }

}
