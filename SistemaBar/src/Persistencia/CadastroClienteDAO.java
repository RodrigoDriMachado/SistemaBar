package Persistencia;

import java.util.ArrayList;

import Negocio.Cliente;
import java.util.List;
import Negocio.CadastroCliente;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroClienteDAO implements CadastroCliente {

    private ClienteTxtFile clntTxt;
    private List<Cliente> listaCliente;
    private static CadastroClienteDAO cad = null;
    private FileWriter arq;
    private PrintWriter gravarArq;
//  FileWriter arq;
    // PrintWriter gravarArq = new PrintWriter(arq);

    public CadastroClienteDAO() throws IOException {

        clntTxt = new ClienteTxtFile();
        /*
        this.arq = new FileWriter("C:\\Users\\l61615\\Documents\\entrada.txt");
        this.gravarArq = new PrintWriter(arq);*/
        // this.arq = new FileWriter("C:\\Users\\l61615\\Documents\\NetBeansProjects\\SistemaBAR\\entrada.txt");
        listaCliente = new ArrayList<>();
    }

    public static CadastroClienteDAO getInstance() throws IOException {
        if (cad == null) {
            cad = new CadastroClienteDAO();
        }
        return cad;
    }

    @Override
    public void add(Cliente cliente) {
        listaCliente.add(cliente);

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
                }
            }
        } else if (listaCliente.isEmpty()) {
            throw new DAOException("Lista Vazia");
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
        List<Cliente> listaClientePorCategoria = new ArrayList();
        if (categoria.equals("GOLD")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("GOLD")) {
                    listaClientePorCategoria.add(cliente);
                }
            }
        } else if (categoria.equals("SILVER")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("SILVER")) {
                    listaClientePorCategoria.add(cliente);
                }
            }
        } else if (categoria.equals("PLATINUM")) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCategoria().equals("PLATINUM")) {
                    listaClientePorCategoria.add(cliente);
                }
            }
        }
        return listaClientePorCategoria;
    }

    @Override
    public int totalCliente() {
        return this.listaCliente.size();
    }

    @Override
    public boolean vazia() {
        return listaCliente.isEmpty();
    }

}
