
package piapoo;

class Producto {
    private String nombre;
    private double precio;
    private boolean disponible;
    public static int dimesionArray;
    
    
    //Constructor
    public Producto(){}
     public Producto(String nombre, double precio) {
    this.nombre   = nombre;
    this.precio = precio;
    dimesionArray++;
  }
     @Override
     public String toString(){
         return "Nombre: "+getNombre()+"\nPrecio: $"+getPrecio()+"\n";
     }
     
     public String getNombre() {
    return this.nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public double getPrecio() {
    return this.precio;
  }
  public void setPrecio(double precio) {
    this.precio = precio;
  }  
     
}
