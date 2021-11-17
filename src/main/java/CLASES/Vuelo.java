package CLASES;

import java.util.Date;

public class Vuelo {

    private String codigo;
    private String origen;
    private double precioPersona;
    private Date fechaVuelo;
    private int plazasDisponibles;
    private int terminal;
    private int puerta;

    public Vuelo(String codigo, String origen, double precioPersona, Date fechaVuelo, int plazasDisponibles, int terminal, int puerta) {
        this.codigo = codigo;
        this.origen = origen;
        this.precioPersona = precioPersona;
        this.fechaVuelo = fechaVuelo;
        this.plazasDisponibles = plazasDisponibles;
        this.terminal = terminal;
        this.puerta = puerta;
    }

    public Vuelo() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getPrecioPersona() {
        return precioPersona;
    }

    public void setPrecioPersona(double precioPersona) {
        this.precioPersona = precioPersona;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getPuerta() {
        return puerta;
    }

    public void setPuerta(int puerta) {
        this.puerta = puerta;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo='" + codigo + '\'' +
                ", origen='" + origen + '\'' +
                ", precioPersona=" + precioPersona +
                ", fechaVuelo=" + fechaVuelo +
                ", plazasDisponibles=" + plazasDisponibles +
                ", terminal=" + terminal +
                ", puerta=" + puerta +
                '}';
    }
}
