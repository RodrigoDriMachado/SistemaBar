package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Persistencia.DAOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DistribuicaoGenero extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;
	private JTextField jTextFieldPercentualMasculino;
	private JTextField jTextFieldPercentualFeminino;

	/**
	 * Create the frame.
	 */
	public DistribuicaoGenero(ClntGUI controle) {
		setTitle("Distribuicao de Clientes por Genero");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Sexo");
		label.setBounds(10, 24, 47, 14);
		contentPane.add(label);

		final JComboBox jComboBoxGenero = new JComboBox();
		jComboBoxGenero.setModel(new DefaultComboBoxModel(new String[] { "", "Masculino", "Feminino" }));
		jComboBoxGenero.setBounds(76, 21, 89, 20);
		contentPane.add(jComboBoxGenero);

		jTextFieldPercentualMasculino = new JTextField();
		jTextFieldPercentualMasculino.setBounds(10, 100, 55, 20);
		contentPane.add(jTextFieldPercentualMasculino);
		jTextFieldPercentualMasculino.setColumns(10);

		jTextFieldPercentualFeminino = new JTextField();
		jTextFieldPercentualFeminino.setBounds(10, 160, 55, 20);
		contentPane.add(jTextFieldPercentualFeminino);
		jTextFieldPercentualFeminino.setColumns(10);

		JLabel lblClientesDoSexo = new JLabel("Clientes do Sexo Masculino");
		lblClientesDoSexo.setBounds(76, 103, 212, 14);
		contentPane.add(lblClientesDoSexo);

		JLabel lblClientesDoSexo_1 = new JLabel("Clientes do Sexo Feminino");
		lblClientesDoSexo_1.setBounds(76, 163, 212, 14);
		contentPane.add(lblClientesDoSexo_1);

		JButton jButtonVoltar = new JButton("Voltar");
		jButtonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jButtonVoltar.setBounds(10, 228, 89, 23);
		contentPane.add(jButtonVoltar);
		cntrl = controle;

		JButton jButtonValidar = new JButton("Calcular");
		jButtonValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total=0;
				int calculo;
				try {
					total = cntrl.quantidadeClientesGenero("Masculino") + cntrl.quantidadeClientesGenero("Feminino");
				} catch (DAOException ex) {
					JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
				}
				if (jComboBoxGenero.getSelectedIndex() == 1) {
					try{
					jTextFieldPercentualFeminino.setText(null);
					calculo = 100 * cntrl.quantidadeClientesGenero("Masculino");
					calculo = calculo / total;
					jTextFieldPercentualMasculino.setText(calculo + "%");
					}
					catch (DAOException ex) {
						JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
					}
				} else if (jComboBoxGenero.getSelectedIndex() == 2) {
					try{
					jTextFieldPercentualMasculino.setText(null);
					calculo = 100 * cntrl.quantidadeClientesGenero("Feminino");
					calculo = calculo / total;
					jTextFieldPercentualFeminino.setText(calculo + "%");
					}
					catch (DAOException ex) {
						JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
					}
				}
			}
		});
		jButtonValidar.setBounds(303, 20, 89, 23);
		contentPane.add(jButtonValidar);

	}
}
