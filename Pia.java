package piapoo;

import java.util.Scanner;

public class Pia {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        Menu menu = new Menu();
        String nombre, correo, contraseña;

        int opcion;

        do {
            do {
                System.out.println("ingresa una opcion\n1)iniciar sesion\n2)contraseñaolvidada\n3)registrarse\n4)salir");
                opcion = escaner.nextInt();
                escaner.nextLine();
            } while (opcion < 1 || opcion > 4);
            switch (opcion) {
                case 1:
                    System.out.println("ingresa tu nombre de usuario/correo electronico");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("ingresa tu contraseña");
                    contraseña = escaner.nextLine();
                    escaner.nextLine();
                    if (menu.iniciarSesion(nombre, contraseña)) {
                        //ingresar
                    } else {
                        System.out.println("nombre/correo o contraseña equivocada\n");
                    }
                    break;
                case 2:
                    System.out.println("ingresa tu nombre de usuario/correo electronico");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    menu.contraseñaOlvidada(nombre);
                    break;
                case 3:
                    System.out.println("ingrese el nommbre de usuario");
                    nombre = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("ingrese su correo electronico");
                    correo = escaner.nextLine();
                    escaner.nextLine();
                    System.out.println("ingrese la contraseña");
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