import grafo.*;
import hash.HashTable;

public class Prueba {
    static String[] nombres = { "Maria", "José", "Carmen", "Antonio", "Ana", "Juan", "Isabel", "Manuel", "Dolores",
            "Francisco", "Pilar", "Luis", "Teresa", "Javier", "Rosa", "Miguel", "Josefa", "Carlos", "Cristina", "Angel",
            "Ángeles", "Jesús", "Laura", "David", "Antonia", "Pedro", "Elena", "Daniel", "Marta", "Alejandro",
            "Francisca", "Maria", "Lucia", "Alberto", "Mercedes", "Rafael", "Luisa", "Fernando", "Concepción", "Pablo",
            "Rosario", "Jorge", "Jose", "Ramón", "Paula", "Sergio", "Sara", "Enrique", "Raquel", "Andrés", "Juana",
            "Diego", "Manuela", "Vicente", "Eva", "Víctor", "Rocío", "Adrián", "Beatriz", "Ignacio", "Patricia",
            "Álvaro", "Jesús", "Raúl", "Victoria", "Eduardo", "Julia", "Iván", "Belen", "Oscar", "Andrea", "Joaquín",
            "Silvia", "Rubén", "Encarnación", "Santiago", "Alba", "Roberto", "Esther", "Mario", "Nuria", "Gabriel",
            "Irene", "Alfonso", "Montserrat", "Jaime", "Angela", "Marcos", "Sandra", "Ricardo", "Inmaculada", "Julio",
            "Mónica", "Emilio", "Alicia", "Salvador", "Yolanda", "Hugo", "Sonia", "Guillermo", "Mar", "Tomas", "Marina",
            "Julian", "Margarita", "Martin", "Susana", "Jordi", "Natalia", "Mohamed", "Claudia", "Nicolas", "Sofia",
            "Agustin", "Carolina", "Felix", "Amparo", "Gonzalo", "Ines", "Cristian", "Gloria", "Cesar", "Nieves",
            "Josep", "Veronica", "Joan", "Lourdes", "Marc", "Soledad", "Sebastian", "Carla", "Samuel", "Alejandra",
            "Domingo", "Daniela", "Felipe", "Luz", "Ismael", "Noelia", "Alfredo", "Lorena", "Hector", "Begoña", "Lucas",
            "Fatima", "Mariano", "Consuelo", "Aitor", "Asuncion", "Alex", "Olga", "Rodrigo", "Blanca", "Iker", "Nerea",
            "Xavier", "Miriam", "Esteban", "Esperanza", "Gregorio", "Milagros", "Alexander", "Clara", "Marco",
            "Catalina", "Arturo", "Lidia", "Lorenzo", "Aurora", "Mateo", "Celia", "Albert", "Magdalena", "Borja",
            "Anna", "Eugenio", "Emilia", "Cristobal", "Adriana", "Aaron", "Elisa", "Joel", "Martina", "Dario",
            "Eugenia", "Valentin", "Vanesa", "Isaac", "Virginia", "German", "Ainhoa", "Jonathan", "Gema", "Adolfo",
            "Josefina", "Christian", "Purificacion", "Pau", "Diana", "Eric" };

    public static void main(String[] args) throws Exception {

        pruebaGrafo();
        pruebaTabla();

    }

    private static void pruebaGrafo() throws Exception {

        // Instanciar grafo dirigido
        Grafo grafo = new Grafo(true); // dirigido
        testGrafo(grafo);

        System.out.println("Repetimos para el mismo grafo pero no dirigido");

        // Instanciar grafo No dirigido
        grafo = new Grafo(false); // No dirigido
        testGrafo(grafo);

    }

    private static void testGrafo(Grafo grafo) throws Exception {
        if (grafo.esDirigido()) {
            System.out.println("[obj0]--4-->[obj1]<--6--[obj4]");
            System.out.println("  | ^ \\       | ^ ");
            System.out.println("  | |  \\      | | ");
            System.out.println("  4 0   1     5 3 ");
            System.out.println("  | |    \\    | | ");
            System.out.println("  | |     \\   | | ");
            System.out.println("  V |     _\\/ V | ");
            System.out.println("[obj2]--2-->[obj3]");
        } else {
            System.out.println("[obj0]--4--[obj1]--6--[obj4]");
            System.out.println("   |  \\      | ");
            System.out.println("   |   \\     | ");
            System.out.println("   0    1    3 ");
            System.out.println("   |     \\   | ");
            System.out.println("   |      \\  | ");
            System.out.println("[obj2]--2--[obj3]");
        }

        // ► añadir(x) → nodo
        System.out.println("\nAñadir nodos");
        Nodo o0 = grafo.addNodo("obj0");
        Nodo o1 = grafo.addNodo("obj1");
        Nodo o2 = grafo.addNodo("obj2");
        Nodo o3 = grafo.addNodo("obj3");
        Nodo o4 = grafo.addNodo("obj4");
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        // ► añadir(x, y) → añadir arista que une x e y
        System.out.println("\nAñadir aristas");
        grafo.addArista(o0, o2);
        grafo.addArista(o0, o3);
        grafo.addArista(o0, o1);
        grafo.addArista(o1, o3);
        grafo.addArista(o2, o0); // repetida si es no dirigido
        grafo.addArista(o2, o3);
        grafo.addArista(o3, o1); // repetida si es no dirigido
        grafo.addArista(o4, o1);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        // ► establecerValorArco(x, y, a)
        System.out.println("\nDar pesos a las aristas");
        grafo.establecerValorArco(o0, o2, 4);
        grafo.establecerValorArco(o0, o3, 1);
        grafo.establecerValorArco(o0, o1, 4);
        grafo.establecerValorArco(o1, o3, 5);
        grafo.establecerValorArco(o2, o0, 0);
        grafo.establecerValorArco(o2, o3, 2);
        grafo.establecerValorArco(o3, o1, 3);
        grafo.establecerValorArco(o4, o1, 6);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        // ► borrar(x, y) → borrar arista que une x e y
        System.out.println("Borrar arista o2-o0");
        grafo.borrarArista(o2, o0);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        System.out.println("Borrar arista o3-o1");
        grafo.borrarArista(o3, o1);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        // ► obtenerValorArco(x, y)
        System.out.println("Recuperar valores de los arcos");
        Object valor;
        valor = grafo.obtenerValorArco(o0, o2);
        System.out.println("Valor arco o0-o2: " + valor);
        valor = grafo.obtenerValorArco(o0, o3);
        System.out.println("Valor arco o0-o3: " + valor);
        valor = grafo.obtenerValorArco(o0, o1);
        System.out.println("Valor arco o0-o1: " + valor);
        valor = grafo.obtenerValorArco(o1, o3);
        System.out.println("Valor arco o1-o3: " + valor);
        valor = grafo.obtenerValorArco(o2, o0);
        System.out.println("Valor arco o2-o0: " + valor);
        valor = grafo.obtenerValorArco(o2, o3);
        System.out.println("Valor arco o2-o3: " + valor);
        valor = grafo.obtenerValorArco(o3, o1);
        System.out.println("Valor arco o3-o1: " + valor);
        valor = grafo.obtenerValorArco(o4, o1);
        System.out.println("Valor arco o4-o1: " + valor);

        // ► adyacente(x, y) → bool si x, y son adyacentes
        System.out.println("\nEs adyacente o0 con o1?");
        if (grafo.adyacente(o0, o1))
            System.out.println("Si son adyacentes");
        else
            System.out.println("No son ayacentes");

        System.out.println("\nEs adyacente o1 con o0?");
        if (grafo.adyacente(o1, o0))
            System.out.println("Si son adyacentes.");
        else
            System.out.println("No son ayacentes");

        // ► vecinos(x) → nodos adyacentes a x
        Object[] vecinos;
        System.out.println("\nCuales son los vecions de o0?");
        vecinos = grafo.vecinos(o0);
        for (int i = 0; i < vecinos.length; i++) {
            System.out.println(vecinos[i]);
        }
        System.out.println("\nCuales son los vecions de o1?");
        vecinos = grafo.vecinos(o1);
        for (int i = 0; i < vecinos.length; i++) {
            System.out.println(vecinos[i]);
        }
        System.out.println("\nCuales son los vecions de o2?");
        vecinos = grafo.vecinos(o2);
        for (int i = 0; i < vecinos.length; i++) {
            System.out.println(vecinos[i]);
        }
        System.out.println("\nCuales son los vecions de o3?");
        vecinos = grafo.vecinos(o3);
        for (int i = 0; i < vecinos.length; i++) {
            System.out.println(vecinos[i]);
        }
        System.out.println("\nCuales son los vecions de o4?");
        vecinos = grafo.vecinos(o4);
        for (int i = 0; i < vecinos.length; i++) {
            System.out.println(vecinos[i]);
        }

        // ► establecerValorNodo(x, a) → asignar a como valor de x
        System.out.println("\nEstablecer el valor de o0 a \"Objeto 0\"");
        grafo.establecerValorNodo(o0, "Objeto 0");
        System.out.println("Establecer el valor de o1 a \"Objeto 1\"");
        grafo.establecerValorNodo(o1, "Objeto 1");
        System.out.println("Establecer el valor de o2 a \"Objeto 2\"");
        grafo.establecerValorNodo(o2, "Objeto 2");
        System.out.println("Establecer el valor de o3 a \"Objeto 3\"");
        grafo.establecerValorNodo(o3, "Objeto 3");
        System.out.println("Establecer el valor de o4 a \"Objeto 4\"");
        grafo.establecerValorNodo(o4, "Objeto 4");
        // grafo.establecerValorNodo("obj4", "Objeto 4");

        // ► obtenerValorNodo(x) → objeto encapsulado en el vértice
        System.out.println("\nObtener los valores de los nodos");
        Object contenido;
        contenido = grafo.obtenerValorNodo(o0);
        System.out.println("El contenido de o0 es: " + contenido);
        contenido = grafo.obtenerValorNodo(o1);
        System.out.println("El contenido de o1 es: " + contenido);
        contenido = grafo.obtenerValorNodo(o2);
        System.out.println("El contenido de o2 es: " + contenido);
        contenido = grafo.obtenerValorNodo(o3);
        System.out.println("El contenido de o3 es: " + contenido);
        contenido = grafo.obtenerValorNodo(o4);
        System.out.println("El contenido de o4 es: " + contenido);

        // ► borrar(x) → nodo y referencias
        System.out.println("\nBorrar elemento o1");
        grafo.borrar(o1);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();
        // Imprimir matriz
        grafo.printMatrizAdyacencia();
    }

    private static void pruebaTabla() {
        HashTable tabla = new HashTable();

        insertarEnTabla(tabla);

        leerDeTabla(tabla);

        borrarDeTabla(tabla);

        insertarEnTabla(tabla);

        borrarDeTabla(tabla);
    }

    private static void borrarDeTabla(HashTable tabla) {
        System.out.println("Borrar por nombre");
        for (int i = 0; i < nombres.length; i++) {
            Object aux = tabla.borrar(nombres[i]);
            System.out.println(
                    aux == null ? "No se ha encontrado " + nombres[i] + " para borrar" : "Se ha borrado " + aux);
        }
    }

    private static void leerDeTabla(HashTable tabla) {
        System.out.println("Recuperar datos de la tabla e imprimir");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(tabla.get(nombres[i]));
        }
    }

    private static void insertarEnTabla(HashTable tabla) {
        System.out.println("Recuperar datos de la tabla e imprimir");
        for (int i = 0; i < nombres.length; i++) {
            if (tabla.insertar(nombres[i], "Mi nombre es " + nombres[i])) {
                System.out.println("Se ha insertado " + nombres[i]);
            } else {
                System.out.println("No se ha insertado " + nombres[i]);
            }
        }
    }
}
