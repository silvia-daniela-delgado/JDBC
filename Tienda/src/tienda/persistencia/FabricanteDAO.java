/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.ResultSet;
import java.util.Scanner;
import tienda.entidades.Fabricante;

/**
 *
 * @author dani.delgado
 */
public class FabricanteDAO extends DAO {
    Scanner read = new Scanner(System.in);
    ProductoDAO producto = new ProductoDAO();
    
    public void fabricanteSeleccionar() throws Exception {
        try {
            String sql = "SELECT codigo, nombre FROM fabricante";
            ResultSet result = select(sql);
            while (result.next()){
                System.out.println("Codigo: " + result.getInt("codigo") + ", Nombre: " + result.getString("nombre"));
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void fabricanteInsertar(Fabricante fabricante) throws Exception {
        try {
            String sql = "INSERT INTO fabricante (nombre) VALUES ('" + fabricante.getNombre() + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void cerrarScanner() {
        read.close();
    }
}
