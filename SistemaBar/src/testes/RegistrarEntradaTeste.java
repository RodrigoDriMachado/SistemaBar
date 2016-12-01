package testes;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

import negocio.CadastroClienteDAO;
import negocio.Cliente;
import negocio.ClienteDAO;
import persistencia.DAOException;


public class RegistrarEntradaTeste {

	Cliente clnt;
	CadastroClienteDAO cadClnt;

	@Before
	public void setUp() throws IOException {
		cadClnt = new ClienteDAO();
		clnt = new Cliente("Joaquim Davi Fernandes", "69004804625", "Masculino", 24, "VIP", "Silver");
	}

	@Test
	public void positiveCadastroClienteComum() throws DAOException{
		clnt  = new Cliente("Joao Enzo Ryan Freitas", "32581353392", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		assertEquals(clnt, cadClnt.pesquisaClienteCPF("32581353392"));
	}

	@Test
	public void positiveCadastroClienteVIPSilver() throws DAOException{
		clnt  = new Cliente("Joana Larissa Costa", "83326024088", "Feminino", 45, "VIP", "Silver");
		cadClnt.add(clnt);
		assertEquals(clnt, cadClnt.pesquisaClienteCPF("83326024088"));
	}


	@Test
	public void positiveCadastroClienteVIPPlatinum() throws DAOException{
		clnt  = new Cliente("Sarah Maitê Campos", "69111113073", "Feminino", 46, "VIP", "Platinum");
		cadClnt.add(clnt);
		assertEquals(clnt, cadClnt.pesquisaClienteCPF("69111113073"));
	}

	@Test
	public void negativeCadastroClienteComum() throws DAOException{
		clnt  = new Cliente("Paulo Kaique Kevin Souza", "69004804625", "Masculino", 41, "Comum", null);
		cadClnt.add(clnt);
		assertEquals("Paulo Kaique Kevin Souza", cadClnt.pesquisaClienteCPF(clnt.getCpf()).getNome());
	}
	@Test
	public void negativeCadastroClienteVIPSilver() throws DAOException{
		clnt  = new Cliente("Elias Ian Moura", "83326024088", "Feminino", 37, "VIP", "Gold");
		cadClnt.add(clnt);
		assertEquals("Elias Ian Moura", cadClnt.pesquisaClienteCPF(clnt.getCpf()).getNome());
	}

	@Test
	public void negativeCadastroClienteVIPPlatinum() throws DAOException{
		clnt  = new Cliente("Natalia Stefany Rocha", "69111113073", "Feminino", 38, "VIP", "Platinum");
		cadClnt.add(clnt);
		assertEquals("Natalia Stefany Rocha", cadClnt.pesquisaClienteCPF(clnt.getCpf()).getNome());
	}

}
