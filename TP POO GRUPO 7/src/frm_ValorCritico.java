import javax.swing.*;

public class frm_ValorCritico extends JInternalFrame{
    private JPanel panelPrincipal;
    private JButton altaButton;
    private JButton modificaciónButton;
    private JButton bajaButton;

    public frm_ValorCritico() {
        super("Valor Critico");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
    }
}
