package Persistencia;

import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;


public class InicializadorBancoDadosDataSource {


	    public static String DB_NAME = "cadastroCliente";
	    public static String USER_NAME = "usuario";
	    public static String PASSWORD = "password";
	    private static DataSource dataSource;



	    private static DataSource criarDataSource() throws Exception {
	        if (dataSource == null) {
	            EmbeddedDataSource ds = new EmbeddedDataSource();
	            ds.setDatabaseName(DB_NAME);
	            ds.setCreateDatabase("create");
	            ds.setUser(USER_NAME);
	            ds.setPassword(PASSWORD);
	            dataSource = ds;
	        }
	        return dataSource;
	    }

	    public static void criarBd() throws Exception {
	        try (Connection con = criarDataSource().getConnection();
	                Statement sta = con.createStatement()) {
	            String sql = " CREATE TABLE USUARIO.CLIENTE ("
	            			+ "NOME VARCHAR(50), "
	            			+ "CPF VARCHAR(20) NOT NULL,"
	            			+ "GENERO VARCHAR(20), "
	            			+ "IDADE NUMERIC(3), "
	            			+ "TP_CLNT VARCHAR(20) NOT NULL, "
	            			+ "CT_CLNT VARCHAR(20), PRIMARY KEY (CPF))";
	            sta.executeUpdate(sql);
	        }
	    }

	    public static Connection conectarBd() throws Exception {
	        return criarDataSource().getConnection();
	    }
}
