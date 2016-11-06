package Negocio;

public class Cliente {

	private String nome;
	private String cpf;
	private int idade;
	private String tipoCliente;
	private String tpClnt;
	private String sexo;
        private String categ;


	public Cliente(String nome, String cpf, int idade, String tipoCliente, String sexo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipoCliente = tipoCliente;
		this.sexo = sexo;
	}


	public String getNome() {
		return this.nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getIdade() {
		return this.idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getTipoCliente() {
		return this.tipoCliente;
	}


	public void setTipoCliente(String tpCliente) {
		this.tipoCliente = tpCliente;
	}

	public String getSexo() {
		return this.sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

        public void setCateg (String categoria){
                this.categ = categoria;
        }


	@Override
	public String toString() {
		return "Cliente [nome=" + this.nome + ", cpf=" + this.cpf + ", idade=" + this.idade + ", tipoCliente=" + this.tipoCliente
				+ ", categoria=" + this.categ + ", sexo=" + this.sexo + "]";
	}

}
