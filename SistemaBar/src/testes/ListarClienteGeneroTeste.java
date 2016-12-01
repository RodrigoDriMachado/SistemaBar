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

public class ListarClienteGeneroTeste {

	private CadastroClienteDAO cadClnt;
	private Cliente clnt;
	private List<Cliente> listaMasculino;
	private List<Cliente> listaFeminino;


	@Before
	public void setUp() throws Exception {

		listaMasculino = new ArrayList<>();
		listaFeminino = new ArrayList<>();

		cadClnt = new ClienteDAO();
		cadClnt.removeAll();

		clnt = new Cliente("Eduardo Ryan Gustavo Freitas", "22062919085", "Masculino", 25, "Comum", null);
		cadClnt.add(clnt);
		listaMasculino.add(clnt);

		clnt = new Cliente("Luan Eduardo Pereira", "08732995237", "Masculino", 45, "VIP", "Silver");
		cadClnt.add(clnt);
		listaMasculino.add(clnt);

		clnt = new Cliente("Ester Larissa Cecília Pinto", "21757984100", "Feminino", 21, "VIP", "Gold");
		cadClnt.add(clnt);
		listaFeminino.add(clnt);

		clnt = new Cliente("Isabella Isadora Mariane da Silva", "51061333604", "Feminino", 12, "VIP", "Platinum");
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
	}


	@Test
	public void positiveListarClientesMasculinoTest() throws DAOException{
		clnt = new Cliente("Vitor Enzo Mendes", "67928250691", "Masculino", 22, "VIP", "Silver");
		cadClnt.add(clnt);
		listaMasculino.add(clnt);
		clnt = new Cliente("Pedro Renato Hugo Moura", "39232718162", "Masculino", 35, "VIP", "Silver");
		cadClnt.add(clnt);
		listaMasculino.add(clnt);
		assertEquals(cadClnt.listaClientePorSexo("Masculino").toString(), listaMasculino.toString());
	}

	@Test
	public void positiveListarClientesFemininoTest() throws DAOException{
		clnt = new Cliente("Alice Beatriz Pereira", "66852582841", "Feminino", 27, "VIP", "Gold");
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
		clnt = new Cliente("Bárbara Eloá Pinto", "13499048728", "Feminino", 31, "VIP", "Gold");
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
		assertEquals(cadClnt.listaClientePorSexo("Feminino").toString(), listaFeminino.toString());
	}


}
