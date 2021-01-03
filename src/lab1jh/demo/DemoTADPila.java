package demo;

import java.util.ArrayList;

import demo.util.io;
import pila.Pila;

public class DemoTADPila {

    public static void main(String[] args) { 
        
        testPila();

	}

    private static void testPila() {
        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test aniadir Pila ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        System.out.println("Crear Pila<Object>. Podra contener cualquier tipo de objeto.");
        Pila<Object> miPila = new Pila<Object>();
        miPila.print();
        io.esperarUsuario();

        System.out.println("Crear objetos ArrayList<String> para trabajar con instancias de objeto");
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
        miPila.apilar(lista0);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista1\"");
        miPila.apilar(lista1);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista2\"");
        miPila.apilar(lista2);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista3\"");
        miPila.apilar(lista3);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"lista4\"");
        miPila.apilar(lista4);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"cero\"");
        miPila.apilar("cero");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"uno\"");
        miPila.apilar("uno");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"dos\"");
        miPila.apilar("dos");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"tres\"");
        miPila.apilar("tres");
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Integer\"");
        miPila.apilar((Integer) 25);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Double\"");
        miPila.apilar((Double) 25.125);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"Boolean\"");
        miPila.apilar((Boolean) true);
        miPila.print();
        io.esperarUsuario();

        System.out.println("Aniadir un elemento \"String\"");
        miPila.apilar("Esto es una cadena");
        miPila.print();
        io.esperarUsuario();

        System.out.println(io.box('*', 60, '*'));
        System.out.println(io.linea(" Test desapilar ", 60, "*"));
        System.out.println(io.box('*', 60, '*'));

        while (!miPila.isVacia()) {
            System.out.println("Desapilar e imprimir un elemento");
            System.out.println(miPila.desapilar());
            io.esperarUsuario();
            System.out.println("Imprimir Pila");
            System.out.println(miPila);
            io.esperarUsuario();
        }

        System.out.println("Desapilar e imprimir un elemento");
        System.out.println(miPila.desapilar());
        io.esperarUsuario();
        System.out.println("Imprimir Pila");
        System.out.println(miPila);
        io.esperarUsuario();
    }

}
