package br.com.conta.controller;

import br.com.conta.model.TipoFase;

import br.com.conta.DAO.TipoFaseDAO;

import br.com.conta.service.TipoFaseService;

import java.sql.SQLException;
import java.util.Scanner;

public class TipoFaseController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        TipoFaseDAO tipoFaseDAO = new TipoFaseDAO();
        TipoFaseService tipoFaseService = new TipoFaseService(tipoFaseDAO);

        var tipoFase = new TipoFase();

        System.out.println("1: Salvar Tipo Fase" +
                "\n2: Atualizar Tipo Fase" +
                "\n3: Deletar Tipo Fase" +
                "\n4: Buscar Tipo Fase Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                tipoFase.setDescricao("Teste");
                System.out.println("Saved: " + tipoFaseService.insert(tipoFase));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tipoFase.setDescricao("Teste Atualizado");
                System.out.println("Updated: " + tipoFaseService.update(idUpdate, tipoFase));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tipoFaseService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tipoFaseService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + tipoFaseService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}
