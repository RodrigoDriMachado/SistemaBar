package Persistencia;

import java.util.ArrayList;

import Negocio.Cliente;
import java.util.List;
import Negocio.CadastroCliente;

public class CadastroClienteDAO implements CadastroCliente {

    private List<Cliente> listaCliente;
    private static CadastroClienteDAO cad = null;

    public CadastroClienteDAO() {
        listaCliente = new ArrayList<>();
    }

    public static CadastroClienteDAO getInstance() {
        if (cad == null) {
            cad = new CadastroClienteDAO();
        }
        return cad;
    }

    @Override
    public void cleanAll() {
        listaCliente.clear();

    }

    @Override
    public void add(Cliente Cliente) {
        listaCliente.add(Cliente);

    }

    @Override
    public boolean containsCliente(Cliente clnt) {
        return listaCliente.contains(clnt);

    }

    @Override
    public void removeCliente(int index) {
        listaCliente.remove(index);

    }

    @Override
    public Cliente pesquisaClienteNome(String nome) {
        Cliente clnt = null;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNome().equals(nome)) {
                clnt = listaCliente.get(i);
            }
        }
        return clnt;
    }

    @Override
    public boolean pesquisaClienteCPF(String cpf) {
        boolean aux = false;
        if (!listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i).getNome().equals(cpf)) {
                    aux = true;
                }
            }
        }
        return aux;
    }

    @Override
    public int pesquisaNodoCliente(String nome) {
        int aux = 0;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNome().equals(nome)) {
                aux = listaCliente.indexOf(listaCliente.get(i));
            }
        }
        return aux;
    }

    @Override
    public Cliente getCliente(String nome) {
        Cliente aux = null;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getNome().equals(nome)) {
                aux = listaCliente.get(i);
            }
        }
        return aux;
    }

    @Override
    public boolean vazia() {
        return listaCliente.isEmpty();
    }

    @Override
    public int ClntMasculino() {
        int contM = 0;
        for (Cliente cliente : listaCliente) {
            if (cliente.getSexo().equals("Masculino"));
            contM++;
        }
        return contM;
    }

    @Override
    public int ClntFeminino() {
        int contF = 0;
        for (Cliente cliente : listaCliente) {
            if (cliente.getSexo().equals("Feminino"));
            contF++;
        }
        return contF;
    }

    @Override
    public List<Cliente> ListaCliente() {
        return listaCliente;
    }

    @Override
    public List<Cliente> ListaClienteMasculino() {
         List<Cliente> listaMasculino = new ArrayList();
        for (Cliente cliente : listaCliente) {
            if (cliente.getSexo().equals("Masculino")){
                listaMasculino.add(cliente);
            }

        }
        return listaMasculino;
    }


     @Override
    public List<Cliente> ListaClienteFeminino() {
         List<Cliente> listaFeminino = new ArrayList();
        for (Cliente cliente : listaCliente) {
            if (cliente.getSexo().equals("Feminino")){
                listaFeminino.add(cliente);
            }

        }
        return listaFeminino;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Imprimindo Lista de Cliente");
        s.append("\n");
        s.append("\n");
        for (int i = 0; i < listaCliente.size(); i++) {
            s.append(listaCliente.get(i).toString());
            s.append("\n");
        }
        return s.toString();
    }

}
