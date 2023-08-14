package br.com.conta.DAO;

import br.com.conta.model.Poste;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PosteDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO poste (latitude, longitude, codigo, observacao) VALUES(?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, latitude, longitude, codigo, observacao FROM poste WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM poste;";
    private static final String DELETE = "DELETE FROM poste WHERE id = ?;";
    private static final String UPDATE = "UPDATE poste SET latitude = ?, longitude = ? , codigo = ?, observacao = ? WHERE id= ?;";
    private static final String TOTAL = "SELECT count(1) FROM poste;";

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

    public Poste insert(Poste model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getLatitude());
            preparedStatement.setString(2, model.getLongitude());
            preparedStatement.setString(3, model.getCodigo());
            preparedStatement.setString(4, model.getObservacao());
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

    public Poste findById(int id) {
        Poste model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String latitude = rs.getString("latitude");
                String longitude = rs.getString("longitude");
                String codigo = rs.getString("codigo");
                String observacao = rs.getString("observacao");
                model = new Poste(id, latitude, longitude, codigo, observacao);
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

    public List<Poste> findAll() {
        List<Poste> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String latitude = rs.getString("latitude");
                String longitude = rs.getString("longitude");
                String codigo = rs.getString("codigo");
                String observacao = rs.getString("observacao");
                modelList.add(new Poste(id, latitude, longitude, codigo, observacao));
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

    public boolean update(int id, Poste model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getLatitude());
            statement.setString(2, model.getLongitude());
            statement.setString(3, model.getCodigo());
            statement.setString(4, model.getObservacao());
            statement.setInt(5, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
