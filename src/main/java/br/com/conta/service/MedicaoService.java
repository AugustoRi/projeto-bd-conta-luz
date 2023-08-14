package br.com.conta.service;

import br.com.conta.DAO.MedicaoDAO;
import br.com.conta.model.Medicao;

import java.sql.SQLException;
import java.util.List;

public class MedicaoService {
    private final MedicaoDAO medicaoDAO;

    public MedicaoService(MedicaoDAO medicaoDAO) {
        this.medicaoDAO = medicaoDAO;
    }

    public List<Medicao> findAll() {
        return medicaoDAO.findAll();
    };

    public Medicao findById(int id) {
        return medicaoDAO.findById(id);
    };

    public Medicao insert(Medicao model) {
        return medicaoDAO.insert(model);
    };

    public boolean update(int id, Medicao model) throws SQLException {
        return medicaoDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return medicaoDAO.delete(id);
    };
}
