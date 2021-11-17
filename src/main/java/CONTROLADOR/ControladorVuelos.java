package CONTROLADOR;

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
        boolean salir = false;
        do {
            //Ejecuto el menu principal y obtengo la opciona  ejecutar
            int opcion = VistaVuelos.getVistas().mostrarMenuPrincipalVuelos();
            switch (opcion) {
                case 0:
                    System.out.println("Cancelar Menu de Vuelos.");
                    salir=true;
                    break;
                case 1:
                    System.out.println("Crear Vuelo");
                    //this.crearVuelo();
                    break;
                case 2:
                    System.out.println("Mostrar Vuelos");
                    //this.mostrarVuelos();
                    break;
                case 3:
                    System.out.println("Modificar Vuelo");
                    //this.modificarVuelo();
                    break;
                case 4:
                    System.out.println("Eliminar Vuelo");
                    //this.eliminarVuelo();
                    break;
                case 5:
                    System.out.println("Asignar Puerta y Terminal");
                    //this.asignarPuertaYTerminal();
                    break;
            }
        }while(!salir);
    }
}
