import uade.edu.ar.dto.ValorReservadoDTO;
import uade.edu.ar.model.TipoResultado;

import javax.swing.*;

public class frm_BajaValorReservado extends JInternalFrame {
    private JTextField textFieldValorReservadoID;
    private JButton cancelarButton;
    private JButton eliminarButton;
    private JPanel panelPrincipal;

    private frm_BajaValorReservado self;

    ValorReservadoDTO VRDTO = new ValorReservadoDTO("", TipoResultado.Booleano, 0);

    public frm_BajaValorReservado() throws Exception {
        super("Baja Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();
    }

    public void asociarEventos(){
        //Faltan los ACTION LISTENERS
    }
            }