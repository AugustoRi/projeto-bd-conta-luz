package br.com.conta.service;

import br.com.conta.DAO.CobrancaDAO;
import br.com.conta.model.Cobranca;

import java.sql.SQLException;
import java.util.List;

public class CobrancaService {
    private final CobrancaDAO cobrancaDAO;

    public CobrancaService(CobrancaDAO cobrancaDAO) {
        this.cobrancaDAO = cobrancaDAO;
    }

    public List<Cobranca> findAll() {
        return cobrancaDAO.findAll();
    }

    public Cobranca findById(int id) {
        return cobrancaDAO.findById(id);
    }

    public Cobranca insert(Cobranca model) {
        return cobrancaDAO.insert(model);
    }

    public boolean update(int id, Cobranca model) throws SQLException {
        return cobrancaDAO.update(id, model);
    }

    public boolean delete(int id) throws SQLException {
        return cobrancaDAO.delete(id);
    }
}
