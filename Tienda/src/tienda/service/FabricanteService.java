package tienda.service;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author dani.delgado
 */
public class FabricanteService {
    Scanner read = new Scanner(System.in);
    FabricanteDAO fabri = new FabricanteDAO();
    
    public void fabricanteInsertar() throws Exception {
        try {
            System.out.println("Ingrese el nombre del fabricante");
            String nombre = read.nextLine();
            
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabri.fabricanteInsertar(fabricante);
        } catch (Exception e) {
            System.out.println("Error al insertar el fabricante: " + e.getMessage());
        }
    }
    
    public void cerrarScanner() {
        read.close();
    }
}
