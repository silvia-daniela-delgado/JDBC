package tienda;

import java.util.Scanner;
import tienda.service.FabricanteService;
import tienda.service.ProductoService;

/**
 *
 * @author dani.delgado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);
    static ProductoService producto = new ProductoService();
    static FabricanteService fabricante = new FabricanteService();
    
    public static void main(String[] args) {

        try {
            int operacion = 0;
            while (operacion != 9) {
                System.out.println("Menu");
                System.out.println("1. Listar el nombre de todos los productos");
                System.out.println("2. Listar el nombre y precio de todos los productos");
                System.out.println("3. Listar los productos cuyo precio esté entre 120 y 202");
                System.out.println("4. Listar todos los portátiles");
                System.out.println("5. Listar el nombre y precio del producto más barato");
                System.out.println("6. Crear nuevo producto");
                System.out.println("7. Crear nuevo fabricante");
                System.out.println("8. Editar producto");
                System.out.println("9. Salir");
                operacion = leer.nextInt();
                switch (operacion) {
                    case 1:
                        producto.todoProductos();
                        break;
                    case 2:
                        producto.listarNombreYPrecioDeProductos();
                        break;
                    case 3:
                        producto.listarProductosRangoDePrecio();
                        break;
                    case 4:
                        producto.listarPortatiles();
                        break;
                    case 5:
                        producto.listarProductoMasBarato();
                        break;
                    case 6:
                        producto.insertarProductos();
                        break;
                    case 7:
                        fabricante.fabricanteInsertar();
                        break;
                    case 8:
                        producto.modificarProductos();
                        break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                    case 10:
                        System.out.println("Operacion terminada, Adios");
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            producto.cerrarScanner();
            fabricante.cerrarScanner();
            leer.close(); 
        }
    }
}


