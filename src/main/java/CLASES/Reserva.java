package CLASES;

import java.util.Date;
import java.util.List;

public class Reserva {
    private int idReserva;
    private Date fecha_res;
    private boolean cancelada;
    private List<Pasajero> pasajeros;
    private Vuelo vuelo;
    private double importe;

    public Reserva() {
    }

    public Reserva(int idReserva, Date fecha_res, boolean cancelada, List<Pasajero> pasajeros, Vuelo vuelo, double importe) {
        this.idReserva = idReserva;
        this.fecha_res = fecha_res;
        this.cancelada = cancelada;
        this.pasajeros = pasajeros;
        this.vuelo = vuelo;
        this.importe = importe;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFecha_res() {
        return fecha_res;
    }

    public void setFecha_res(Date fecha_res) {
        this.fecha_res = fecha_res;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", fecha_res=" + fecha_res +
                ", cancelada=" + cancelada +
                ", pasajeros=" + pasajeros +
                ", vuelo=" + vuelo +
                ", importe=" + importe +
                '}';
    }
}
