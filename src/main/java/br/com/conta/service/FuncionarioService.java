package br.com.conta.service;

import br.com.conta.DAO.FuncionarioDAO;
import br.com.conta.model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioService {
    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioService(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public List<Funcionario> findAll() {
        return funcionarioDAO.findAll();
    };

    public Funcionario findById(int id) {
        return funcionarioDAO.findById(id);
    };

    public Funcionario insert(Funcionario model) {
        return funcionarioDAO.insert(model);
    };

    public boolean update(int id, Funcionario model) throws SQLException {
        return funcionarioDAO.update(id, model);
    };

    public boolean delete(int id) throws SQLException {
        return funcionarioDAO.delete(id);
    };
}
