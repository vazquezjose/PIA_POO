package piapoo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
    private LocalDate fechaDeCompra;
    private LocalTime horaDeCompra;
    private Cliente cliente;
    private Producto productoComprado;
    
    public Compra(LocalDate fechaDeCompra, LocalTime horaDeCompra, Cliente cliente, Producto productoComprado) {
        this.fechaDeCompra = fechaDeCompra;
        this.horaDeCompra = horaDeCompra;
        this.cliente = cliente;
        this.productoComprado = productoComprado;
    }
    
    @Override
    public String toString() {
        return "========== Vapor - TICKET DE COMPRA ==========\n"
        + "Hola, " + cliente.getNombre() + "\n"
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
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public Producto getProductoComprado() {
        return this.productoComprado;
    }
}