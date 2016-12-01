package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.BarException;
import persistencia.DAOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistraSaida extends JFrame {

	private JPanel contentPane;
	private JTextField jTextCPF;
	private ClntGUI cntrl;


	/**
	 * Create the frame.
	 */
	public RegistraSaida(ClntGUI controler) {
		setTitle("Registrar Saida do Cliente");
		cntrl = controler;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 86, 46, 14);
		contentPane.add(lblCpf);

		jTextCPF = new JTextField();
		jTextCPF.setBounds(66, 83, 162, 20);
		contentPane.add(jTextCPF);
		jTextCPF.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 228, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (jTextCPF.getText().equals("")) {
			            JOptionPane.showMessageDialog(contentPane, "Favor Informar o CPF do cliente");
			            jTextCPF.setText(null);
			        } else {
			            try {
			                cntrl.registrarSaida(jTextCPF.getText());
			                JOptionPane.showMessageDialog(contentPane, "Saida Registrada com sucesso!!");
			                jTextCPF.setText(null);
			            } catch (DAOException ex) {
			            	JOptionPane.showMessageDialog(contentPane, "Falha ao Registrar a saida!!");
			            }
			        }
			}
		});
		btnRegistrar.setBounds(322, 228, 89, 23);
		contentPane.add(btnRegistrar);
	}
}
