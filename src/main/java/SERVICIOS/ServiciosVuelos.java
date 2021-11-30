package SERVICIOS;

import CLASES.Vuelo;
import DAO.BaseDeDatos;
import DAO.DAOException;
import DAO.IVuelosDAO;
import DAO.TXT.VuelosTxtDAO;

import java.util.Date;
import java.util.List;

public class ServiciosVuelos {

    //Aqui guardaremos la instancia del tipo de almacenamiento que se haya elegido para poder usar ese tipo en concreto
    private IVuelosDAO dao = null;

    //Ejemplo del patrón singleton
    // El constructor es privado
    private ServiciosVuelos() {
    }

    //Hay una única instancia que se invoca usando a la clase
    private static ServiciosVuelos servicioVuelos;

    public static ServiciosVuelos getServicio() throws DAOException{
        if (servicioVuelos == null) {
            servicioVuelos = new ServiciosVuelos();
        }
        return servicioVuelos;
    }
    // También lo podríamos haber usado para la clase controlador
    //y para la clase de vistas

    public void elegirSistemaAlmacenamiento(int opcion) throws DAOException {

        if (opcion == 1) {
            dao = new VuelosTxtDAO();
        }
        /*if (opcion == 2) {

            idao = new FutbolAleatorioDAO();

        }
        if (opcion == 3) {

            idao = new FutbolXMLDAO();

        }
        if (opcion == 4) {

            idao = new FutbolXMLSaxDAO();

        }
        if (opcion == 5) {

            idao = new FutbolJDBCDAO();

        }
        if (opcion == 6) {

            idao = new FutbolHibernate();

        }
        if (opcion == 7) {

            idao = new FutbolMongoDAO();

        }*/

    }
    public void crearVuelo(Vuelo v) throws DAOException, ServiciosException{

        if (dao.obtenerVuelo(v.getCodigoVuelo()) != null) {
            throw new ServiciosException("El vuelo ya existe.");
        }

        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }

        dao.crearVuelo(v);

        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public void modificarTerminal(String codigoVuelo, int terminal) throws DAOException, ServiciosException {
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        Vuelo v = this.obtenerVuelo(codigoVuelo);
        v.setTerminal(terminal);
        dao.modificarVuelo(v);
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public void modificarPuerta(String codigoVuelo, int puerta) throws DAOException, ServiciosException {
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        Vuelo v = this.obtenerVuelo(codigoVuelo);
        v.setPuerta(puerta);
        dao.modificarVuelo(v);
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public void modificarPlazasVuelo(String codigoVuelo, int plazas) throws DAOException, ServiciosException {
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        Vuelo v = this.obtenerVuelo(codigoVuelo);
        v.setPlazasDisponibles(plazas);
        dao.modificarVuelo(v);

        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }

    }

    public void modificarFechaVuelo(String codigoVuelo, Date fecha) throws DAOException, ServiciosException {
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        Vuelo v = this.obtenerVuelo(codigoVuelo);
        v.setFechaVuelo(fecha);
        dao.modificarVuelo(v);

        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public void modificarPrecioVuelo(String codigoVuelo, double precio) throws DAOException, ServiciosException {
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        Vuelo v = this.obtenerVuelo(codigoVuelo);
        v.setPrecioPersona(precio);
        dao.modificarVuelo(v);

        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public List<Vuelo> obtenerVuelos() throws DAOException, ServiciosException {
        /**
         * Método que obtiene los vuelos del dao seleccionado
         */
        List<Vuelo> vuelos = dao.obtenerVuelos();
        if (vuelos.isEmpty()) {
            //Si ha habido un problema como que no hay vuelos, creo una excepcion y lo devuelvo desde el Servicio hasta la vista
            throw new ServiciosException(" No hay ningún vuelo.");
        }
        return vuelos;
    }

    public void eliminarVuelo(String codigoVuelo) throws DAOException, ServiciosException {
        //inicializamos transaccion
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).iniciarTransaccion();
        }
        //si hay vuelo saldrá del metodo con el, aun que no se guarde es una devolucion positiva, si no hay volverá con una excepcion
        this.obtenerVuelo(codigoVuelo);

        //se llama al metodo eliminar con el codigoVuelo valido
        dao.eliminarVuelo(codigoVuelo);

        //finalizamos transaccion
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarTransaccion();
        }
    }

    public Vuelo obtenerVuelo(String codigoVuelo) throws ServiciosException, DAOException {
        List<Vuelo>vuelos = dao.obtenerVuelos();
        for(Vuelo v : vuelos){
            if(v.getCodigoVuelo().equals(codigoVuelo)){
                return v;
            }
        }
        throw new ServiciosException("No hay ningun vuelo con el codigo especificado.");
    }

    public void finalizar() throws DAOException{
        if(dao instanceof BaseDeDatos){
            ((BaseDeDatos) dao).finalizarConexion();
        }
    }
}
