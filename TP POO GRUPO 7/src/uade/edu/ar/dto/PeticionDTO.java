package uade.edu.ar.dto;
import uade.edu.ar.dao.PracticaDAO;
import uade.edu.ar.dao.ResultadoDAO;
import uade.edu.ar.model.clases.Paciente;

import java.util.ArrayList;

public class PeticionDTO {

    //DEFINIR ATRIBUTOS

    private String FechaCarga;

    private String FechaEntrega;

    private int IDPeticion;

    private String ObraSocial;

    private boolean Completado;



    //DEFINIR RELACIONES

    private Paciente PacienteAsociada;

    private ArrayList<Integer> PracticaAsociada;

    private PracticaDAO PracticaDAO;

    private ArrayList<Integer> ResultadoAsociado;

    private ResultadoDAO ResultadoDAO;


    //DEFINIR METODOS

    //GETTERS/SETTERS
    public String getFechaCarga() {
        return FechaCarga;
    }

    public void setFechaCarga(String fechaCarga) {
        FechaCarga = fechaCarga;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public int getIDPeticion() {
        return IDPeticion;
    }

    public void setIDPeticion(int IDPeticion) {
        this.IDPeticion = IDPeticion;
    }

    public String getObraSocial() {
        return ObraSocial;
    }

    public void setObraSocial(String obraSocial) {
        ObraSocial = obraSocial;
    }

    public boolean isCompletado() {
        return Completado;
    }

    public void setCompletado(boolean completado) {
        Completado = completado;
    }

    public Paciente getPacienteAsociada() {
        return PacienteAsociada;
    }

    public void setPacienteAsociada(Paciente pacienteAsociada) {
        PacienteAsociada = pacienteAsociada;
    }

    public ArrayList<Integer> getPracticaAsociada() {
        return PracticaAsociada;
    }

    public void setPracticaAsociada(ArrayList<Integer> practicaAsociada) {
        PracticaAsociada = practicaAsociada;
    }

    public ArrayList<Integer> getResultadoAsociado() {
        return ResultadoAsociado;
    }

    public void setResultadoAsociado(ArrayList<Integer> resultadoAsociado) {
        ResultadoAsociado = resultadoAsociado;
    }

    public PracticaDAO getPracticaDAO() {
        return PracticaDAO;
    }

    public ResultadoDAO getResultadoDAO() {
        return ResultadoDAO;
    }

    public PeticionDTO(String FechaCarg, String FechaEntrega, int IDPeticion,String ObraSocial,boolean Completado, Paciente PacAsociado, ArrayList<Integer> PracAsociada, ArrayList<Integer> RAsociado){
        this.FechaCarga=FechaCarg;
        this.FechaEntrega=FechaEntrega;
        this.IDPeticion=IDPeticion;
        this.ObraSocial=ObraSocial;
        this.Completado=Completado;
        this.PacienteAsociada=PacAsociado;
        this.PracticaAsociada=PracAsociada;
        this.ResultadoAsociado=RAsociado;
    }

    public ArrayList<PracticaDTO> getListaPracticas(PeticionDTO pet){

        ArrayList<PracticaDTO> ListaAuxPrac = null;
        try {
            ListaAuxPrac = pet.getPracticaDAO().getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<PracticaDTO> ListaPracticas = new ArrayList<PracticaDTO>();

        for (int id :pet.getPracticaAsociada()){
            for (PracticaDTO pr: ListaAuxPrac){
                if (pr.getIDPractica() == Integer.toString(id));
                ListaPracticas.add(pr);
            }
        }

        return ListaPracticas;
    }

    public ArrayList<ResultadoDTO> getListaResultados(PeticionDTO p){

        ArrayList<ResultadoDTO> ListaAuxRes = null;
        try {
            ListaAuxRes = p.getResultadoDAO().getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<ResultadoDTO> ListaResultados = new ArrayList<ResultadoDTO>();

        for (int id :p.getResultadoAsociado()){
            for (ResultadoDTO pet: ListaAuxRes){
                if (pet.getIDResultado() == id);
                ListaResultados.add(pet);
            }
        }
        return ListaResultados;
    }
}
