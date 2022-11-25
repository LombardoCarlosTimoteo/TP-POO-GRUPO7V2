import uade.edu.ar.controller.ControllerUsuario;
import uade.edu.ar.dto.UsuarioDTO;
import uade.edu.ar.model.RolUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frm_ModificacionUsuario extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField textFieldFechaNacimiento;
    private JTextField textFieldDNI;
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldMail;
    private JTextField textFieldContraseña;
    private JTextField textFieldDomicilio;
    private JTextField textFieldNombreApellido;
    private JTextField textFieldRol;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private frm_ModificacionUsuario self;
    private UsuarioDTO UDTO = new UsuarioDTO(0, "", "", "", "", "", "", RolUsuario.Recepcionista);
    private ControllerUsuario controllerUsuario;

    {
        try {
            controllerUsuario = ControllerUsuario.getInstances();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public frm_ModificacionUsuario(){
        super("Alta Paciente");
        setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        asociarEventos();


    }

    private void asociarEventos(){
        this.self = this;

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int DNI = Integer.parseInt(textFieldDNI.getText());
                String NombreApellido = textFieldNombreApellido.getText();
                String contraseña = textFieldContraseña.getText();
                String domicilio = textFieldDomicilio.getText();
                String fechaNacimiento = textFieldFechaNacimiento.getText();
                String mail = textFieldMail.getText();
                String NombreUsuario = textFieldNombreUsuario.getText();
                // RolUsuario rolUsuario = textFieldRol.getText();

                UDTO.setDNI(DNI);
                UDTO.setDomicilio(domicilio);
                UDTO.setFechaNacimiento(fechaNacimiento);
                UDTO.setEmail(mail);
                //UDTO.setRolUsuario(rolUsuario);
                UDTO.setPassword(contraseña);
                UDTO.setNombre(NombreApellido);
                UDTO.setNombreUsuario(NombreUsuario);

                try {
                    controllerUsuario.ModificarUsuario(UDTO.getDNI(), UDTO);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}