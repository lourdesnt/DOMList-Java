/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoxml;

import java.io.File;

/**
 *
 * @author Lourdes
 */
public class TestDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File xml = new File("src/xmldata/Pelis.xml");
        
        AccesoXML dom = new AccesoXML();
        dom.abrir_XML_DOM(xml);
        String datos = dom.recorrerDOMyMostrar();
        System.out.println(datos);
    }
    
}
