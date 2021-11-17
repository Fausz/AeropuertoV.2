package SERVICIO;

public class ServicioException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3249803612006121332L;
	public ServicioException(String msg, Exception e) {
        super(msg,e);
    }
	public ServicioException(String msg) {
        super(msg);
    }

}
