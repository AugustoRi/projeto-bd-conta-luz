package br.com.conta.controller;

import br.com.conta.model.TarefaRota;

import br.com.conta.DAO.TarefaRotaDAO;

import br.com.conta.service.TarefaRotaService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class TarefaRotaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        TarefaRotaDAO tarefaRotaDAO = new TarefaRotaDAO();
        TarefaRotaService tarefaRotaService = new TarefaRotaService(tarefaRotaDAO);

        var tarefaRota = new TarefaRota();

        System.out.println("1: Salvar tarefaRota" +
                "\n2: Atualizar tarefaRota" +
                "\n3: Deletar tarefaRota" +
                "\n4: Buscar tarefaRota Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                tarefaRota.setObservacao("Desvio de Rota");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(2)));
                tarefaRota.setRotaId(1);
                System.out.println("Saved: " + tarefaRotaService.insert(tarefaRota));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tarefaRota.setObservacao("Rota defeituosa");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(4)));
                tarefaRota.setRotaId(1);
                System.out.println("Updated: " + tarefaRotaService.update(idUpdate, tarefaRota));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tarefaRotaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tarefaRotaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + tarefaRotaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}