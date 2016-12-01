package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistencia.DAOException;

public class ClienteDAO implements CadastroClienteDAO {

    private List<Cliente> listaCliente;
    private static ClienteDAO cad = null;


    public ClienteDAO() throws IOException {
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
    		throw new DAOException("CPF já cadastrado");
    	}
    	if(cliente.getTipoCliente().equalsIgnoreCase("VIP") && cliente.getCategoria().equals(null)){
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
        Cliente clnt = null;
        if (!listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getCpf().equals(cpf)) {
                    clnt = listaCliente.get(i);
                    break;
                }
            }
        }
        return clnt;
    }

    @Override
    public int quantidadeClientesGenero(String genero) {
        int cont = 0;
        if (genero.equalsIgnoreCase("Feminino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equalsIgnoreCase("Feminino")) {
                    cont++;
                }
            }

        } else if (genero.equalsIgnoreCase("Masculino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equalsIgnoreCase("Masculino")) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public int quantidadeClienteCategoria(String categoria) {
        int cont = 0;
        if (categoria.equalsIgnoreCase("Silver")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equalsIgnoreCase("Silver")) {
                    cont++;
                }
            }

        } else if (categoria.equalsIgnoreCase("Gold")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equalsIgnoreCase("Gold")) {
                    cont++;
                }
            }
        }
        else if(categoria.equalsIgnoreCase("Platinum")){
            for(Cliente cliente : listaCliente){
                if(cliente.getCategoria().equalsIgnoreCase("Platinum")){
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
        List<Cliente> listaClientePorSexo = new ArrayList<Cliente>();
        if (sexo.equalsIgnoreCase("Masculino")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equalsIgnoreCase("Masculino")) {
                    listaClientePorSexo.add(cliente);
                }
            }
        } else {
            for (Cliente cliente : listaCliente) {
                if (cliente.getSexo().equalsIgnoreCase("Feminino")) {
                    listaClientePorSexo.add(cliente);
                }
            }
        }
        return listaClientePorSexo;
    }

    @Override
    public List<Cliente> listaClientePorCategoria(String categoria) {
        List<Cliente> listaClientePorCategoria = new ArrayList<Cliente>();
        if (categoria.equalsIgnoreCase("Silver")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equalsIgnoreCase("Silver")) {
                	listaClientePorCategoria.add(cliente);
                }
            }

        } else if (categoria.equalsIgnoreCase("Gold")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equalsIgnoreCase("Gold")) {
                	listaClientePorCategoria.add(cliente);;
                }
            }
        }
        else if(categoria.equalsIgnoreCase("Platinum")){
            for(Cliente cliente : listaCliente){
                if(cliente.getCategoria().equalsIgnoreCase("Platinum")){
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
