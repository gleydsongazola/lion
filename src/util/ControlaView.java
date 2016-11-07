package util;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import principal.ViewPrincipal;
import pais.ViewPais;
import estado.ViewEstado;

/**
 *
 * @author Gleydson Israel
 */
public class ControlaView {
    
    public ControlaView() {}
    
    public static ViewPais viewPais;
    public static ViewEstado viewEstado;

    public static void criaViewPais() {
        if (viewPais == null) {
            ViewPais vp = new ViewPais();
            viewPais = vp;
            ViewPrincipal.desktopPane.add(viewPais);
            viewPais.setVisible(true);
            viewPais.setPosicao();
        } else {
            viewPais.moveToFront();
            viewPais.requestFocus();
            try {
                viewPais.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    public static void criaViewEstado() {
        if (viewEstado == null) {
            ViewEstado vp = new ViewEstado();
            viewEstado = vp;
            ViewPrincipal.desktopPane.add(viewEstado);
            viewEstado.setVisible(true);
            viewEstado.setPosicao();
        } else {
            viewEstado.moveToFront();
            viewEstado.requestFocus();
            try {
                viewEstado.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(principal.ViewPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
