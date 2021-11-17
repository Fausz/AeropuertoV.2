package VISTAS;

import CONTROLADOR.ControladorPrincipal;

public class Main {
    public static void main(String[] args) {
        //Creamos el objeto controlador para poder gestionar la aplicacion desde ahi
        ControladorPrincipal ca= new ControladorPrincipal();
        ca.iniciar_aplicacion();
    }
}
