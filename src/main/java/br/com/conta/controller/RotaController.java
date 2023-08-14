package br.com.conta.controller;

import br.com.conta.model.Rota;

import br.com.conta.DAO.RotaDAO;

import br.com.conta.service.RotaService;

import java.sql.SQLException;
import java.util.Scanner;

public class RotaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        RotaDAO rotaDAO = new RotaDAO();
        RotaService rotaService = new RotaService(rotaDAO);

        var rota = new Rota();

        System.out.println("1: Salvar Rota" +
                "\n2: Atualizar Rota" +
                "\n3: Deletar Rota" +
                "\n4: Buscar Rota Por Id" +
                "\n5: Buscar Todas");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                rota.setDescricao("IFCE maracanaú");
                System.out.println("Saved: " + rotaService.insert(rota));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                rota.setDescricao("Reitoria");
                System.out.println("Updated: " + rotaService.update(idUpdate, rota));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + rotaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + rotaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + rotaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}