package ejem1;

public class Deportista {
    
    private int id;
    private String nombre;
    private String deporte;
    private boolean activo;
    private String genero;

    public Deportista() {
    }


    public Deportista(int id, String nombre, String deporte, boolean activo, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.activo = activo;
        this.genero = genero;
    }

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

  
    public String getDeporte() {
        return this.deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public boolean getActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
