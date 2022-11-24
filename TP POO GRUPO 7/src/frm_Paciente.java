import javax.swing.*;

public class frm_Paciente extends JInternalFrame {
    private JPanel panelPrincipal;
    private JButton altaButton;
    private JButton obtenerResultadosDePracticaButton;
    private JButton bajaButton;
    private JButton modificaciónButton;

    public frm_Paciente() {
        super("Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);

        setContentPane(panelPrincipal);
    }
}