package models;

public class Pelicula {

    private int idPelicula;
    private String titulo;
    private String argumento;
    private String foto;
    private String fecha;
    private String actores;
    private String director;
    private int duracion;
    private double precio;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, String argumento, String foto,
            String fecha, String actores, String director,
            int duracion, double precio) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.argumento = argumento;
        this.foto = foto;
        this.fecha = fecha;
        this.actores = actores;
        this.director = director;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
