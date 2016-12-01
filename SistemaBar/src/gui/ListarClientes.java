package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.BarException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarClientes extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;

	/**
	 * Create the frame.
	 */
	public ListarClientes(ClntGUI controler) {
		setTitle("Lista de Clientes");
		this.cntrl = controler;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JList listCliente = new JList();
		listCliente.setBounds(10, 35, 414, 194);
		contentPane.add(listCliente);

		JButton JBVoltar = new JButton("Voltar");
		JBVoltar.setBounds(10, 234, 69, 23);
		JBVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listCliente.setToolTipText(null);
				dispose();
			}
		});
		contentPane.add(JBVoltar);

		JButton JBListar = new JButton("Listar");
		JBListar.setBounds(355, 234, 69, 23);
		JBListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (cntrl.getClientes().getSize() != 0) {
						listCliente.setModel(cntrl.getClientes());
					} else {
						JOptionPane.showMessageDialog(contentPane, "O Bar esta vazio");
					}
				} catch (BarException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(JBListar);

		JLabel lblClientes = new JLabel("Clientes Presentes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setBounds(137, 11, 150, 14);
		contentPane.add(lblClientes);
	}

}
