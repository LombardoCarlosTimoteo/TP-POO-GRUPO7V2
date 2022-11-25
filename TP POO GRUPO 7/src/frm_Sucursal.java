import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_Sucursal extends JInternalFrame{
    private JButton listarPeticionesConValorButton;
    private JButton modificaciónButton;
    private JButton bajaButton;
    private JButton altaButton;
    private JPanel panelPrincipal;
    private JPanel desktopPaneEmbebido;

    public frm_Sucursal() {
        super("Sucursal");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();
    }

    private void asociarEventos(){
//        frm_AltaSucursal PantallaAltaSucursal = new frm_AltaSucursal();
//        frm_BajaSucursal PantallaBajaSucursal = new frm_AltaSucursal();
//        frm_ModificacionSucursal PantallaModificacionSucursal = new frm_AltaSucursal();
//        frm_ListarValoresCriticos PantallaListarValoresCriticos = new frm_ListarValoresCriticos();

//        desktopPaneEmbebidoPaciente.add(PantallaAltaSucursal);
//        desktopPaneEmbebidoPaciente.add(PantallaBajaSucursal);
//        desktopPaneEmbebidoPaciente.add(PantallaModificacionSucursal);
//        desktopPaneEmbebidoPaciente.add(PantallaListarValoresCriticos);


        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

