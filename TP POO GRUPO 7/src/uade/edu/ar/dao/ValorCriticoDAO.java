package uade.edu.ar.dao;

import uade.edu.ar.model.clases.Sucursal;
import uade.edu.ar.model.clases.ValorCritico;
import uade.edu.ar.util.GenericDAO;

public class ValorCriticoDAO extends GenericDAO {

    public ValorCriticoDAO(Class<ValorCritico> clase, String file) throws Exception {//es una clase abstracta. y se pueden usar todos los metodos de genericDAO
       // super(Sucursal.class,"C:\\Users\\Admin\\Desktop\\ValorCriticoDAO.txt" ); //Cambiar ruta
       super(uade.edu.ar.model.clases.ValorCritico.class, "C:\\Users\\timoteo\\Desktop\\ValorCriticoDAO.txt");
    }
}