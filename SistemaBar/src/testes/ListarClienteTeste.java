package Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Negocio.CadastroClienteDAO;
import Negocio.CategoriaVIP;
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
		lstClnt = new ArrayList<>();
		cadClnt = new ClienteDAO();
		cadClnt.removeAll();
		clnt = new Cliente("Augusto Hugo Samuel Lima", "66837013424", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		lstClnt.add(clnt);
	}

	@Test
	public void positiveListarClientesTest() throws DAOException{
		clnt = new Cliente("Caua Filipe Felipe Costa", "78290942923", "Masculino", 22, "Comum", null);
		cadClnt.add(clnt);
		lstClnt.add(clnt);
		clnt = new Cliente("Juan Filipe Costa", "78290942925", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		lstClnt.add(clnt);
		assertEquals(cadClnt.listaCliente().toString(), lstClnt.toString());
	}

	@Test
	public void negativeListaClientesTest() throws DAOException{
		clnt = new Cliente("Lucas Murilo Araújo", "89743557288", "Masculino", 31, "VIP", CategoriaVIP.Gold.getValueGold());
		cadClnt.add(clnt);
		clnt = new Cliente("Rebeca Stella dos Santos", "45142626680", "Feminino", 45, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		clnt = cadClnt.pesquisaClienteCPF("89743557288");
		cadClnt.removeCliente(clnt);
		assertFalse(cadClnt.listaCliente().contains(clnt));
	}


}
