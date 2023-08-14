package br.com.conta.service;

import br.com.conta.DAO.MedidorDAO;
import br.com.conta.model.Medidor;

import java.sql.SQLException;
import java.util.List;

public class MedidorService {
    private final MedidorDAO medidorDAO;

    public MedidorService(MedidorDAO medidorDAO) {
        this.medidorDAO = medidorDAO;
    }

    public List<Medidor> findAll() {
        return medidorDAO.findAll();
    };

    public Medidor findById(int id) {
        return medidorDAO.findById(id);
    };

    public Medidor insert(Medidor model) {
        return medidorDAO.insert(model);
    };

    public boolean update(int id, Medidor model) throws SQLException {
        return medidorDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return medidorDAO.delete(id);
    };
}
