package uade.edu.ar.dao;

import uade.edu.ar.model.clases.Paciente;
import uade.edu.ar.model.clases.Sucursal;
import uade.edu.ar.util.GenericDAO;
import uade.edu.ar.model.clases.Usuario;

public class UsuarioDAO extends GenericDAO {

    public UsuarioDAO(Class<Usuario> clase, String file) throws Exception {//es una clase abstracta. y se pueden usar todos los metodos de genericDAO
        super(Sucursal.class,"C:\\Users\\Admin\\Desktop\\UsuarioDAO.txt" ); //Cambiar ruta
        //super(Usuario.class, "C:\\Users\\timoteo\\Desktop\\UsuarioDAO.txt");
    }
}
