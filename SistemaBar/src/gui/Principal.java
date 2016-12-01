package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import negocio.BarException;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private ClntGUI clntGUI;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Sistema de Controle de Acesso ao Bar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		 try {
	            clntGUI = new ClntGUI();
	        } catch (BarException ex) {
	            JOptionPane.showMessageDialog(null, "Falha de inicialização. " + ex.getMessage());
	        }

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu jMRegistrar = new JMenu("Registrar");
		menuBar.add(jMRegistrar);

		JMenuItem jMIRegistrarEntrada = new JMenuItem("Registrar Entrada");
		jMIRegistrarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RegistrarEntrada cadClnt = new RegistrarEntrada(clntGUI);
			        cadClnt.setVisible(true);
			}
		});
		jMRegistrar.add(jMIRegistrarEntrada);

		JMenuItem jMIRegistrarSaida = new JMenuItem("Registrar Saida");
		jMIRegistrarSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  RegistraSaida regSaida = new RegistraSaida(clntGUI);
			        regSaida.setVisible(true);

			}
		});
		jMRegistrar.add(jMIRegistrarSaida);

		JMenu jMPesquisar = new JMenu("Pesquisar");
		menuBar.add(jMPesquisar);

		JMenuItem jMIListaCliente = new JMenuItem("Listar Clientes");
		jMIListaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClientes listaClnt = new ListarClientes(clntGUI);
				listaClnt.setVisible(true);
			}
		});
		jMPesquisar.add(jMIListaCliente);

		JMenuItem jMIListaClienteGenero = new JMenuItem("Listar CLientes Por Genero");
		jMIListaClienteGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   ListarClientePorGenero listaPSexo = new ListarClientePorGenero(clntGUI);
			        listaPSexo.setVisible(true);
			}
		});
		jMPesquisar.add(jMIListaClienteGenero);

		JMenuItem jMIListaClienteCategoria = new JMenuItem("Listar Clientes Por Categoria");
		jMIListaClienteCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarClienteCategoria distribuiClntCategoria = new ListarClienteCategoria(clntGUI);
			        distribuiClntCategoria.setVisible(true);
			}
		});
		jMPesquisar.add(jMIListaClienteCategoria);

		JMenu jMDistribuicoes = new JMenu("Distribuicoes");
		menuBar.add(jMDistribuicoes);

		JMenuItem jMIDistribuicaoGenero = new JMenuItem("Distribuicao de Cliente Por Genero");
		jMIDistribuicaoGenero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DistribuicaoGenero dClntG = new DistribuicaoGenero(clntGUI);
			        dClntG.setVisible(true);
			}
		});
		jMDistribuicoes.add(jMIDistribuicaoGenero);

		JMenuItem jMIDistribuicaoCategoria = new JMenuItem("Distribuicao de Cliente Por Categoria");
		jMIDistribuicaoCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DistribuicaoCategoria listaPCategoria = new DistribuicaoCategoria(clntGUI);
		        listaPCategoria.setVisible(true);
			}
		});
		jMDistribuicoes.add(jMIDistribuicaoCategoria);

		JMenu jMOpcoes = new JMenu("Opcoes");
		menuBar.add(jMOpcoes);

		JMenuItem jMISair = new JMenuItem("Sair");
		jMISair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jMOpcoes.add(jMISair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
