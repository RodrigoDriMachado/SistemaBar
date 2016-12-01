package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.BarException;
import negocio.CategoriaVIP;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DistribuicaoCategoria extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;
	private JTextField jTextFieldPercentualSILVER;
	private JTextField jTextFieldPercentualGOLD;
	private JTextField jTextFieldPLATINUM;

	/**
	 * Create the frame.
	 */
	public DistribuicaoCategoria(ClntGUI controle) {
		setTitle("Distribuicao de Cliente por Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox jCBCategoria = new JComboBox();
		jCBCategoria.setModel(new DefaultComboBoxModel(CategoriaVIP.values()));
		jCBCategoria.setBounds(91, 28, 89, 20);
		contentPane.add(jCBCategoria);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 31, 71, 14);
		contentPane.add(lblCategoria);

		jTextFieldPercentualSILVER = new JTextField();
		jTextFieldPercentualSILVER.setBounds(10, 100, 55, 20);
		contentPane.add(jTextFieldPercentualSILVER);
		jTextFieldPercentualSILVER.setColumns(10);

		jTextFieldPercentualGOLD = new JTextField();
		jTextFieldPercentualGOLD.setBounds(10, 145, 55, 20);
		contentPane.add(jTextFieldPercentualGOLD);
		jTextFieldPercentualGOLD.setColumns(10);

		jTextFieldPLATINUM = new JTextField();
		jTextFieldPLATINUM.setBounds(10, 190, 55, 20);
		contentPane.add(jTextFieldPLATINUM);
		jTextFieldPLATINUM.setColumns(10);

		JLabel lblNewLabel = new JLabel("Clientes VIP com Categoria SILVER");
		lblNewLabel.setBounds(91, 103, 265, 14);
		contentPane.add(lblNewLabel);

		JLabel lblClientesVipCom = new JLabel("Clientes VIP com categoria GOLD");
		lblClientesVipCom.setBounds(91, 148, 265, 14);
		contentPane.add(lblClientesVipCom);

		JLabel lblClientesVipCom_1 = new JLabel("Clientes VIP com categoria PLATINUM");
		lblClientesVipCom_1.setBounds(91, 193, 265, 14);
		contentPane.add(lblClientesVipCom_1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 228, 89, 23);
		contentPane.add(btnVoltar);

		JButton jButtonValidar = new JButton("Calcular");
		jButtonValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total=0;
				int calculo;
				try {
					total = cntrl.totalClientes();
				} catch (BarException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equalsIgnoreCase("Silver")) {
					try{
					jTextFieldPercentualGOLD.setText(null);
					jTextFieldPLATINUM.setText(null);
					calculo = 100 * cntrl.quantidadeClientesCategoria("Silver");
					calculo = calculo / total;
					jTextFieldPercentualSILVER.setText(calculo + "%");
					}
					catch (BarException ex) {
						JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
					}
				} else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equalsIgnoreCase("Gold")) {
					try{
					jTextFieldPercentualSILVER.setText(null);
					jTextFieldPLATINUM.setText(null);
					calculo = 100 * cntrl.quantidadeClientesCategoria("Gold");
					calculo = calculo / total;
					jTextFieldPercentualGOLD.setText(calculo + "%");
					}
					catch (BarException ex) {
						JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
					}
				} else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equalsIgnoreCase("Platinum")) {
					try{
					jTextFieldPercentualSILVER.setText(null);
					jTextFieldPercentualGOLD.setText(null);
					calculo = 100 * cntrl.quantidadeClientesCategoria("Platinum");
					calculo = calculo / total;
					jTextFieldPLATINUM.setText(calculo + "%");
					}
					catch (Exception ex) {
						JOptionPane.showMessageDialog(contentPane, "Falha ao calcular  " + ex.getMessage());
					}
				}
			}
		});
		jButtonValidar.setBounds(313, 27, 89, 23);
		contentPane.add(jButtonValidar);
		cntrl = controle;

	}

}
