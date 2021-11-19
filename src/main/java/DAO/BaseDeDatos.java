package DAO;

public interface BaseDeDatos {
    void finalizarConexion() throws DAOException;
    void iniciarTransaccion() throws DAOException;
    void finalizarTransaccion() throws DAOException;
}
