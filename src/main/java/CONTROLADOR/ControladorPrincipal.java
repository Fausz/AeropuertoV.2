package CONTROLADOR;

import DAO.DAOException;
import SERVICIOS.ServiciosVuelos;
import VISTAS.VistaPrincipal;
import VISTAS.VistaVuelos;

public class ControladorPrincipal {

    //Instanciamos las clases de vistas a null para poder usarlas con esta clase pero en el constructor le damos la instanciacion de la misma
    //private VistaVuelos vv = null;
    private static boolean modo_depuracion = true;

    public ControladorPrincipal() {
        /**
         * Metodo constructor que creará la instancia a la clase vuelos para tener acceso a ella
         */
        //vv = new VistaVuelos();
    }

    public void iniciar_aplicacion() {
        /**
         * Metodo que selecciona el tipo de almacenamiento que se usará, tras ello ejecutará el menú de la aplicacion con acceso a ese almacenamiento
         */
        int sistemaAl = VistaPrincipal.getVistas().elegirSistemaAlmacenamiento();
        if (sistemaAl == 0) {
            //salimos de la aplicacion
            return;

        } else {
            //acceso a una clase Singleton
            //como se ve no hace falta una instancia concreta
            // Esta clase controlador y la clase vistas también la podróamos haber
            //hecho así
            try {
                //En servicio se guardará el tipo de almacenamiento que se elija, para instanciar la clase via singleton
                ServiciosVuelos.getServicio().elegirSistemaAlmacenamiento(sistemaAl);
                //tras haber guardado el tipo de almacenamiento se ejecuta el menu principal
                this.iniciar_menu_principal();

            } catch (DAOException e) {
                VistaPrincipal.getVistas().mostrarError("Error al iniciar sistema de almacenamiento \n" + e.getMessage());
                if (modo_depuracion) {
                    //esto de aquí abajo solo para depuración
                    e.printStackTrace();
                }
            }
        }
    }

    private void iniciar_menu_principal(){
        do {
            //Ejecuto el menu principal y obtengo la opciona  ejecutar
            int opcion = VistaPrincipal.getVistas().mostrarMenuPrincipal();
            switch (opcion) {
                case 0:
                    System.out.println("Fin del Programa.");
                    try {
                        ServiciosVuelos.getServicio().finalizar();
                    } catch (DAOException dao) {
                        VistaVuelos.mostrarError("Ha habido un error al finalizar la conexion " + dao.getMessage());
                    }
                    return;
                case 1:
                    System.out.println("Gestionar Vuelos");
                    ControladorVuelos.getControladorVuelos().menuControladorVuelos();
                    break;
                case 2:
                    System.out.println("Gestionar Reservas");
                    break;
                case 3:
                    System.out.println("Gestionar Informes");
                    break;
            }
        }while(true);
    }

}
