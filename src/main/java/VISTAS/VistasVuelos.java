package VISTAS;

import java.util.Scanner;

public class VistasVuelos {
    static Scanner sc = new Scanner(System.in);
    private VistasVuelos(){

    }
    private static VistasVuelos vistasVuelos;
    public static VistasVuelos getVistas(){
        if (vistasVuelos == null) {
            vistasVuelos = new VistasVuelos();
        }
        return vistasVuelos;
    }




}

