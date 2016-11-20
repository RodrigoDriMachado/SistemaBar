package Negocio;

public enum CategoriaVIP {
    
    SILVER("SILVER"),GOLD("GOLD"),PLATINUM("PLATINUM");
    private static String categoria;
    
    CategoriaVIP(String categoria){
        categoria = categoria;
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
