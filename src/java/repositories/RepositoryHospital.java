package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Hospital;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryHospital {

    private DriverManagerDataSource datasource;

    public DriverManagerDataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    public ArrayList<Hospital> getHospital(int id) throws SQLException {
        Connection cn = datasource.getConnection();
        String sql = "select * from hospital";
        ArrayList<Hospital> hospital = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int idHospital = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String telefono = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMAS");
            Hospital hospi = new Hospital(idHospital, nombre, direccion, telefono, camas);
            hospital.add(hospi);
        }
        rs.close();
        cn.close();
        if (hospital.size() == 0) {
            return null;
        } else {
            return hospital;
        }
    }
}
