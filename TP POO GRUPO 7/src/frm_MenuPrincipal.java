import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_MenuPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JButton valorCríticoButton;
    private JButton valorReservadoButton;
    private JButton Paciente;
    private JButton usuarioButton;
    private JButton sucursalButton;
    private JPanel desktopPaneEmbebido;

    public frm_MenuPrincipal() {
        super("Menu Principal");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        asociarEventos();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void asociarEventos() {

        Paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_Paciente pantalla = new frm_Paciente();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);

            }
        });

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frm_Usuario pantalla = new frm_Usuario();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });

        sucursalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_Sucursal pantalla = new frm_Sucursal();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });

        valorCríticoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_ValorCritico pantalla = new frm_ValorCritico();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });

        valorReservadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_ValorReservado pantalla = new frm_ValorReservado();
                desktopPaneEmbebido.add(pantalla);
                pantalla.setVisible(true);
            }
        });
    }
}

