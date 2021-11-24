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

    public void menuControladorVuelos(){
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
                    //this.modificarVuelo();
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

    public void crearVuelo(){
        Vuelo v = VistaVuelos.getVistas().crearVuelo();

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
