package uade.edu.ar.model.clases;

import java.util.ArrayList;
import uade.edu.ar.controller.ControllerSucursal;

public class Laboratorio {

    //DEFINIR ATRIBUTOS

    private String Nombre;

    private String CUIT;

    //DEFINIR RELACIONES

    private ArrayList<Sucursal> SucursalAsociada;

    private ArrayList<Practica> PracticaAsociada;

    private ControllerSucursal ControllerSucursal;



    //DEFINIR METODOS
    //CONSTRUCTOR GENERAL

    /* ESTE CONSTRUCTOR TIENE QUE IR A EL CONTROLLER LABORATORIO

   public  Laboratorio(String Nombre,String CUIT){
        this.CUIT=CUIT;
        this.Nombre = Nombre;
    }
    */





    //CONSTRUCTOR DE PRACTICAS
    public Practica CrearPractica(String IDPractica,String Nombre,String Grupo,String CantHorasResultado,boolean Habilitado, Laboratorio LabAsociado, ArrayList VCritico, ArrayList VReservado, Peticion PetAsociada, ArrayList ResultadoAsociado){
        Practica PracticaNueva = new Practica();
        PracticaNueva.setIDPractica(IDPractica);
        PracticaNueva.setNombre(Nombre);
        PracticaNueva.setGrupo(Grupo);
        PracticaNueva.setCantHorasResultado(CantHorasResultado);
        PracticaNueva.setHabilitado(Habilitado);
        PracticaNueva.setLaboratorioAsociado(LabAsociado);
        PracticaNueva.setVCriticoAsociado(VCritico);
        PracticaNueva.setResultadoAsociado(ResultadoAsociado);
        PracticaNueva.setVReservadoAsociado(VReservado);
        PracticaNueva.setPeticionAsociada(PetAsociada);

        return PracticaNueva;
    }

    //CONSTRUCTOR DE SUCURSALES
    public Sucursal CrearSucursal(int Numero, String Direccion, String ResponsableTecnico, boolean PeticonesCompletas, ArrayList PacienteAsociado, Laboratorio LabAsociado, ArrayList PetAsociadas){
        Sucursal SucursalNueva = new Sucursal();
        SucursalNueva.setNumero(Numero);
        SucursalNueva.setDireccion(Direccion);
        SucursalNueva.setResponsableTecnico(ResponsableTecnico);
        SucursalNueva.setPeticonesCompletas(PeticonesCompletas);
        SucursalNueva.setPeticionAsociada(PetAsociadas);
        SucursalNueva.setPacienteAsociado(PacienteAsociado);
        SucursalNueva.setLaboratorioAsociado(LabAsociado);
        return SucursalNueva;
    }




    //AÑADIR PRACTICAS
    public void AnadirPractica (Practica PAnadir, ArrayList ListaPracticas){
        ListaPracticas.add(PAnadir);
    }

    //ANADIR SUCURSAL
    public void AnadirSucursal (Practica SAnadir, ArrayList ListaSucursales){
        ListaSucursales.add(SAnadir);
    }




    //GETTERS/SETTERS
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public ArrayList<Sucursal> getSucursalAsociada() {
        return SucursalAsociada;
    }

    public void setSucursalAsociada(ArrayList<Sucursal> sucursalAsociada) {
        SucursalAsociada = sucursalAsociada;
    }

    public ArrayList<Practica> getPracticaAsociada() {
        return PracticaAsociada;
    }

    public void setPracticaAsociada(ArrayList<Practica> practicaAsociada) {
        PracticaAsociada = practicaAsociada;
    }

    public ControllerSucursal getControllerLaboratorio() {
        return ControllerSucursal;
    }

    public void setControllerLaboratorio(ControllerSucursal controllerSucursal) {
        ControllerSucursal = controllerSucursal;
    }
}

