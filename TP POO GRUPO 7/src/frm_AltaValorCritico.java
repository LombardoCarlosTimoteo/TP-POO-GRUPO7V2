import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_AltaValorCritico extends JInternalFrame{
    private JTextField textFieldValor;
    private JTextField textFieldIDValorCritico;
    private JTextField textFieldTipoComparacion;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelPrincipal;
    private frm_AltaValorCritico self;
    public frm_AltaValorCritico() throws Exception {
        super("Alta Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();


    }

    public frm_AltaValorCritico() {
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
