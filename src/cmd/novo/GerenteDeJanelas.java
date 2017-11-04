/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd.novo;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Usuario
 * 
 * Esta classe controla a quantidade de janelas(JInternalFrame)
 * abertas, permite que se abra apenas uma janela por vez, 
 * - Sem duplicatas
 * 
 */
public class GerenteDeJanelas {
    private static JDesktopPane jDesktopPane;
    
    public GerenteDeJanelas(JDesktopPane jDesktopPane){
        GerenteDeJanelas.jDesktopPane = jDesktopPane;
    }
    
    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if(jInternalFrame.isVisible()){
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else{
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }
        
    }
}
