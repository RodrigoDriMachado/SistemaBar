/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author 00161615
 */
public enum CategoriaVIP {
    
    VAZIO(""),SILVER("SILVER"),GOLD("GOLD"),PLATINUM("PLATINUM");
    private static String categoria;
    CategoriaVIP(String categoria){
        categoria = categoria;
    }
    
    public static String getCategoriaVAZIO(){
        return VAZIO.toString();
    }
    public static String getCategoriaSilver(){
       return SILVER.toString();
    }
    public static String getCategoriaGOLD(){
        return GOLD.toString();
    }
    public static String getCatagoriaPlatinum(){
        return PLATINUM.toString();
    }
    
}
