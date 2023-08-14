package br.com.conta.DAO;

import br.com.conta.model.Medicao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicaoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO medicao (mes, ano, data_medicao, consumo, medidor_id, time_rota_id) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id FROM medicao WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM medicao;";
    private static final String DELETE = "DELETE FROM medicao WHERE id = ?;";
    private static final String UPDATE = "UPDATE medicao SET mes = ?, ano = ?, data_medicao = ?, consumo = ?, medidor_id = ?, time_rota_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medicao;";

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

    public Medicao insert(Medicao model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getMes());
            preparedStatement.setString(2, model.getAno());
            preparedStatement.setDate(3, model.getDataMedicao());
            preparedStatement.setString(4, model.getConsumo());
            preparedStatement.setInt(5, model.getMedidorId());
            preparedStatement.setInt(6, model.getTimeRotaId());
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

    public Medicao findById(int id) {
        Medicao model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Date data_medicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                int time_rota_id = rs.getInt("time_rota_id");
                model = new Medicao(id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id);
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

    public List<Medicao> findAll() {
        List<Medicao> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String mes = rs.getString("mes");
                String ano = rs.getString("ano");
                Date data_medicao = rs.getDate("data_medicao");
                String consumo = rs.getString("consumo");
                int medidor_id = rs.getInt("medidor_id");
                int time_rota_id = rs.getInt("time_rota_id");
                modelList.add(new Medicao(id, mes, ano, data_medicao, consumo, medidor_id, time_rota_id));
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

    public boolean update(int id, Medicao model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getMes());
            statement.setString(2, model.getAno());
            statement.setDate(3, model.getDataMedicao());
            statement.setString(4, model.getConsumo());
            statement.setInt(5, model.getMedidorId());
            statement.setInt(6, model.getTimeRotaId());
            statement.setInt(7, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
