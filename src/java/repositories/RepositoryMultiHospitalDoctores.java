package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Doctor;
import models.Hospital;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryMultiHospitalDoctores {

    DriverManagerDataSource datasource;

    public RepositoryMultiHospitalDoctores(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    public List<Hospital> getHospitales() throws SQLException {
        Connection cn = this.datasource.getConnection();
        String sql = "select * from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Hospital> hospitales = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String telefono = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMA");
            Hospital hosp = new Hospital(id, nombre, direccion, telefono, camas);
            hospitales.add(hosp);
        }
        rs.close();
        cn.close();
        return hospitales;
    }

    public List<Doctor> getDoctorHospital(int idhospital) throws SQLException {
        Connection cn = this.datasource.getConnection();
        String sql = "select * from doctor where hospital_cod=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idhospital);
        ResultSet rs = pst.executeQuery();
        ArrayList<Doctor> doctores = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("HOSPITAL_COD");
            int iddoctor = rs.getInt("DOCTOR_NO");
            String apellido = rs.getString("APELLIDO");
            String especialidad = rs.getString("ESPECIALIDAD");
            int salario = rs.getInt("SALARIO");
            Doctor doc = new Doctor(id, iddoctor, apellido, especialidad, salario);
            doctores.add(doc);
        }
        rs.close();
        cn.close();
        return doctores;
    }
}
