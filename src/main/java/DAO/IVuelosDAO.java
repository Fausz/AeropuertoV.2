package DAO;

import CLASES.Vuelo;

import java.util.Date;
import java.util.List;

public interface IVuelosDAO {
    //Interfaz que se aplicara a todos los DAO para que ejecuten estos metodos
    void crearVuelo (Vuelo vuelo)  throws DAOException;
    void modificarVuelo(Vuelo v)  throws DAOException;
    void eliminarVuelo(String codigo)  throws DAOException;
    Vuelo obtenerVuelo(String codigo)  throws DAOException;
    List<Vuelo> obtenerVuelos(Date fechaSalida)  throws DAOException;
    List<Vuelo> obtenerVuelos(Date fechaInicio,Date fechaFin)  throws DAOException;
    List<Vuelo> obtenerVuelosSinPlazas() throws DAOException;
    List<Vuelo> obtenerVuelos()  throws DAOException;
}
