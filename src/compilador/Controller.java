package compilador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    ArrayList<String> lineas = new ArrayList<>();
    ArrayList<Declaracion> dec = new ArrayList<>();


    public void obtenerDatos(File file) {
        LeerArchivo rf = new LeerArchivo();
        try {
            //obtener las lineas del archivo
            lineas = rf.redFile(file);
        } catch (IOException ex) {
            ex.toString();
        }
    }
    
    public String[] tokens(String linea) {
        String[] tokens = new String[3];
        String[] preToken = null;

        if (linea.contains("=")) {
            //Variable con Asignacion
            preToken = linea.split("=");
            String[] st = preToken[0].split(" ");
            tokens[0] = st[0];
            if (st.length == 3) {
                tokens[1] = st[2]; 
                tokens[2] = preToken[1].replace("'", "");
            }else if(st.length==1){
                tokens[2] = preToken[1];
            }
            
        } else {
            //Variable sin asignacion
            String[] st = linea.split(" ");
            tokens[0] = st[0];
            tokens[1] = st[2]; 
        }

        return tokens;
    }

    public void declaraciones() {
        for (String linea : lineas) {
            Declaracion decl = new Declaracion();
            String[] tokens = tokens(linea);
//            System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[2]);
            
                decl.setNombreVariable(tokens[0]);
                decl.setTipoVariable(tokens[1]);
                decl.setValorVariable(tokens[2]);
            
            dec.add(decl);
        }

    }

    public void validarTipos(){
        
        System.out.println("validanto tipos...");
        
        for(Declaracion nuev: dec){
            //System.out.println("| "+nuev.getNombreVariable()+" | "+nuev.getTipoVariable()+" | "+nuev.getValorVariable());
            if(nuev.getValorVariable() != null && nuev.getTipoVariable()!=null){
                System.out.println("validar--" + nuev.getNombreVariable());
            } 
        }
    }
    
    public void validarParentesis(){
        int parentecisAbierto = 0;
        int parentecisCerrado = 0;
        for(Declaracion nuev: dec){
                
            if(nuev.getTipoVariable()==null){
                
                for(char i : nuev.getValorVariable().toCharArray()){
                    if(i == '('){
                        parentecisAbierto++;
                    }else if( i == ')'){
                        parentecisCerrado++;
                    }
                }
            }
            if(parentecisAbierto < parentecisCerrado){
               throw new IllegalArgumentException("Error en: "+ nuev.getNombreVariable()+" <<- falta Apertura de Parentesis");
            }else if (parentecisCerrado < parentecisAbierto){
                throw new IllegalArgumentException("Error en Formula: "+ nuev.getNombreVariable()+" falta Cierre de Parentesis");
            }
        }
        
    }
}
