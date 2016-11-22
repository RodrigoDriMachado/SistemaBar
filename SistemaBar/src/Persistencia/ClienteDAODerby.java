package Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Negocio.CadastroClienteDAO;
import Negocio.Cliente;

public class ClienteDAODerby implements CadastroClienteDAO {

	@Override
	public void add(Cliente cliente) throws DAOException {
		int resultado = 0;
		if (pesquisaClienteCPF(cliente.getCpf()) != null) {
			throw new DAOException("CPF ja existe no banco de dados!!");
		}
		String sql = "INSERT INTO Clientes (NOME, CPF, GENERO, IDADE, TP_CLNT, CT_CLNT) VALUES (?,?,?,?,?,?)";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, cliente.getNome());
				comando.setString(2, cliente.getCpf());
				comando.setString(3, cliente.getSexo());
				comando.setInt(4, cliente.getIdade());
				comando.setString(5, cliente.getTipoCliente());
				comando.setString(6, cliente.getCategoria());
				resultado = comando.executeUpdate();
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na inserção. " + ex.getMessage());
		}
		if (resultado == 0)
			throw new DAOException("Falha na inserção.");

	}

	@Override
	public void removeCliente(Cliente cliente) throws DAOException {
		Cliente clnt;
		clnt = pesquisaClienteCPF(cliente.getCpf());
		if (clnt != null) {
			String sql = "DELETE FROM Cliente WHERE CPF = ? ";
			try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
				try (PreparedStatement comando = conexao.prepareStatement(sql)) {
					comando.setString(1, cliente.getCpf());
					comando.executeQuery();

				}
			} catch (Exception ex) {
				throw new DAOException("Falha na busca. " + ex.getMessage());
			}
		}
	}

	@Override
	public Cliente pesquisaClienteCPF(String cpf) throws DAOException {
		Cliente cliente = null;
		String sql = "SELECT NOME, CPF,  GENERO, IDADE, TP_CLNT, CT_CLNT FROM Clientes WHERE CPF = ?";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, cpf);
				try (ResultSet resultado = comando.executeQuery()) {
					if (resultado.next()) {
						cliente = new Cliente(resultado.getString("NOME"), resultado.getString("CPF"),
								resultado.getString("GENERO"), resultado.getInt("IDADE"),
								resultado.getString("TP_CLNT"), resultado.getString("CT_CLNT"));
					}
					return cliente;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}

	}

	@Override
	public int quantidadeClienteCategoria(String categoria) throws DAOException {
		int quantidade = 0;
		String sql = "SELECT COUNT(*) FROM Clientes WHERE CT_CLLNT = ?";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, categoria);
				try (ResultSet resultado = comando.executeQuery()) {
					if (resultado.next()) {
						quantidade = resultado.getInt(0);
					}
					return quantidade;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}

	}

	@Override
	public int quantidadeClientesGenero(String genero) throws DAOException {
		int quantidade = 0;
		String sql = "SELECT COUNT(*) FROM Clientes WHERE GENERO = ?";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, genero);
				try (ResultSet resultado = comando.executeQuery()) {
					if (resultado.next()) {
						quantidade = resultado.getInt(0);
					}
					return quantidade;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}
	}

	@Override
	public List<Cliente> listaCliente() throws DAOException {
		List<Cliente> lst = new ArrayList<>();
		String sql = "SELECT NOME, CPF,  GENERO, IDADE, TP_CLNT, CT_CLNT FROM Clientes";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				try (ResultSet resultado = comando.executeQuery()) {
					while (resultado.next()) {
						lst.add(new Cliente(resultado.getString("NOME"), resultado.getString("CPF"),
								resultado.getString("GENERO"), resultado.getInt("IDADE"),
								resultado.getString("TP_CLNT"), resultado.getString("CT_CLNT")));
					}
					return lst;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}
	}

	@Override
	public List<Cliente> listaClientePorSexo(String sexo) throws DAOException {
		List<Cliente> lst = new ArrayList<>();
		String sql = "SELECT NOME, CPF, GENERO, IDADE, TP_CLNT, CT_CLNT FROM Clientes WHERE GENERO = ?";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, sexo);
				try (ResultSet resultado = comando.executeQuery()) {
					while (resultado.next()) {
						lst.add(new Cliente(resultado.getString("NOME"), resultado.getString("CPF"),
								resultado.getString("GENERO"), resultado.getInt("IDADE"),
								resultado.getString("TP_CLNT"), resultado.getString("CT_CLNT")));
					}
					return lst;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}
	}

	@Override
	public List<Cliente> listaClientePorCategoria(String categoria) throws DAOException {
		List<Cliente> lst = new ArrayList<>();
		String sql = "SELECT NOME, CPF,  GENERO, IDADE, TP_CLNT, CT_CLNT FROM Clientes WHERE CT_CLNT = ?";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				comando.setString(1, categoria);
				try (ResultSet resultado = comando.executeQuery()) {
					while (resultado.next()) {
						lst.add(new Cliente(resultado.getString("NOME"), resultado.getString("CPF"),
								resultado.getString("GENERO"), resultado.getInt("IDADE"),
								resultado.getString("TP_CLNT"), resultado.getString("CT_CLNT")));
					}
					return lst;
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}
	}

	@Override
	public boolean vazia() throws DAOException {
		String sql = "SELECT NOME, CPF,  GENERO, IDADE, TP_CLNT, CT_CLNT FROM Clientes";
		try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
			try (PreparedStatement comando = conexao.prepareStatement(sql)) {
				try (ResultSet resultado = comando.executeQuery()) {
					if (resultado.next()) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch (Exception ex) {
			throw new DAOException("Falha na busca. " + ex.getMessage());
		}
	}

	@Override
	public int totalCliente() {
		// TODO Auto-generated method stub
		return 0;
	}
}
