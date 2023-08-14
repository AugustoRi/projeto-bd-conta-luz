package br.com.conta.controller;

import br.com.conta.model.Tarifa;

import br.com.conta.DAO.TarifaDAO;

import br.com.conta.service.TarifaService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TarifaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        TarifaDAO tarifaDAO = new TarifaDAO();
        TarifaService tarifaService = new TarifaService(tarifaDAO);

        var tarifa = new Tarifa();

        System.out.println("1: Salvar tarifa" +
                "\n2: Atualizar tarifa" +
                "\n3: Deletar tarifa" +
                "\n4: Buscar tarifa Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                tarifa.setTaxa("10%");
                tarifa.setClasseId(1);
                tarifa.setLei("14.203 - TARIFA SOCIAL");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now()));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                tarifa.setAliquotaIcms("25%");
                System.out.println("Saved: " + tarifaService.insert(tarifa));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tarifa.setTaxa("ISENTO");
                tarifa.setClasseId(1);
                tarifa.setLei("8.742 - Família CadÚnico");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now().plusDays(7)));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusDays(7).plusMonths(1)));
                tarifa.setAliquotaIcms("ISENTO");
                System.out.println("Updated: " + tarifaService.update(idUpdate, tarifa));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tarifaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tarifaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + tarifaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}