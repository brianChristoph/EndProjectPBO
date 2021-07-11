package view;
import javax.swing.JOptionPane;
/**
 *
 * @author Axell Silvano;
 */
public class ErrorView {

    public static void printError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
