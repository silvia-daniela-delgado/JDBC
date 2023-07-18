package tienda.persistencia;

import java.sql.*;

/**
 *
 * @author dani.delgado
 */
public abstract class DAO {
    protected Connection coneccion = null;
    protected Statement statement = null;
    protected ResultSet result = null;
    
    private final String URL = "jdbc:mysql://localhost:3306/tienda?useSSl=false";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            coneccion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    protected void desconectarBase() throws Exception {
        try {
            if (result != null){
                result.close();
            }
            if (statement != null){
                statement.close();
            }
            if (coneccion != null){
                coneccion.close();
            }
        } catch (Exception ex){
            throw ex;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            statement = coneccion.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    
    protected ResultSet select(String sql) throws Exception {
        try {
            conectarBase();
            statement = coneccion.createStatement();
            result = statement.executeQuery(sql);
            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
