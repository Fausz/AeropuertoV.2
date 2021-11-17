package VISTAS;

import java.util.Scanner;

public class VistaPrincipal {
    static Scanner sc = new Scanner(System.in);
    private VistaPrincipal(){

    }
    private static VistaPrincipal vistasPrincipal;
    public static VistaPrincipal getVistas(){
        if (vistasPrincipal == null) {
            vistasPrincipal = new VistaPrincipal();
        }
        return vistasPrincipal;
    }

    public int mostrarMenuPrincipal(){
        int opcion=-1;
        do {
            System.out.println("\n----Menu Principal-----");
            System.out.println("1. Gestionar Vuelos");
            System.out.println("2. Gestionar reservas");
            System.out.println("3. Informes");
            System.out.println("0. Salir");
            String entrada = sc.nextLine();
            if (!esEntero(entrada)) {
                opcion = -1;
            } else {
                opcion = Integer.parseInt(entrada);
            }
            if (opcion<0 || opcion>3){
                System.out.println("Opcion no valida.");
                opcion=-1;
            }
        }while(opcion == -1);
        return opcion;
    }


    public int elegirSistemaAlmacenamiento(){
        int opcion = -1; //opcio -1 indica opcion incorrecta
        while (opcion == -1) {
            System.out.println("Introduzca El tipo de sistema de almacenamiento");
            System.out.println("1. Archivo de texto");
            System.out.println("2. Archivo Binario");
            System.out.println("3. Archivo XML usando DOM");
            System.out.println("4. Archivo XML usando SAX");
            System.out.println("5. Base de datos relacional usando JDBC");
            System.out.println("6. Base de datos relacional usando Hibernate");
            System.out.println("7. Base de datos documental con MongoDB");
            System.out.println("0. Salir");

            String entrada = sc.nextLine();

            //Si no se logra parsear a int asignara -1 y repetirá el bucle
            if (!esEntero(entrada)) {
                opcion = -1;
            } else {
                //si lo logra parsear se asigna
                opcion = Integer.parseInt(entrada);
            }
            if (opcion >= 8 || opcion < 0) {
                //Si no está dentro del rango del menu asigna a -1 para repetir el bucle
                System.out.println("Opcion No valida");
                opcion = -1;
            }
        }
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
    public void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }
}
