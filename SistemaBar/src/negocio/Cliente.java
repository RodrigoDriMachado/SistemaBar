package Negocio;

public class Cliente {

	private String nome;
	private String cpf;
	private int idade;
	private String tipoCliente;
	private String sexo;
	private String categoria;

	public Cliente(String nome, String cpf, String sexo, int idade, String tipoCliente, String categoria) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tipoCliente = tipoCliente;
		this.sexo = sexo;
		this.categoria = categoria;
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

	public String getCategoria() {
		return this.categoria;
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

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return this.nome + "," + this.cpf + "," + this.idade + "," + this.sexo + "," + this.tipoCliente + ","
				+ this.categoria;
	}

}
