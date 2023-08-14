package br.com.conta.service;

import br.com.conta.DAO.FaturaDAO;
import br.com.conta.model.Fatura;

import java.sql.SQLException;
import java.util.List;

public class FaturaService {
    private final FaturaDAO faturaDAO;

    public FaturaService(FaturaDAO faturaDAO) {
        this.faturaDAO = faturaDAO;
    }

    public List<Fatura> findFatura() throws SQLException {
        return faturaDAO.findFatura();
    }
}
