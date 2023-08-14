package br.com.conta.service;

import br.com.conta.DAO.TipoFaseDAO;
import br.com.conta.model.TipoFase;

import java.sql.SQLException;
import java.util.List;

public class TipoFaseService {
    private final TipoFaseDAO tipoFaseDAO;

    public TipoFaseService(TipoFaseDAO tipoFaseDAO) {
        this.tipoFaseDAO = tipoFaseDAO;
    }

    public List<TipoFase> findAll() {
        return tipoFaseDAO.findAll();
    };

    public TipoFase findById(int id) {
        return tipoFaseDAO.findById(id);
    };

    public TipoFase insert(TipoFase model) {
        return tipoFaseDAO.insert(model);
    };

    public boolean update(int id, TipoFase model) throws SQLException {
        return tipoFaseDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return tipoFaseDAO.delete(id);
    };
}
