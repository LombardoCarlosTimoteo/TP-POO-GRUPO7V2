package uade.edu.ar.dao;

import uade.edu.ar.model.clases.Paciente;
import uade.edu.ar.model.clases.Sucursal;
import uade.edu.ar.util.GenericDAO;

    public class SucursalDAO extends GenericDAO {

        public SucursalDAO(Class<Sucursal> clase, String file) throws Exception {//es una clase abstracta. y se pueden usar todos los metodos de genericDAO
            super(Sucursal.class,"F:\\Repositorios\\TP POO GRUPO 7\\ArchivosPrueba" ); //Cambiar ruta
        }
    }

