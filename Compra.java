package piapoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Compra {
    private LocalDate fechaDeCompra;
    private LocalTime horaDeCompra;
    private String clienteNombre;
    private int clienteTelefono;
    private Producto productoComprado;
    
    public Compra(LocalDate fechaDeCompra, LocalTime horaDeCompra, String clienteNombre, int clienteTelefono, Producto productoComprado) {
        this.fechaDeCompra = fechaDeCompra;
        this.horaDeCompra = horaDeCompra;
        this.clienteNombre = clienteNombre;
        this.clienteTelefono = clienteTelefono;
        this.productoComprado = productoComprado;
    }
    
    @Override
    public String toString() {
        return "========== Vapor - TICKET DE COMPRA ==========\n"
        + "Hola, " + clienteNombre + "\n"
        + "¡Muchas gracias por tu preferencia!\n\n\n"
        + "Producto: " + productoComprado.getNombre() + "\n"
        + "Total: " + productoComprado.getPrecio() + "\n"
        + "Fecha de compra: " + this.fechaDeCompra.toString() + " " + this.horaDeCompra.toString() + "\n"
        + "==============================================";
    }
    
    public LocalDate getFechaDeCompra() {
        return this.fechaDeCompra;
    }
    
    public void setFechaDeCompra(LocalDate fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }
    
    public LocalTime getHoraDeCompra() {
        return this.horaDeCompra;
    }
    
    public void setHoraDeCompra(LocalTime horaDeCompra) {
        this.horaDeCompra = horaDeCompra;
    }
    
    public String getNombreDelCliente() {
        return this.clienteNombre;
    }
    
    public int getTelefonoDelCliente() {
        return this.clienteTelefono;
    }
    
    public Producto getProductoComprado() {
        return this.productoComprado;
    }
    
    public static Compra generarCompra(Vendedor vendedor) {
        Scanner escaner = new Scanner(System.in);
        int opcion1;
        
        LocalDate fechaDeCompra = LocalDate.now();
        LocalTime horaDeCompra = LocalTime.now();
        String nombreDelCliente;
        int telefonoDelCliente;
        Producto productoComprado = null;
        
        String introduccion;
        
        do {
            System.out.println("¿Cuál es el nombre del cliente?");
            nombreDelCliente = escaner.nextLine();
            if (nombreDelCliente.length() == 0)
                System.out.println("El nombre introducido es inválido.");
        } while (nombreDelCliente.length() == 0);
        
        do {
            System.out.println("¿Cuál es el número de teléfono del cliente?");
            introduccion = escaner.nextLine();
            telefonoDelCliente = Integer.valueOf(introduccion);
        }
        while (telefonoDelCliente == 0);
        
        do {
            do {
                System.out.println("¿Cuál es el SKU del juego que se desea comprar?");
                introduccion = escaner.nextLine();
                productoComprado = vendedor.getProductoPorSku(Long.valueOf(introduccion));
                if (productoComprado == null)
                    System.out.println("El SKU introducido es inválido.");
            } while (productoComprado == null);
            
            System.out.println("¿El producto seleccionado es '" + productoComprado.getNombre() + "'?\n1) Sí\n2) No");
            introduccion = escaner.nextLine();
            opcion1 = Integer.valueOf(introduccion);
            
            if (opcion1 < 1 || opcion1 > 2)
                System.out.println("Opción inválida.");
        } while (opcion1 < 1 || opcion1 > 2);
        
        Compra compra = new Compra(fechaDeCompra, horaDeCompra, nombreDelCliente, telefonoDelCliente, productoComprado);
        return compra;
    }
}