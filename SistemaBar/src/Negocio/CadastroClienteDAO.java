package Negocio;

import Persistencia.DAOException;
import java.util.ArrayList;
import java.util.List;

public interface CadastroClienteDAO {
 
    public void add(Cliente cliente);

    public void removeCliente(Cliente cliente)throws DAOException;

    public Cliente pesquisaClienteCPF(String cpf)throws DAOException;

    public int quantidadeClienteCategoria(String categoria);
    
    public int quantidadeClientesGenero(String genero);

    public List<Cliente> listaCliente();

    public List<Cliente> listaClientePorSexo(String sexo);
    
    public List<Cliente> listaClientePorCategoria(String categoria);
    
    public int totalCliente();
    
    public boolean vazia();
}
