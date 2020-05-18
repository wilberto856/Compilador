package compilador;

import java.io.IOException;
import java.util.ArrayList;

public class Compilador {

    public static void main(String[] args) {
//        int valor;
//        Class cls = valor.getClass();
//        System.out.println("The type of the object is: " + cls.getName());
        
        ArrayList<String> lineas =  new ArrayList<>();
        
        LeerArchivo rf = new LeerArchivo();
        try {
            lineas = rf.redFile();
        } catch (IOException ex) {
            ex.toString();
        }
        
        for (String linea : lineas){
            System.out.println(linea);
        }
    }
    
}
