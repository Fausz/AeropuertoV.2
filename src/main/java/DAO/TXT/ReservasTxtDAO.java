package DAO.TXT;

import CLASES.OrdenPago;
import CLASES.Reserva;
import CLASES.TarjetaEmbarque;
import DAO.DAOException;
import DAO.IReservasDAO;

import java.util.Date;
import java.util.List;

public class ReservasTxtDAO implements IReservasDAO {
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
        return null;
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
}
