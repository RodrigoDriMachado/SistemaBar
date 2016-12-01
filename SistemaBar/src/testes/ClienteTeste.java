package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import negocio.CadastroClienteDAO;
import negocio.Cliente;
import negocio.ClienteDAO;
import negocio.ValidadorCliente;

public class ClienteTeste {
	private CadastroClienteDAO cadClnt;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		cadClnt.removeAll();
	}

	@Test
	public void negativeValidacaoClienteNomeComposto() {
			Cliente cliente = new Cliente("Fulano", "12345678900", "Masculino", 22, "Comum", null);
			Assert.assertFalse(ValidadorCliente.getInstance().validaNome(cliente.getNome()));
	}

	@Test
	public void negativeValidacaoClienteCpf() {
			Cliente cliente = new Cliente("Fulano Cpf Pequeno", "123", "Masculino", 22, "Comum", null);
			Assert.assertFalse(ValidadorCliente.getInstance().validaCpf(cliente.getCpf()));
	}

	@Test
	public void negativeValidacaoClienteIdade() {
			Cliente cliente = new Cliente("Fulano da Silva", "12345678900", "Masculino", 15, "Comum", null);
			Assert.assertFalse(ValidadorCliente.getInstance().validaIdade(cliente.getIdade()));
	}

	@Test
	public void negativeValidacaoClienteSexo() {
			Cliente cliente = new Cliente("Fulano da Silva", "12345678900", "undefined", 22, "Comum", null);
			Assert.assertFalse(ValidadorCliente.getInstance().validaSexo(cliente.getSexo()));
	}

	@Test
	public void positiveValidacaoClienteNomeComposto() {
			Cliente cliente = new Cliente("Fulano Composto", "12345678900", "Masculino", 22, "Comum", null);
			Assert.assertTrue(ValidadorCliente.getInstance().validaNome(cliente.getNome()));
	}

	@Test
	public void positiveValidacaoClienteCpf() {
			Cliente cliente = new Cliente("Fulano Cpf Pequeno", "12345678900", "Masculino", 22, "Comum", null);
			Assert.assertTrue(ValidadorCliente.getInstance().validaCpf(cliente.getCpf()));
	}

	@Test
	public void positiveValidacaoClienteIdade() {
			Cliente cliente = new Cliente("Fulano da Silva", "12345678900", "Masculino", 18, "Comum", null);
			Assert.assertTrue(ValidadorCliente.getInstance().validaIdade(cliente.getIdade()));
	}

	@Test
	public void positiveValidacaoClienteSexo() {
			Cliente cliente = new Cliente("Fulano da Silva", "12345678900", "Masculino", 22, "Comum", null);
			Assert.assertTrue(ValidadorCliente.getInstance().validaSexo(cliente.getSexo()));
	}

}
