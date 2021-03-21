package repositories;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Pelicula;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryPeliculas {

    DriverManagerDataSource dataSource;

    public RepositoryPeliculas(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Pelicula> getPeliculas() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from peliculas";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("idpelicula");
            String titulo = rs.getString("titulo");
            String argumento = rs.getString("argumento");
            String foto = rs.getString("foto");
            String fecha = rs.getString("fecha_estreno");
            String actores = rs.getString("actores");
            String director = rs.getString("director");
            int duracion = rs.getInt("duracion");
            double precio = rs.getInt("precio");
            Pelicula pelis = new Pelicula(id, titulo, argumento, foto, fecha, actores, director, duracion, precio);
            peliculas.add(pelis);
        }
        rs.close();
        cn.close();
        return peliculas;
    }

    public Pelicula getDetalles(int idpelicula) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from peliculas where idpelicula=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idpelicula);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("idpelicula");
            String titulo = rs.getString("titulo");
            String argumento = rs.getString("argumento");
            String foto = rs.getString("foto");
            String fecha = rs.getString("fecha_estreno");
            String actores = rs.getString("actores");
            String director = rs.getString("director");
            int duracion = rs.getInt("duracion");
            double precio = rs.getInt("precio");
            Pelicula peliculas = new Pelicula(id, titulo, argumento, foto, fecha, actores, director, duracion, precio);
            rs.close();
            cn.close();
            return peliculas;
        } else {
            rs.close();
            cn.close();
            return null;
        }
    }

    public List<Pelicula> getpagina() {

    }
}
