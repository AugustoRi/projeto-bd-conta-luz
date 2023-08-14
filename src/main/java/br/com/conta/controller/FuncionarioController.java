package br.com.conta.controller;

import br.com.conta.model.Funcionario;

import br.com.conta.DAO.FuncionarioDAO;

import br.com.conta.service.FuncionarioService;

import java.sql.SQLException;
import java.util.Scanner;

public class FuncionarioController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FuncionarioService funcionarioService = new FuncionarioService(funcionarioDAO);

        var funcionario = new Funcionario();

        System.out.println("1: Salvar Funcionario" +
                "\n2: Atualizar Funcionario" +
                "\n3: Deletar Funcionario" +
                "\n4: Buscar Funcionario Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                funcionario.setCodigoFuncional("0800-0010");
                funcionario.setPessoaId(1);
                System.out.println("Saved: " + funcionarioService.insert(funcionario));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                funcionario.setCodigoFuncional("0500-0012");
                funcionario.setPessoaId(1);
                System.out.println("Updated: " + funcionarioService.update(idUpdate, funcionario));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + funcionarioService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();

                System.out.println("Individual search: " + funcionarioService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + funcionarioService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}