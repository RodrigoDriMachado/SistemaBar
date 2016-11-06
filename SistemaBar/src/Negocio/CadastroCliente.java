package Negocio;

import java.util.ArrayList;
import java.util.List;

public interface CadastroCliente {

    public void cleanAll();

    public void add(Cliente Cliente);

    public boolean containsCliente(Cliente clnt);

    public void removeCliente(int index);

    public Cliente pesquisaClienteNome(String nome);

    public boolean pesquisaClienteCPF(String cpf);

    public int pesquisaNodoCliente(String nome);

    public Cliente getCliente(String nome);

    public boolean vazia();

    public int ClntMasculino();

    public int ClntFeminino();

    public List<Cliente> ListaCliente();

    public List<Cliente> ListaClienteMasculino();

    public List<Cliente> ListaClienteFeminino();

    @Override
    public String toString();

}
