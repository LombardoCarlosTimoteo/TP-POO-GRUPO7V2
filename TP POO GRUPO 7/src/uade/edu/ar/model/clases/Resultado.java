package uade.edu.ar.model.clases;

public class Resultado {

    //DEFINIR ATRIBUTOS

    private String Valor;

    private int IDResultado;

    //DEFINIR RELACIONES

    private Practica PracticaAsociada;

    private Peticion PeticionAsociada;




    //DEFINIR METODOS

    //GETTERS/SETTERS

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public int getIDResultado() {
        return IDResultado;
    }

    public void setIDResultado(int IDResultado) {
        this.IDResultado = IDResultado;
    }

    public Practica getPracticaAsociada() {
        return PracticaAsociada;
    }

    public void setPracticaAsociada(Practica practicaAsociada) {
        PracticaAsociada = practicaAsociada;
    }

    public Peticion getPeticionAsociada() {
        return PeticionAsociada;
    }

    public void setPeticionAsociada(Peticion peticionAsociada) {
        PeticionAsociada = peticionAsociada;
    }

}
