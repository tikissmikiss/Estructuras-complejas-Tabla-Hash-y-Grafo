package jh.lab1.demo;

import jh.util.io;

public class Demo {
    public static boolean stepByStep;

    public static void main(String[] args) {
        String rsp;
        do {
            rsp = io.leerString("\nHabilitar ejecución paso a paso? [y/n] (por defecto: n)", "n");
            if (rsp.equals("y"))
                stepByStep = true;
            else if (rsp.equals("n"))
                stepByStep = false;
            else
                System.out.println("Respuesta no aceptada...");
        } while (!(rsp.equals("y") || rsp.equals("n")));

        jh.lab1.demo.DemoLista.main(args);
        jh.lab1.demo.DemoPila.main(args);
        jh.lab1.demo.DemoCola.main(args);
        jh.lab1.demo.DemoUso.main(args);
    }
}
