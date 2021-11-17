package SERVICIO;

import DAO.DAOException;
import DAO.IVuelosDAO;
import DAO.TXT.VuelosTxtDAO;

public class ServicioVuelos {

    //Aqui guardaremos la instancia del tipo de almacenamiento que se haya elegido para poder usar ese tipo en concreto
    private IVuelosDAO idao = null;

    //Ejemplo del patrón singleton
    // El constructor es privado
    private ServicioVuelos() {
    }

    //Hay una única instancia que se invoca usando a la clase
    private static ServicioVuelos servicioVuelos;

    public static ServicioVuelos getServicio() {
        if (servicioVuelos == null) {
            servicioVuelos = new ServicioVuelos();
        }
        return servicioVuelos;
    }
    // También lo podríamos haber usado para la clase controlador
    //y para la clase de vistas

    public void elegirSistemaAlmacenamiento(int opcion) throws DAOException {

        if (opcion == 1) {
            idao = new VuelosTxtDAO();
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
}
