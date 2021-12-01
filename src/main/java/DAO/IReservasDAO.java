package DAO;

import CLASES.OrdenPago;
import CLASES.Reserva;
import CLASES.TarjetaEmbarque;

import java.util.Date;
import java.util.List;

public interface IReservasDAO {
    void crearReserva(Reserva r)throws DAOException ;
    void crearOrdenPago(OrdenPago orden) throws DAOException ;
    void modificarReserva(Reserva r)throws DAOException ;
    Reserva obtenerReserva(int id)throws DAOException ;
    OrdenPago obtenerOrdenPago(int id)throws DAOException ;
    List<OrdenPago> obtenerOrdenPago()throws DAOException ;
    List<OrdenPago> obtenerOrdenPago(Reserva r)throws DAOException;
    List<TarjetaEmbarque> obtenerTarjetasEmbarque(Integer idReserva) throws DAOException;
    boolean eliminarReserva(int id)throws DAOException ;
    List<Reserva> obtenerTodasReservas()throws DAOException ;
    List<Reserva> obtenerTodasReservas(Date d)throws DAOException ;
    List<Reserva> obtenerTodasReservas(String idVuelo)throws DAOException ;

    double obtenerDineroOrdenesDePagoVuelo(String codigoVuelo) throws DAOException;
    int obtenerNumeroDeAdultosDeVuelo(String codigoVuelo) throws DAOException;
    int obtenerNumeroDeNinyosDeVuelo(String codigoVuelo) throws DAOException;
    int obtenerNumPasajerosSinTarjeta(String codigoVuelo) throws DAOException;
    List<Reserva> obtenerReservasCanceladas(String codVuelo) throws DAOException;
}
