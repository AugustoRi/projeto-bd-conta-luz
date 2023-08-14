package br.com.conta.controller;

import br.com.conta.model.Cliente;

import br.com.conta.DAO.ClienteDAO;

import br.com.conta.service.ClienteService;

import java.sql.SQLException;
import java.util.Scanner;

public class ClienteController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteService clienteService = new ClienteService(clienteDAO);

        var cliente = new Cliente();

        System.out.println("1: Salvar Cliente" +
                "\n2: Atualizar Cliente" +
                "\n3: Deletar Cliente" +
                "\n4: Buscar Cliente Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                cliente.setNumDocumento("0800-001");
                cliente.setNumCliente("0001");
                cliente.setPessoaId(1);
                System.out.println("Saved: " + clienteService.insert(cliente));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                cliente.setNumDocumento("0500-002");
                cliente.setNumCliente("0002");
                cliente.setPessoaId(1);
                System.out.println("Updated: " + clienteService.update(idUpdate, cliente));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + clienteService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + clienteService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + clienteService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}