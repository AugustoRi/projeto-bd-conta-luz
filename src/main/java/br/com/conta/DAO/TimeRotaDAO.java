package br.com.conta.DAO;

import br.com.conta.model.TimeRota;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeRotaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO time_rota (funcionario_id, tarefa_rota_id) VALUES(?, ?);";
    private static final String FIND_BY_ID = "SELECT id, funcionario_id, tarefa_rota_id FROM time_rota WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM time_rota;";
    private static final String DELETE = "DELETE FROM time_rota WHERE id = ?;";
    private static final String UPDATE = "UPDATE time_rota SET funcionario_id = ?, tarefa_rota_id = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM time_rota;";

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

    public TimeRota insert(TimeRota model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setInt(1, model.getFuncionarioId());
            preparedStatement.setInt(2, model.getTarefaRotaId());
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

    public TimeRota findById(int id) {
        TimeRota model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int funcionario_id = rs.getInt("funcionario_id");
                int tarefa_rota_id = rs.getInt("tarefa_rota_id");
                model = new TimeRota(id, funcionario_id, tarefa_rota_id);
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

    public List<TimeRota> findAll() {
        List<TimeRota> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int funcionario_id = rs.getInt("funcionario_id");
                int tarefa_rota_id = rs.getInt("tarefa_rota_id");
                modelList.add(new TimeRota(id, funcionario_id, tarefa_rota_id));
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

    public boolean update(int id, TimeRota model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setInt(1, model.getFuncionarioId());
            statement.setInt(2, model.getTarefaRotaId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
