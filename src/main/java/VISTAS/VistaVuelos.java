package VISTAS;

import CLASES.Vuelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public Vuelo crearVuelo(){

        String codigo = this.pedirCodigoVuelo();
        if(codigo == null){
            return null;
        }

        String origen = this.pedirOrigenVuelo();
        if(origen == null){
            return null;
        }

        String destino = this.pedirDestinoVuelo();
        if(destino == null){
            return null;
        }

        Double precio = this.pedirPrecioPersonaVuelo();
        if(precio == null){
            return null;
        }

        Date fecha = this.pedirFechaVuelo();
        if(fecha == null){
            return null;
        }

        //Plazas disponibles del vuelo
        Integer plazasDisponibles = this.pedirPlazasDisponibles();
        if (plazasDisponibles == null) {
            return null;
        }

        return new Vuelo(codigo,origen,destino,precio,fecha,plazasDisponibles);

    }

    public Integer menuModificarVuelo(){
        String entrada;
        int opcion;
        do{
            System.out.println("\n-----Menu Modificar Vuelo-----");
            System.out.println("1 - Precio por persona");
            System.out.println("2 - Fecha");
            System.out.println("3 - Plazas disponibles");
            System.out.println("4 - Terminal");
            System.out.println("5 - Puerta");
            System.out.println("0 - Salir");
            entrada = sc.nextLine();
            if(entrada.equals("0")){
                return null;
            }
            if(!esEntero(entrada)){
                System.err.println("Introduce una opcion valida.");
            }else{
                opcion=Integer.parseInt(entrada);
                if(opcion<=5 || opcion>=1) {
                    return opcion;
                }
            }
        }while(true);

    }

    private String pedirCodigoVuelo(){
        String respuesta;
        do{
            System.out.println("Introduce el codigo de vuelo (0 para cancelar): ");
            respuesta = sc.nextLine();
            if(respuesta.equals("0")){
                return null;
            }
            if(respuesta.length()!=8){
                System.err.println("El codigo tiene que tener 8 caracteres.");
            }
        }while(respuesta.length()!=8);
        return respuesta;
    }

    private String pedirOrigenVuelo(){
        String respuesta;
        do{
            System.out.println("Introduce el origen del vuelo (0 para cancelar): ");
            respuesta = sc.nextLine().toUpperCase();
            if(respuesta.equals("0")){
                return null;
            }
            if(respuesta.length()!=3){
                System.err.println("El origen tiene que tener 3 caracteres.");
            }
        }while(respuesta.length()!=3);
        return respuesta;
    }

    private String pedirDestinoVuelo(){
        String respuesta;
        do{
            System.out.println("Introduce el destino del vuelo (0 para cancelar): ");
            respuesta = sc.nextLine().toUpperCase();
            if(respuesta.equals("0")){
                return null;
            }
            if(respuesta.length()!=3){
                System.err.println("El destino tiene que tener 3 caracteres.");
            }
        }while(respuesta.length()!=3);
        return respuesta;
    }

    public Double pedirPrecioPersonaVuelo(){
        String entrada;
        double precio;
        do{
            System.out.println("Introeduce el precio del vuelo (0 para cancelar): ");
            entrada = sc.nextLine();
            if(entrada.equals("0")){
                return null;
            }
            if(!esDecimal(entrada)){
                System.err.println("El precio ha de ser un numero decimal.");
            }else{
                precio=Double.parseDouble(entrada);

                if(precio <=0){
                    System.err.println("No hay vuelos gratis o negativos.");
                }else{
                    return precio;
                }
            }
        }while (true);
    }

    private Date pedirFechaVuelo(){
        String respuesta;
        Date fecha;
        do{
            System.out.println("Introduce una fecha en formato dd/mm/yyyy (0 para cancelar): ");
            respuesta = sc.nextLine();
            if(respuesta.equals("0")){
                return null;
            }
            fecha = obtenerFecha(respuesta);
            if (fecha == null) {
                System.err.println("El formato de fecha no es valido");
            }
        }while(fecha == null);
        return fecha;
    }
    private Integer pedirPlazasDisponibles(){
    String respuesta;
    Integer numEntero = null;
        do {
        System.out.println("Introduzca el número de plazas disponibles.");
        respuesta = sc.nextLine();
        if (!esEntero(respuesta)) {
            System.err.println("El número de plazas debe ser un número");
        } else {
            numEntero = Integer.parseInt(respuesta);
            if (numEntero == 0) {
                //salimos
                return null;
            } else if (numEntero < 0) {
                System.err.println("El número de plazas ha de ser positivo");
            } else {
                return numEntero;
            }
        }
    } while (true);
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

    private static Date obtenerFecha(String cadena) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNac = null;
        try {
            fechaNac = sdf.parse(cadena);
            return fechaNac;
        } catch (ParseException ex) {
            // si no es fecha devolvemos un null
            return null;
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

