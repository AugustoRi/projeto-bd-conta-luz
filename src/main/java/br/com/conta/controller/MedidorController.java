package br.com.conta.controller;

import br.com.conta.model.Medidor;

import br.com.conta.DAO.MedidorDAO;

import br.com.conta.service.MedidorService;

import java.sql.SQLException;
import java.util.Scanner;

public class MedidorController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        MedidorDAO medidorDAO = new MedidorDAO();
        MedidorService medidorService = new MedidorService(medidorDAO);

        var medidor = new Medidor();

        System.out.println("1: Salvar medidor" +
                "\n2: Atualizar medidor" +
                "\n3: Deletar medidor" +
                "\n4: Buscar medidor Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                medidor.setDescricao("setar kWh padrão internacional");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Saved: " + medidorService.insert(medidor));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                medidor.setDescricao("medidor defeituoso");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Updated: " + medidorService.update(idUpdate, medidor));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + medidorService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + medidorService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + medidorService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}