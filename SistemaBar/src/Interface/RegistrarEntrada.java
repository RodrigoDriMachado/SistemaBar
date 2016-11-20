package Interface;

import Negocio.BarException;
import Negocio.CategoriaVIP;
import Persistencia.DAOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class RegistrarEntrada extends JFrame {

	private JPanel contentPane;
	private ClntGUI cntrl;
    private String categoria;
    private String tipoCliente;
    private String sexo;
    private JTextField jTextNome;
    private JTextField jTextCPF;
    private JTextField jTextIdade;

	/**
	 * Create the frame.
	 */
	public RegistrarEntrada(ClntGUI controler) {
		setTitle("Registrar Entrada");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel jLabelNome = new JLabel("Nome");
		jLabelNome.setBounds(19, 25, 42, 15);
		jLabelNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(jLabelNome);

		jTextNome = new JTextField();
		jTextNome.setBounds(71, 22, 240, 20);
		contentPane.add(jTextNome);
		jTextNome.setColumns(10);

		JLabel jLabelCPF = new JLabel("CPF");
		jLabelCPF.setBounds(25, 80, 36, 15);
		jLabelCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(jLabelCPF);

		jTextCPF = new JTextField();
		jTextCPF.setBounds(71, 78, 240, 20);
		contentPane.add(jTextCPF);
		jTextCPF.setColumns(10);

		JLabel jLabelIdade = new JLabel("Idade");
		jLabelIdade.setBounds(21, 136, 40, 14);
		contentPane.add(jLabelIdade);

		jTextIdade = new JTextField();
		jTextIdade.setBounds(71, 133, 90, 20);
		contentPane.add(jTextIdade);
		jTextIdade.setColumns(10);

		JLabel jLabelGenero = new JLabel("Sexo");
		jLabelGenero.setBounds(216, 136, 47, 14);
		contentPane.add(jLabelGenero);

		final JComboBox jCBSexo = new JComboBox();
		jCBSexo.setBounds(282, 133, 89, 20);
		jCBSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		contentPane.add(jCBSexo);

				JLabel jLabelCategoria = new JLabel("Categoria");
				jLabelCategoria.setBounds(206, 221, 71, 14);
				contentPane.add(jLabelCategoria);

		final JComboBox jCBCategoria = new JComboBox();
		jCBCategoria.setBounds(282, 218, 89, 20);
		jCBCategoria.setModel(new DefaultComboBoxModel(CategoriaVIP.values()));
		contentPane.add(jCBCategoria);


		final JComboBox jCBTipoCliente = new JComboBox();
		jCBTipoCliente.setBounds(85, 218, 90, 20);
		jCBTipoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (((String) (jCBTipoCliente.getSelectedItem())).equals("VIP") == true) {
					 jCBCategoria.enable();
			        } else {
			        	jCBCategoria.setSelectedIndex(0);
			        	jCBCategoria.disable();
			        }
			}
		});

				JLabel jLabelTipoCliente = new JLabel("Tipo Cliente");
				jLabelTipoCliente.setBounds(7, 221, 68, 14);
				contentPane.add(jLabelTipoCliente);
		jCBTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"", "Comum", "VIP"}));
		contentPane.add(jCBTipoCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(7, 306, 69, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVoltar);

		JButton btnSalvar = new JButton("Registrar");
		btnSalvar.setBounds(342, 306, 92, 23);
		btnSalvar.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				tipoCliente = jCBTipoCliente.getSelectedItem().toString();
		        if(tipoCliente.equals("COMUM")){
		            categoria= null;
		        }
		        else{
		             categoria = ((CategoriaVIP) jCBCategoria.getSelectedItem()).toString();
		        }
		        try {
		            if(cntrl.validaCliente(jTextCPF.getText())){

		                jTextCPF.setText(null);
		            }
		        } catch (DAOException ex) {
		           JOptionPane.showMessageDialog(contentPane, "CPF ja cadastrado");
		        }
		        try {
		            cntrl.salvar(jTextNome.getText(), jTextCPF.getText(), jCBSexo.getSelectedItem().toString(), jTextIdade.getText(), tipoCliente, categoria);
		            JOptionPane.showMessageDialog(contentPane, "Cliente cadastrado com sucesso!!");
		            jTextCPF.setText(null);
			        jTextNome.setText(null);
			        jTextIdade.setText(null);
			        jCBSexo.setSelectedIndex(0);
			        jCBCategoria.setSelectedIndex(0);
			        jCBTipoCliente.setSelectedIndex(0);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Campos Preenchidos Incorretamente ");
		        } catch (BarException ex) {
		            JOptionPane.showMessageDialog(contentPane, "Falha ao salvar. " + ex.getMessage());
		        }

			}
		});
		contentPane.add(btnSalvar);



		this.cntrl = controler;
		 jCBCategoria.disable();

	}

}
