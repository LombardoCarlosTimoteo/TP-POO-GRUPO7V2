package uade.edu.ar.controller;
import uade.edu.ar.dao.PacienteDAO;
import uade.edu.ar.dao.UsuarioDAO;

import uade.edu.ar.dto.PacienteDTO;
import uade.edu.ar.dto.UsuarioDTO;
import uade.edu.ar.model.clases.Paciente;
import uade.edu.ar.model.clases.Usuario;

import java.util.ArrayList;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

private ControllerUsuario(){}
    private ArrayList<UsuarioDTO> UsuariosDTO = new ArrayList<UsuarioDTO>();

    private static List<Usuario> ListaUsuarios;
    private static UsuarioDAO UsuarioDAO;

    public ArrayList<UsuarioDTO> getUsuarios() {
        return UsuariosDTO;
    }
    private static ControllerUsuario CONTROLLERUSUARIO = null;



    public void ModificarUsuario (int DNI, UsuarioDTO UDTO){
        int i=0;
        while (getUsuarios().get(i).getDNI() == DNI) {
            i++;}
        getUsuarios().get(i).setDNI(UDTO.getDNI());
        getUsuarios().get(i).setNombreUsuario(UDTO.getNombreUsuario());
        getUsuarios().get(i).setEmail(UDTO.getEmail());
        getUsuarios().get(i).setPassword(UDTO.getPassword());
        getUsuarios().get(i).setNombre(UDTO.getNombre());
        getUsuarios().get(i).setFechaNacimiento(UDTO.getFechaNacimiento());
        getUsuarios().get(i).setRol(UDTO.getRol());
    }

    public void AgregarUsuario (UsuarioDTO U){
        getUsuarios().add(U);
    }
    public void EliminarUsuario (int U){
        getUsuarios().remove(U);
    }

    public static synchronized ControllerUsuario getInstances() throws Exception {
        if(CONTROLLERUSUARIO == null) {
            CONTROLLERUSUARIO = new ControllerUsuario();
            UsuarioDAO = new UsuarioDAO(Usuario.class,getPathOutModel(Usuario.class.getSimpleName()));//se crea el dao para que ya este en memoria fisica y no crearlo todo el tiempo
            ListaUsuarios = UsuarioDAO.getAll(Usuario.class);//recupero la info de ese archivo creado.
        }
        return CONTROLLERUSUARIO;
    }
    public void addUsuario(UsuarioDTO dto) throws Exception {
        if(getByIdModel(dto.getDNI()) == null){
            UsuarioDAO.save(toModel(dto));
        }
    }
    public ArrayList<UsuarioDTO> getAll() throws Exception {
        ArrayList<UsuarioDTO> dtoList = new ArrayList<UsuarioDTO>();
        for (Usuario model : ListaUsuarios) {
            dtoList.add(toDto(model));
        }
        return dtoList;
    }

    private static String getPathOutModel(String name){
        String dir = "C:/IOO/";
        return  new File(dir+name+".json").getPath();
    }

    public static Usuario toModel(UsuarioDTO dto){
        return new Usuario(dto.getDNI(),dto.getNombreUsuario(),dto.getEmail(),dto.getPassword(),dto.getNombre(),dto.getFechaNacimiento(),dto.getRol());
    }

    public static UsuarioDTO toDto(Usuario model){
        return new UsuarioDTO(model.getDNI(),model.getNombreUsuario(),model.getEmail(),model.getPassword(),model.getNombre(),model.getFechaNacimiento(),model.getRol());
    }
    public UsuarioDTO getByIdModel(int id) throws Exception {
        for (Usuario model: ListaUsuarios) {
            if (model.getDNI() == id){
                return toDto(model);
            }
        }
        return  null;
    }

    public void deleteByIdModel(int id){
        int index = getIndex(id);
        if(index != -1){
            ListaUsuarios.remove(index);
        }
    }

    private int getIndex(int id){
        for (int i=0;i<ListaUsuarios.size();i++){
            if(ListaUsuarios.get(i).getDNI() == id){
                return i;
            }
        }
        return -1;
    }


}