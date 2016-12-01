package persistencia;

import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import negocio.Cliente;
public class ClienteTxtFile {

    private static final String arquivoEntrada = "entrada.txt";
    private static final String arquivoSaida = "saida.txt";
    private List<Cliente> listaCliente;



    public ClienteTxtFile() throws IOException {
        listaCliente = new ArrayList<Cliente>();

    }

    private void saveDataEntrada() throws IOException {
       FileWriter fw = new FileWriter(arquivoEntrada);
        for (Cliente c : listaCliente) {
            fw.write(horas() + " " + c.toString());
            fw.write("\n");
        }
        fw.close();
    }

    private static String horas() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


    private void saveDataSaida(Cliente clnt) throws IOException {
        FileWriter fw = new FileWriter(arquivoSaida);
        for (Cliente c : listaCliente) {
            if (c.equals(clnt)) {
            	 fw.write(horas() + " " + c.toString());
            	 fw.write("\n");
            }
        }
        fw.close();
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
