import uade.edu.ar.dto.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_AltaSucursal extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JButton cancelarButton;

    private frm_AltaSucursal self;

    private SucursalDTO S = new SucursalDTO( 0,"","",false);

    public frm_AltaSucursal() {
        this.self = this;

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ID = Integer.parseInt(textField1.getText());
                String Direc = textField2.getText();
                String Reesp = textField3.getText();

                self.S.setNumero(ID);
                self.S.setDireccion(Direc);
                self.S.setResponsableTecnico(Reesp);
            }


        });
    }
}
