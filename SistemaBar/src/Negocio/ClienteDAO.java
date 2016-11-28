package Negocio;

import java.util.ArrayList;
import java.util.List;

import Persistencia.ClienteTxtFile;
import Persistencia.DAOException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClienteDAO implements CadastroClienteDAO {

    private ClienteTxtFile clntTxt;
    private List<Cliente> listaCliente;
    private static ClienteDAO cad = null;


    public ClienteDAO() throws IOException {
        clntTxt = new ClienteTxtFile();
        listaCliente = new ArrayList<>();
    }

    public static ClienteDAO getInstance() throws IOException {
        if (cad == null) {
            cad = new ClienteDAO();
        }
        return cad;
    }

    @Override
    public void add(Cliente cliente) throws DAOException {
    	Cliente clnt = pesquisaClienteCPF(cliente.getCpf());
    	if(clnt != null){
    		throw new DAOException("CPF j� cadastrado");
    	}
    	if(cliente.getTipoCliente().equals("VIP") && cliente.getCategoria().equals(null)){
    		throw new DAOException("Clientes VIP devem informar uma categoria!");
    	}
    	else{
        listaCliente.add(cliente);
    	}

    }

    @Override
    public void removeCliente(Cliente cliente) throws DAOException {
        boolean achou = false;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).equals(cliente)) {
                listaCliente.remove(i);
                achou = true;
            }
        }
        if (achou == false) {
            throw new DAOException("Cliente Inexistente!!");
        }
    }

    @Override
    public Cliente pesquisaClienteCPF(String cpf) throws DAOException {
        boolean achou = false;
        Cliente clnt = null;
        if (!listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getCpf().equals(cpf)) {
                    clnt = listaCliente.get(i);
                    break;
                }
            }
        } else if (listaCliente.isEmpty()) {
            clnt = null;
        }
        return clnt;
    }

    @Override
    public int quantidadeClientesGenero(String genero) {
        int cont = 0;
        if (genero.equals("Feminino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equals("Feminino")) {
                    cont++;
                }
            }

        } else if (genero.equals("Masculino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equals("Masculino")) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public int quantidadeClienteCategoria(String categoria) {
        int cont = 0;
        if (categoria.equals("SILVER")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("SILVER")) {
                    cont++;
                }
            }

        } else if (categoria.equals("GOLD")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("GOLD")) {
                    cont++;
                }
            }
        }
        else if(categoria.equals("PLATINUM")){
            for(Cliente cliente : listaCliente){
                if(cliente.getCategoria().equals("PLATINUM")){
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public List<Cliente> listaCliente() {
        return listaCliente;
    }

    @Override
    public List<Cliente> listaClientePorSexo(String sexo) {
        List<Cliente> listaClientePorSexo = new ArrayList();
        if (sexo.equals("Masculino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equals("Masculino")) {
                    listaClientePorSexo.add(cliente);
                }
            }
        } else {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equals("Feminino")) {
                    listaClientePorSexo.add(cliente);
                }
            }
        }
        return listaClientePorSexo;
    }

    @Override
    public List<Cliente> listaClientePorCategoria(String categoria) {
        List<Cliente> listaClientePorCategoria = new ArrayList<Cliente>();
        if (categoria.equals("SILVER")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("SILVER")) {
                	listaClientePorCategoria.add(cliente);
                }
            }

        } else if (categoria.equals("GOLD")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("GOLD")) {
                	listaClientePorCategoria.add(cliente);;
                }
            }
        }
        else if(categoria.equals("PLATINUM")){
            for(Cliente cliente : listaCliente){
                if(cliente.getCategoria().equals("PLATINUM")){
                	listaClientePorCategoria.add(cliente);;
                }
            }
        }
        return listaClientePorCategoria;
    }


    @Override
    public boolean vazia() {
        return listaCliente.isEmpty();
    }

	@Override
	public int totalCliente() {
		return listaCliente.size();
	}

	@Override
	public void removeAll() throws DAOException {
		for(int i=0;i<listaCliente.size();i++){
			listaCliente.remove(i);
		}

	}

}