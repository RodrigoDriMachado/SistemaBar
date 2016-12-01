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

public class DistribuicaoCategoriaTeste {

	Cliente clnt;
	CadastroClienteDAO cadClnt;
	private List<Cliente> listaSilver;
	private List<Cliente> listaGold;
	private List<Cliente> listaPlatinum;
	private int total;
	int distribuicao;
	int calculo;

	@Before
	public void setUp() throws Exception {
		cadClnt = new ClienteDAO();
		listaSilver = new ArrayList<>();
		listaGold = new ArrayList<>();
		listaPlatinum = new ArrayList<>();
		total =0;
		calculo =0;
		distribuicao =0;
		clnt = new Cliente("Alice Emanuelly Fernanda Mendes", "85288775400", "Feminino", 34, "VIP", CategoriaVIP.Platinum.getValuePlatinum());
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
		clnt = new Cliente("Heloisa Alana Fernandes", "38154411377", "Feminino", 34, "VIP", CategoriaVIP.Silver.getValueSilver());
		cadClnt.add(clnt);
		listaSilver.add(clnt);
		clnt = new Cliente("Larissa Giovanna Almeida", "31359665935", "Feminino", 34, "VIP", CategoriaVIP.Gold.getValueGold());
		cadClnt.add(clnt);
		listaGold.add(clnt);

	}


	@Test
	public void positiveDisposicaoSilverTeste() throws DAOException {
		total = cadClnt.listaCliente().size();
		distribuicao = 100 * listaSilver.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClienteCategoria(CategoriaVIP.Silver.getValueSilver());
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void positiveDisposicaoGoldTeste() throws DAOException {
		clnt = new Cliente("Benício Caio Cardoso", "15910481843", "Masculino", 34, "VIP", CategoriaVIP.Gold.getValueGold());
		cadClnt.add(clnt);
		listaGold.add(clnt);
		total = cadClnt.totalCliente();
		distribuicao = 100 * listaGold.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClienteCategoria("Gold");
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void positiveDisposicaoPlatinumTeste() throws DAOException {
		clnt = new Cliente("Fernando Raul Rocha", "13673299220", "Masculino", 28, "VIP", CategoriaVIP.Platinum.getValueGold());
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
		clnt = new Cliente("Pedro Henrique Murilo Alexandre", "58203112722", "Masculino", 63, "VIP", CategoriaVIP.Platinum.getValueGold());
		cadClnt.add(clnt);
		listaPlatinum.add(clnt);
		cadClnt.removeCliente(cadClnt.pesquisaClienteCPF("13673299220"));
		listaPlatinum.remove(cadClnt.pesquisaClienteCPF("58203112722"));
		total = cadClnt.listaCliente().size();
		distribuicao = 100 * listaPlatinum.size();
		distribuicao = distribuicao / total;
		calculo = 100 * cadClnt.quantidadeClienteCategoria(CategoriaVIP.Platinum.getValueGold());
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(distribuicao, calculo);
	}

	@Test
	public void negativeDisposicaoSilverTeste() throws DAOException {
		cadClnt.removeAll();
		clnt = new Cliente("Maria Marcela Lara Almeida", "86041050261", "Feminino", 47, "VIP", CategoriaVIP.Gold.getValueGold());
		calculo = 100 * cadClnt.quantidadeClienteCategoria(CategoriaVIP.Silver.getValueSilver());
		calculo = calculo / cadClnt.totalCliente();
		assertEquals(0,calculo);
	}



}
