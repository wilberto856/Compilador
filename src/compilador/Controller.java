package compilador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
     ArrayList<String> lineas =  new ArrayList<>();
     ArrayList<Declaracion> dec =  new ArrayList<>();
     
    
    public void obtenerDatos(File file){
        LeerArchivo rf = new LeerArchivo();
        try {
            //obtener las lineas del archivo
            lineas = rf.redFile(file);
            for (String linea : lineas){
                System.out.println(linea);
            }
        } catch (IOException ex) {
            ex.toString();
        }
    }
    
    public void declaraciones(){
        for (String linea : lineas){
            String[] tokens = tokens(linea);
            for(String token : tokens){
                if (token != "" || token !=" ")
                    System.out.println("token: "+ token);
            }
            System.out.println("----");
        }
    }
    
    public String[] tokens(String linea){
        String [] tokens;
        tokens = linea.split(" ");
        return tokens;
    }
}
