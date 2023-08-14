package br.com.conta.service;

import br.com.conta.DAO.TarifaDAO;
import br.com.conta.model.Tarifa;

import java.sql.SQLException;
import java.util.List;

public class TarifaService {
    private final TarifaDAO tarifaDAO;

    public TarifaService(TarifaDAO tarifaDAO) {
        this.tarifaDAO = tarifaDAO;
    }

    public List<Tarifa> findAll() {
        return tarifaDAO.findAll();
    };

    public Tarifa findById(int id) {
        return tarifaDAO.findById(id);
    };

    public Tarifa insert(Tarifa model) {
        return tarifaDAO.insert(model);
    };

    public boolean update(int id, Tarifa model) throws SQLException {
        return tarifaDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return tarifaDAO.delete(id);
    };
}
