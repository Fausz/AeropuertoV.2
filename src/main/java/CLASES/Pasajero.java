package CLASES;

import java.util.Date;

public class Pasajero {
    private int idPasajero;
    private String dni;
    private String nombre;
    private String apellidos;
    private Date fecha_nacimiento;
    private int num_maletas_facturar;
    //private TarjetaEmbarque tarjeta_embarque;


    public Pasajero() {
    }

    public Pasajero(int idPasajero, String dni, String nombre, String apellidos, Date fecha_nacimiento, int num_maletas_facturar) {
        this.idPasajero = idPasajero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.num_maletas_facturar = num_maletas_facturar;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getNum_maletas_facturar() {
        return num_maletas_facturar;
    }

    public void setNum_maletas_facturar(int num_maletas_facturar) {
        this.num_maletas_facturar = num_maletas_facturar;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "idPasajero=" + idPasajero +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", num_maletas_facturar=" + num_maletas_facturar +
                '}';
    }
}
