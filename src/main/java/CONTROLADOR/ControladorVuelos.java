package CONTROLADOR;

import CLASES.Vuelo;
import DAO.DAOException;
import SERVICIOS.ServiciosException;
import SERVICIOS.ServiciosVuelos;
import VISTAS.VistaVuelos;

public class ControladorVuelos {
    private ControladorVuelos(){}
    private static ControladorVuelos controladorVuelos;
    public static ControladorVuelos getControladorVuelos(){
        if(controladorVuelos == null){
            controladorVuelos = new ControladorVuelos();
        }
        return controladorVuelos;
    }

    public void menuControladorVuelos() throws DAOException, ServiciosException {
        do {
            //Ejecuto el menu principal y obtengo la opciona  ejecutar
            int opcion = VistaVuelos.getVistas().mostrarMenuPrincipalVuelos();
            switch (opcion) {
                case 0:
                    System.out.println("Cancelar Menu de Vuelos.");
                    return;
                case 1:
                    System.out.println("Crear Vuelo");
                    this.crearVuelo();
                    break;
                case 2:
                    this.mostrarVuelos();
                    break;
                case 3:
                    System.out.println("Modificar Vuelo");
                    this.modificarVuelo();
                    break;
                case 4:
                    System.out.println("Eliminar Vuelo");
                    this.eliminarVuelo();
                    break;
                case 5:
                    System.out.println("Asignar Puerta y Terminal");
                    //this.asignarPuertaYTerminal();
                    break;
            }
        }while(true);
    }

    public void modificarVuelo() throws DAOException, ServiciosException {
        try {
            VistaVuelos.mostrarVuelos(ServiciosVuelos.getServicio().obtenerVuelos());
            String codigo = VistaVuelos.getVistas().obtenerCodigoVuelo();
            if (codigo == null) {
                return;
            }
            Integer opcion;
            opcion = VistaVuelos.getVistas().menuModificarVuelo();
            if (opcion != null) {
                switch (opcion){
                    case 1:
                        Double precio = VistaVuelos.getVistas().pedirPrecioPersonaVuelo();
                        if(precio != null){
                            ServiciosVuelos.getServicio().modificarPrecioVuelo(codigo, precio);
                        }
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                }
            }
        }catch (DAOException dao) {
            VistaVuelos.mostrarError("Error al intentar obtener los datos: " + dao.getMessage());
        } catch (ServiciosException se) {
            VistaVuelos.mostrarError("Error al modificar un vuelo: " + se.getMessage());
        }
    }

    public void crearVuelo(){
        Vuelo v = VistaVuelos.getVistas().crearVuelo();
        try{
            if(v != null){
                ServiciosVuelos.getServicio().crearVuelo(v);
            }

        }catch (ServiciosException se){
            VistaVuelos.mostrarError("Ha habido un problema al insertar el vuelo: " + se.getMessage());
        }catch (DAOException DAO){
            VistaVuelos.mostrarError("Ha habido un error al obtener los datos: " + DAO.getMessage());
        }
    }

    public void eliminarVuelo(){
        try{
            VistaVuelos.mostrarVuelos(ServiciosVuelos.getServicio().obtenerVuelos());
            String codigo = VistaVuelos.getVistas().obtenerCodigoVuelo();
            if(codigo==null){
                return;
            }
            ServiciosVuelos.getServicio().eliminarVuelo(codigo);

        }catch (DAOException dao){
            VistaVuelos.mostrarError("Error al intentar obtener los datos en " + dao);
        }catch (ServiciosException se) {
            //Si ha habido un error desde el Servicio muestro el error del Servicio
            VistaVuelos.mostrarError("Error al eliminar un vuelo: " + se.getMessage());
        }
    }

    public void mostrarVuelos() {
        /**
         * Método que nos mostrará los vuelos obtenidos del Servicio desde la vista.
         */
        try {
            VistaVuelos.mostrarVuelos(ServiciosVuelos.getServicio().obtenerVuelos());
        } catch (DAOException dao) {
            //Si ha habido un error desde el DAO muestro el error del DAO
            VistaVuelos.mostrarError("Error al intentar obtener los datos en " + dao);
        } catch (ServiciosException se) {
            //Si ha habido un error desde el Servicio muestro el error del Servicio
            VistaVuelos.mostrarError("Error al intentar mostrar los datos en " + se);
        }
    }
}
