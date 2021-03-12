package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryEmpleados {

    private DriverManagerDataSource datasource;

    public RepositoryEmpleados(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    public List<Empleado> getEmpleados() throws SQLException {
        Connection cn = this.datasource.getConnection();
        String sql = "select * from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            Empleado emp = new Empleado(id, apellido, oficio, salario);
            empleados.add(emp);
        }
        rs.close();
        cn.close();
        return empleados;
    }

    public List<Empleado> getEmpleadosSession(List<String> listaids) throws SQLException {
        Connection cn = this.datasource.getConnection();
        //hay que separar los ids con una coma
        String data = "";
        for (String id : listaids) {
            data += id + ",";
        }
        //se elimina la última coma para que no de error la consulta sql
        data = data.substring(0, data.lastIndexOf(","));
        //se hace la consulta sql
        String sql = "select * from emp where emp_no in(" + data + ")";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            Empleado emp = new Empleado(id, apellido, oficio, salario);
            empleados.add(emp);
        }
        rs.close();
        cn.close();
        return empleados;
    }
}
