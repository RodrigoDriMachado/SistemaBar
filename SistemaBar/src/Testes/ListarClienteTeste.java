package Testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Negocio.CadastroClienteDAO;
import Negocio.Cliente;
import Negocio.ClienteDAO;

public class ListarClienteTeste {

	private CadastroClienteDAO cadClnt;
	private Cliente clnt;
	private List<Cliente> lstClnt;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		cadClnt.removeAll();
		clnt = new Cliente("Rodrigo Machado", "02536982009", "Masculino", 25, "Comum", null);
		lstClnt.add(clnt);
	}


}
