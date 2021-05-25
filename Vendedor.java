
package piapoo;

import java.util.Scanner;

public class Vendedor extends Menu{
    private Producto productos[]=null;
    private double caja;
    
    public Vendedor(){}
    @SuppressWarnings("NonPublicExported")
    public Vendedor(Producto[] productos){
        this.productos = productos;
    }
    
      public void mostrarProductos(Producto[] productos) { 
        for (Producto producto : productos) {
            System.out.print(producto + "\n");
        }
  }
  public void mostrarNombreProductos(Producto[] productos) { 
      for (int i = 0; i < productos.length; i++) {
        System.out.println(i+1 +" "+productos[i].getNombre()+"\n");
      }
      System.out.println("\n");
  }   
  /*public double comprarProducto(Producto[] productos, int num, int cantidadUnidades) {
    if (productos[num-1].isDisponible()) {
      if (productos[num-1].getStock() >= cantidadUnidades){
        System.out.println("La compra se ha realizado con éxito!!n");
        productos[num -1].setStock(productos[num -1].getStock()-cantidadUnidades);
        return caja+=cantidadUnidades*productos[num-1].getPrecio();
      } else {System.out.println("No hay cantidad suficiente de producto");}
    } else {System.out.println("No hay cantidad suficiente de producto");}
    return caja;
  }*//*
  public double mostrarCaja() {
    System.out.print("El total de la caja es ");
    caja=Math.round(caja*100);
    return caja/100;
  } */
  
    /**
     *
     */
    public static void Type(){
      Scanner escaner = new Scanner(System.in);
      int opcion;
      do{
          do{
             System.out.println("ingresa una opcion\n1) Agregar Producto\n2) Checar inventario\n3) Cerrar sesión");
             opcion = escaner.nextInt();
          }while(opcion <1 || opcion >3);
          switch(opcion){
              case 1:
                  

                  break;
              case 2:

                  break;
              default:
          }
        }while(opcion != 3);
  }
}
    
