import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_Usuario extends JInternalFrame {

    private JPanel panel1;

    private JPanel panelPrincipal;
    private JButton modificaciónButton;
    private JButton bajaButton;
    private JButton altaButton;
    private JPanel desktopPaneEmbebido;

    public frm_Usuario() {
        super("Usuario");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        asociarEventos();
    }
}
