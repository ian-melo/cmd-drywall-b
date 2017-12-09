/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.testes;

import cmd.controle.CalculoController;
import cmd.controle.ConstrucaoController;
import cmd.controle.MaterialController;
import cmd.entidade.Construcao;
import cmd.entidade.Item;
import cmd.entidade.Material;
import cmd.entidade.Pedidos;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TesteOrcamentoMax {
//Organizado kkkkkkkkkkk

    private static int linConstrucao = -1;
    private static int[] linMaterial = new int[0];
    private static int linItem = -1;
    private static List<Construcao> listaConstrucoes = null;
    private static List<Construcao> listaConstrucoesMax = null;
    private static List<Construcao> listaConMaxAux;
    private static List<Item> listaItens = null;
    private static List<Item> listaItensMax = null;
    private static float totalParcial = 0;
    private static Pedidos pp = null;

    private static int maximo = 50;
    private static String altura1 = "2,5";
    private static String perimetro = "5";

    private static Construcao c = null;

    private static final CalculoController cControle = new CalculoController();

    public static void main(String[] args) {
        verificaValorMax();

        System.exit(0);
    }

    private static void verificaValorMax() {

        double altura = Double.parseDouble(altura1.replaceAll(",", "."));
        listaConstrucoesMax = cControle.procurarTipologias(true, false, false, altura);
        //JOptionPane.showMessageDialog(rootPane, listaConstrucoes.size()); //Teste
        if (listaConstrucoesMax == null || listaConstrucoesMax.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Construções não encontradas.");
            return;
        }
        //adicionarMax();
        adi();
        listarConstrucoesMax();
    }

    private static void adi() {
        listaConMaxAux = new ArrayList<>();

        int valor = listaConstrucoesMax.size();
        //Vars
        List<Material> mOp = new ArrayList<>();

        Item it;

//Construção        
        for (int i = 0; i < 20; i++) {

            c = listaConstrucoesMax.get(i);

            //listaConstrucoesMaxAux.add(c);//ERRO <<---------------------------------------------------------------------------------
            //Materiais adicionais
            //JOptionPane.showMessageDialog(null, "_4_listaConstrucoesMax= " + listaConstrucoesMax.size());
            for (Object o : c.getMaterials()) {//Deve fazer q add todos
                mOp.add((Material) o);
                break;

            }

            //Adição
            if (listaItensMax == null) {
                listaItensMax = new ArrayList<>();
            }
            //JOptionPane.showMessageDialog(null, "_5_listaConstrucoesMax= " + listaConstrucoesMax.size());
            it = cControle.definirItem(
                    Double.parseDouble(altura1.replaceAll(",", ".")),
                    Double.parseDouble(perimetro.replaceAll(",", ".")),
                    Double.parseDouble("1".replaceAll(",", ".")),
                    Double.parseDouble("1".replaceAll(",", ".")), c, mOp);

            totalParcial += it.getPrecoTotal().doubleValue();//Mostra na Label
            //it.setPrecoTotal(new BigDecimal("0"));

            System.err.println("_______Total Parcial= " + String.valueOf(totalParcial));//substituido
            System.err.println("cod= " + c.getCodConstrucao());

            JOptionPane.showMessageDialog(null, c.getCodConstrucao());
            JOptionPane.showMessageDialog(null, c.getDetalhes());

            if (it.getPrecoTotal().doubleValue() <= maximo && it.getPrecoTotal().doubleValue() >= 40) {
//                JOptionPane.showMessageDialog(null, "totalParcial "
//                        + totalParcial + " <= " + "maximo " + maximo);

                JOptionPane.showMessageDialog(null, "it.getPrecoTotal().doubleValue() "
                        + it.getPrecoTotal().doubleValue() + " <= " + "maximo " + maximo);

                listaConMaxAux.add(c);

            }
            System.err.println("it.getPrecoTotal().doubleValue()= " + it.getPrecoTotal().doubleValue());
        }

    }

    private static void adicionarMax() {

        int valor = listaConstrucoesMax.size();
        //Vars
        ConstrucaoController contc = new ConstrucaoController();
        MaterialController contm = new MaterialController();
        List<Material> mOp = new ArrayList<>();

        Item it;
        JOptionPane.showMessageDialog(null, "_1_listaConstrucoesMax= " + listaConstrucoesMax.size());
        //listaConstrucoesMaxAux.add(c);
        JOptionPane.showMessageDialog(null, listaConstrucoesMax.size());
//Construção        
        for (int i = 0; i < 20; i++) {
            JOptionPane.showMessageDialog(null, "i= " + i);
            JOptionPane.showMessageDialog(null, "_2_(" + i + ")listaConstrucoesMax= " + listaConstrucoesMax.size());
            c = listaConstrucoesMax.get(i);
            JOptionPane.showMessageDialog(null, "_3_listaConstrucoesMax= " + listaConstrucoesMax.size());
            JOptionPane.showMessageDialog(null, c.getCodConstrucao());
            JOptionPane.showMessageDialog(null, c.getDescricao());
            //listaConstrucoesMaxAux.add(c);//ERRO <<---------------------------------------------------------------------------------
            JOptionPane.showMessageDialog(null, "++++++++++++++++++++++++++");

//            for (int j = 0; j < valor; j++) {
//                listaConstrucoesMaxAux.add(listaConstrucoesMax.get(j));
//            }
            //listaConstrucoesMaxAux = listaConstrucoesMax;
//            JOptionPane.showMessageDialog(null, listaConMaxAux.size());
//            listaConMaxAux.clear();
//            JOptionPane.showMessageDialog(null, listaConMaxAux.size());
            JOptionPane.showMessageDialog(null, "ADD");
            //Materiais adicionais
            JOptionPane.showMessageDialog(null, "_4_listaConstrucoesMax= " + listaConstrucoesMax.size());
            for (Object o : c.getMaterials()) {//Deve fazer q add todos
                mOp.add((Material) o);
                break;

            }

            //Adição
            if (listaItensMax == null) {
                listaItensMax = new ArrayList<>();
            }
            JOptionPane.showMessageDialog(null, "_5_listaConstrucoesMax= " + listaConstrucoesMax.size());
            it = cControle.definirItem(
                    Double.parseDouble(altura1.replaceAll(",", ".")),
                    Double.parseDouble(perimetro.replaceAll(",", ".")),
                    Double.parseDouble("1".replaceAll(",", ".")),
                    Double.parseDouble("1".replaceAll(",", ".")), c, mOp);

            totalParcial += it.getPrecoTotal().doubleValue();//Mostra na Label
            //it.setPrecoTotal(new BigDecimal("0"));

            System.err.println("________________________________________________________Total Parcial= " + String.valueOf(totalParcial));//substituido

            JOptionPane.showMessageDialog(null, c.getCodConstrucao());

            if (totalParcial <= maximo) {
                JOptionPane.showMessageDialog(null, "totalParcial "
                        + totalParcial + " <= " + "txt_max.getText() " + maximo);

//                JOptionPane.showMessageDialog(null, "_1_________ " + listaConstrucoesMaxAux.size());
                listaConMaxAux.add(c);
                JOptionPane.showMessageDialog(null, "_2_________ " + listaConMaxAux.size());
                //listaItensMax.add(it);
            }
            JOptionPane.showMessageDialog(null, "_6_listaConstrucoesMax= " + listaConstrucoesMax.size());
            //listarItensMax();
        }

    }

    private static void listarConstrucoesMax() {
        System.out.println("===========================================");
        for (Construcao c : listaConMaxAux) {
            System.out.println("============");
            System.out.println("CodConstrucao= " + c.getCodConstrucao().toString());

            if (c.getParede() != null && c.getForro() == null) {
                System.out.println("Parede");
            } else if (c.getParede() == null && c.getForro() != null) {
                System.out.println("Forro");
            } else {
                System.out.println("Desconhecido");

            }

            System.out.println("Descricao= " + c.getDescricao());
            System.out.println("Detalhes= " + c.getDetalhes());
            System.out.println("Qualidade= " + c.getQualidade().toString());
            System.out.println("============");

        }

        linConstrucao = -1;

        System.out.println("===========================================");
    }
}
