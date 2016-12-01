package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

import negocio.CategoriaVIP;
import persistencia.DAOException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ListarClienteCategoria extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;

	/**
	 * Create the frame.
	 */
	public ListarClienteCategoria(ClntGUI controler) {
		setTitle("Lista de Cliente por Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelCategoria = new JLabel("Categoria");
		jLabelCategoria.setBounds(10, 25, 71, 14);
		contentPane.add(jLabelCategoria);

		final JComboBox jCBCategoria = new JComboBox();
		jCBCategoria.setModel(new DefaultComboBoxModel(CategoriaVIP.values()));
		jCBCategoria.setBounds(86, 22, 107, 20);
		contentPane.add(jCBCategoria);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		final JList jListCategoria = new JList();
		jListCategoria.setBounds(10, 95, 414, 173);
		contentPane.add(jListCategoria);
		btnVoltar.setBounds(10, 278, 89, 23);
		contentPane.add(btnVoltar);
		cntrl = controler;

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		        	if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("SILVER")){
		        		jListCategoria.setModel(cntrl.getClientesCategoria("SILVER"));
		            } else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("GOLD")) {
		            	jListCategoria.setModel(cntrl.getClientesCategoria("GOLD"));
		            } else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("PLATINUM")) {
		            	jListCategoria.setModel(cntrl.getClientesCategoria("PLATINUM"));
		            }
		        } catch (Exception e1) {
		            JOptionPane.showMessageDialog(contentPane, "Falha na busca. " + e1.getMessage());
		        }
			}
		});
		btnListar.setBounds(303, 21, 89, 23);
		contentPane.add(btnListar);

	}
}
