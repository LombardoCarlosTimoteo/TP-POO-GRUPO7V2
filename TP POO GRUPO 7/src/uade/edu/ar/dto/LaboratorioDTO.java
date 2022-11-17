package uade.edu.ar.dto;

public class LaboratorioDTO {

    //DEFINIR ATRIBUTOS

    private String Nombre;

    private String CUIT;

    //CONSTRUCTOR
    public LaboratorioDTO(String Nombre, String CUIT) {
        this.CUIT = CUIT;
        this.Nombre = Nombre;
    }

    public LaboratorioDTO() {
    }

    public String getCUIT() {
        return CUIT;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
}


