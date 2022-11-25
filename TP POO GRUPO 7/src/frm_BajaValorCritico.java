import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_BajaValorCritico {
    private JTextField textFieldIDValorCritico;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private JPanel panelPrincipal;

    private frm_BajaValorCritico self;

    ValorCriticoDTO VCDTO = new ValorCriticoDTO(0, "", TipoResultado.Booleano);

    ControllerValorCritico controllerValorCritico = ControllerValorCritico.getInstances();

    public frm_BajaValorCritico() throws Exception {
        super("Baja Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();
    }

       private void asociarEventos(){
        this.self=self;
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
