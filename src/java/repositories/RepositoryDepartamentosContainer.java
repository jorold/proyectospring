package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import models.Departamento;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryDepartamentosContainer {

    //el repository para poder trabajar necesita un DriverManagerDatasource
    //para que el controller mande un drivermanager tenemos que crear su getter y setter
    private DriverManagerDataSource datasource;

    public RepositoryDepartamentosContainer(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    /*public DriverManagerDataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }*/
    public Departamento buscarDepartamento(int id) throws SQLException {
        //NECESITAMOS LA CONEXION
        //LA CONEXION NOS LA OFRECE EL OBJETO DATASOURCE DEL CONTAINER
        //RECUPERAMOS EL DATASOURCE DEL CONTAINER
        Connection cn = datasource.getConnection();
        String sql = "select * from dept where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int iddept = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento dept = new Departamento(iddept, nombre, localidad);
            rs.close();
            cn.close();
            return dept;
        }
        rs.close();
        cn.close();
        return null;
    }
}
