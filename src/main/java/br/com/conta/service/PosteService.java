package br.com.conta.service;

import br.com.conta.DAO.PosteDAO;
import br.com.conta.model.Poste;

import java.sql.SQLException;
import java.util.List;

public class PosteService {
    private final PosteDAO posteDAO;

    public PosteService(PosteDAO posteDAO) {
        this.posteDAO = posteDAO;
    }

    public List<Poste> findAll() {
        return posteDAO.findAll();
    };

    public Poste findById(int id) {
        return posteDAO.findById(id);
    };

    public Poste insert(Poste model) {
        return posteDAO.insert(model);
    };

    public boolean update(int id, Poste model) throws SQLException {
        return posteDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return posteDAO.delete(id);
    };
}
