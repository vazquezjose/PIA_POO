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
        guardarTicket(fechaDeCompra, horaDeCompra, cliente, productoComprado);
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
        boolean comprobar;
        LocalDate fechaDeCompra = LocalDate.now();
        LocalTime horaDeCompra = LocalTime.now();
        String nombreDelCliente;
        int telefonoDelCliente;
        Producto productoComprado = null;
        String introduccion;
        String sku;
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
                sku = escaner.nextLine();
                productoComprado = vendedor.getProductoPorSku(Long.valueOf(sku));
                if (productoComprado == null)
                    System.out.println("El SKU introducido es inválido.");
            } while (productoComprado == null);
            comprobar = comprobarExistencias(sku);
            System.out.println("¿El producto seleccionado es '" + productoComprado.getNombre() + "'?\n1) Sí\n2) No");
            introduccion = escaner.nextLine();
            opcion1 = Integer.valueOf(introduccion);
            if(comprobar == false){
            System.out.println("lo sentimos, el producto ya no posee existencias\n");
            }
            
            if (opcion1 < 1 || opcion1 > 2)
                System.out.println("Opción inválida.");
        } while (opcion1 < 1 || opcion1 > 2 || comprobar == false);
            actualizarProducto(sku);
        
        
        
        Compra compra = new Compra(fechaDeCompra, horaDeCompra, nombreDelCliente, telefonoDelCliente, productoComprado);
        return compra;
        
    }
    
    
    public boolean comprobarExistencias(String sku){
    try {
            CsvReader leerProductos = new CsvReader("Productos.csv");
            while (leerProductos.readRecord()) {
                String clave = leerProductos.get(0);
                String cantidadStock = leerProductos.get(3);
                if(sku.equals(clave) && Integer.valueOf(cantidadStock) <= 0){
                    leerProductos.close();
                    return false;
                }
            }
            leerProductos.close();
            return true;
        } catch (FileNotFoundException error) {
            System.out.println("hubo un error al leer el archivo\n");
            return false;
        } catch (IOException error) {
            System.out.println("hubo un error al leer el archivo\n");
            return false;
        }
    }
    
    private void actualizarProducto(String sku) {
        try {
             File auxiliar = new File("temporal.csv");
           CsvWriter registrar = new CsvWriter(new FileWriter("temporal.csv",false), ',');
           CsvReader leer = new CsvReader("Productos.csv");
       
           while(leer.readRecord()){           
                String clave = leer.get(0);
                String nombreProducto = leer.get(1);
                String resumenProducto = leer.get(2);
                String cantidadStock = leer.get(3);
                String precioProducto = leer.get(4);
                registrar.write(clave);
                registrar.write(nombreProducto);
                registrar.write(resumenProducto);
                if(sku.equals(clave)){
                int stockActualizado = Integer.valueOf(cantidadStock) - 1;
                String stock = String.valueOf(stockActualizado);
                    registrar.write(stock);  
                }
                else{
                    registrar.write(cantidadStock);    
                }
                registrar.write(precioProducto);
                registrar.endRecord();
            }
            registrar.close();
            leer.close();
           
           File Usuario = new File("Productos.csv");
           CsvWriter eliminar = new CsvWriter(new FileWriter("Productos.csv",false), ',');
            CsvReader escanear = new CsvReader("Productos.csv");
            while(escanear.readRecord()){           
                String clave = escanear.get(0);
                String nombreProducto = escanear.get(1);
                String resumenProducto = escanear.get(2);
                String cantidadStock = escanear.get(3);
                String precioProducto = escanear.get(4);
                eliminar.write(clave);
                eliminar.write(nombreProducto);
                eliminar.write(resumenProducto);
                eliminar.write(cantidadStock);    
                eliminar.write(precioProducto);
                eliminar.endRecord();
            }
            eliminar.close();
            escanear.close();
        } catch (IOException error) {
            System.out.println("hubo un error en el archivo\n");
        }
    }


private void guardarTicket(LocalDate fechaDeCompra, LocalTime horaDeCompra, String cliente, Producto productoComprado){
        File Historial = new File("historial.csv");
        try {
            CsvWriter historial = new CsvWriter(new FileWriter("historial.csv", true), ',');
            historial.write(fechaDeCompra.toString());
            historial.write(horaDeCompra.toString());
            historial.write(cliente);
            historial.write(productoComprado.getNombre());
            historial.write(String.valueOf(productoComprado.getPrecio()));
            historial.endRecord();
            historial.close();
        } catch (IOException error) {
            System.out.println("hubo un error en el archivo\n");
        }
    }

}