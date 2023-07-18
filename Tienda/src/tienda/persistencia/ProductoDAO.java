/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.ResultSet;
import tienda.entidades.Producto;

/**
 *
 * @author dani.delgado
 */
public class ProductoDAO extends DAO {
    public void productoTodos() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            ResultSet result = select(sql);
            while (result.next()) {
                System.out.println("Nombre: " + result.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productoNombrePrecio() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            ResultSet result = select(sql);
            while (result.next()) {
                System.out.println("Producto: " + result.getString("nombre") + ", Precio: " + result.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productoPrecioEntre() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto WHERE precio BETWEEN 120 AND 200";
            ResultSet result = select(sql);
            while (result.next()) {
                System.out.println("Nombre: " + result.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productoPortatil() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE nombre LIKE 'Portatil%'";
            ResultSet result = select(sql);
            while (result.next()) {
                System.out.println("Nombre: " + result.getString("nombre") + ", Precio: " + result.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productoBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto ORDER BY PRECIO LIMIT 1";
            ResultSet result = select(sql);
            while (result.next()) {
                System.out.println("Nombre: " + result.getString("nombre") + ", Precio: " + result.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productoInsertar(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("El Producto es nulo (null)");
            }
            String sql = "INSERT INTO producto (nombre, precio, odigo_fabricante) VALUES ('" + producto.getNombre()
                + "', " + producto.getPrecio() + ", " + producto.getCodigoFabricante() + ")";
                insertarModificarEliminar(sql);
        } catch (Exception e) {
        throw e;
        }
    }
    
    public void productoModificar(Producto producto, String nombreProducto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("El Producto es nulo (null)");
            }
            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio()
                +", codigo_fabricante = " + producto.getCodigoFabricante() + "WHERE nombre = '" + nombreProducto
                + "';";    
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
