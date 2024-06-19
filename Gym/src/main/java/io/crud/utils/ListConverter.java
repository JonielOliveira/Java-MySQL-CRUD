
package io.crud.utils;

import java.util.ArrayList;
import java.util.List;

public class ListConverter {
    
    public static List<Integer> extractId(List<String> lista){
        List<Integer> listaIds = new ArrayList<>();
        
        for(String elemento : lista){
            int tagStart = elemento.indexOf(":");
            int tagFinal = elemento.indexOf(",");
            // System.out.println(tagStart);
            // System.out.println(tagFinal);
            if(tagStart != -1 & tagFinal != -1){
                tagStart += 2;
                int valor = Integer.valueOf(elemento.substring(tagStart, tagFinal));
                listaIds.add(valor);
            }
        }
        return listaIds;
    } 
    
}
