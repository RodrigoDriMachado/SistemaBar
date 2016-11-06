
package Interface;

import Negocio.BarException;
import Negocio.Cliente;
import Negocio.ValidadorCliente;
import Persistencia.CadastroClienteDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import Negocio.CadastroCliente;

public class CtrlGUI {

    private String contribuinteAtual;
    private CadastroCliente cadCliente;

    public CtrlGUI() throws BarException {
        try {
            //Melhor seria utilizar injeção de dependência
            cadCliente = new CadastroClienteDAO();
        } catch (Exception ex) {
            throw new BarException(ex);
        }
    }

    public void salvar(String nome, String cpf, String sIdade, String tpClnt, String sexo, String categoria) throws BarException, NumberFormatException {

        int idade = Integer.parseInt(sIdade);
        if (!ValidadorCliente.getInstance().validaNome(nome)) {
            throw new BarException("Nome inválido");
        }
        if (!ValidadorCliente.getInstance().validaCpf(cpf)) {
            throw new BarException("Cpf inválido");
        }
        if (!ValidadorCliente.getInstance().validaIdade(idade)) {
            throw new BarException("Idade inválida");
        }/*
        if(!ValidadorCliente.getInstance().validaTipoCliente(tpClnt, categoria)){
            throw new BarException("Tipo Cliente Incorreto");
        }*/

        Cliente clnt = new Cliente(nome, cpf, idade, tpClnt, sexo);
        clnt.setCateg(categoria);
        cadCliente.add(clnt);

    }

    public ListModel getClientes() throws BarException {
        DefaultListModel lmCliente = new DefaultListModel();
        List<Cliente> clientes;
        try {
            clientes = cadCliente.ListaCliente();
            for (Cliente clnt : clientes) {
                lmCliente.addElement(clnt);
            }
        } catch (Exception e) {
            throw new BarException(e);
        }
        return lmCliente;
    }

    public ListModel getClientesMasculino() throws BarException {
        DefaultListModel lmClienteMasculino = new DefaultListModel();
        List<Cliente> clientesMasculino;
        try {
            clientesMasculino = cadCliente.ListaClienteMasculino();
            for (Cliente clnt : clientesMasculino) {
                lmClienteMasculino.addElement(clnt);
            }
        } catch (Exception e) {
            throw new BarException(e);
        }
        return lmClienteMasculino;
    }

    public ListModel getClientesFeminino() throws BarException {
        DefaultListModel lmFeminino = new DefaultListModel();
        List<Cliente> clientesFeminino;
        try {
            clientesFeminino = cadCliente.ListaClienteFeminino();
            for (Cliente clnt : clientesFeminino) {
                lmFeminino.addElement(clnt);
            }
        } catch (Exception e) {
            throw new BarException(e);
        }
        return lmFeminino;
    }

}
