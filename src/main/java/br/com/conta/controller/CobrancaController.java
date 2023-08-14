package br.com.conta.controller;

import br.com.conta.model.Cobranca;

import br.com.conta.DAO.CobrancaDAO;

import br.com.conta.service.CobrancaService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class CobrancaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        CobrancaDAO cobrancaDAO = new CobrancaDAO();
        CobrancaService cobrancaService = new CobrancaService(cobrancaDAO);

        var cobranca = new Cobranca();

        System.out.println("1: Salvar cobranca" +
                "\n2: Atualizar cobranca" +
                "\n3: Deletar cobranca" +
                "\n4: Buscar cobranca Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(1);
                System.out.println("Saved: " + cobrancaService.insert(cobranca));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().plusMonths(1).getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(2);
                System.out.println("Updated: " + cobrancaService.update(idUpdate, cobranca));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + cobrancaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + cobrancaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + cobrancaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}