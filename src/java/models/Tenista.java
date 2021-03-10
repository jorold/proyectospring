package models;

public class Tenista {

    private String nombre;
    private String imagen;
    private int palmares;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPalmares() {
        return palmares;
    }

    public void setPalmares(int palmares) {
        this.palmares = palmares;
    }
}
