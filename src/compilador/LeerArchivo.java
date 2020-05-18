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
    
    public ArrayList redFile() throws IOException{
        File file = new File("C:\\proyecto_compiladores\\codigo.txt");
        BufferedReader br = null; 
        try {
            br = new BufferedReader(new FileReader(file));
            String st; 
            while ((st = br.readLine()) != null) 
                if(st.contains(";")){
                    lineas.add(st);
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
