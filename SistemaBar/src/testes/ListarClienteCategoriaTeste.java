package testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import negocio.CadastroClienteDAO;
import negocio.Cliente;
import negocio.ClienteDAO;
import persistencia.DAOException;

public class ListarClienteCategoriaTeste {

	private CadastroClienteDAO cadClnt;
	private Cliente clnt;
	private List<Cliente> listaSilver;
	private List<Cliente> listaGold;
	private List<Cliente> listaPlatinum;


	@Before
	public void setUp() throws Exception {

		listaSilver = new ArrayList<Cliente>();
		listaGold = new ArrayList<Cliente>();
		listaPlatinum = new ArrayList<Cliente>();

		cadClnt = new ClienteDAO();
		cadClnt.removeAll();


		clnt = new Cliente("Luan Eduardo Pereira", "08732995237", "Masculino", 45, "VIP", "Silver");
		cadClnt.add(clnt);
		listaSilver.add(clnt);

		clnt = new Cliente("Ester Larissa Cec�lia Pinto", "21757984100", "Feminino", 21, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);

		clnt = new Cliente("Isabella Isadora Mariane da Silva", "51061333604", "Feminino", 12, "VIP", "Platinum");
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
	}


	@Test
	public void positiveListarClientesVIPSilverTest() throws DAOException{
		clnt = new Cliente("Vitor Enzo Mendes", "67928250691", "Masculino", 22, "VIP", "Silver");
		cadClnt.add(clnt);
		listaSilver.add(clnt);
		clnt = new Cliente("Pedro Renato Hugo Moura", "39232718162", "Masculino", 35, "VIP", "Silver");
		cadClnt.add(clnt);
		listaSilver.add(clnt);
		assertEquals(cadClnt.listaClientePorCategoria("Silver").toString(), listaSilver.toString());
	}

	@Test
	public void positiveListarClientesVIPGoldTest() throws DAOException{
		clnt = new Cliente("Alice Beatriz Pereira", "66852582841", "Feminino", 27, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);
		clnt = new Cliente("B�rbara Elo� Pinto", "13499048728", "Feminino", 31, "VIP", "Gold");
		cadClnt.add(clnt);
		listaGold.add(clnt);
		assertEquals(cadClnt.listaClientePorCategoria("Gold").toString(), listaGold.toString());
	}

	@Test
	public void positiveListarClientesVIPPlatinumTest() throws DAOException{
		clnt = new Cliente("Alice Emanuelly Fernanda Mendes", "39232718162", "Feminino", 27, "VIP", "Platinum");
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
		clnt = new Cliente("Vitor Enzo Mendes", "67928250691", "Masculino", 31, "VIP", "Platinum");
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
		assertEquals(cadClnt.listaClientePorCategoria("Platinum").toString(), listaPlatinum.toString());
	}


}
