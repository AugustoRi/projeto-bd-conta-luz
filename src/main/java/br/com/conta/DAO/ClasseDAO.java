package br.com.conta.DAO;

import br.com.conta.model.Classe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO classe (descricao, tipo_fase_id) VALUES(?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, tipo_fase_id FROM classe WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM classe;";
    private static final String DELETE = "DELETE FROM classe WHERE id = ?;";
    private static final String UPDATE = "UPDATE classe SET descricao = ?, tipo_fase_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM classe;";

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

    public Classe insert(Classe model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getDescricao());
            preparedStatement.setInt(2, model.getTipoFaseId());
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

    public Classe findById(int id) {
        Classe model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int tipo_fase_id = rs.getInt("tipo_fase_id");
                model = new Classe(id, descricao, tipo_fase_id);

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

    public List<Classe> findAll() {
        List<Classe> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int tipo_fase_id = rs.getInt("tipo_fase_id");
                modelList.add(new Classe(id, descricao, tipo_fase_id));
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

    public boolean update(int id, Classe model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getDescricao());
            statement.setInt(2, model.getTipoFaseId());
            statement.setInt(3, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
