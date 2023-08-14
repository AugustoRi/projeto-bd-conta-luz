package br.com.conta.controller;

import br.com.conta.model.Contrato;

import br.com.conta.DAO.ContratoDAO;

import br.com.conta.service.ContratoService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class ContratoController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        ContratoDAO contratoDAO = new ContratoDAO();
        ContratoService contratoService = new ContratoService(contratoDAO);

        var contrato = new Contrato();

        System.out.println("1: Salvar contrato" +
                "\n2: Atualizar contrato" +
                "\n3: Deletar contrato" +
                "\n4: Buscar contrato Por Id" +
                "\n5: Buscar Todos" +
                "\n6: Buscar contratos que possuem clientes" +
                "\n7: Buscar contratos que possuem medidores");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                contrato.setDescricao("Expirado a 5 meses");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Saved: " + contratoService.insert(contrato));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                contrato.setDescricao("Gato removido!");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Updated: " + contratoService.update(idUpdate, contrato));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + contratoService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + contratoService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + contratoService.findAll());
                break;
            case 6:
                System.out.println("Search Contrato with Cliente: " + contratoService.findAnyContractWithCliente());
                break;
            case 7:
                System.out.println("Search Contrato with Medidor: " + contratoService.findAnyContractWithMedidor());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}