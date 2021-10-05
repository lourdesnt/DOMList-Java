/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoxml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Lourdes
 */
public class AccesoXML {
    
    Document doc;
    
    public int abrir_XML_DOM(File fichero){
        doc = null;
        try{
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
          factory.setIgnoringComments(true);
         
          factory.setIgnoringElementContentWhitespace(true);
          
          factory.setValidating(false);
         
          DocumentBuilder builder = factory.newDocumentBuilder();
         
          doc = builder.parse(fichero);
         
          return 0;
        }
        catch(Exception e){
          e.printStackTrace();
          return -1;
        }

    }
    
    public String recorrerDOMyMostrar(){
        String datos_nodo[] = null;
        String salida = "";
        Node node;
    
        Node raiz = doc.getFirstChild();
    
        NodeList nodeList = raiz.getChildNodes();
    
        for (int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                datos_nodo = procesarPelis(node);
                salida = salida + "\n " + "Titulo: " + datos_nodo[1] + "\n";
                if(!datos_nodo[0].equals("")){ //Si el primer elemento (el atributo) no es un string vacío (es decir, tiene atributo) se añade a la salida
                    salida = salida + "\n " + "Tipo: " + datos_nodo[0];
                }
                salida = salida + "\n " + "Productora: " + datos_nodo[2];
                salida = salida + "\n " + "Duración: " + datos_nodo[3];
                salida = salida + "\n --------------------";
            }
        }
        return salida;
}
    
    protected String[] procesarPelis(Node n){
        String datos[] = new String[4];
        Node ntemp = null;
        int contador = 1;
        
        if(n.getAttributes().item(0)!=null){
            datos[0] = n.getAttributes().item(0).getNodeValue();
        } else {
            datos[0]=""; //Si el nodo no tiene atributo, en el array de datos se reflejará como un string vacío
        }
    
        NodeList nodos = n.getChildNodes();
        for (int i = 0; i <nodos.getLength(); i++){
            ntemp = nodos.item(i);
            if(ntemp.getNodeType() == Node.ELEMENT_NODE){
                datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
                contador++;
            }
        }
        return datos;
    }   
}
