package piapoo;

import java.util.Scanner;

public class Pia {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Menu menu = new Menu();
        Vendedor producto = new Vendedor();
        String nombre, correo, contraseña;

        int opcion;

        do {
            do {
                System.out.println("| BIENVENIDO A VAPOR |\n |Ingresa Una Opcion|\n-----------------------\n1)Iniciar Sesion\n2)Contraseña Olvidada\n3)Registrarse\n4)Salir\n-----------------------");
                opcion = escaner.nextInt();
                escaner.nextLine();
            } while (opcion < 1 || opcion > 4);
            switch (opcion) {
                case 1:
                    System.out.println("| Ingresa Tu Nombre de Usuario/Correo Electronico |");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("| Ingresa Tu Contraseña |");
                    contraseña = escaner.nextLine();
                    escaner.nextLine();
                    if (menu.iniciarSesion(nombre, contraseña)) {
                         if(menu.getRol(nombre)==0){
                            producto.Type();
                        }
                    } else {
                        System.out.println("            | ATENCION!!! |\n| Nombre/Correo o Contraseña Equivocada!!! |\n");
                    }
                    break;
                case 2:
                    System.out.println("| Ingresa Tu Nombre de Usuario/Correo Electronico |");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    menu.contraseñaOlvidada(nombre);
                    break;
                case 3:
                    System.out.println("| Ingrese El Nommbre De Usuario |");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("| Ingrese Su Correo Electronico |");
                    correo = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("| Ingrese La Contraseña |");
                    contraseña = escaner.nextLine();
                    escaner.nextLine();
                    menu.setNombre(nombre);
                    menu.setCorreo(correo);
                    menu.setContraseña(contraseña);
                    menu.registrarse();
                    break;
                default:
            }
        } while (opcion != 4);
    }
}