package br.com.conta.DAO;

import br.com.conta.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO pessoa (nome, cpf, cnpj, tipo_pessoa_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, nome, cpf, cnpj, tipo_pessoa_id FROM pessoa WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM pessoa;";
    private static final String DELETE = "DELETE FROM pessoa WHERE id = ?;";
    private static final String UPDATE = "UPDATE pessoa SET nome = ?, cpf = ? , cnpj = ?, tipo_pessoa_id = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM pessoa;";

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

    public Pessoa insert(Pessoa model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getNome());
            preparedStatement.setString(2, model.getCpf());
            preparedStatement.setString(3, model.getCnpj());
            preparedStatement.setInt(4, model.getTipoPessoaId());
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

    public Pessoa findById(int id) {
        Pessoa model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int tipoPessoaId = rs.getInt("tipo_pessoa_id");
                model = new Pessoa(id, nome, cpf, cnpj, tipoPessoaId);
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

    public List<Pessoa> findAll() {
        List<Pessoa> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");
                int tipoPessoaId = rs.getInt("tipo_pessoa_id");
                modelList.add(new Pessoa(id, nome, cpf, cnpj, tipoPessoaId));
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

    public boolean update(int id, Pessoa model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getNome());
            statement.setString(2, model.getCpf());
            statement.setString(3, model.getCnpj());
            statement.setInt(4, model.getTipoPessoaId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}