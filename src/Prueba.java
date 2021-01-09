import grafo.*;
import hash.HashTable;

public class Prueba {
    public static void main(String[] args) throws Exception {

        pruebaGrafo();
        pruebaTabla();

    }

    private static void pruebaGrafo() {

        // Instanciar grafo dirigido
        Grafo grafo = new Grafo(true); // dirigido
        testGrafo(grafo);

        System.out.println("Repetimos para el mismo grafo pero no dirigido");

        // Instanciar grafo No dirigido
        grafo = new Grafo(false); // No dirigido
        testGrafo(grafo);

    }

    private static void testGrafo(Grafo grafo) {
        if (grafo.esDisigido()) {
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
        grafo.borrar(o2, o0);
        // Imprimir matriz
        grafo.printMatrizAdyacencia();

        System.out.println("Borrar arista o3-o1");
        grafo.borrar(o3, o1);
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

        System.out.println("Borrar elemento que contiene \"Objeto 4\"");
        grafo.borrar("Objeto 4");
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
        tabla.borrar("Maria");
        tabla.borrar("José");
        tabla.borrar("Carmen");
        tabla.borrar("Antonio");
        tabla.borrar("Ana");
        tabla.borrar("Juan");
        tabla.borrar("Isabel");
        tabla.borrar("Manuel");
        tabla.borrar("Dolores");
        tabla.borrar("Francisco");
        tabla.borrar("Pilar");
        tabla.borrar("Luis");
        tabla.borrar("Teresa");
        tabla.borrar("Javier");
        tabla.borrar("Rosa");
        tabla.borrar("Miguel");
        tabla.borrar("Josefa");
        tabla.borrar("Carlos");
        tabla.borrar("Cristina");
        tabla.borrar("Angel");
        tabla.borrar("Ángeles");
        tabla.borrar("Jesús");
        tabla.borrar("Laura");
        tabla.borrar("David");
        tabla.borrar("Antonia");
        tabla.borrar("Pedro");
        tabla.borrar("Elena");
        tabla.borrar("Daniel");
        tabla.borrar("Marta");
        tabla.borrar("Alejandro");
        tabla.borrar("Francisca");
        tabla.borrar("Maria");
        tabla.borrar("Lucia");
        tabla.borrar("Alberto");
        tabla.borrar("Mercedes");
        tabla.borrar("Rafael");
        tabla.borrar("Luisa");
        tabla.borrar("Fernando");
        tabla.borrar("Concepción");
        tabla.borrar("Pablo");
        tabla.borrar("Rosario");
        tabla.borrar("Jorge");
        tabla.borrar("Jose");
        tabla.borrar("Ramón");
        tabla.borrar("Paula");
        tabla.borrar("Sergio");
        tabla.borrar("Sara");
        tabla.borrar("Enrique");
        tabla.borrar("Raquel");
        tabla.borrar("Andrés");
        tabla.borrar("Juana");
        tabla.borrar("Diego");
        tabla.borrar("Manuela");
        tabla.borrar("Vicente");
        tabla.borrar("Eva");
        tabla.borrar("Víctor");
        tabla.borrar("Rocío");
        tabla.borrar("Adrián");
        tabla.borrar("Beatriz");
        tabla.borrar("Ignacio");
        tabla.borrar("Patricia");
        tabla.borrar("Álvaro");
        tabla.borrar("Jesús");
        tabla.borrar("Raúl");
        tabla.borrar("Victoria");
        tabla.borrar("Eduardo");
        tabla.borrar("Julia");
        tabla.borrar("Iván");
        tabla.borrar("Belen");
        tabla.borrar("Oscar");
        tabla.borrar("Andrea");
        tabla.borrar("Joaquín");
        tabla.borrar("Silvia");
        tabla.borrar("Rubén");
        tabla.borrar("Encarnación");
        tabla.borrar("Santiago");
        tabla.borrar("Alba");
        tabla.borrar("Roberto");
        tabla.borrar("Esther");
        tabla.borrar("Mario");
        tabla.borrar("Nuria");
        tabla.borrar("Gabriel");
        tabla.borrar("Irene");
        tabla.borrar("Alfonso");
        tabla.borrar("Montserrat");
        tabla.borrar("Jaime");
        tabla.borrar("Angela");
        tabla.borrar("Marcos");
        tabla.borrar("Sandra");
        tabla.borrar("Ricardo");
        tabla.borrar("Inmaculada");
        tabla.borrar("Julio");
        tabla.borrar("Mónica");
        tabla.borrar("Emilio");
        tabla.borrar("Alicia");
        tabla.borrar("Salvador");
        tabla.borrar("Yolanda");
        tabla.borrar("Hugo");
        tabla.borrar("Sonia");
        tabla.borrar("Guillermo");
        tabla.borrar("Mar");
        tabla.borrar("Tomas");
        tabla.borrar("Marina");
        tabla.borrar("Julian");
        tabla.borrar("Margarita");
        tabla.borrar("Martin");
        tabla.borrar("Susana");
        tabla.borrar("Jordi");
        tabla.borrar("Natalia");
        tabla.borrar("Mohamed");
        tabla.borrar("Claudia");
        tabla.borrar("Nicolas");
        tabla.borrar("Sofia");
        tabla.borrar("Agustin");
        tabla.borrar("Carolina");
        tabla.borrar("Felix");
        tabla.borrar("Amparo");
        tabla.borrar("Gonzalo");
        tabla.borrar("Ines");
        tabla.borrar("Cristian");
        tabla.borrar("Gloria");
        tabla.borrar("Cesar");
        tabla.borrar("Nieves");
        tabla.borrar("Josep");
        tabla.borrar("Veronica");
        tabla.borrar("Joan");
        tabla.borrar("Lourdes");
        tabla.borrar("Marc");
        tabla.borrar("Soledad");
        tabla.borrar("Sebastian");
        tabla.borrar("Carla");
        tabla.borrar("Samuel");
        tabla.borrar("Alejandra");
        tabla.borrar("Domingo");
        tabla.borrar("Daniela");
        tabla.borrar("Felipe");
        tabla.borrar("Luz");
        tabla.borrar("Ismael");
        tabla.borrar("Noelia");
        tabla.borrar("Alfredo");
        tabla.borrar("Lorena");
        tabla.borrar("Hector");
        tabla.borrar("Begoña");
        tabla.borrar("Lucas");
        tabla.borrar("Fatima");
        tabla.borrar("Mariano");
        tabla.borrar("Consuelo");
        tabla.borrar("Aitor");
        tabla.borrar("Asuncion");
        tabla.borrar("Alex");
        tabla.borrar("Olga");
        tabla.borrar("Rodrigo");
        tabla.borrar("Blanca");
        tabla.borrar("Iker");
        tabla.borrar("Nerea");
        tabla.borrar("Xavier");
        tabla.borrar("Miriam");
        tabla.borrar("Esteban");
        tabla.borrar("Esperanza");
        tabla.borrar("Gregorio");
        tabla.borrar("Milagros");
        tabla.borrar("Alexander");
        tabla.borrar("Clara");
        tabla.borrar("Marco");
        tabla.borrar("Catalina");
        tabla.borrar("Arturo");
        tabla.borrar("Lidia");
        tabla.borrar("Lorenzo");
        tabla.borrar("Aurora");
        tabla.borrar("Mateo");
        tabla.borrar("Celia");
        tabla.borrar("Albert");
        tabla.borrar("Magdalena");
        tabla.borrar("Borja");
        tabla.borrar("Anna");
        tabla.borrar("Eugenio");
        tabla.borrar("Emilia");
        tabla.borrar("Cristobal");
        tabla.borrar("Adriana");
        tabla.borrar("Aaron");
        tabla.borrar("Elisa");
        tabla.borrar("Joel");
        tabla.borrar("Martina");
        tabla.borrar("Dario");
        tabla.borrar("Eugenia");
        tabla.borrar("Valentin");
        tabla.borrar("Vanesa");
        tabla.borrar("Isaac");
        tabla.borrar("Virginia");
        tabla.borrar("German");
        tabla.borrar("Ainhoa");
        tabla.borrar("Jonathan");
        tabla.borrar("Gema");
        tabla.borrar("Adolfo");
        tabla.borrar("Josefina");
        tabla.borrar("Christian");
        tabla.borrar("Purificacion");
        tabla.borrar("Pau");
        tabla.borrar("Diana");
        tabla.borrar("Eric");
    }

    private static void leerDeTabla(HashTable tabla) {
        System.out.println(tabla.get("Maria"));
        System.out.println(tabla.get("Jose"));
        System.out.println(tabla.get("Carmen"));
        System.out.println(tabla.get("Antonio"));
        System.out.println(tabla.get("Ana"));
        System.out.println(tabla.get("Juan"));
        System.out.println(tabla.get("Isabel"));
        System.out.println(tabla.get("Manuel"));
        System.out.println(tabla.get("Dolores"));
        System.out.println(tabla.get("Francisco"));
        System.out.println(tabla.get("Pilar"));
        System.out.println(tabla.get("Luis"));
        System.out.println(tabla.get("Teresa"));
        System.out.println(tabla.get("Javier"));
        System.out.println(tabla.get("Rosa"));
        System.out.println(tabla.get("Miguel"));
        System.out.println(tabla.get("Josefa"));
        System.out.println(tabla.get("Carlos"));
        System.out.println(tabla.get("Cristina"));
        System.out.println(tabla.get("Angel"));
        System.out.println(tabla.get("Angeles"));
        System.out.println(tabla.get("Jesus"));
        System.out.println(tabla.get("Laura"));
        System.out.println(tabla.get("David"));
        System.out.println(tabla.get("Antonia"));
        System.out.println(tabla.get("Pedro"));
        System.out.println(tabla.get("Elena"));
        System.out.println(tabla.get("Daniel"));
        System.out.println(tabla.get("Marta"));
        System.out.println(tabla.get("Alejandro"));
        System.out.println(tabla.get("Francisca"));
        System.out.println(tabla.get("Maria"));
        System.out.println(tabla.get("Lucia"));
        System.out.println(tabla.get("Alberto"));
        System.out.println(tabla.get("Mercedes"));
        System.out.println(tabla.get("Rafael"));
        System.out.println(tabla.get("Luisa"));
        System.out.println(tabla.get("Fernando"));
        System.out.println(tabla.get("Concepcion"));
        System.out.println(tabla.get("Pablo"));
        System.out.println(tabla.get("Rosario"));
        System.out.println(tabla.get("Jorge"));
        System.out.println(tabla.get("Jose"));
        System.out.println(tabla.get("Ramon"));
        System.out.println(tabla.get("Paula"));
        System.out.println(tabla.get("Sergio"));
        System.out.println(tabla.get("Sara"));
        System.out.println(tabla.get("Enrique"));
        System.out.println(tabla.get("Raquel"));
        System.out.println(tabla.get("Andres"));
        System.out.println(tabla.get("Juana"));
        System.out.println(tabla.get("Diego"));
        System.out.println(tabla.get("Manuela"));
        System.out.println(tabla.get("Vicente"));
        System.out.println(tabla.get("Eva"));
        System.out.println(tabla.get("Victor"));
        System.out.println(tabla.get("Rocio"));
        System.out.println(tabla.get("Adrian"));
        System.out.println(tabla.get("Beatriz"));
        System.out.println(tabla.get("Ignacio"));
        System.out.println(tabla.get("Patricia"));
        System.out.println(tabla.get("Alvaro"));
        System.out.println(tabla.get("Jesus"));
        System.out.println(tabla.get("Raul"));
        System.out.println(tabla.get("Victoria"));
        System.out.println(tabla.get("Eduardo"));
        System.out.println(tabla.get("Julia"));
        System.out.println(tabla.get("Ivan"));
        System.out.println(tabla.get("Belen"));
        System.out.println(tabla.get("Oscar"));
        System.out.println(tabla.get("Andrea"));
        System.out.println(tabla.get("Joaquin"));
        System.out.println(tabla.get("Silvia"));
        System.out.println(tabla.get("Ruben"));
        System.out.println(tabla.get("Encarnacion"));
        System.out.println(tabla.get("Santiago"));
        System.out.println(tabla.get("Alba"));
        System.out.println(tabla.get("Roberto"));
        System.out.println(tabla.get("Esther"));
        System.out.println(tabla.get("Mario"));
        System.out.println(tabla.get("Nuria"));
        System.out.println(tabla.get("Gabriel"));
        System.out.println(tabla.get("Irene"));
        System.out.println(tabla.get("Alfonso"));
        System.out.println(tabla.get("Montserrat"));
        System.out.println(tabla.get("Jaime"));
        System.out.println(tabla.get("Angela"));
        System.out.println(tabla.get("Marcos"));
        System.out.println(tabla.get("Sandra"));
        System.out.println(tabla.get("Ricardo"));
        System.out.println(tabla.get("Inmaculada"));
        System.out.println(tabla.get("Julio"));
        System.out.println(tabla.get("Monica"));
        System.out.println(tabla.get("Emilio"));
        System.out.println(tabla.get("Alicia"));
        System.out.println(tabla.get("Salvador"));
        System.out.println(tabla.get("Yolanda"));
        System.out.println(tabla.get("Hugo"));
        System.out.println(tabla.get("Sonia"));
        System.out.println(tabla.get("Guillermo"));
        System.out.println(tabla.get("Mar"));
        System.out.println(tabla.get("Tomas"));
        System.out.println(tabla.get("Marina"));
        System.out.println(tabla.get("Julian"));
        System.out.println(tabla.get("Margarita"));
        System.out.println(tabla.get("Martin"));
        System.out.println(tabla.get("Susana"));
        System.out.println(tabla.get("Jordi"));
        System.out.println(tabla.get("Natalia"));
        System.out.println(tabla.get("Mohamed"));
        System.out.println(tabla.get("Claudia"));
        System.out.println(tabla.get("Nicolas"));
        System.out.println(tabla.get("Sofia"));
        System.out.println(tabla.get("Agustin"));
        System.out.println(tabla.get("Carolina"));
        System.out.println(tabla.get("Felix"));
        System.out.println(tabla.get("Amparo"));
        System.out.println(tabla.get("Gonzalo"));
        System.out.println(tabla.get("Ines"));
        System.out.println(tabla.get("Cristian"));
        System.out.println(tabla.get("Gloria"));
        System.out.println(tabla.get("Cesar"));
        System.out.println(tabla.get("Nieves"));
        System.out.println(tabla.get("Josep"));
        System.out.println(tabla.get("Veronica"));
        System.out.println(tabla.get("Joan"));
        System.out.println(tabla.get("Lourdes"));
        System.out.println(tabla.get("Marc"));
        System.out.println(tabla.get("Soledad"));
        System.out.println(tabla.get("Sebastian"));
        System.out.println(tabla.get("Carla"));
        System.out.println(tabla.get("Samuel"));
        System.out.println(tabla.get("Alejandra"));
        System.out.println(tabla.get("Domingo"));
        System.out.println(tabla.get("Daniela"));
        System.out.println(tabla.get("Felipe"));
        System.out.println(tabla.get("Luz"));
        System.out.println(tabla.get("Ismael"));
        System.out.println(tabla.get("Noelia"));
        System.out.println(tabla.get("Alfredo"));
        System.out.println(tabla.get("Lorena"));
        System.out.println(tabla.get("Hector"));
        System.out.println(tabla.get("Begoña"));
        System.out.println(tabla.get("Lucas"));
        System.out.println(tabla.get("Fatima"));
        System.out.println(tabla.get("Mariano"));
        System.out.println(tabla.get("Consuelo"));
        System.out.println(tabla.get("Aitor"));
        System.out.println(tabla.get("Asuncion"));
        System.out.println(tabla.get("Alex"));
        System.out.println(tabla.get("Olga"));
        System.out.println(tabla.get("Rodrigo"));
        System.out.println(tabla.get("Blanca"));
        System.out.println(tabla.get("Iker"));
        System.out.println(tabla.get("Nerea"));
        System.out.println(tabla.get("Xavier"));
        System.out.println(tabla.get("Miriam"));
        System.out.println(tabla.get("Esteban"));
        System.out.println(tabla.get("Esperanza"));
        System.out.println(tabla.get("Gregorio"));
        System.out.println(tabla.get("Milagros"));
        System.out.println(tabla.get("Alexander"));
        System.out.println(tabla.get("Clara"));
        System.out.println(tabla.get("Marco"));
        System.out.println(tabla.get("Catalina"));
        System.out.println(tabla.get("Arturo"));
        System.out.println(tabla.get("Lidia"));
        System.out.println(tabla.get("Lorenzo"));
        System.out.println(tabla.get("Aurora"));
        System.out.println(tabla.get("Mateo"));
        System.out.println(tabla.get("Celia"));
        System.out.println(tabla.get("Albert"));
        System.out.println(tabla.get("Magdalena"));
        System.out.println(tabla.get("Borja"));
        System.out.println(tabla.get("Anna"));
        System.out.println(tabla.get("Eugenio"));
        System.out.println(tabla.get("Emilia"));
        System.out.println(tabla.get("Cristobal"));
        System.out.println(tabla.get("Adriana"));
        System.out.println(tabla.get("Aaron"));
        System.out.println(tabla.get("Elisa"));
        System.out.println(tabla.get("Joel"));
        System.out.println(tabla.get("Martina"));
        System.out.println(tabla.get("Dario"));
        System.out.println(tabla.get("Eugenia"));
        System.out.println(tabla.get("Valentin"));
        System.out.println(tabla.get("Vanesa"));
        System.out.println(tabla.get("Isaac"));
        System.out.println(tabla.get("Virginia"));
        System.out.println(tabla.get("German"));
        System.out.println(tabla.get("Ainhoa"));
        System.out.println(tabla.get("Jonathan"));
        System.out.println(tabla.get("Gema"));
        System.out.println(tabla.get("Adolfo"));
        System.out.println(tabla.get("Josefina"));
        System.out.println(tabla.get("Christian"));
        System.out.println(tabla.get("Purificacion"));
        System.out.println(tabla.get("Pau"));
        System.out.println(tabla.get("Diana"));
        System.out.println(tabla.get("Eric"));
    }

    private static void insertarEnTabla(HashTable tabla) {
        tabla.insertar("Maria", "Mi nombre es Maria");
        tabla.insertar("Jose", "Mi nombre es Jose");
        tabla.insertar("Carmen", "Mi nombre es Carmen");
        tabla.insertar("Antonio", "Mi nombre es Antonio");
        tabla.insertar("Ana", "Mi nombre es Ana");
        tabla.insertar("Juan", "Mi nombre es Juan");
        tabla.insertar("Isabel", "Mi nombre es Isabel");
        tabla.insertar("Manuel", "Mi nombre es Manuel");
        tabla.insertar("Dolores", "Mi nombre es Dolores");
        tabla.insertar("Francisco", "Mi nombre es Francisco");
        tabla.insertar("Pilar", "Mi nombre es Pilar");
        tabla.insertar("Luis", "Mi nombre es Luis");
        tabla.insertar("Teresa", "Mi nombre es Teresa");
        tabla.insertar("Javier", "Mi nombre es Javier");
        tabla.insertar("Rosa", "Mi nombre es Rosa");
        tabla.insertar("Miguel", "Mi nombre es Miguel");
        tabla.insertar("Josefa", "Mi nombre es Josefa");
        tabla.insertar("Carlos", "Mi nombre es Carlos");
        tabla.insertar("Cristina", "Mi nombre es Cristina");
        tabla.insertar("Angel", "Mi nombre es Angel");
        tabla.insertar("Angeles", "Mi nombre es Angeles");
        tabla.insertar("Jesus", "Mi nombre es Jesus");
        tabla.insertar("Laura", "Mi nombre es Laura");
        tabla.insertar("David", "Mi nombre es David");
        tabla.insertar("Antonia", "Mi nombre es Antonia");
        tabla.insertar("Pedro", "Mi nombre es Pedro");
        tabla.insertar("Elena", "Mi nombre es Elena");
        tabla.insertar("Daniel", "Mi nombre es Daniel");
        tabla.insertar("Marta", "Mi nombre es Marta");
        tabla.insertar("Alejandro", "Mi nombre es Alejandro");
        tabla.insertar("Francisca", "Mi nombre es Francisca");
        tabla.insertar("Maria", "Mi nombre es Maria");
        tabla.insertar("Lucia", "Mi nombre es Lucia");
        tabla.insertar("Alberto", "Mi nombre es Alberto");
        tabla.insertar("Mercedes", "Mi nombre es Mercedes");
        tabla.insertar("Rafael", "Mi nombre es Rafael");
        tabla.insertar("Luisa", "Mi nombre es Luisa");
        tabla.insertar("Fernando", "Mi nombre es Fernando");
        tabla.insertar("Concepcion", "Mi nombre es Concepcion");
        tabla.insertar("Pablo", "Mi nombre es Pablo");
        tabla.insertar("Rosario", "Mi nombre es Rosario");
        tabla.insertar("Jorge", "Mi nombre es Jorge");
        tabla.insertar("Jose", "Mi nombre es Jose");
        tabla.insertar("Ramon", "Mi nombre es Ramon");
        tabla.insertar("Paula", "Mi nombre es Paula");
        tabla.insertar("Sergio", "Mi nombre es Sergio");
        tabla.insertar("Sara", "Mi nombre es Sara");
        tabla.insertar("Enrique", "Mi nombre es Enrique");
        tabla.insertar("Raquel", "Mi nombre es Raquel");
        tabla.insertar("Andres", "Mi nombre es Andres");
        tabla.insertar("Juana", "Mi nombre es Juana");
        tabla.insertar("Diego", "Mi nombre es Diego");
        tabla.insertar("Manuela", "Mi nombre es Manuela");
        tabla.insertar("Vicente", "Mi nombre es Vicente");
        tabla.insertar("Eva", "Mi nombre es Eva");
        tabla.insertar("Victor", "Mi nombre es Victor");
        tabla.insertar("Rocio", "Mi nombre es Rocio");
        tabla.insertar("Adrian", "Mi nombre es Adrian");
        tabla.insertar("Beatriz", "Mi nombre es Beatriz");
        tabla.insertar("Ignacio", "Mi nombre es Ignacio");
        tabla.insertar("Patricia", "Mi nombre es Patricia");
        tabla.insertar("Alvaro", "Mi nombre es Alvaro");
        tabla.insertar("Jesus", "Mi nombre es Jesus");
        tabla.insertar("Raul", "Mi nombre es Raul");
        tabla.insertar("Victoria", "Mi nombre es Victoria");
        tabla.insertar("Eduardo", "Mi nombre es Eduardo");
        tabla.insertar("Julia", "Mi nombre es Julia");
        tabla.insertar("Ivan", "Mi nombre es Ivan");
        tabla.insertar("Belen", "Mi nombre es Belen");
        tabla.insertar("Oscar", "Mi nombre es Oscar");
        tabla.insertar("Andrea", "Mi nombre es Andrea");
        tabla.insertar("Joaquin", "Mi nombre es Joaquin");
        tabla.insertar("Silvia", "Mi nombre es Silvia");
        tabla.insertar("Ruben", "Mi nombre es Ruben");
        tabla.insertar("Encarnacion", "Mi nombre es Encarnacion");
        tabla.insertar("Santiago", "Mi nombre es Santiago");
        tabla.insertar("Alba", "Mi nombre es Alba");
        tabla.insertar("Roberto", "Mi nombre es Roberto");
        tabla.insertar("Esther", "Mi nombre es Esther");
        tabla.insertar("Mario", "Mi nombre es Mario");
        tabla.insertar("Nuria", "Mi nombre es Nuria");
        tabla.insertar("Gabriel", "Mi nombre es Gabriel");
        tabla.insertar("Irene", "Mi nombre es Irene");
        tabla.insertar("Alfonso", "Mi nombre es Alfonso");
        tabla.insertar("Montserrat", "Mi nombre es Montserrat");
        tabla.insertar("Jaime", "Mi nombre es Jaime");
        tabla.insertar("Angela", "Mi nombre es Angela");
        tabla.insertar("Marcos", "Mi nombre es Marcos");
        tabla.insertar("Sandra", "Mi nombre es Sandra");
        tabla.insertar("Ricardo", "Mi nombre es Ricardo");
        tabla.insertar("Inmaculada", "Mi nombre es Inmaculada");
        tabla.insertar("Julio", "Mi nombre es Julio");
        tabla.insertar("Monica", "Mi nombre es Monica");
        tabla.insertar("Emilio", "Mi nombre es Emilio");
        tabla.insertar("Alicia", "Mi nombre es Alicia");
        tabla.insertar("Salvador", "Mi nombre es Salvador");
        tabla.insertar("Yolanda", "Mi nombre es Yolanda");
        tabla.insertar("Hugo", "Mi nombre es Hugo");
        tabla.insertar("Sonia", "Mi nombre es Sonia");
        tabla.insertar("Guillermo", "Mi nombre es Guillermo");
        tabla.insertar("Mar", "Mi nombre es Mar");
        tabla.insertar("Tomas", "Mi nombre es Tomas");
        tabla.insertar("Marina", "Mi nombre es Marina");
        tabla.insertar("Julian", "Mi nombre es Julian");
        tabla.insertar("Margarita", "Mi nombre es Margarita");
        tabla.insertar("Martin", "Mi nombre es Martin");
        tabla.insertar("Susana", "Mi nombre es Susana");
        tabla.insertar("Jordi", "Mi nombre es Jordi");
        tabla.insertar("Natalia", "Mi nombre es Natalia");
        tabla.insertar("Mohamed", "Mi nombre es Mohamed");
        tabla.insertar("Claudia", "Mi nombre es Claudia");
        tabla.insertar("Nicolas", "Mi nombre es Nicolas");
        tabla.insertar("Sofia", "Mi nombre es Sofia");
        tabla.insertar("Agustin", "Mi nombre es Agustin");
        tabla.insertar("Carolina", "Mi nombre es Carolina");
        tabla.insertar("Felix", "Mi nombre es Felix");
        tabla.insertar("Amparo", "Mi nombre es Amparo");
        tabla.insertar("Gonzalo", "Mi nombre es Gonzalo");
        tabla.insertar("Ines", "Mi nombre es Ines");
        tabla.insertar("Cristian", "Mi nombre es Cristian");
        tabla.insertar("Gloria", "Mi nombre es Gloria");
        tabla.insertar("Cesar", "Mi nombre es Cesar");
        tabla.insertar("Nieves", "Mi nombre es Nieves");
        tabla.insertar("Josep", "Mi nombre es Josep");
        tabla.insertar("Veronica", "Mi nombre es Veronica");
        tabla.insertar("Joan", "Mi nombre es Joan");
        tabla.insertar("Lourdes", "Mi nombre es Lourdes");
        tabla.insertar("Marc", "Mi nombre es Marc");
        tabla.insertar("Soledad", "Mi nombre es Soledad");
        tabla.insertar("Sebastian", "Mi nombre es Sebastian");
        tabla.insertar("Carla", "Mi nombre es Carla");
        tabla.insertar("Samuel", "Mi nombre es Samuel");
        tabla.insertar("Alejandra", "Mi nombre es Alejandra");
        tabla.insertar("Domingo", "Mi nombre es Domingo");
        tabla.insertar("Daniela", "Mi nombre es Daniela");
        tabla.insertar("Felipe", "Mi nombre es Felipe");
        tabla.insertar("Luz", "Mi nombre es Luz");
        tabla.insertar("Ismael", "Mi nombre es Ismael");
        tabla.insertar("Noelia", "Mi nombre es Noelia");
        tabla.insertar("Alfredo", "Mi nombre es Alfredo");
        tabla.insertar("Lorena", "Mi nombre es Lorena");
        tabla.insertar("Hector", "Mi nombre es Hector");
        tabla.insertar("Begoña", "Mi nombre es Begoña");
        tabla.insertar("Lucas", "Mi nombre es Lucas");
        tabla.insertar("Fatima", "Mi nombre es Fatima");
        tabla.insertar("Mariano", "Mi nombre es Mariano");
        tabla.insertar("Consuelo", "Mi nombre es Consuelo");
        tabla.insertar("Aitor", "Mi nombre es Aitor");
        tabla.insertar("Asuncion", "Mi nombre es Asuncion");
        tabla.insertar("Alex", "Mi nombre es Alex");
        tabla.insertar("Olga", "Mi nombre es Olga");
        tabla.insertar("Rodrigo", "Mi nombre es Rodrigo");
        tabla.insertar("Blanca", "Mi nombre es Blanca");
        tabla.insertar("Iker", "Mi nombre es Iker");
        tabla.insertar("Nerea", "Mi nombre es Nerea");
        tabla.insertar("Xavier", "Mi nombre es Xavier");
        tabla.insertar("Miriam", "Mi nombre es Miriam");
        tabla.insertar("Esteban", "Mi nombre es Esteban");
        tabla.insertar("Esperanza", "Mi nombre es Esperanza");
        tabla.insertar("Gregorio", "Mi nombre es Gregorio");
        tabla.insertar("Milagros", "Mi nombre es Milagros");
        tabla.insertar("Alexander", "Mi nombre es Alexander");
        tabla.insertar("Clara", "Mi nombre es Clara");
        tabla.insertar("Marco", "Mi nombre es Marco");
        tabla.insertar("Catalina", "Mi nombre es Catalina");
        tabla.insertar("Arturo", "Mi nombre es Arturo");
        tabla.insertar("Lidia", "Mi nombre es Lidia");
        tabla.insertar("Lorenzo", "Mi nombre es Lorenzo");
        tabla.insertar("Aurora", "Mi nombre es Aurora");
        tabla.insertar("Mateo", "Mi nombre es Mateo");
        tabla.insertar("Celia", "Mi nombre es Celia");
        tabla.insertar("Albert", "Mi nombre es Albert");
        tabla.insertar("Magdalena", "Mi nombre es Magdalena");
        tabla.insertar("Borja", "Mi nombre es Borja");
        tabla.insertar("Anna", "Mi nombre es Anna");
        tabla.insertar("Eugenio", "Mi nombre es Eugenio");
        tabla.insertar("Emilia", "Mi nombre es Emilia");
        tabla.insertar("Cristobal", "Mi nombre es Cristobal");
        tabla.insertar("Adriana", "Mi nombre es Adriana");
        tabla.insertar("Aaron", "Mi nombre es Aaron");
        tabla.insertar("Elisa", "Mi nombre es Elisa");
        tabla.insertar("Joel", "Mi nombre es Joel");
        tabla.insertar("Martina", "Mi nombre es Martina");
        tabla.insertar("Dario", "Mi nombre es Dario");
        tabla.insertar("Eugenia", "Mi nombre es Eugenia");
        tabla.insertar("Valentin", "Mi nombre es Valentin");
        tabla.insertar("Vanesa", "Mi nombre es Vanesa");
        tabla.insertar("Isaac", "Mi nombre es Isaac");
        tabla.insertar("Virginia", "Mi nombre es Virginia");
        tabla.insertar("German", "Mi nombre es German");
        tabla.insertar("Ainhoa", "Mi nombre es Ainhoa");
        tabla.insertar("Jonathan", "Mi nombre es Jonathan");
        tabla.insertar("Gema", "Mi nombre es Gema");
        tabla.insertar("Adolfo", "Mi nombre es Adolfo");
        tabla.insertar("Josefina", "Mi nombre es Josefina");
        tabla.insertar("Christian", "Mi nombre es Christian");
        tabla.insertar("Purificacion", "Mi nombre es Purificacion");
        tabla.insertar("Pau", "Mi nombre es Pau");
        tabla.insertar("Diana", "Mi nombre es Diana");
        tabla.insertar("Eric", "Mi nombre es Eric");
    }

}
