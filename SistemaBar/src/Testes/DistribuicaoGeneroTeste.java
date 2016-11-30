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

public class DistribuicaoGeneroTeste {

	Cliente clnt;
	CadastroClienteDAO cadClnt;
	private List<Cliente> listaMasculino;
	private List<Cliente> listaFeminino;
	private int total;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		listaMasculino = new ArrayList<>();
		listaFeminino = new ArrayList<>();

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
	public void testeDisposicaoMasculino() throws DAOException {
		total = cadClnt.listaCliente().size();
		int distribuicao;
		int calculo;
		distribuicao = 100 * listaMasculino.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClientesGenero("Masculino");
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void testeDisposicaoFeminino() throws DAOException {
		total = cadClnt.listaCliente().size();
		int distribuicao;
		int calculo;
		distribuicao = 100 * listaFeminino.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClientesGenero("Feminino");
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}


}

