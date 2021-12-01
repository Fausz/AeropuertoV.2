package CONTROLADOR;

import DAO.DAOException;
import SERVICIOS.ServiciosException;
import SERVICIOS.ServiciosReservas;
import VISTAS.VistasReservas;

public class ControladorReservas {

    private ControladorReservas(){}
    private static ControladorReservas controladorReservas;
    public static ControladorReservas getControladorReservas(){
        if(controladorReservas == null){
            controladorReservas = new ControladorReservas();
        }
        return controladorReservas;
    }

    public void menuControladorReservas(){
        do {
            /*"  1. Nuevo Reserva. \n"
                + "2.Ver Reserva \n "
                + "3.Ver reserva de un vuelo. \n "
                + "4.Modificar Reserva. \n "
                + "5.Generar tarjetas de embarque de una reserva. \n "
                + "6.Cancelar Reserva. \n"
                + "0)Salir \n "*/
            int opcion = VistasReservas.getVistas().mostrarMenuPrincipalReservas();
            switch (opcion){
                case 0:
                    return;
                case 1:
                    System.out.println("--Nueva Reserva--");
                    break;
                case 2:
                    System.out.println("--Ver Reservas--");
                    this.mostrarReservas();
                    break;
                case 3:
                    System.out.println("--Ver Reservas de un Vuelo--");
                    break;
                case 4:
                    System.out.println("--Generar Tarjetas de Embarque de una Reserva--");
                    break;
                case 5:
                    System.out.println("--Cancelar Reserva--");
                    break;
            }
        }while(true);
    }

    private void mostrarReservas(){
        try {
            VistasReservas.getVistas().mostrarReservas(ServiciosReservas.getServicio().obtenerReservas());
        }catch (DAOException DAO){
            VistasReservas.mostrarError("Error al intentar obtener las reservas "+DAO);
        }catch (ServiciosException se){
            VistasReservas.mostrarError("Error al intentar mostrar las reservas "+se);
        }
    }
}
