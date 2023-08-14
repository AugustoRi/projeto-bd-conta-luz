package br.com.conta.DAO;

import br.com.conta.model.Tarifa;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarifaDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO tarifa (taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS FROM tarifa WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM tarifa;";
    private static final String DELETE = "DELETE FROM tarifa WHERE id = ?;";
    private static final String UPDATE = "UPDATE tarifa SET taxa = ?, classe_id = ?, lei = ?, data_inicio = ?, data_fim = ?, aliquota_ICMS = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM tarifa;";

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

    public Tarifa insert(Tarifa model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getTaxa());
            preparedStatement.setInt(2, model.getClasseId());
            preparedStatement.setString(3, model.getLei());
            preparedStatement.setDate(4, model.getDataInicio());
            preparedStatement.setDate(5, model.getDataFim());
            preparedStatement.setString(6, model.getAliquotaIcms());
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

    public Tarifa findById(int id) {
        Tarifa model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String taxa = rs.getString("taxa");
                int classe_id = rs.getInt("classe_id");
                String lei = rs.getString("lei");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                model = new Tarifa(id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS);
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
        //return model
    }

    public List<Tarifa> findAll() {
        List<Tarifa> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String taxa = rs.getString("taxa");
                int classe_id = rs.getInt("classe_id");
                String lei = rs.getString("lei");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                String aliquota_ICMS = rs.getString("aliquota_ICMS");
                modelList.add(new Tarifa(id, taxa, classe_id, lei, data_inicio, data_fim, aliquota_ICMS));
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

    public boolean update(int id, Tarifa model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getTaxa());
            statement.setInt(2, model.getClasseId());
            statement.setString(3, model.getLei());
            statement.setDate(4, model.getDataInicio());
            statement.setDate(5, model.getDataFim());
            statement.setString(6, model.getAliquotaIcms());
            statement.setInt(7, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
