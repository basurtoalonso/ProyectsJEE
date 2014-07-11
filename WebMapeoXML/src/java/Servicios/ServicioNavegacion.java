/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guardia.sisport
 */
public class ServicioNavegacion {
    private static final String ruta = "/WEB-INF/navigationXML/";
    //private static final String rutaPrueba = "http://localhost:7001/CFS3-war/WEB-INF/navigationXML/";
    
    
    public static synchronized String getMenu(String url, HttpServletRequest request ){
        
        //Busca un archivo xml cuyo nombre sea igual a la ultima palabra de la ruta
        
        String pieces[] = url.split("/");
        String xml = ruta.concat( pieces[pieces.length - 1] + ".xml");
        File file = new File(request.getSession().getServletContext().getRealPath(xml));
        
        if (file.exists()){
            return xml;
        }
        else{
            throw new NullPointerException();
        }
    }
}
