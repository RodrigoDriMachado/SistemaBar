package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import negocio.CadastroClienteDAO;
import negocio.CategoriaVIP;
import negocio.Cliente;
import negocio.ClienteDAO;
import persistencia.DAOException;

public class DistribuicaoGeneroTeste {

	Cliente clnt;
	CadastroClienteDAO cadClnt;
	private List<Cliente> listaMasculino;
	private List<Cliente> listaFeminino;
	private int total;
	int calculo;
	int distribuicao;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		listaMasculino = new ArrayList<>();
		listaFeminino = new ArrayList<>();
		calculo = 0;
		distribuicao = 0;

		clnt = new Cliente("Alice Emanuelly Fernanda Mendes", "85288775400", "Feminino", 34, "VIP", CategoriaVIP.Platinum.getValuePlatinum());
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
		clnt = new Cliente("Heloisa Alana Fernandes", "38154411377", "Feminino", 34, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
		clnt = new Cliente("Larissa Giovanna Almeida", "31359665935", "Feminino", 34, "VIP", CategoriaVIP.Gold.getValueGold());
		cadClnt.add(clnt);
		listaFeminino.add(clnt);
		clnt = new Cliente("Ryan Ian Fernandes", "58566511115", "Masculino", 75, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		listaMasculino.add(clnt);
		clnt = new Cliente("Alexandre Diego de Paula", "72344366938", "Masculino", 35, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		listaMasculino.add(clnt);
		clnt = new Cliente("Carlos Eduardo Pedro", "52924341914", "Masculino", 66, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		listaMasculino.add(clnt);
	}

	@Test
	public void positiveDisposicaoClienteMasculinoTeste() throws DAOException {
		total = cadClnt.totalCliente();
		distribuicao = 100 * listaMasculino.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClientesGenero("Masculino");
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void positiveDisposicaoClienteFemininoTeste() throws DAOException {
		total = cadClnt.totalCliente();
		distribuicao = 100 * listaFeminino.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClientesGenero("Feminino");
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void negativeDisposicaoClienteMasculinoTeste() throws DAOException {
		cadClnt.removeAll();
		total = cadClnt.totalCliente();
		calculo = 100 * cadClnt.quantidadeClientesGenero("Masculino");
		calculo = calculo / cadClnt.totalCliente();
		assertFalse(0==calculo);
	}

	@Test
	public void negativeDisposicaoClienteFemininoTeste() throws DAOException {
		cadClnt.removeAll();
		total = cadClnt.totalCliente();
		calculo = 100 * cadClnt.quantidadeClientesGenero("Feminino");
		calculo = calculo / cadClnt.totalCliente();
		assertFalse(0==calculo);
	}


}

