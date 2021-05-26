package piapoo;

class Producto {
    private long sku;
    private String nombre;
    private String resumen;
    private int stock;
    private double precio;
    
    public static long cantidadDeProductos = 0;

    //Constructor
    public Producto() {
        this.sku = cantidadDeProductos; // OJO: No es el SKU final, pero se le dará este valor por default para evitar que se repita
        this.nombre = "";
        this.resumen = "";
        this.stock = 0;
        this.precio = 0.0d; // Gratis por default
        cantidadDeProductos++;
    }

    public Producto(long sku, String nombre, String resumen, int stock, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.resumen = resumen;
        this.stock = stock;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n"
        + "Precio: $" + getPrecio() + " MXN\n"
        + "Disponibilidad: " + this.getStock();
    }
    
    public String getDatosEsenciales() {    // usado por el "Mostrar lista de productos"
        return "SKU: " + this.sku + " Nombre: " + nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}