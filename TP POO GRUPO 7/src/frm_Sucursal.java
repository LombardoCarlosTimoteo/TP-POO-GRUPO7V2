import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_Sucursal extends JInternalFrame{
    private JButton listarPeticionesConValorButton;
    private JButton modificaciónButton;
    private JButton bajaButton;
    private JButton altaButton;
    private JPanel panelPrincipal;

    public frm_Sucursal() {
        super("Sucursal");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        altaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
