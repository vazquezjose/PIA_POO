package piapoo;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Menu {
    private String nombre;
    private String correo;
    private String contraseña;
    private int rol;

    public boolean iniciarSesion(String usuario, String contraseña) {
        try {
            boolean comprobar = false;
            CsvReader comprobarExistenciaUsuario = new CsvReader("Usuarios.csv");
            while (comprobarExistenciaUsuario.readRecord()) {
                String nombreUsuario = comprobarExistenciaUsuario.get(0);
                String correoUsuario = comprobarExistenciaUsuario.get(1);
                String contraseñaUsuario = comprobarExistenciaUsuario.get(2);

                if ((correoUsuario.equals(usuario) || nombreUsuario.equals(usuario)) && contraseñaUsuario.equals(contraseña)) {
                    comprobar = true;
                }
            }
            comprobarExistenciaUsuario.close();
            return comprobar;
        } catch (FileNotFoundException error) {
            System.out.println("hubo un error al leer el archivo\n");
            return false;
        } catch (IOException error) {
            System.out.println("hubo un error al leer el archivo\n");
            return false;
        }
    }

    public void contraseñaOlvidada(String nombreCorreo) {
        try {
            boolean comprobar = false;
            CsvReader comprobarExistenciaUsuario = new CsvReader("Usuarios.csv");
            while (comprobarExistenciaUsuario.readRecord()) {
                String nombreUsuario = comprobarExistenciaUsuario.get(0);
                String correoUsuario = comprobarExistenciaUsuario.get(1);
                String contraseñaUsuario = comprobarExistenciaUsuario.get(2);
                if (nombreCorreo.equals(nombreUsuario) || nombreCorreo.equals(correoUsuario)) {
                    System.out.println("tu contraseña es:" + contraseñaUsuario + "\n");
                    comprobar = true;
                }
            }
            if (comprobar == false) {
                System.out.println("nombre o correo equivocado\n");
            }
            comprobarExistenciaUsuario.close();
        } catch (FileNotFoundException error) {
            System.out.println("hubo un error al leer el archivo\n");
        } catch (IOException error) {
            System.out.println("hubo un error al leer el archivo\n");
        }
    }

    public void registrarse() {
        File Usuarios = new File("Usuarios.csv");
        try {
            boolean comprobar = false;
            CsvWriter registrar = new CsvWriter(new FileWriter("Usuarios.csv", true), ',');
            CsvReader comprobarExistenciaUsuario = new CsvReader("Usuarios.csv");

            while (comprobarExistenciaUsuario.readRecord()) {
                String nombreUsuario = comprobarExistenciaUsuario.get(0);
                String correoUsuario = comprobarExistenciaUsuario.get(1);
                String contraseñaUsuario = comprobarExistenciaUsuario.get(2);
                if (getNombre().equals(nombreUsuario) || getCorreo().equals(correoUsuario)) {
                    System.out.println("el nombre de usuario o el correo ya existen\n");
                    comprobar = true;
                }
            }
            if (comprobar == false) {
                registrar.write(getNombre());
                registrar.write(getCorreo());
                registrar.write(getContraseña());
                registrar.write("1");
                registrar.endRecord();
            }
            comprobarExistenciaUsuario.close();
            registrar.close();
        } catch (IOException error) {
            System.out.println("hubo un error en el archivo\n");
        }
    }

        public int getRol(String nombre){   
        try{
            CsvReader comprobarExistenciaUsuario = new CsvReader("Usuarios.csv");
            while (comprobarExistenciaUsuario.readRecord()) {
                String nombreUsuario = comprobarExistenciaUsuario.get(0);
                String correoUsuario = comprobarExistenciaUsuario.get(1);
                String contraseñaUsuario = comprobarExistenciaUsuario.get(2);
                String StrRol = comprobarExistenciaUsuario.get(3);
                int iRol; 
                rol = Integer.parseInt(StrRol);
              
                }
            comprobarExistenciaUsuario.close();
            }
                    catch (IOException error) {
            System.out.println("hubo un error en el archivo\n");
        }  
        if(0==rol){
            return 0;
        } else {
            return 1;
        }
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}