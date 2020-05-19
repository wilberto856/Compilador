package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerArchivo {
    ArrayList<String> lineas = new ArrayList<>();
    
    //funcion recibe argumento tipo File para leer el .txt
    //valida que todas las lineas finalicen con ;
    //retorna un array con las lineas leidas sin el ;
    public ArrayList redFile(File file) throws IOException{
        
        BufferedReader br = null; 
        try {
            br = new BufferedReader(new FileReader(file));
            String st; 
            while ((st = br.readLine()) != null) 
                if(st.contains(";")){
                    String linea = st.replace(";", "");
                    if (linea != "" || linea !=" " || linea !="\n"){
                        lineas.add(linea);
                    }
                }else{
                    System.out.println("Error en: "+st+" <<: sentencia no finaliza con ';'");
                    break;
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        finally{
            br.close();
        }
                return lineas;
        } 
    
}
