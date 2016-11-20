package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import Negocio.CategoriaVIP;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DistribuicaoCategoria extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;
	private JTextField jTextFieldSILVER;
	private JTextField jTextFieldGOLD;
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

		jTextFieldSILVER = new JTextField();
		jTextFieldSILVER.setBounds(10, 100, 55, 20);
		contentPane.add(jTextFieldSILVER);
		jTextFieldSILVER.setColumns(10);

		jTextFieldGOLD = new JTextField();
		jTextFieldGOLD.setBounds(10, 145, 55, 20);
		contentPane.add(jTextFieldGOLD);
		jTextFieldGOLD.setColumns(10);

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
				int total;
				int calculo;
				total = cntrl.totalClientes();
				if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("SILVER")) {
					calculo = 100 * cntrl.quantidadeClientesCategoria("SILVER");
					calculo = calculo / total;
					jTextFieldSILVER.setText(calculo + "%");
				} else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("GOLD")) {
					calculo = 100 * cntrl.quantidadeClientesCategoria("GOLD");
					calculo = calculo / total;
					jTextFieldGOLD.setText(calculo + "%");
				} else if (((CategoriaVIP) jCBCategoria.getSelectedItem()).toString().equals("PLATINUM")) {
					calculo = 100 * cntrl.quantidadeClientesCategoria("PLATINUM");
					calculo = calculo / total;
					jTextFieldPLATINUM.setText(calculo + "%");
				}
			}
		});
		jButtonValidar.setBounds(313, 27, 89, 23);
		contentPane.add(jButtonValidar);

		JButton btnCalcularTodos = new JButton("Calcular Todos");
		btnCalcularTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total;
				int calculo;
				total = cntrl.totalClientes();

				calculo = 100 * cntrl.quantidadeClientesCategoria("SILVER");
				calculo = calculo / total;
				jTextFieldSILVER.setText(calculo + "%");

				calculo = 100 * cntrl.quantidadeClientesCategoria("GOLD");
				calculo = calculo / total;
				jTextFieldGOLD.setText(calculo + "%");

				calculo = 100 * cntrl.quantidadeClientesCategoria("PLATINUM");
				calculo = calculo / total;
				jTextFieldPLATINUM.setText(calculo + "%");

			}
		});
		btnCalcularTodos.setBounds(300, 228, 116, 23);
		contentPane.add(btnCalcularTodos);
		cntrl = controle;

	}

}
