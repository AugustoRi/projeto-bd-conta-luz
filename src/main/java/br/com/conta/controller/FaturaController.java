package br.com.conta.controller;

import br.com.conta.DAO.FaturaDAO;

import br.com.conta.service.FaturaService;

import java.sql.SQLException;
import java.util.Scanner;

public class FaturaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        FaturaDAO faturaDAO = new FaturaDAO();
        FaturaService faturaService = new FaturaService(faturaDAO);

        System.out.println("1: Mostrar Fatura");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Finded: " + faturaService.findFatura());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
