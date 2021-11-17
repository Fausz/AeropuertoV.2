package DAO.TXT;

import CLASES.Vuelo;
import DAO.DAOException;
import DAO.IVuelosDAO;

import java.util.Date;
import java.util.List;

public class VuelosTxtDAO implements IVuelosDAO {
    //Implementamos los metodos de la interfaz, desde aqui tendremos acceso a la BD
    @Override
    public void crearVuelo(Vuelo vuelo) throws DAOException {

    }

    @Override
    public void modificarVuelo(Vuelo v) throws DAOException {

    }

    @Override
    public void eliminarVuelo(String codigo) throws DAOException {

    }

    @Override
    public Vuelo obtenerVuelo(String codigo) throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos(Date fechaSalida) throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos(Date fechaInicio, Date fechaFin) throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelosSinPlazas() throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos() throws DAOException {
        return null;
    }
}
