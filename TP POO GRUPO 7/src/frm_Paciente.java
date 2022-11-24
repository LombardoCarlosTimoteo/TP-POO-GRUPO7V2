import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_Paciente extends JInternalFrame {
    private JPanel panelPrincipal;
    private JButton altaButton;
    private JButton obtenerResultadosDePracticaButton;
    private JButton bajaButton;
    private JButton modificaciónButton;
    private JPanel desktopPaneEmbebidoPaciente;

    public frm_Paciente() throws Exception {
        super("Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();
    }

    private void asociarEventos() throws Exception {
        frm_AltaPaciente PantallaAltaPaciente = new frm_AltaPaciente();

        desktopPaneEmbebidoPaciente.add(PantallaAltaPaciente);
        PantallaAltaPaciente.setVisible(false);
        altaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PantallaAltaPaciente.setVisible(true);


                revalidate();
                repaint();

            }
        });
    }
}