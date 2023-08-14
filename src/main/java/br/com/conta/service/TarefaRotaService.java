package br.com.conta.service;

import br.com.conta.DAO.TarefaRotaDAO;
import br.com.conta.model.TarefaRota;

import java.sql.SQLException;
import java.util.List;

public class TarefaRotaService {
    private final TarefaRotaDAO tarefaRotaDAO;

    public TarefaRotaService(TarefaRotaDAO tarefaRotaDAO) {
        this.tarefaRotaDAO = tarefaRotaDAO;
    }

    public List<TarefaRota> findAll() {
        return tarefaRotaDAO.findAll();
    };

    public TarefaRota findById(int id) {
        return tarefaRotaDAO.findById(id);
    };

    public TarefaRota insert(TarefaRota model) {
        return tarefaRotaDAO.insert(model);
    };

    public boolean update(int id, TarefaRota model) throws SQLException {
        return tarefaRotaDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return tarefaRotaDAO.delete(id);
    };
}
