/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.service;

import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.FabricanteDAO;
import tienda.persistencia.ProductoDAO;
/**
 *
 * @author dani.delgado
 */
public class ProductoService {
    ProductoDAO produc = new ProductoDAO();
    FabricanteDAO fabric = new FabricanteDAO();
    Scanner read = new Scanner(System.in);
    
    public void todoProductos() {
        try {
            produc.productoTodos();
        } catch (Exception e) {
            System.out.println("Error al listar todos los productos: " + e.getMessage());
        }
    }
    
     public void listarNombreYPrecioDeProductos() {
        try {
            produc.productoNombrePrecio();
        } catch (Exception e) {
            System.out.println("Error al listar nombres y precios de productos: " + e.getMessage());
        }
    }
    
    public void listarProductosRangoDePrecio() {
        try {
            produc.productoPrecioEntre();
        } catch (Exception e) {
            System.out.println("Error al listar productos en rango de precios: " + e.getMessage());
        }
    }
    
     public void listarPortatiles() {
        try {
            produc.productoPortatil();
        } catch (Exception e) {
            System.out.println("Error al listar portátiles: " + e.getMessage());
        }
    }

    public void listarProductoMasBarato() {
        try {
            produc.productoBarato();
        } catch (Exception e) {
            System.out.println("Error al listar producto más barato: " + e.getMessage());
        }
    }

    public void insertarProductos() {
        try {
            System.out.println("Ingrese el nombre del producto");
            String nombre = read.nextLine();

            System.out.println("Ingrese el precio del producto");
            double precio = read.nextDouble();

            read.nextLine(); // Consumir el carácter de nueva línea pendiente

            System.out.println("Ingrese el código del fabricante");
            fabric.fabricanteSeleccionar();
            int codigo = read.nextInt();

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigo);
            produc.productoInsertar(producto);

        } catch (Exception e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    public void modificarProductos() {
        try {
            read.nextLine(); // Consumir el carácter de nueva línea pendiente

            System.out.println("Ingrese el nombre del producto a modificar");
            String nombreModificar = read.nextLine();

            System.out.println("Ingrese el nombre del nuevo producto");
            String nombre = read.nextLine();

            System.out.println("Ingrese el precio del nuevo producto");
            double precio = read.nextDouble();

            read.nextLine(); // Consumir el carácter de nueva línea pendiente

            System.out.println("Ingrese el código del fabricante del nuevo producto");
            fabric.fabricanteSeleccionar();
            int fabricante = read.nextInt();

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(fabricante);
            produc.productoModificar(producto, nombreModificar);
        } catch (Exception e) {
            System.out.println("Error al modificar el producto: " + e.getMessage());
        }
    }

    // Cierre del recurso Scanner
    public void cerrarScanner() {
        read.close();
    }
}
