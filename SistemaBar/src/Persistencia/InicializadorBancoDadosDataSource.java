package Persistencia;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.iapi.sql.ResultSet;
import org.apache.derby.jdbc.EmbeddedDataSource;

public class InicializadorBancoDadosDataSource {

	public static String DB_NAME = "cadastroCliente";
	public static String USER_NAME = "usuario";
	public static String PASSWORD = "password";
	private static DataSource dataSource;

	private static Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public static void validaObjetos() {
		try {
			connection = conectarBd();
			DatabaseMetaData meta = connection.getMetaData();
			java.sql.ResultSet res2 = meta.getSchemas();
			boolean schema = false;
			while (res2.next()) {
				if (res2.getString("TABLE_SCHEM").compareTo("USUARIO") == 0) {
					schema = true;
				}
			}
			if (schema == false) {
				createSchema();
				createTable();
			} else {
				java.sql.ResultSet res = meta.getTables(null, null, null, new String[] { "TABLE" });
				boolean table = false;
				while (res.next()) {
					if (res.getString("TABLE_NAME").compareTo("CLIENTE") == 0) {
						table = true;
					}
				}

				if (table == false) {
					createTable();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static DataSource criarDataSource() throws Exception {
		if (dataSource == null) {
			EmbeddedDataSource ds = new EmbeddedDataSource();
			ds.setDatabaseName(DB_NAME);
			ds.setCreateDatabase("create");
			ds.setUser(USER_NAME);
			ds.setPassword(PASSWORD);
			dataSource = ds;
			validaObjetos();
		}
		return dataSource;
	}

	public static void createSchema() throws Exception {
		try (Connection con = criarDataSource().getConnection(); Statement sta = con.createStatement()) {
			String sql = "CREATE SCHEMA USUARIO  AUTHORIZATION USUARIO";
			sta.executeUpdate(sql);
		}
	}

	public static void createTable() throws Exception {
		try (Connection con = criarDataSource().getConnection(); Statement sta = con.createStatement()) {
			String sql = " CREATE TABLE USUARIO.CLIENTE (" + "NOME VARCHAR(50), " + "CPF VARCHAR(20) NOT NULL,"
					+ "GENERO VARCHAR(20), " + "IDADE NUMERIC(3), " + "TP_CLNT VARCHAR(20) NOT NULL, "
					+ "CT_CLNT VARCHAR(20), PRIMARY KEY (CPF))";
			sta.executeUpdate(sql);
		}
	}

	public static Connection conectarBd() throws Exception {
		return criarDataSource().getConnection();

	}
}
