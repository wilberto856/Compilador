package compilador;

import java.io.File;

public class Compilador {

    public static void main(String[] args) {
//        int valor;
//        Class cls = valor.getClass();
//        System.out.println("The type of the object is: " + cls.getName());
        File file = new File("C:\\proyecto_compiladores\\codigo.txt");
        Controller control =  new Controller();
        control.obtenerDatos(file);
        control.declaraciones();

    }
    
}
