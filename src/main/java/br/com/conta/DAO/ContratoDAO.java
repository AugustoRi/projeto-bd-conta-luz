package br.com.conta.DAO;

import br.com.conta.dto.ContratoClienteResponse;
import br.com.conta.dto.ContratoMedidorResponse;
import br.com.conta.model.Contrato;

import br.com.conta.service.ClienteService;
import br.com.conta.service.MedidorService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ContratoDAO extends ConexaoDB {
    private static final String INSERT = "INSERT INTO contrato (descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id) VALUES(?, ?, ?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id FROM contrato WHERE id = ?;";
    private static final String FIND_ALL = "SELECT * FROM contrato;";
    private static final String DELETE = "DELETE FROM contrato WHERE id = ?;";
    private static final String UPDATE = "UPDATE contrato SET descricao = ?, data_inicio = ?, data_fim = ?, medidor_id = ?, classe_id = ?, tipo_fase = ?, cliente_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM contrato;";
    private static final String FIND_ANY_CONTRACT_WITH_CLIENT = "SELECT * FROM contrato INNER JOIN cliente ON contrato.cliente_id = cliente.id";
    private static final String FIND_ANY_CONTRATO_WITH_MEDIDOR = "SELECT * FROM contrato INNER JOIN medidor ON contrato.medidor_id = medidor.id";

    ClienteDAO clienteDAO = new ClienteDAO();
    ClienteService clienteService = new ClienteService(clienteDAO);

    MedidorDAO medidorDAO = new MedidorDAO();
    MedidorService medidorService = new MedidorService(medidorDAO);

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

    public Contrato insert(Contrato model) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT)) {
            preparedStatement.setString(1, model.getDescricao());
            preparedStatement.setDate(2, model.getDataInicio());
            preparedStatement.setDate(3, model.getDataFim());
            preparedStatement.setInt(4, model.getMedidorId());
            preparedStatement.setInt(5, model.getClasseId());
            preparedStatement.setInt(6, model.getTipoFase());
            preparedStatement.setInt(7, model.getClienteId());
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

    public Contrato findById(int id) {
        Contrato model = null;

        try (PreparedStatement preparedStatement = prepararSQL(FIND_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int medidor_id = rs.getInt("medidor_id");
                int classe_id = rs.getInt("classe_id");
                int tipo_fase = rs.getInt("tipo_fase");
                int cliente_id = rs.getInt("cliente_id");
                model = new Contrato(id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id);
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

    public List<Contrato> findAll() {
        List<Contrato> modelList = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date data_inicio = rs.getDate("data_inicio");
                Date data_fim = rs.getDate("data_fim");
                int medidor_id = rs.getInt("medidor_id");
                int classe_id = rs.getInt("classe_id");
                int tipo_fase = rs.getInt("tipo_fase");
                int cliente_id = rs.getInt("cliente_id");
                modelList.add(new Contrato(id, descricao, data_inicio, data_fim, medidor_id, classe_id, tipo_fase, cliente_id));
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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, Contrato model) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE)) {
            statement.setString(1, model.getDescricao());
            statement.setDate(2, (Date) model.getDataInicio());
            statement.setDate(3, (Date) model.getDataFim());
            statement.setInt(4, model.getMedidorId());
            statement.setInt(5, model.getClasseId());
            statement.setInt(6, model.getTipoFase());
            statement.setInt(7, model.getClienteId());
            statement.setInt(8, id);

            return statement.executeUpdate() > 0;
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ContratoClienteResponse> findAnyContractWithCliente() {
        List<ContratoClienteResponse> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ANY_CONTRACT_WITH_CLIENT)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");
                int medidorId = rs.getInt("medidor_id");
                int classeId = rs.getInt("classe_id");
                int tipoFase = rs.getInt("tipo_fase");
                int clienteId = rs.getInt("cliente_id");
                var cliente = clienteService.findById(clienteId);
                modelList.add(new ContratoClienteResponse(id, descricao, dataInicio, dataFim, medidorId, classeId, tipoFase, cliente));
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

    public List<ContratoMedidorResponse> findAnyContractWithMedidor() {
        List<ContratoMedidorResponse> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_ANY_CONTRATO_WITH_MEDIDOR)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                Date dataInicio = rs.getDate("data_inicio");
                Date dataFim = rs.getDate("data_fim");
                int medidorId = rs.getInt("medidor_id");
                int classeId = rs.getInt("classe_id");
                int tipoFase = rs.getInt("tipo_fase");
                int clienteId = rs.getInt("cliente_id");
                var medidor = medidorService.findById(medidorId);
                modelList.add(new ContratoMedidorResponse(id, descricao, dataInicio, dataFim, medidorId, classeId, tipoFase, medidor));
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
}