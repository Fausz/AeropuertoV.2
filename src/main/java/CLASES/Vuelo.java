package CLASES;

import java.util.Date;
import java.util.Objects;

public class Vuelo {

    private String codigoVuelo;
    private String origen;
    private String destino;
    private double precioPersona;
    private Date fechaVuelo;
    private int plazasDisponibles;
    private int terminal;
    private int puerta;


    public Vuelo(String codigo, String origen, String destino, double precioPersona, Date fechaVuelo, int plazasDisponibles, int terminal, int puerta) {
        this.codigoVuelo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.precioPersona = precioPersona;
        this.fechaVuelo = fechaVuelo;
        this.plazasDisponibles = plazasDisponibles;
        this.terminal = terminal;
        this.puerta = puerta;
    }

    public Vuelo() {
    }

    //Metodo que se usa para obtener  el vuelo de la BD
    public Vuelo(String codigoVuelo, String origen, String destino, double precioPersona, Date fechaVuelo, int plazasDisponibles) {
        this(codigoVuelo,origen,destino,precioPersona,fechaVuelo,plazasDisponibles,0,0);
    }


    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
                "codigo='" + codigoVuelo + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", precioPersona=" + precioPersona +
                ", fechaVuelo=" + fechaVuelo +
                ", plazasDisponibles=" + plazasDisponibles +
                ", terminal=" + terminal +
                ", puerta=" + puerta +
                '}';
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigoVuelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vuelo other = (Vuelo) obj;
        if (!Objects.equals(this.codigoVuelo, other.codigoVuelo)) {
            return false;
        }
        return true;
    }


    public int compareTo(Vuelo v) {
        return this.codigoVuelo.compareTo(v.codigoVuelo);
    }
}
