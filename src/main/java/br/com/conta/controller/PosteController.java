package br.com.conta.controller;

import br.com.conta.model.Poste;

import br.com.conta.DAO.PosteDAO;

import br.com.conta.service.PosteService;

import java.sql.SQLException;
import java.util.Scanner;

public class PosteController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        PosteDAO posteDAO = new PosteDAO();
        PosteService posteService = new PosteService(posteDAO);

        var poste = new Poste();

        System.out.println("1: Salvar Poste" +
                "\n2: Atualizar Poste" +
                "\n3: Deletar Poste" +
                "\n4: Buscar Poste Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                poste.setLatitude("-3.871969239596693");
                poste.setLongitude("-38.61165904952067");
                poste.setCodigo("61939140");
                poste.setObservacao("Local sob domínio federal");
                System.out.println("Saved: " + posteService.insert(poste));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                poste.setLatitude("-3.744249730942002");
                poste.setLongitude("-38.536020318839235");
                poste.setCodigo("60040531");
                poste.setObservacao("Mudança de endereço");
                System.out.println("Updated: " + posteService.update(idUpdate, poste));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + posteService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + posteService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + posteService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}