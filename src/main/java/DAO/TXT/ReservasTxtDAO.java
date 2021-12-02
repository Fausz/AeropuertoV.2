package DAO.TXT;

import CLASES.*;
import DAO.DAOException;
import DAO.IReservasDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservasTxtDAO implements IReservasDAO {

    private String archivoReservas = null;
    private String archivoPasajeros = null;
    private String archivoTarjetasEmbarque = null;
    private String archivoOrdenesPago = null;

    public ReservasTxtDAO() throws DAOException {
        Configuracion configuracion = new Configuracion("/configuracion.properties");
        this.archivoReservas = configuracion.getTxtReservas();
        this.archivoPasajeros = configuracion.getTxtPasajeros();
        //this.archivoTarjetasEmbarque = configuracion.getTxtTarjetasEmbarque();
        //this.archivoOrdenesPago = configuracion.getTxtOrdenesPago();

    }
    @Override
    public void crearReserva(Reserva r) throws DAOException {

    }

    @Override
    public void crearOrdenPago(OrdenPago orden) throws DAOException {

    }

    @Override
    public void modificarReserva(Reserva r) throws DAOException {

    }

    @Override
    public Reserva obtenerReserva(int id) throws DAOException {
        return null;
    }

    @Override
    public OrdenPago obtenerOrdenPago(int id) throws DAOException {
        return null;
    }

    @Override
    public List<OrdenPago> obtenerOrdenPago() throws DAOException {
        return null;
    }

    @Override
    public List<OrdenPago> obtenerOrdenPago(Reserva r) throws DAOException {
        return null;
    }

    @Override
    public List<TarjetaEmbarque> obtenerTarjetasEmbarque(Integer idReserva) throws DAOException {
        return null;
    }

    @Override
    public boolean eliminarReserva(int id) throws DAOException {
        return false;
    }

    @Override
    public List<Reserva> obtenerTodasReservas() throws DAOException {
        return this.sacarReservasTxt();
    }

    @Override
    public List<Reserva> obtenerTodasReservas(Date d) throws DAOException {
        return null;
    }

    @Override
    public List<Reserva> obtenerTodasReservas(String idVuelo) throws DAOException {
        return null;
    }

    @Override
    public double obtenerDineroOrdenesDePagoVuelo(String codigoVuelo) throws DAOException {
        return 0;
    }

    @Override
    public int obtenerNumeroDeAdultosDeVuelo(String codigoVuelo) throws DAOException {
        return 0;
    }

    @Override
    public int obtenerNumeroDeNinyosDeVuelo(String codigoVuelo) throws DAOException {
        return 0;
    }

    @Override
    public int obtenerNumPasajerosSinTarjeta(String codigoVuelo) throws DAOException {
        return 0;
    }

    @Override
    public List<Reserva> obtenerReservasCanceladas(String codVuelo) throws DAOException {
        return null;
    }
    private List<Reserva> sacarReservasTxt() throws DAOException {
        List<Reserva> reservas = new ArrayList<>();
        try (BufferedReader brR = new BufferedReader(new FileReader(archivoReservas))){
            String linea;
            //Mintras encuentre una linea no vacia leera el bloque
            while ((linea = brR.readLine()) != null) {
                String [] datosReserva = linea.split("#");
                int id = Integer.parseInt(datosReserva[0]);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaReserva = sdf.parse(datosReserva[1]);

                boolean cancelada = Boolean.parseBoolean(datosReserva[2]);

                String codigoVuelo = datosReserva[3];
                VuelosTxtDAO daoVuelo = new VuelosTxtDAO();
                Vuelo v = daoVuelo.obtenerVuelo(codigoVuelo);

                double importe = Double.parseDouble(datosReserva[4]);

                List<Pasajero>pasajeros = new ArrayList<>();
                try(BufferedReader brP = new BufferedReader(new FileReader(archivoPasajeros))){

                }catch (Exception e){
                    throw new DAOException("Ha habido un problema al obtener los pasajeros desde el archivo de texto: "+e.getMessage(),e);
                }
            }

            return reservas;
        }catch (Exception e){
            throw new DAOException("Ha habido un problema al obtener las reservas desde el archivo de texto:" + e.getMessage(), e);
        }
    }
}
