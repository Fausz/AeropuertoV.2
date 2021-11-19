package VISTAS;

import CLASES.Vuelo;

import java.text.SimpleDateFormat;
import java.util.List;
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

    public String obtenerCodigoVuelo(){
        String codigo;
        System.out.println("Inserta el codigo del vuelo (0 para salir): ");
        codigo = sc.nextLine();
        if(codigo.equals("0")){
            return null;
        }
        return codigo;
    }

    public static void mostrarVuelos(List<Vuelo> vuelos) {
        System.out.println("\n--------------- VUELOS -------------");
        System.out.println("CÓDIGO    ORIGEN   DESTINO    P/PERS     FECHA     PLAZAS_DISP    TERMINAL    PUERTA");
        String fechaStr;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Vuelo v : vuelos) {
            fechaStr = sdf.format(v.getFechaVuelo());
            System.out.printf("%-8s  %-8s %-10s %-6.2f   %-10s  %-14d %-11d %-8d \n", v.getCodigo(), v.getOrigen(), v.getDestino(), v.getPrecioPersona(), fechaStr, v.getPlazasDisponibles(), v.getTerminal(), v.getPuerta());
        }

    }



    private static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }

}

