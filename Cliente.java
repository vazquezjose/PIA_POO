
package piapoo;

import static java.lang.Character.toUpperCase;

public class Cliente {
    private String nombre;
    private String direccion; 
    private char sexo;
    private int edad;
    private int telefono;


    public Cliente(String _nombre, String _direccion, char _sexo, int _edad, int _telefono)
    {
        nombre = _nombre;
        direccion = _direccion;
        sexo = _sexo;
        edad = _edad;
        telefono = _telefono;
        
        comprobarSexo();
    }
    
     public void comprobarSexo()
    {
        if (sexo == 'h' || sexo == 'H' || sexo == 'm' || sexo == 'M')
            sexo = toUpperCase(sexo); // no hace nada, nomas arregla el sexo y lo pone en mayúsculas
        else
            sexo = 'H';
    }
     
     @Override
    public String toString()
    {
        return "Nombre: " + nombre + "\nDireccion: " + direccion + "\nSexo: " + sexo + "\nEdad: " + edad + " años\nTelefono: " + telefono + "";
    }
    
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public char getSexo() { return sexo; }
    public int getEdad() { return edad; }
    public int getTelefono() { return telefono; }
    
    public void setNombre(String _nombre) { nombre = _nombre; }
    public void setDireccion(String _direccion) { direccion = _direccion; }
    public void setSexo(char _sexo) { sexo = _sexo; comprobarSexo(); }
    public void setEdad(int _edad) { edad = _edad; }
    public void setTelefono(int _telefono) { telefono = _telefono; }

}
