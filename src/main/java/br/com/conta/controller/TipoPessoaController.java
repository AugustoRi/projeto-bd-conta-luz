package br.com.conta.controller;

import br.com.conta.model.TipoPessoa;

import br.com.conta.DAO.TipoPessoaDAO;

import br.com.conta.service.TipoPessoaService;

import java.sql.SQLException;
import java.util.Scanner;

public class TipoPessoaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();
        TipoPessoaService tipoPessoaService = new TipoPessoaService(tipoPessoaDAO);

        var tipoPessoa = new TipoPessoa();

        System.out.println("1: Salvar Tipo Pessoa" +
                "\n2: Atualizar Tipo Pessoa" +
                "\n3: Deletar Tipo Pessoa" +
                "\n4: Buscar Tipo Pessoa Por Id " +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                tipoPessoa.setDescricao("Pessoa Jurídica isenta - Igreja");
                System.out.println("Saved: " + tipoPessoaService.insert(tipoPessoa));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                tipoPessoa.setDescricao("Pessoa Juridica");
                System.out.println("Updated: " + tipoPessoaService.update(idUpdate, tipoPessoa));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + tipoPessoaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + tipoPessoaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + tipoPessoaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}