package br.com.conta.controller;

import br.com.conta.model.Pessoa;

import br.com.conta.DAO.PessoaDAO;

import br.com.conta.service.PessoaService;

import java.sql.SQLException;
import java.util.Scanner;

public class PessoaController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();
        PessoaService pessoaService = new PessoaService(pessoaDAO);

        var pessoa = new Pessoa();

        System.out.println("1: Salvar Pessoa" +
                "\n2: Atualizar Pessoa" +
                "\n3: Deletar Pessoa" +
                "\n4: Buscar Pessoa Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                pessoa.setNome("Felipe Heitor Edson Silva");
                pessoa.setCpf("492.156.243-17");
                pessoa.setCnpj("91.615.333/0005-50");
                pessoa.setTipoPessoaId(1);
                System.out.println("Saved: " + pessoaService.insert(pessoa));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                pessoa.setNome("Antonio Fernando Araújo");
                pessoa.setCpf("469.282.373-92");
                pessoa.setCnpj("44.280.623/0123-04");
                pessoa.setTipoPessoaId(1);
                System.out.println("Updated: " + pessoaService.update(idUpdate, pessoa));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + pessoaService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + pessoaService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + pessoaService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}