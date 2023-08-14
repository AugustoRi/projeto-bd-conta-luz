package br.com.conta.DAO;

import br.com.conta.model.Fatura;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FaturaDAO extends ConexaoDB {
    private static final String FIND_FATURA = "SELECT pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, pessoa.cpf as pessoa_cpf, pessoa.cnpj as pessoa_cnpj, cliente.num_cliente as cliente_num_cliente, cliente.num_documento as cliente_num_documento, contrato.data_inicio as contrato_data_inicio, contrato.data_fim as contrato_data_fim, contrato.descricao as contrato_descricao, rota.descricao as rota_descricao, medidor.descricao as medidor_descricao, tipo_pessoa.id as tipo_pessoa_id FROM rota INNER JOIN medidor ON (medidor.id_rota = rota.id) INNER JOIN contrato ON (contrato.medidor_id = medidor.id) INNER JOIN cliente ON (contrato.cliente_id = cliente.id) INNER JOIN pessoa ON (cliente.pessoa_id = pessoa.id) INNER JOIN tipo_pessoa ON (pessoa.tipo_pessoa_id = tipo_pessoa.id);";

    public List<Fatura> findFatura() {
        List<Fatura> modelList = new ArrayList<>();

        try (PreparedStatement preparedStatement = prepararSQL(FIND_FATURA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int pessoaId = rs.getInt("pessoa_id");
                String pessoaNome = rs.getString("pessoa_nome");
                String pessoaCpf = rs.getString("pessoa_cpf");
                String pessoaCnpj = rs.getString("pessoa_cnpj");
                String numCliente = rs.getString("cliente_num_cliente");
                String numDocumento = rs.getString("cliente_num_documento");
                Date contratoDataInicio = rs.getDate("contrato_data_inicio");
                Date contratoDataFim = rs.getDate("contrato_data_fim");
                String contratoDescricao = rs.getString("contrato_descricao");
                String rotaDescricao = rs.getString("rota_descricao");
                String medidorDescricao = rs.getString("medidor_descricao");
                int tipoPessoaId = rs.getInt("tipo_pessoa_id");

                modelList.add(new Fatura(pessoaId, pessoaNome, pessoaCpf, pessoaCnpj, numCliente, numDocumento, contratoDataInicio, contratoDataFim, contratoDescricao, rotaDescricao, medidorDescricao, tipoPessoaId));
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
