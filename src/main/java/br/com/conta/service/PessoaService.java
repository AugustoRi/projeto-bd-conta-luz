package br.com.conta.service;

import br.com.conta.DAO.PessoaDAO;
import br.com.conta.model.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class PessoaService {
    private final PessoaDAO pessoaDAO;

    public PessoaService(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public List<Pessoa> findAll() {
        return pessoaDAO.findAll();
    };

    public Pessoa findById(int id) {
        return pessoaDAO.findById(id);
    };

    public Pessoa insert(Pessoa model) {
        return pessoaDAO.insert(model);
    };

    public boolean update(int id, Pessoa model) throws SQLException {
        return pessoaDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return pessoaDAO.delete(id);
    };
}

