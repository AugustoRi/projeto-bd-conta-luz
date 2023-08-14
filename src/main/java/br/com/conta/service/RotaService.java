package br.com.conta.service;

import br.com.conta.DAO.RotaDAO;
import br.com.conta.model.Rota;

import java.sql.SQLException;
import java.util.List;

public class RotaService {
    private final RotaDAO rotaDAO;

    public RotaService(RotaDAO rotaDAO) {
        this.rotaDAO = rotaDAO;
    }

    public List<Rota> findAll() {
        return rotaDAO.findAll();
    };

    public Rota findById(int id) {
        return rotaDAO.findById(id);
    };

    public Rota insert(Rota model) {
        return rotaDAO.insert(model);
    };

    public boolean update(int id, Rota model) throws SQLException {
        return rotaDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return rotaDAO.delete(id);
    };
}
