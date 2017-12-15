package cmd.novo;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * Esta classe controla a quantidade de janelas(JInternalFrame) abertas, permite
 * que se abra apenas uma janela por vez, sem duplicatas
 *
 * @author Usuario
 */
public class GerenteDeJanelas {

    /**
     * Janela
     */
    private static JDesktopPane jDesktopPane;

    /**
     * Define a janela
     *
     * @param jDesktopPane
     */
    public GerenteDeJanelas(JDesktopPane jDesktopPane) {
        GerenteDeJanelas.jDesktopPane = jDesktopPane;
    }

    /**
     * Abre uma janela
     *
     * @param jInternalFrame Janela
     */
    public void abrirJanelas(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }

    }
}
