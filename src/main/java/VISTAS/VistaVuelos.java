package VISTAS;

import java.util.Scanner;

public class VistaVuelos {
    static Scanner sc = new Scanner(System.in);
    private VistaVuelos(){

    }
    private static VistaVuelos vistasVuelos;
    public static VistaVuelos getVistas(){
        if (vistasVuelos == null) {
            vistasVuelos = new VistaVuelos();
        }
        return vistasVuelos;
    }

    public int mostrarMenuPrincipalVuelos(){
        int opcion=-1;
        do {
            System.out.println("\n----Menu Vuelos-----");
            System.out.println("1. Crear Vuelo");
            System.out.println("2. Mostrar Vuelos");
            System.out.println("3. Modificar Vuelo");
            System.out.println("4. Eliminar Vuelo");
            System.out.println("0. Volver al Menú Principal");
            String entrada = sc.nextLine();
            if (!esEntero(entrada)) {
                opcion = -1;
            } else {
                opcion = Integer.parseInt(entrada);
            }
            if (opcion<0 || opcion>4){
                System.out.println("Opcion no valida.");
                opcion=-1;
            }
        }while(opcion == -1);
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




}

