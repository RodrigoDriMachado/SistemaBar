package testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import negocio.CadastroClienteDAO;
import negocio.Cliente;
import negocio.ClienteDAO;
import persistencia.DAOException;

public class ListarClienteTeste {

	private CadastroClienteDAO cadClnt;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		cadClnt.removeAll();
	}

	@Test
	public void testaRemocaoClienteComumDaLista() throws DAOException{
		Cliente cliente = null;
		Cliente clienteAux = new Cliente("Caua Filipe Felipe Costa", "78290942923", "Masculino", 22, "Comum", null);
		cadClnt.add(clienteAux);
		cadClnt.removeCliente(clienteAux);
		cliente = cadClnt.pesquisaClienteCPF("78290942923");
		assertNull(cliente);
	}
	@Test
	public void testaInclusaoClienteComumNaLista() throws DAOException{
		Cliente cliente = null;
		Cliente clienteAux = new Cliente("Caua Filipe Felipe Costa", "78290942923", "Masculino", 22, "Comum", null);
		cadClnt.add(clienteAux);
		cliente = cadClnt.pesquisaClienteCPF("78290942923");
		assertEquals(cliente.getNome(), "Caua Filipe Felipe Costa");
	}
	@Test
	public void testaRemocaoClienteVipDaLista() throws DAOException{
		Cliente cliente = null;
		Cliente clienteAux = new Cliente("Maria da Graça", "82198723149", "Feminino", 18, "VIP", "Platinum");
		cadClnt.add(clienteAux);
		cadClnt.removeCliente(clienteAux);
		cliente = cadClnt.pesquisaClienteCPF("82198723149");
		assertNull(cliente);
	}
	@Test
	public void testaInclusaoClienteVipNaLista() throws DAOException{
		Cliente cliente = null;
		Cliente clienteAux = new Cliente("Maria da Graça", "82198723149", "Feminino", 18, "VIP", "Platinum");
		cadClnt.add(clienteAux);
		cliente = cadClnt.pesquisaClienteCPF("82198723149");
		assertEquals(cliente.getNome(), "Maria da Graça");
	}
}
