package lion;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import principal.ViewPrincipal;
import static sun.io.Win32ErrorMode.initialize;

/**
 *
 * @author Gleydson Israel
 */
public class Lion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        initialize();
        new ViewPrincipal().setVisible(true);
    }

}
