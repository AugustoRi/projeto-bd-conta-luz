package br.com.conta.service;

import br.com.conta.DAO.ClasseDAO;
import br.com.conta.model.Classe;

import java.sql.SQLException;
import java.util.List;

public class ClasseService {
    private final ClasseDAO classeDAO;

    public ClasseService(ClasseDAO classeDAO) {
        this.classeDAO = classeDAO;
    }

    public List<Classe> findAll() {
        return classeDAO.findAll();
    }

    public Classe findById(int id) {
        return classeDAO.findById(id);
    }

    public Classe insert(Classe model) {
        return classeDAO.insert(model);
    }

    public boolean update(int id, Classe model) throws SQLException {
        return classeDAO.update(id, model);
    }

    public boolean delete(int id) throws SQLException {
        return classeDAO.delete(id);
    }
}
