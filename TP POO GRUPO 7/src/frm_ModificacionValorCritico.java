import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_ModificacionValorCritico {
    private JPanel panelPrincipal;
    private JTextField textFieldValor;
    private JTextField textFieldIDValorCritico;
    private JTextField textFieldTipoComparacion;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private frm_ModificacionValorCritico self;


    public frm_ModificacionValorCritico(){
        super("Alta Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();


    }
    public void asociarEventos() {
        this.self=self;
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
