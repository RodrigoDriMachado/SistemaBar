package Persistencia;

import Negocio.Cliente;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClienteTxtFile {

    private static final String arquivoEntrada = "entrada.txt";
    private static final String arquivoSaida = "saida.txt";
    private List<Cliente> listaCliente;

    private void saveDataEntrada() throws IOException {
       FileWriter fw = new FileWriter(arquivoEntrada);
        for (Cliente c : listaCliente) {
            fw.write(c.toString());
            fw.write("\n");
        }
        fw.close();
    }

    private void loadDataEntrada() throws IOException {
        FileReader fr = new FileReader(arquivoEntrada);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String nome = st.nextToken();
            String cpf = st.nextToken();

            int idade = 0;

            try {
                idade = Integer.parseInt(st.nextToken());

            } catch (NumberFormatException e) {
                throw new IOException("Formato de dados invlido", e);
            }
            String sexo = st.nextToken();
            String tipoCliente = st.nextToken();
            String categoria = st.nextToken();

            try {
                Cliente clnt = new Cliente(nome, cpf, sexo, idade, tipoCliente, categoria);
                listaCliente.add(clnt);
            } catch (IllegalArgumentException e) {
                throw new IOException("Valor de dados invalido", e);
            }
            line = br.readLine();
        }
        br.close();
    }

    private void saveDataSaida(Cliente clnt) throws IOException {
        FileWriter fw = new FileWriter(arquivoSaida);
        for (Cliente c : listaCliente) {
            if (c.equals(clnt)) {
                fw.write(c.toString());
            }
        }
        fw.close();
    }

    private void loadDataSaida() throws IOException {
        FileReader fr = new FileReader(arquivoEntrada);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            String nome = st.nextToken();
            String cpf = st.nextToken();

            int idade = 0;

            try {
                idade = Integer.parseInt(st.nextToken());

            } catch (NumberFormatException e) {
                throw new IOException("Formato de dados invlido", e);
            }
            String sexo = st.nextToken();
            String tipoCliente = st.nextToken();
            String categoria = st.nextToken();

            try {
                Cliente clnt = new Cliente(nome, cpf, sexo, idade, tipoCliente, categoria);
                listaCliente.add(clnt);
            } catch (IllegalArgumentException e) {
                throw new IOException("Valor de dados invalido", e);
            }
            line = br.readLine();
        }
        br.close();
    }

    public ClienteTxtFile() throws IOException {
        listaCliente = new ArrayList<Cliente>();
        File fentrada = new File(arquivoEntrada);
        File fsaida = new File(arquivoSaida);
    }

    public void add(Cliente cliente) {
        listaCliente.add(cliente);
        try {
            saveDataEntrada();
        } catch (IOException ex) {
            Logger.getLogger(ClienteTxtFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeCliente(Cliente cliente) throws DAOException {
        try {
            saveDataSaida(cliente);
        } catch (IOException mensagem) {
           throw new DAOException("Erro ao salvar arquivo!");
        }
        listaCliente.remove(cliente);
    }



}
