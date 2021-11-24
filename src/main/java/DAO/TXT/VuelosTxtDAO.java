package DAO.TXT;

import CLASES.Configuracion;
import CLASES.Vuelo;
import DAO.DAOException;
import DAO.IVuelosDAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VuelosTxtDAO implements IVuelosDAO {

    //Variable con la ruta del archivo
    private String archivoVuelo = null;
    private List<Vuelo> vuelos = null;

    public VuelosTxtDAO() throws DAOException{
        //Creo el objeto configuración que contendrá los metodos con acceso a los respectivos parametros de acceso a los archivos
        Configuracion configuracion=new Configuracion("/configuracion.propierties");
        //Asigno el valor del metodo de vuelos en TXT
        this.archivoVuelo=configuracion.getTxtVuelos();
    }


    //Implementamos los metodos de la interfaz, desde aqui tendremos acceso a la BD
    @Override
    public void crearVuelo(Vuelo vuelo) throws DAOException {

    }

    @Override
    public void modificarVuelo(Vuelo v) throws DAOException {

    }
    /*
    @Override
    public void eliminarVuelo(String codigo) throws DAOException {
        //obtengo la lista con todos
        List<Vuelo>vuelos = this.sacarVuelosTxt();

        //lo obtengo via codigo
        Vuelo vueloAEliminar = this.obtenerVuelo(codigo);

        //elimino el vuelo de la lista
        vuelos.remove(vueloAEliminar);

        //inserto la lista en la BD
        this.guardarVuelosTxt(vuelos);
    }*/
    @Override
    public void eliminarVuelo(String codigo) throws DAOException {

        this.vuelos = this.sacarVuelosTxt();

        this.vuelos.remove(this.obtenerVuelo(codigo));

        //inserto la lista en la BD
        this.guardarVuelosTxt(vuelos);
    }

    public void guardarVuelosTxt(List<Vuelo> vuelos) throws DAOException {
        //Intento escribir en el archivo, false para que reemplace los datos
        try ( PrintWriter pw = new PrintWriter(new FileWriter(archivoVuelo, false))) {
            for (Vuelo v : vuelos) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaStr = sdf.format(v.getFechaVuelo());
                //preparo las cadenas a insertar con # de separacion de campos
                String cadena = v.getCodigo() + "#" + v.getOrigen() + "#" + v.getDestino() + "#" + v.getPrecioPersona()
                        + "#" + fechaStr + "#" + v.getPlazasDisponibles() + "#" + v.getPuerta() + "#" + v.getTerminal();
                //inserto la cadena en la BD
                pw.println(cadena);
            }

        } catch (Exception e) {
            throw new DAOException(
                    "Ha habido un problema al guardar los vuelos en el archivo de texto:", e);
        }
    }

    /*
    @Override
    public Vuelo obtenerVuelo(String codigo) throws DAOException {
        List<Vuelo>vuelos = sacarVuelosTxt();
        //creo un nuevo vuelo con el codigo asignado
        Vuelo vuelo = new Vuelo();
        vuelo.setCodigo(codigo);
        //si la lista contiene ese vuelo
        if(vuelos.contains(vuelo)){
            //la recorro
            for(Vuelo v : vuelos){
                //cuando el vuelo coincida con el de la lista, se devuelve
                if(v.equals(vuelo)){
                    return v;
                }
            }
        }
        //si no lo contenia devuelve null como que no está
        return null;
    }*/
    @Override
    public Vuelo obtenerVuelo(String codigo) throws DAOException {
        if(vuelos == null)
            this.vuelos = sacarVuelosTxt();

        //la recorro
        for(Vuelo v : this.vuelos){
            //cuando el vuelo coincida con el de la lista, se devuelve
            if(v.getCodigo().equals(codigo)){
                return v;
            }
        }
        //si no lo contenia devuelve null como que no está
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos(Date fechaSalida) throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos(Date fechaInicio, Date fechaFin) throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelosSinPlazas() throws DAOException {
        return null;
    }

    @Override
    public List<Vuelo> obtenerVuelos() throws DAOException{
        return this.sacarVuelosTxt();
    }

    public List<Vuelo> sacarVuelosTxt() throws DAOException {
        //Creo una lista para añadirlos aqui y devolverlos
        List<Vuelo> vuelos = new ArrayList<>();
        //Intento acceder al archivo con BufferedReader con la ruta del archivo
        try ( BufferedReader br = new BufferedReader(new FileReader(archivoVuelo))) {
            String linea;
            //Mintras encuentre una linea no vacia leera el bloque
            while ((linea = br.readLine()) != null) {
                //Guardo en un array de String todos los valores de la linea separando por #
                String[] datos = linea.split("#");
                String codigo = datos[0];
                String origen = datos[1];
                String destino = datos[2];
                double precioPersona = Double.parseDouble(datos[3]);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaVuelo = sdf.parse(datos[4]);

                int plazasDisponibles = Integer.parseInt(datos[5]);
                int terminal = Integer.parseInt(datos[7]);
                int puerta = Integer.parseInt(datos[6]);
                //Creo un objeto vuelo con los parametros obtenidos
                Vuelo v=new Vuelo(codigo, origen, destino, precioPersona, fechaVuelo, plazasDisponibles);
                v.setTerminal(terminal);
                v.setPuerta(puerta);
                //Añado el vuelo a la lista
                vuelos.add(v);

            }
            //Devuelvo la lista con todos los vuelos
            return vuelos;

        } catch (Exception e) {
            //Si no ha podido acceder al txt, creo una excepcion desde el dao y la envío hacia las vistas
            throw new DAOException(" Ha habido un problema al obtener los vuelos desde el archivo de texto.",e);
        }
    }
}
