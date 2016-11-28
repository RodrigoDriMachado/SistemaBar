package Testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Negocio.CadastroClienteDAO;
import Negocio.Cliente;
import Negocio.ClienteDAO;
import Persistencia.DAOException;
import junit.framework.TestCase;

public class ListarClienteTeste {

	private CadastroClienteDAO cadClnt;
	private Cliente clnt;
	private List<Cliente> lstClnt;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		cadClnt.removeAll();
		clnt = new Cliente("Augusto Hugo Samuel Lima", "66837013424", "Masculino", 25, "Comum", null);
		lstClnt.add(clnt);
	}

	@Test
	public void positiveListarClientesTest() throws DAOException{
		clnt = new Cliente("Caua Filipe Felipe Costa", "78290942923", "Masculino", 22, "Comum", null);
		cadClnt.add(clnt);
		clnt = cadClnt.pesquisaClienteCPF("78290942923");
		assertEquals(true, cadClnt.listaCliente().contains(clnt));
	}


}
