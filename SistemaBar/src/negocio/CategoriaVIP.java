package negocio;

public enum CategoriaVIP {

    Silver("Silver"),Gold("Gold"),Platinum("Platinum");
    private static String categoria;

    CategoriaVIP(String categoria){
        categoria = categoria;
    }

   public String getValueSilver(){
	   return "Silver";
   }

   public String getValueGold(){
	   return "Gold";
   }

   public String getValuePlatinum(){
	   return "Platinum";
   }
}
