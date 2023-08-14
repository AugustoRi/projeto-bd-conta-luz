package br.com.conta.service;

import br.com.conta.DAO.TipoPessoaDAO;
import br.com.conta.model.TipoPessoa;

import java.sql.SQLException;
import java.util.List;

public class TipoPessoaService {
    private final TipoPessoaDAO tipoPessoDAO;

    public TipoPessoaService(TipoPessoaDAO tipoPessoDAO) {
        this.tipoPessoDAO = tipoPessoDAO;
    }

    public List<TipoPessoa> findAll() {
        return tipoPessoDAO.findAll();
    };

    public TipoPessoa findById(int id) {
        return tipoPessoDAO.findById(id);
    };

    public TipoPessoa insert(TipoPessoa model) {
        return tipoPessoDAO.insert(model);
    };

    public boolean update(int id, TipoPessoa model) throws SQLException {
        return tipoPessoDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return tipoPessoDAO.delete(id);
    };
}
