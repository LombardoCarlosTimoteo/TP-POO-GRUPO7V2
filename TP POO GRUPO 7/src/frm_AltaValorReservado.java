import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_AltaValorReservado extends JInternalFrame{
    private JTextField textFieldValorReservadoID;
    private JTextField textFieldTipoComparacion;
    private JTextField textFieldValor;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelPrincipal;

    private frm_AltaValorReservado self;

    public frm_AltaValorReservado() throws Exception {
        super("Alta Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();
    }
    public asociarEventos() {
        this.self=self;
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
