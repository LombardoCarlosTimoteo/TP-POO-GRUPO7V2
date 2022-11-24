import javax.swing.*;

public class frm_ValorReservado extends JInternalFrame{
    private JPanel panelPrincipal;
    private JButton modificaciónButton;
    private JButton bajaButton;
    private JButton altaButton;

    public frm_ValorReservado() {
        super("Valor Reservado");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setContentPane(panelPrincipal);
    }
}
