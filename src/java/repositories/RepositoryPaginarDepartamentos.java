package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Departamento;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryPaginarDepartamentos {

    DriverManagerDataSource dataSource;

    public RepositoryPaginarDepartamentos(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    //necesitamos recuperar el número de registros a paginar
    //necesitamos el objeto que queremos mostrar
    private int numeroRegistros;

    public int getNumeroRegistros() {
        return numeroRegistros;
    }

    //necesitamos un método que nos devuelva el dato por su posición
    public Departamento getDepartamento(int posicion) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from dept";
        //necesitamos que el statement se pueda mover entre las posiciones del cursor
        Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery(sql);
        //ahora tenemos movimiento por el cursor de registros, hay que ir al último
        rs.last();
        //y almacenar el número de registro
        this.numeroRegistros = rs.getRow();
        //nos posicionamos el la fila que deseemos
        rs.absolute(posicion);
        //extraemos los datos para el objeto
        int id = rs.getInt("DEPT_NO");
        String nombre = rs.getString("DNOMBRE");
        String localidad = rs.getString("LOC");
        Departamento dept = new Departamento(id, nombre, localidad);
        rs.close();
        cn.close();
        return dept;
    }

}
