package br.com.conta.DAO;

import br.com.conta.model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO funcionario (codigo_funcional, pessoa_id) VALUES(?, ?);";
    private static final String FIND_BY_ID = "SELECT id, codigo_funcional, pessoa_id FROM funcionario WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM funcionario;";
    private static final String DELETE = "DELETE FROM funcionario WHERE id = ?;";
    private static final String UPDATE = "UPDATE funcionario SET codigo_funcional = ?, pessoa_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM funcionario;";

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

    public Funcionario insert(Funcionario model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getCodigoFuncional());
            preparedStatement.setInt(2, model.getPessoaId());
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

    public Funcionario findById(int id) {
        Funcionario model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoaId = rs.getInt("pessoa_id");
                model = new Funcionario(id, codigoFuncional, pessoaId);
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

    public List<Funcionario> findAll() {
        List<Funcionario> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String codigoFuncional = rs.getString("codigo_funcional");
                int pessoaId = rs.getInt("pessoa_id");
                modelList.add(new Funcionario(id, codigoFuncional, pessoaId));
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

    public boolean update(int id, Funcionario model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getCodigoFuncional());
            statement.setInt(2, model.getPessoaId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}