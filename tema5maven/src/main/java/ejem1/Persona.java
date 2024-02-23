package ejem1;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {

    public Persona(){
        
    }
    public Persona(int id, String nombre, boolean casado, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.casado = casado;
        this.sexo = sexo;
    }

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCasado() {
        return this.casado;
    }

    public boolean getCasado() {
        return this.casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    private String nombre;
    private boolean casado;
    private String sexo;

}
