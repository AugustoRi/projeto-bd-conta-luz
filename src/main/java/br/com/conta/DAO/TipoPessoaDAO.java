package br.com.conta.DAO;

import br.com.conta.model.TipoPessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoPessoaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO tipo_pessoa (descricao) VALUES (?);";
    private static final String FIND_BY_ID = "SELECT id, descricao FROM tipo_pessoa WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM tipo_pessoa;";
    private static final String DELETE = "DELETE FROM tipo_pessoa WHERE id = ?;";
    private static final String UPDATE = "UPDATE tipo_pessoa SET descricao = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tipo_pessoa;";

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

    public TipoPessoa insert(TipoPessoa model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getDescricao());
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

    public TipoPessoa findById(int id) {
        TipoPessoa model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                model = new TipoPessoa(id, descricao);
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

    public List<TipoPessoa> findAll() {
        List<TipoPessoa> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                modelList.add(new TipoPessoa(id, descricao));
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

    public boolean update(int id, TipoPessoa model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getDescricao());
            statement.setInt(2, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
