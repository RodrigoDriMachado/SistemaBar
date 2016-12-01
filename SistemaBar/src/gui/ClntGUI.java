package gui;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import negocio.BarException;
import negocio.CadastroClienteDAO;
import negocio.Cliente;
import negocio.ClienteDAO;
import negocio.ValidadorCliente;
import persistencia.ClienteDAODerby;
import persistencia.ClienteTxtFile;
import persistencia.DAOException;

public class ClntGUI {

    private CadastroClienteDAO cadCliente;
    private ClienteTxtFile clntTXT;
    private CadastroClienteDAO cadClienteDerby;

    public ClntGUI() throws BarException {

        try {
        	cadCliente = new ClienteDAO();
            clntTXT = new ClienteTxtFile();

           cadClienteDerby = new ClienteDAODerby();

        } catch (Exception ex) {
            throw new BarException(ex);
        }
    }

    public void salvar(String nome, String cpf, String sexo, String sIdade, String tpClnt, String categoria) throws BarException, NumberFormatException {
        int idade = Integer.parseInt(sIdade);
        if (!ValidadorCliente.getInstance().validaNome(nome))
            throw new BarException("Nome invalido");
        if (!ValidadorCliente.getInstance().validaCpf(cpf))
            throw new BarException("Cpf invalido");
        if (!ValidadorCliente.getInstance().validaIdade(idade))
            throw new BarException("Idade invalida");
        if(!ValidadorCliente.getInstance().validaSexo(sexo))
        	throw new BarException("Opção sexo inválida");
       /* if(!ValidadorCliente.getInstance().validaTipoCliente(tpClnt, categoria))
        	throw new BarException("Tipo e categoria do cliente não são compatíveis");*/
        Cliente clnt = new Cliente(nome, cpf, sexo, idade, tpClnt, categoria);

        try {
			cadCliente.add(clnt);
			cadClienteDerby.add(clnt);
		} catch (DAOException e) {
        	throw new BarException(e);
		}

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

    public ListModel<Cliente> getClientes() throws BarException {
        DefaultListModel<Cliente> lmCliente = new DefaultListModel<Cliente>();
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

    public ListModel<Cliente> getClientesGenero(String genero) throws BarException {
        DefaultListModel<Cliente> lmClienteGenero = new DefaultListModel<Cliente>();
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

    public ListModel<Cliente> getClientesCategoria(String categoria) throws BarException {
        DefaultListModel<Cliente> lmClienteCategoria = new DefaultListModel<Cliente>();
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

    public int quantidadeClientesGenero(String genero) throws DAOException {
    	try{
        return cadCliente.quantidadeClientesGenero(genero);
    	}
    	catch (DAOException e) {
			throw new DAOException("Falha ao buscar quantidade");
		}
    }

    public int quantidadeClientesCategoria(String categoria) throws BarException{
        try {
			return cadCliente.quantidadeClienteCategoria(categoria);
		} catch (DAOException e) {
			throw new BarException(e);
		}

    }

    public int totalClientes() throws BarException {
        try {
			return cadCliente.totalCliente();
		} catch (DAOException e) {
			throw new BarException(e);
		}
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
