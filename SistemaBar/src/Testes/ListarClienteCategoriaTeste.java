package Testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Negocio.CadastroClienteDAO;
import Negocio.CategoriaVIP;
import Negocio.Cliente;
import Negocio.ClienteDAO;
import Persistencia.DAOException;

public class ListarClienteCategoriaTeste {

	private CadastroClienteDAO cadClnt;
	private Cliente clnt;
	private List<Cliente> listaSilver;
	private List<Cliente> listaGold;
	private List<Cliente> listaPlatinum;

	@Before
	public void setUp() throws Exception {

		listaSilver = new ArrayList<>();
		listaGold = new ArrayList<>();
		listaPlatinum = new ArrayList<>();

		cadClnt = new ClienteDAO();
		cadClnt.removeAll();

		clnt = new Cliente("Pedro Renato Hugo Moura", "69617376768", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);

		clnt = new Cliente("Rayssa Cecília Yasmin Moura", "21650395760", "Feminino", 45, "VIP", "Silver");
		cadClnt.add(clnt);
		listaSilver.add(clnt);

		clnt = new Cliente("Isabella Gabrielly Letícia Alves", "52802346210", "Feminino", 21, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);

		clnt = new Cliente("Julia Sophia Campos", "31905321333", "Feminino", 12, "VIP", "Platinum");
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
	}


	@Test
	public void positiveListarClientesSilverTest() throws DAOException{
		clnt = new Cliente("Sabrina Sophie Maitê dos Santos", "67928250691", "Masculino", 22, "VIP", "Silver");
		cadClnt.add(clnt);

		listaSilver.add(clnt);
		clnt = new Cliente("Lara Sophia Costa", "39232718162", "Masculino", 35, "VIP", "Silver");
		cadClnt.add(clnt);
		listaSilver.add(clnt);
		assertEquals(cadClnt.listaClientePorCategoria("Silver").toString(), listaSilver.toString());
	}

	@Test
	public void positiveListarClientesGoldTest() throws DAOException{
		clnt = new Cliente("Alice Beatriz Pereira", "66852582841", "Masculino", 27, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);
		clnt = new Cliente("Bárbara Eloá Pinto", "13499048728", "Masculino", 31, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);
		assertEquals(cadClnt.listaClientePorCategoria("Gold").toString(), listaGold.toString());
	}


}
