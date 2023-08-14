package br.com.conta.controller;

import br.com.conta.model.TimeRota;

import br.com.conta.DAO.TimeRotaDAO;

import br.com.conta.service.TimeRotaService;

import java.sql.SQLException;
import java.util.Scanner;

public class TimeRotaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        TimeRotaDAO timeRotaDAO = new TimeRotaDAO();
        TimeRotaService timeRotaService = new TimeRotaService(timeRotaDAO);

        var timeRota = new TimeRota();

        System.out.println("1: Salvar timeRota" +
                "\n2: Atualizar timeRota" +
                "\n3: Deletar timeRota" +
                "\n4: Buscar timeRota Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Saved: " + timeRotaService.insert(timeRota));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Updated: " + timeRotaService.update(idUpdate, timeRota));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + timeRotaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + timeRotaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + timeRotaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
