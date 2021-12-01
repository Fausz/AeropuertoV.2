package VISTAS;

import CONTROLADOR.ControladorReservas;

import java.util.Scanner;

public class VistasReservas {
    private VistasReservas() {
    }
    public static Scanner sc = new Scanner(System.in);
    private static VistasReservas vistasReservas;
    public static VistasReservas getVistas(){
        if(vistasReservas == null){
            vistasReservas = new VistasReservas();
        }
        return vistasReservas;
    }
    /*"  1. Nuevo Reserva. \n"
                    + "2.Ver Reserva \n "
                    + "3.Ver reserva de un vuelo. \n "
                    + "4.Modificar Reserva. \n "
                    + "5.Generar tarjetas de embarque de una reserva. \n "
                    + "6.Cancelar Reserva. \n"
                    + "0)Salir \n "*/
    public int mostrarMenuPrincipalReservas(){
        int opcion=-1;
        String entrada;
        do {
            System.out.println("----MENU RESERVAS----");
            System.out.println("1 - Crear Reserva");
            System.out.println("2 - Ver Reservas");
            System.out.println("3 - Ver Reservas de un Vuelo");
            System.out.println("4 - Modificar una Reserva");
            System.out.println("5 - Generar Tarjetas de Embarque de una Reserva");
            System.out.println("6 - Cancelar Reserva");
            System.out.println("0 - Salir");
            System.out.println("Introduce una opción: ");
            entrada = sc.nextLine();
            if(!esEntero(entrada)){
                System.err.println("No has introducido un caracter numerico.");
            }else{
                opcion = Integer.parseInt(entrada);
            }
            if (opcion<0 || opcion>6){
                System.out.println("Opcion no valida.");
                opcion=-1;
            }
        }while(opcion==-1);
        return opcion;
    }

    private static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean esDecimal(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }
}
