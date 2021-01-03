package lab1jh.demo;

import lab1jh.demo.util.io;

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

        lab1jh.demo.DemoLista.main(args);
        lab1jh.demo.DemoPila.main(args);
        lab1jh.demo.DemoCola.main(args);
        lab1jh.demo.DemoUso.main(args);
    }
}
