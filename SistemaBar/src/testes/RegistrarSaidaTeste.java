package Testes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Negocio.CadastroClienteDAO;
import Negocio.Cliente;
import Negocio.ClienteDAO;
import Persistencia.DAOException;

public class RegistrarSaidaTeste {

	Cliente clnt;
	CadastroClienteDAO cadClnt;

	@Before
	public void setUP() throws IOException, DAOException {
		cadClnt = new ClienteDAO();
		clnt = new Cliente("Joaquim Davi Fernandes", "69004804625", "Masculino", 24, "VIP", "Silver");
		cadClnt.add(clnt);
	}

	@Test
	public void positiveRegistraEntrada() throws DAOException{
		clnt  = new Cliente("Joao Enzo Ryan Freitas", "32581353392", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		clnt  = new Cliente("Erick Nicolas Pereira", "60808577824", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		cadClnt.removeCliente(cadClnt.pesquisaClienteCPF("69004804625"));
		assertEquals(2, cadClnt.totalCliente());
	}

	@Test
	public void positiveRegistraEntrada2() throws DAOException{
		clnt  = new Cliente("Augusto Nathan Rocha", "10040706591", "Masculino", 25, "VIP", "Gold");
		cadClnt.add(clnt);
		clnt  = new Cliente("Pedro Gustavo Levi Souza", "13145661728", "Masculino", 25, "VIP", "Silver");
		cadClnt.add(clnt);
		cadClnt.removeCliente(cadClnt.pesquisaClienteCPF("10040706591"));
		assertEquals(2, cadClnt.quantidadeClienteCategoria("Silver"));
	}

	@Test
	public void negativeCadastroClienteComum() throws DAOException{
		clnt  = new Cliente("Antonio Kevin de Paula", "94571516401", "Masculino", 25, "VIP", "Gold");
		cadClnt.add(clnt);
		assertEquals(1, cadClnt.quantidadeClienteCategoria("Gold"));
	}

	@Test
	public void positiveRegistraEntrada3() throws DAOException{
		clnt  = new Cliente("Cauê Daniel Luiz Barbosa", "39488138920", "Masculino", 25, "VIP", "Gold");
		cadClnt.add(clnt);
		clnt  = new Cliente("Levi Caio Gustavo Ribeiro", "977927.17917", "Masculino", 25, "VIP", "Silver");
		cadClnt.add(clnt);
		cadClnt.removeCliente(cadClnt.pesquisaClienteCPF("69004804625"));
		assertFalse(cadClnt.listaCliente().contains(cadClnt.pesquisaClienteCPF("69004804625")));
	}

}
