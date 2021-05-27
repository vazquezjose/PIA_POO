package piapoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vendedor extends Menu {
    private Producto productos[] = null;
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private double caja;

    public Vendedor() {
        productos = new Producto[]
            {
                new Producto(597820, "BIOMUTANT", "Open-world, post-apocalyptic Kung-Fu fable RPG, with a unique martial arts styled combat system.", 500, 999.0d),
                new Producto(1005120, "Touhou Genso Wanderer -Lotus Labyrinth R-", "This is a dungeon-crawler RPG with an absurdly large party size! Lead and conquer the impregnable Lotus Labyrinth dungeon!", 500, 551.99),
                new Producto(1586830, "Toy Tinker Simulator: BETA", "¿Siempre has querido ser un creador de juguetes? ¡Aquí puedes completar los primeros pasos para convertirte en uno!", 500, 550.0),
                new Producto(1301210, "Knockout City™", "Forma equipo y lucha hasta el final contra tus rivales. ¡Lanza, atrapa, pasa, esquiva y ábrete camino hacia el dominio del dodgeball!", 500, 459.0),
                new Producto(1580970, "Samorost 1", "Revive los inicios de la franquicia Samorost con la miniaventura original del gnomo espacial que se publicó en 2003.", 500, 550.0),
                new Producto(848450, "Subnautica: Below Zero", "Sobrevive a condiciones hostiles y construye hábitats, fabrica herramientas y ahonda más en el mundo de Subnautica.", 500, 799.8),
                new Producto(1536610, "OpenTTD", "Business simulation game in which players earn money by transporting passengers and cargo via road, rail, water, and air.", 500, 550.0),
                new Producto(1554790, "Coloring Game 4", "This is the last part of the franchise. The game’s fans are going to enjoy the improved functionality and a multitude of new images.", 500, 550.0),
                new Producto(1377580, "Soulworker", "The devastated scene of a post-apocalyptic world following an unidentifiable catastrophe welcomes you to be their hero.", 500, 550.0),
                new Producto(1018830, "Element TD 2 - Multiplayer Tower Defense", "Une Luz, Oscuridad, Agua, Fuego, Naturaleza y Tierra en este juego competitivo de defensa de torres basado en combinar los elementos.", 500, 159.99),
                new Producto(1426210, "It Takes Two", "Emprende el viaje más alocado de tu vida. Invita a un amigo y trabajen en conjunto para afrontar una gran variedad de desafíos de juego alegremente disruptivos.", 500, 899.0),
                new Producto(1293830, "Forza Horizon 4", "Las temporadas dinámicas lo cambian todo en el mejor festival automovilístico del mundo. Juega para explorar la hermosa Gran Bretaña en un mundo abierto y compartido.", 500, 1499.0),
                new Producto(1426530, "Sid Classic", "Powerful souls protect the Time and Space engine here. You can see a school fantasy that transcends time and space in a parallel world.", 500, 550.0),
                new Producto(892970, "Valheim", "Un brutal juego de supervivencia y exploración multijugador, ambientado en un purgatorio generado de forma procedural e inspirado en la cultura vikinga.", 500, 185.99),
                new Producto(1469280, "SuchArt: Creative Space", "¡Crea obras maestras, completa encargos y decora tu estudio en el simulador de artista más avanzado!", 500, 550.0),
                new Producto(1463920, "hexceed", "A relaxing, hexagon based, puzzle game. An exciting new twist on a classic game without the element of guesswork!", 500, 550.0),
                new Producto(1399780, "Spellbreak", "Domina la magia elemental que se ajuste a tu estilo de juego y lanza combinaciones de hechizos poderosas para aplastar a otros jugadores en la Hondanada.", 500, 550.0),
                new Producto(1478220, "Puzzle Together", "¡Rompecabezas multijugador con chat de voz! Juega solo o con amigos y siente que estás sentado alrededor de la mesa.", 500, 550.0),
                new Producto(1172470, "Apex Legends™", "Controla un elenco de personajes con habilidades y disfruta del juego estratégico por escuadrones y del Battle Royale.", 500, 550.0),
                new Producto(1049590, "Eternal Return: Black Survival", "Elige uno de los personajes y enfréntate en la Isla Lumia como uno de 18 jugadores, para demostrar tu ingenio y sobrevivir hasta el final.", 500, 550.0),
                new Producto(1313860, "EA SPORTS™ FIFA 21", "Volvió el futbol con más formas de jugar en equipo en la calle o en el estadio para disfrutar de victorias con amigos.", 500, 449.75),
                new Producto(1335200, "Action Taimanin", "¡Intensa acción de hack-and-slash presentada por la fama de Taimanin!", 500, 550.0),
                new Producto(739630, "Phasmophobia", "Paranormal activity is on the rise and it’s up to you and your team to use all the equipment in order to gather evidence.", 500, 149.99),
                new Producto(970830, "The Dungeon Of Naheulbeuk: The Amulet Of Chaos", " Lead a team of unlikely and clumsy heroes in an epic and challenging tactical RPG. Live an adventure filled with humor, surprises and silly encounters.", 500, 225.39),
                new Producto(946050, "Soda Dungeon 2", "Vuestro juego favorito vuelve con una nueva aventura, una ciudad entera que mejorar! Todo lo que os gustaba del original y todo lo que nos pedisteis.", 500, 550.0),
                new Producto(1172620, "Sea of Thieves", "La experiencia de piratas esencial, desde la navegación y el combate hasta la exploración y el saqueo.", 500, 399.99),
                new Producto(1284410, "GWENT: The Witcher Card Game", "¡Dirige a héroes del mundo The Witcher en batallas épicas de cartas online JcJ!", 500, 550.0)
                // https://store.steampowered.com/explore/new/
                // https://store.steampowered.com/search/?filter=popularnew&sort_by=Released_DESC&os=win
            };
    }

    @SuppressWarnings("NonPublicExported")
    public Vendedor(Producto[] productos) {
        this.productos = productos;
    }

    public Producto getProductoPorSku(long sku) {
        Producto productoEncontrado = null;
        for (Producto producto : productos) {
            if (producto.getSku() == sku) {
                productoEncontrado = producto;
                break;
            }
        }
        return productoEncontrado;
    }

    public void mostrarProductos() {    // este usa toString()
        for (Producto producto : this.productos) {
            System.out.print(producto.toString() + "\n");
        }
    }
    
    public void mostrarListaDeProductos() { // este usa getDatosEsenciales()
        for (Producto producto : this.productos) {
            System.out.print(producto.getDatosEsenciales() + "\n");
        }
        System.out.println("\n");
    }

    public void mostrarNombreProductos() {
        for (int i = 0; i < this.productos.length - 1; i++) {
            System.out.println(i + 1 + " " + this.productos[i].getNombre() + "\n");
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

     public void Type() {
        Scanner escaner = new Scanner(System.in);
        int opcion;
        do {
            do {
                System.out.println("Seleccione una opción\n1) Realizar compra\n2) Mostrar lista de productos\n3) Cerrar sesión");
                opcion = escaner.nextInt();
            } while (opcion < 1 || opcion > 3);
            switch (opcion) {
                case 1:
                    Compra compraNueva = Compra.generarCompra(this);
                    compras.add(compraNueva);
                    System.out.println(compraNueva.toString());
                    break;
                case 2:
                    mostrarListaDeProductos();
                    break;
                default:
            }
        } while (opcion != 3);
    }
}