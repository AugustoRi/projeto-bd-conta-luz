package br.com.conta.service;

import br.com.conta.DAO.ClienteDAO;
import br.com.conta.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    public Cliente findById(int id) {
        return clienteDAO.findById(id);
    }

    public Cliente insert(Cliente model) {
        return clienteDAO.insert(model);
    }

    public boolean update(int id, Cliente model) throws SQLException {
        return clienteDAO.update(id, model);
    }

    public boolean delete(int id) throws SQLException {
        return clienteDAO.delete(id);
    }
}
