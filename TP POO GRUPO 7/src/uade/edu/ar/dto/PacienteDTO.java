package uade.edu.ar.dto;

import uade.edu.ar.controller.ControllerPaciente;
import uade.edu.ar.dao.PeticionDAO;
import uade.edu.ar.model.SexoPaciente;
import uade.edu.ar.model.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PacienteDTO {

    // DEFINICION DE ATRIBUTOS

    private int DNI;

    private String NombreUsuario;

    private String Email;

    private String Password;

    private String Nombre;

    private String Domicilio;

    private String FechaNacimiento;

    private int Edad;

    private boolean PeticonesCompletas;

    private SexoPaciente Sexo;
    private Usuario UsuarioAsociado;

    private ArrayList<Integer> PeticionAsociada;

    private Sucursal SucursalAsociada;

    private ControllerPaciente ControllerPaciente;

    private uade.edu.ar.dao.PeticionDAO PeticionDAO;

    //METODOS

    public PacienteDTO(int DNI, String NombreUsuario, String Email, String Password, String Nombre, String Domicilio, String FechaNacimiento, int Edad, boolean PeticonesCompletas, SexoPaciente Sexo) {
        this.DNI = DNI;
        this.NombreUsuario = NombreUsuario;
        this.Email = Email;
        this.Password = Password;
        this.Nombre = Nombre;
        this.Domicilio = Domicilio;
        this.FechaNacimiento = FechaNacimiento;
        this.Edad = Edad;
        this.PeticonesCompletas = PeticonesCompletas;
        this.Sexo = Sexo;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String domicilio) {
        Domicilio = domicilio;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public boolean isPeticonesCompletas() {
        return PeticonesCompletas;
    }

    public void setPeticonesCompletas(boolean peticonesCompletas) {
        PeticonesCompletas = peticonesCompletas;
    }

    public SexoPaciente getSexo() {
        return Sexo;
    }

    public void setSexo(SexoPaciente sexo) {
        Sexo = sexo;
    }
    public Usuario getUsuarioAsociado() {
        return UsuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        UsuarioAsociado = usuarioAsociado;
    }

    public ArrayList<Integer> getPeticionAsociada() {
        return PeticionAsociada;
    }

    public void setPeticionAsociada(ArrayList<Integer> peticionAsociada) {
        PeticionAsociada = peticionAsociada;
    }

    public Sucursal getSucursalAsociada() {
        return SucursalAsociada;
    }

    public void setSucursalAsociada(Sucursal sucursalAsociada) {
        SucursalAsociada = sucursalAsociada;
    }

    public uade.edu.ar.controller.ControllerPaciente getControllerPaciente() {
        return ControllerPaciente;
    }

    public void AltaPeticion(String ObraSocial, int DNI, int nroS, int IDU, ArrayList IDPR){



        int ID = 0;

        //Creado de fechas
        LocalDate FechaCarg = LocalDate.now();
        LocalDate FechaEntrega = FechaCarg.plusMonths(1);

        String FC = FechaCarg.toString();
        String FR = FechaCarg.toString();
        ArrayList<Resultado> RAsociado = new ArrayList<Resultado>();
        //Paciente PacAsociado  =

        //Peticion pet = new Peticion(FC, FR, ID, ObraSocial,false, PacAsociado, SAsociada, UAsociado, PracAsociada, RAsociado)
    }

    public void setControllerPaciente(uade.edu.ar.controller.ControllerPaciente controllerPaciente) {
        ControllerPaciente = controllerPaciente;
    }

    public Paciente dtoToModel(PacienteDTO dto){
        Paciente p = new Paciente(dto.getDNI(), dto.getNombreUsuario(), dto.getEmail(), dto.getPassword(), dto.getNombre(), dto.getDomicilio(), dto.getFechaNacimiento(),dto.getEdad(), dto.isPeticonesCompletas(), dto.getSexo(),  dto.getPeticionAsociada());
    return p;
}
//TUVE QUE AGREGAR ESTO PARA QUE EN CUSTOMTABLEMODEL NO TIRE ERROR LA FUNCION getValueAt
    public PacienteDTO getByIdModel(int id) throws Exception {
        for (Paciente model: ControllerPaciente.ListaPacientes) {//tuve que hacer que listapacientes sea publica
            if (model.getDNI() == id){
                return toDto(model);
            }
        }
        return  null;
    }

    public static PacienteDTO toDto(Paciente model){
        return new PacienteDTO(model.getDNI(),model.getNombreUsuario(),model.getEmail(),model.getPassword(),model.getNombre(),model.getDomicilio(),model.getFechaNacimiento(),model.getEdad(),model.isPeticonesCompletas(),model.getSexo());
    }

    public uade.edu.ar.dao.PeticionDAO getPeticionDAO() {
        return PeticionDAO;
    }

    public void setPeticionDAO(uade.edu.ar.dao.PeticionDAO peticionDAO) {
        PeticionDAO = peticionDAO;
    }

    public ArrayList<PeticionDTO> getListaPeticiones(PacienteDTO pac){

        ArrayList<PeticionDTO> ListaAuxPet = null;
        try {
            ListaAuxPet = pac.getPeticionDAO().getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ArrayList<PeticionDTO> ListaPeticiones = new ArrayList<PeticionDTO>();

        for (int id :pac.getPeticionAsociada()){
            for (PeticionDTO pet: ListaAuxPet){
                if (pet.getIDPeticion() == id);
                ListaPeticiones.add(pet);
            }
        }
        return ListaPeticiones;
    }
}
