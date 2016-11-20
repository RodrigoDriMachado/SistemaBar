package Interface;

import Negocio.BarException;
import Negocio.Cliente;
import Negocio.ValidadorCliente;
import Persistencia.ClienteDAO;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import Negocio.CadastroClienteDAO;
import Persistencia.ClienteTxtFile;
import Persistencia.DAOException;

public class ClntGUI {

    private CadastroClienteDAO cadCliente;
    private ClienteTxtFile clntTXT;

    public ClntGUI() throws BarException {
        try {
            cadCliente = new ClienteDAO();
            clntTXT = new ClienteTxtFile();
        } catch (Exception ex) {
            throw new BarException(ex);
        }
    }

    public void salvar(String nome, String cpf, String sexo, String sIdade, String tpClnt, String categoria) throws BarException, NumberFormatException {
        int idade = Integer.parseInt(sIdade);
        if (!ValidadorCliente.getInstance().validaNome(nome)) {
            throw new BarException("Nome inválido");
        }
        if (!ValidadorCliente.getInstance().validaCpf(cpf)) {
            throw new BarException("Cpf inválido");
        }
        if (!ValidadorCliente.getInstance().validaIdade(idade)) {
            throw new BarException("Idade inválida");
        }
        Cliente clnt = new Cliente(nome, cpf, sexo, idade, tpClnt, categoria);
        cadCliente.add(clnt);
        clntTXT.add(clnt);
    }

    public boolean registrarSaida(String cpf) throws DAOException {
        Cliente clnt;
        boolean retorno = false;
        try {
            clnt = cadCliente.pesquisaClienteCPF(cpf);
            clntTXT.removeCliente(clnt);
            cadCliente.removeCliente(clnt);
            retorno = true;
        } catch (DAOException mensagem) {
            throw new DAOException("Nao foi possivel remover o cliente!!");
        }
        return retorno;
    }

    public ListModel getClientes() throws BarException {
        DefaultListModel lmCliente = new DefaultListModel();
        List<Cliente> clientes;
        try {
            clientes = cadCliente.listaCliente();
            for (Cliente clnt : clientes) {
                lmCliente.addElement(clnt);
            }
        } catch (Exception mensagem) {
            throw new BarException(mensagem);
        }
        return lmCliente;
    }

    public ListModel getClientesGenero(String genero) throws BarException {
        DefaultListModel lmClienteGenero = new DefaultListModel();
        List<Cliente> clientesGenero;
        try {
            clientesGenero = cadCliente.listaClientePorSexo(genero);
            for (Cliente clnt : clientesGenero) {
                lmClienteGenero.addElement(clnt);
            }
        } catch (Exception mensagem) {
            throw new BarException(mensagem);
        }
        return lmClienteGenero;
    }

    public ListModel getClientesCategoria(String categoria) throws BarException {
        DefaultListModel lmClienteCategoria = new DefaultListModel();
        List<Cliente> clientesCategoria;
        try {
            clientesCategoria = cadCliente.listaClientePorCategoria(categoria);
            for (Cliente clnt : clientesCategoria) {
                lmClienteCategoria.addElement(clnt);
            }
        } catch (Exception mensagem) {
            throw new BarException(mensagem);
        }
        return lmClienteCategoria;
    }

    public int quantidadeClientesGenero(String genero) {
        return cadCliente.quantidadeClientesGenero(genero);
    }

    public int quantidadeClientesCategoria(String categoria) {
        return cadCliente.quantidadeClienteCategoria(categoria);
    }

    public int totalClientes() {
        return cadCliente.totalCliente();
    }

    public boolean validaCliente(String cpf) throws DAOException {
        if (!cadCliente.vazia()) {
            Cliente clnt;
            clnt = cadCliente.pesquisaClienteCPF(cpf);
            if (clnt != null) {
                return true;
            }
        }
        return false;
    }

}