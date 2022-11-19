package uade.edu.ar.dao;

import uade.edu.ar.model.clases.Paciente;
import uade.edu.ar.model.clases.Sucursal;
import uade.edu.ar.util.GenericDAO;

    public class SucursalDAO extends GenericDAO {

        public SucursalDAO() throws Exception {//es una clase abstracta. y se pueden usar todos los metodos de genericDAO
            super(Laboratorio.class,"F:\\Repositorios\\TP POO GRUPO 7\\ArchivosPrueba" ); //Cambiar ruta
        }
    }

