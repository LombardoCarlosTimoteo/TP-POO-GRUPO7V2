package uade.edu.ar.controller;
import uade.edu.ar.dto.SucursalDTO;
import uade.edu.ar.dao.SucursalDAO;
import uade.edu.ar.model.clases.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ControllerSucursal {
    private ControllerSucursal(){}
    private ArrayList<SucursalDTO> SucursalesDTO = new ArrayList<SucursalDTO>();
    private static List<Sucursal> ListaSucursales;

    private ArrayList<SucursalDTO> getSucursales() {
        return SucursalesDTO;
    }
    private static ControllerSucursal CONTROLLERSUCURSAL = null;

    private static SucursalDAO SucursalDAO;

public void ModificarSucursal(int Numero, SucursalDTO SDTO){
    int i=0;
    while (getSucursales().get(i).getNumero() == Numero) {
        i++;}
    getSucursales().get(i).setDireccion(SDTO.getDireccion());
    getSucursales().get(i).setResponsableTecnico(SDTO.getResponsableTecnico());
    getSucursales().get(i).setPeticonesCompletas(SDTO.isPeticonesCompletas());
}

public void AgregarSucursal(SucursalDTO S){
    getSucursales().add(S);
    }

    public static synchronized ControllerSucursal getInstances() throws Exception {
        if(CONTROLLERSUCURSAL == null) {
            CONTROLLERSUCURSAL = new ControllerSucursal();
            SucursalDAO = new SucursalDAO(Sucursal.class,getPathOutModel(Sucursal.class.getSimpleName()));//se crea el dao para que ya este en memoria fisica y no crearlo todo el tiempo
            ListaSucursales = SucursalDAO.getAll(Sucursal.class);//recupero la info de ese archivo creado.
        }
        return CONTROLLERSUCURSAL;
    }

    public void addSucursal(SucursalDTO dto) throws Exception {
        if(getByIdModel(dto.getNumero()) == null){
            SucursalDAO.save(toModel(dto));
        }
    }

    public SucursalDTO getByIdModel(int id) throws Exception {
        for (Sucursal model: ListaSucursales) {
            if (model.getNumero() == id){
                return toDto(model);
            }
        }
        return  null;
    }


    public void deleteByIdModel(int id){
        int index = getIndex(id);
        if(index != -1){
            ListaSucursales.remove(index);
        }
    }

    private int getIndex(int id){
        for (int i=0;i<ListaSucursales.size();i++){
            if(ListaSucursales.get(i).getNumero() == id){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<SucursalDTO> getAll() throws Exception {
        ArrayList<SucursalDTO> dtoList = new ArrayList<SucursalDTO>();
        for (Sucursal model : ListaSucursales) {
            dtoList.add(toDto(model));
        }
        return dtoList;
    }


    private static String getPathOutModel(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }


    public static Sucursal toModel(SucursalDTO dto) {
        return new Sucursal(dto.getNumero(), dto.getDireccion(), dto.getResponsableTecnico(), dto.getPeticonesCompletas(),dto.getPacienteAsociado(),dto.getPeticionAsociada());
    }
    public static SucursalDTO toDto(Sucursal model){
        return new SucursalDTO(model.getNumero(),model.getDireccion(),model.getResponsableTecnico(),model.getPeticonesCompletas());
    }


    public ArrayList<Peticion> ListarPeticionesValorCritico(){ //TOMA UNA SUCURSAL, DE CADA SUCURSAL TOMA LAS PETICIONES, DE CADA PETICION TOMA LA LISTA DE PRACTICAS,
                                                                // DE CADA PRACTICA TOMA LA LISTA DE RESULTADOS, DE CADA RESULTADO TOMA VALOR RESERVADO Y COMPARA SI ES RESERVADO PARA AGREGARLO A LA LISTA DE IDPRACTICAS QUE TIENEN RESULTADO VALOR RESULTADO. LO AGREGA A LA LISTA SI ESTE NO SE ENCUENTRA EN LA LISTA.
        ArrayList lista = new ArrayList(); //CREAMOS LA LISTA A RETORNAR

        for (int i = 0; i <= ListaSucursales.size(); i++){ //POR CADA SUCURSAL
            Sucursal sucursal = ListaSucursales.get(i);
            ArrayList Listapeticiones = sucursal.getPeticionAsociada();

            for (int j = 0; i <= Listapeticiones.size(); j++){ //POR CADA PETICION DE LA SUCURSAL
                Peticion peticion = (Peticion) Listapeticiones.get(j);
                ArrayList Listapracticas = peticion.getPracticaAsociada();

                for (int k = 0; k <= Listapracticas.size(); k++){ //POR CADA PRACTICA DE LA PETICION
                    Practica practica = (Practica) Listapracticas.get(k);
                    ArrayList Listaresultado = practica.getResultadoAsociado();
                    ArrayList ListavalorReservado = practica.getVReservadoAsociado();

                    for (int w = 0; w <= Listaresultado.size(); w++) { //POR CADA RESULTADO DE LA PRACTICA
                        Resultado Resultado = (uade.edu.ar.model.clases.Resultado) Listaresultado.get(w);
                        String Valor = Resultado.getValor();

                        for (int m = 0; m <= ListavalorReservado.size(); m++) { //POR CADA VALOR RESERVADO DE LA PRACTICA
                            ValorReservado valorReservado = (ValorReservado) ListavalorReservado.get(m);

                            String comparacion = String.valueOf(valorReservado.getTipoComparacion());

                            String valorComparacion = valorReservado.getValor();

                            boolean hacer = false;

                            hacer = Resultado.EsReservado(comparacion, valorComparacion, Valor, hacer); //COMPARAMOS CADA VALOR DE RESULTADO CON CADA VALOR DE VALOR RESULTADO

                            if (hacer && !lista.contains(practica.getIDPractica())) lista.add(practica.getIDPractica()); //AGREGAMOS A LA LISTA LA ID DE LA PRACTICA CON VALOR RESERVADO POSITIVO Y QUE NO ESTE TODAVIA EN LA LISTA
                        }
                    }
                }
            }
        }
        return lista;
    }

    public void EliminarSucursal(int ID){
        int posicion = getIndex(ID);
        boolean peticion = ListaSucursales.get(posicion).isPeticonesCompletas();
        Sucursal Sucursal = (Sucursal) ListaSucursales.get(posicion);
        if(posicion != -1 && !peticion){
            ListaSucursales.remove(posicion);
            for (Paciente P : Sucursal.getPacienteAsociado()){
                P.setSucursalAsociada(ListaSucursales.get(0));
            }
            System.out.println("Sucursal eliminada correctamente y todos sus pacientes han sido derivados.");
        }
        else System.out.println("La sucursal no puede ser eliminada ya que o no existe o tiene peticiones completas.");
    }






}
