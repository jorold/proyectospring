package models;

public class Doctor {

    private int idHospital;
    private int idDoctor;
    private String apellido;
    private String especialidad;
    private int salario;

    public Doctor() {
    }

    public Doctor(int idHospital, int idDoctor, String apellido, String especialidad, int salario) {
        this.idHospital = idHospital;
        this.idDoctor = idDoctor;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
