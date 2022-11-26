package uade.edu.ar.dao;

import uade.edu.ar.model.clases.Sucursal;
import uade.edu.ar.model.clases.ValorReservado;
import uade.edu.ar.util.GenericDAO;

public class ValorReservadoDAO extends GenericDAO {

    public ValorReservadoDAO(Class<ValorReservado> clase, String file) throws Exception {//es una clase abstracta. y se pueden usar todos los metodos de genericDAO
        //super(Sucursal.class,"C:\\Users\\Admin\\Desktop\\ValorReservadoDAO.txt" ); //Cambiar ruta
        super(uade.edu.ar.model.clases.ValorReservado.class, "C:\\Users\\timoteo\\Desktop\\ValorReservadoDAO.txt");
    }
}