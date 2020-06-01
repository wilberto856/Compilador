package compilador;

import java.util.regex.*;


public class regex {
    
    public static void validarValorDentro(String formula){
        Pattern p = Pattern.compile("\\((.*?)\\)");
        Matcher m = p.matcher(formula);

        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
