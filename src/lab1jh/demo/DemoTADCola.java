package demo;

import java.util.ArrayList;

import cola.Cola;
import demo.util.io;

public class DemoTADCola {
    public static void main(String[] args) {

        testCola();

    }

    private static void testCola() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test aniadir Cola ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Cola<Object>. Podra contener cualquier tipo de objeto.");
        Cola<Object> miCola = new Cola<Object>();
        miCola.print();
        io.esperarUsuario();

        System.out.println("Crear objetos ArrayList<String> para trabajar con instancias de objeto");
        io.esperarUsuario();
        ArrayList<String> lista0 = new ArrayList<String>();
        // Lista lista0 = new Lista();
        lista0.add("lista 0 cero");
        lista0.add("lista 0 uno");
        lista0.add("lista 0 dos");

        ArrayList<String> lista1 = new ArrayList<String>();
        lista1.add("lista 1 cero");
        lista1.add("lista 1 uno");
        lista1.add("lista 1 dos");

        ArrayList<String> lista2 = new ArrayList<String>();
        lista2.add("lista 2 cero");
        lista2.add("lista 2 uno");
        lista2.add("lista 2 dos");

        ArrayList<String> lista3 = new ArrayList<String>();
        lista3.add("lista 3 cero");
        lista3.add("lista 3 uno");
        lista3.add("lista 3 dos");

        ArrayList<String> lista4 = new ArrayList<String>();
        lista4.add("lista 4 cero");
        lista4.add("lista 4 uno");
        lista4.add("lista 4 dos");

        System.out.println("Aniadir un elemento \"lista0\"");
        miCola.encolar(lista0);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista1\"");
        miCola.encolar(lista1);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista2\"");
        miCola.encolar(lista2);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista3\"");
        miCola.encolar(lista3);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista4\"");
        miCola.encolar(lista4);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"cero\"");
        miCola.encolar("cero");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"uno\"");
        miCola.encolar("uno");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"dos\"");
        miCola.encolar("dos");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"tres\"");
        miCola.encolar("tres");
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Integer\"");
        miCola.encolar((Integer) 25);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Double\"");
        miCola.encolar((Double) 25.125);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Boolean\"");
        miCola.encolar((Boolean) true);
        miCola.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"String\"");
        miCola.encolar("Esto es una cadena");
        miCola.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test desencolar ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        while (!miCola.isVacia()) {
            // Object elemento = miCola.desencolar();
            System.out.println("Desencolar e imprimir un elemento");
            System.out.println(miCola.desencolar());
            io.esperarUsuario();
            System.out.println("Imprimir Cola");
            System.out.println(miCola);
            io.esperarUsuario();
        }

        System.out.println("Desencolar e imprimir un elemento");
        System.out.println(miCola.desencolar());
        io.esperarUsuario();
        System.out.println("Imprimir Cola");
        System.out.println(miCola);
        io.esperarUsuario();
    }

}