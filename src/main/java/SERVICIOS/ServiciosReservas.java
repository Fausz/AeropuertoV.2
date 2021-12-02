package SERVICIOS;

import CLASES.Reserva;
import DAO.DAOException;
import DAO.IReservasDAO;
import DAO.IVuelosDAO;
import DAO.TXT.ReservasTxtDAO;
import DAO.TXT.VuelosTxtDAO;

import java.util.List;

public class ServiciosReservas {
    //Aqui guardaremos la instancia del tipo de almacenamiento que se haya elegido para poder usar ese tipo en concreto
    private IReservasDAO dao = null;

    //Ejemplo del patrón singleton
    // El constructor es privado
    private ServiciosReservas() {
    }

    //Hay una única instancia que se invoca usando a la clase
    private static ServiciosReservas servicioReservas;

    public static ServiciosReservas getServicio() throws DAOException {
        if (servicioReservas == null) {
            servicioReservas = new ServiciosReservas();
        }
        return servicioReservas;
    }
    // También lo podríamos haber usado para la clase controlador
    //y para la clase de vistas

    public void elegirSistemaAlmacenamiento(int opcion) throws DAOException {

        if (opcion == 1) {
            dao = new ReservasTxtDAO();
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

    public List<Reserva> obtenerReservas() throws ServiciosException, DAOException {

            List<Reserva> reservas = dao.obtenerTodasReservas();

            if(reservas.isEmpty()){
                throw new ServiciosException("No hay ninguna reserva");
            }
        return reservas;
    }
}
