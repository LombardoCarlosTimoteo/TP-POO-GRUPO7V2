package uade.edu.ar.controller;
import uade.edu.ar.dto.SucursalDTO;
import uade.edu.ar.dao.SucursalDAO;
import uade.edu.ar.model.clases.Sucursal;

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

public void EliminarSucursal(int Numero){
    int i=0;
    while (getSucursales().get(i).getNumero() == Numero) {
        i++;}
    getSucursales().remove(i);
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
        return new Sucursal(dto.getNumero(), dto.getDireccion(), dto.getResponsableTecnico(), dto.getPeticonesCompletas());
    }
    public static SucursalDTO toDto(Sucursal model){
        return new SucursalDTO(model.getNumero(),model.getDireccion(),model.getResponsableTecnico(),model.getPeticonesCompletas());
    }

    /*private static ControllerLaboratorio CONTROLLERLABORATORIO = null;

    private static LaboratorioDAO laboratorioDAO;

    private static List<Laboratorio> Laboratorios;


    private ControllerLaboratorio(){}

    public static synchronized ControllerLaboratorio getInstances() throws Exception {
        if(CONTROLLERLABORATORIO == null) {
            CONTROLLERLABORATORIO = new ControllerLaboratorio();
            laboratorioDAO = new LaboratorioDAO(Laboratorio.class,getPathOutModel(Laboratorio.class.getSimpleName()));//se crea el dao para que ya este en memoria fisica y no crearlo todo el tiempo
            Laboratorios = laboratorioDAO.getAll(Laboratorio.class);//recupero la info de ese archivo creado.
        }
        return CONTROLLERLABORATORIO;
    }


    public void addModel(LaboratorioDTO dto) throws Exception {// guarda en el archivo un objeto por medio del dto. lo guarda si no existe
        if(getByIdModel(dto.getCUIT()) == null){
            laboratorioDAO.save(toModel(dto));
        }
    }

    public ModelDto getByIdModel(int id) throws Exception {
        for (Laboratorio model: Laboratorios) {
            if (Laboratorio.getId().equals(id)){
                return toDto(model);
            }
        }
        return  null;
    }

    public void deleteByIdModel(String id){
        int index = getIndex(id);
        if(index != -1){
            Laboratorios.remove(index);
        }
    }

    private int getIndex(String id){
        for (int i=0;i<Laboratorios.size();i++){
            if(Laboratorios.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public List<ModelDto> getAll() throws Exception {
        List<ModelDto> dtoList = new ArrayList<>();
        for (Laboratorio model : modelDao.getAll(Laboratorio.class)) {
            dtoList.add(toDto(model));
        }
        return dtoList;
    }

    private static String getPathOutModel(String name){
        String dir = "C:\\Users\\Admin\\Desktop\\TPO POO";//crearlo en la direccion en donde se encuentra clonado el repositorio
        return  new File(dir+name+".json").getPath();
    }

    public static Laboratorio toModel(ModelDto dto){
        return new Laboratorio(dto.getIdModel(),dto.getNameModel());
    }

    public static ModelDto toDto(Laboratorio model){
        return new ModelDto(model.getId(),model.getName());
    }
*/


    /*public Paciente(int DNI,String NombreUsuario,String Email,String Password,String Nombre,String Domicilio, Date FechaNacimiento,int Edad, boolean PeticonesCompletas,SexoPaciente Sexo){
                this.DNI = DNI;
                this.NombreUsuario= NombreUsuario;
                this.Email=Email;
                this.Password=Password;
                this.Nombre=Nombre;
                this.Domicilio=Domicilio;
                this.FechaNacimiento=FechaNacimiento;
                this.Edad=Edad;
                this.PeticonesCompletas=PeticonesCompletas;
                this.Sexo=Sexo;
            }

            public paciente (){}

            crear paciente(parametros)
            paciente p= new paciente
            set
            set
            set
            set
            set


            */
}
