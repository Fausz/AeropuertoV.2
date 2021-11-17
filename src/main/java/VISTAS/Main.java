package VISTAS;

import CONTROLADOR.ControladorAeropuerto;

public class Main {
    public static void main(String[] args) {
        //Creamos el objeto controlador para poder gestionar la aplicacion desde ahi
        ControladorAeropuerto ca= new ControladorAeropuerto();
        ca.iniciar_aplicacion();
    }
}
