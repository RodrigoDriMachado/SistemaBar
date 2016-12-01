package negocio;

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
        if (idade < 18 || idade > 150) {
            return false;
        }
        return true;
    }

    public boolean validaSexo(String sexo){
    	if(sexo != null && (sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")))
    		return true;
    	else
    		return false;
    }


}
