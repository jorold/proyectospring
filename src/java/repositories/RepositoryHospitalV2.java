package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Hospital;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryHospitalV2 {

    private DriverManagerDataSource datasource;

    public RepositoryHospitalV2(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    public List<Hospital> getHospital() throws SQLException {
        Connection cn = datasource.getConnection();
        String sql = "select * from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Hospital> hospital = new ArrayList<>();
        while (rs.next()) {
            int idHospital = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String telefono = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMA");
            Hospital hospi = new Hospital(idHospital, nombre, direccion, telefono, camas);
            hospital.add(hospi);
        }
        rs.close();
        cn.close();
        return hospital;
    }
}
