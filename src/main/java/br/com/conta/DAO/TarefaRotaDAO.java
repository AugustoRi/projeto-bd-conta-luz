package br.com.conta.DAO;

import br.com.conta.model.TarefaRota;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TarefaRotaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO tarefa_rota (observacao, data_inicio, data_fim, rota_id) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, observacao, data_inicio, data_fim, rota_id FROM tarefa_rota WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM tarefa_rota;";
    private static final String DELETE = "DELETE FROM tarefa_rota WHERE id = ?;";
    private static final String UPDATE = "UPDATE tarefa_rota SET observacao = ?, data_inicio = ?, data_fim = ?, rota_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarefa_rota;";

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

    public TarefaRota insert(TarefaRota model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getObservacao());
            preparedStatement.setDate(2, model.getDataInicio());
            preparedStatement.setDate(3, model.getDataFim());
            preparedStatement.setInt(4, model.getRotaId());
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

    public TarefaRota findById(int id) {
        TarefaRota model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int rota_id = rs.getInt("rota_id");
                model = new TarefaRota(id, observacao, data_inicio, data_fim, rota_id);
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

    public List<TarefaRota> findAll() {
        List<TarefaRota> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int rota_id = rs.getInt("rota_id");
                modelList.add(new TarefaRota(id, observacao, data_inicio, data_fim, rota_id));
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

    public boolean update(int id, TarefaRota model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getObservacao());
            statement.setDate(2, model.getDataInicio());
            statement.setDate(3, model.getDataFim());
            statement.setInt(4, model.getRotaId());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}