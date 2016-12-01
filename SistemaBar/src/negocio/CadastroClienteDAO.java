package Negocio;

import Persistencia.DAOException;
import java.util.ArrayList;
import java.util.List;

public interface CadastroClienteDAO {

    public void add(Cliente cliente) throws DAOException;

    public void removeCliente(Cliente cliente)throws DAOException;

    public Cliente pesquisaClienteCPF(String cpf)throws DAOException;

    public int quantidadeClienteCategoria(String categoria) throws DAOException;

    public int quantidadeClientesGenero(String genero) throws DAOException;

    public List<Cliente> listaCliente() throws DAOException;

    public List<Cliente> listaClientePorSexo(String sexo) throws DAOException;

    public List<Cliente> listaClientePorCategoria(String categoria) throws DAOException;

    public int totalCliente() throws DAOException;

    public boolean vazia() throws DAOException;

    public void removeAll() throws DAOException;

}
