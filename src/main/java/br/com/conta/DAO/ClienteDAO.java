package br.com.conta.DAO;

import br.com.conta.model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO cliente (num_documento, num_cliente, pessoa_id) VALUES(?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, num_documento, num_cliente, pessoa_id FROM cliente WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM cliente;";
    private static final String DELETE = "DELETE FROM cliente WHERE id = ?;";
    private static final String UPDATE = "UPDATE cliente SET num_documento = ?, num_cliente = ? , pessoa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM cliente;";

    public Integer count() {
        Integer count = 0;

        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public Cliente insert(Cliente model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getNumDocumento());
            preparedStatement.setString(2, model.getNumCliente());
            preparedStatement.setInt(3, model.getPessoaId());
            preparedStatement.executeUpdate();
            return model;
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public Cliente findById(int id) {
        Cliente model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int pessoaId = rs.getInt("pessoa_id");
                model = new Cliente(id, numDocumento, numCliente, pessoaId);
                return model;
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Cliente> findAll() {
        List<Cliente> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String numDocumento = rs.getString("num_documento");
                String numCliente = rs.getString("num_cliente");
                int pessoaId = rs.getInt("pessoa_id");
                modelList.add(new Cliente(id, numDocumento, numCliente, pessoaId));
            }
        }
        catch (SQLException e) {
            printSQLException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return modelList;
    }

    public boolean delete(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, Cliente model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getNumDocumento());
            statement.setString(2, model.getNumCliente());
            statement.setInt(3, model.getPessoaId());
            statement.setInt(4, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
