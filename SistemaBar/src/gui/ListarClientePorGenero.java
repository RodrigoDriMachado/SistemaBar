package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class ListarClientePorGenero extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;

	/**
	 * Create the frame.
	 */
	public ListarClientePorGenero(ClntGUI controler) {
		setTitle("Lista de Cliente por Genero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 25, 55, 14);
		contentPane.add(lblSexo);

		final JComboBox jCBSexo = new JComboBox();
		jCBSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		jCBSexo.setBounds(60, 22, 89, 20);
		contentPane.add(jCBSexo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

				final JList jListClienteGenero = new JList();
				jListClienteGenero.setBounds(10, 87, 414, 178);
				contentPane.add(jListClienteGenero);
		btnVoltar.setBounds(10, 278, 89, 23);
		contentPane.add(btnVoltar);

		JButton jButtonListar = new JButton("Listar");
		jButtonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            if (jCBSexo.getSelectedItem().equals("Masculino")) {
		            	jListClienteGenero.setModel(cntrl.getClientesGenero("Masculino"));

		            } else if (jCBSexo.getSelectedItem().equals("Feminino")) {
		            	jListClienteGenero.setModel(cntrl.getClientesGenero("Feminino"));
		            }
		        } catch (Exception e1) {
		            JOptionPane.showMessageDialog(contentPane, "Falha na busca. " + e1.getMessage());
		        }
			}
		});
		jButtonListar.setBounds(335, 21, 89, 23);
		contentPane.add(jButtonListar);
		cntrl = controler;

	}
}
