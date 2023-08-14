package br.com.conta.DAO;

import br.com.conta.model.Medidor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedidorDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO medidor (descricao, id_poste, id_rota) VALUES(?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, id_poste, id_rota FROM medidor WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM medidor;";
    private static final String DELETE = "DELETE FROM medidor WHERE id = ?;";
    private static final String UPDATE = "UPDATE medidor SET descricao = ?, id_poste = ?, id_rota = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM medidor;";

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

    public Medidor insert(Medidor model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getDescricao());
            preparedStatement.setInt(2, model.getIdPoste());
            preparedStatement.setInt(3, model.getIdRota());
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

    public Medidor findById(int id) {
        Medidor model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int id_poste = rs.getInt("id_poste");
                int id_rota = rs.getInt("id_rota");
                model = new Medidor(id, descricao, id_poste, id_rota);
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

    public List<Medidor> findAll() {
        List<Medidor> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int id_poste = rs.getInt("id_poste");
                int id_rota = rs.getInt("id_rota");
                modelList.add(new Medidor(id, descricao, id_poste, id_rota));
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

    public boolean update(int id, Medidor model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getDescricao());
            statement.setInt(2, model.getIdPoste());
            statement.setInt(3, model.getIdRota());
            statement.setInt(4, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}