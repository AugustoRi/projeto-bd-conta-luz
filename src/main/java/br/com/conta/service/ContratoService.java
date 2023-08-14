package br.com.conta.service;

import br.com.conta.DAO.ContratoDAO;
import br.com.conta.dto.ContratoClienteResponse;
import br.com.conta.dto.ContratoMedidorResponse;
import br.com.conta.model.Contrato;

import java.sql.SQLException;
import java.util.List;

public class ContratoService {
    private final ContratoDAO contratoDAO;

    public ContratoService(ContratoDAO contratoDAO) {
        this.contratoDAO = contratoDAO;
    }

    public List<Contrato> findAll() {
        return contratoDAO.findAll();
    };

    public Contrato findById(int id) {
        return contratoDAO.findById(id);
    };

    public Contrato insert(Contrato model) {
        return contratoDAO.insert(model);
    };

    public boolean update(int id, Contrato model) throws SQLException {
        return contratoDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return contratoDAO.delete(id);
    };

    public List<ContratoClienteResponse> findAnyContractWithCliente() throws SQLException {
        return contratoDAO.findAnyContractWithCliente();
    }

    public List<ContratoMedidorResponse> findAnyContractWithMedidor() throws SQLException {
        return contratoDAO.findAnyContractWithMedidor();
    }
}
