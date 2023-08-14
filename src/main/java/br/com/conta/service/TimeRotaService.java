package br.com.conta.service;

import br.com.conta.DAO.TimeRotaDAO;
import br.com.conta.model.TimeRota;

import java.sql.SQLException;
import java.util.List;

public class TimeRotaService {
    private final TimeRotaDAO timeRotaDAO;

    public TimeRotaService(TimeRotaDAO timeRotaDAO) {
        this.timeRotaDAO = timeRotaDAO;
    }

    public List<TimeRota> findAll() {
        return timeRotaDAO.findAll();
    };

    public TimeRota findById(int id) {
        return timeRotaDAO.findById(id);
    };

    public TimeRota insert(TimeRota model) {
        return timeRotaDAO.insert(model);
    };

    public boolean update(int id, TimeRota model) throws SQLException {
        return timeRotaDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return timeRotaDAO.delete(id);
    };
}
