package Negocio;

/**
 *
 * @author Bernardo Copstein
 */
public class ValidadorCliente {

    private static ValidadorCliente vc = null;

    private ValidadorCliente() {
    }

    public static ValidadorCliente getInstance() {
        if (vc == null) {
            vc = new ValidadorCliente();
        }
        return (vc);
    }

    public boolean validaNome(String nome) {
        if (nome == null
                || nome.length() == 0
                || !nome.contains(" ")) {
            return false;
        }
        return true;
    }

    public boolean validaCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public boolean validaIdade(int idade) {
        if (idade < 0 || idade > 150) {
            return false;
        }
        return true;
    }
    
     public boolean validaTipoCliente(String tipo, String categoria) {
        if (tipo.equals("COMUM")==true && categoria.equals(" ")==false) {
            return false;
        }
        else if(tipo.equals("VIP")==true && categoria.equals(" ")==true ){
            return false;
        }
        return true;
    }


   
}
