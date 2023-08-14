package br.com.conta.controller;

import br.com.conta.model.Medicao;

import br.com.conta.DAO.MedicaoDAO;

import br.com.conta.service.MedicaoService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MedicaoController {
    public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        MedicaoDAO medicaoDAO = new MedicaoDAO();
        MedicaoService medicaoService = new MedicaoService(medicaoDAO);

        var medicao = new Medicao();

        System.out.println("1: Salvar medicao" +
                "\n2: Atualizar medicao" +
                "\n3: Deletar medicao" +
                "\n4: Buscar medicao Por Id" +
                "\n5: Buscar Todos");
        int opcao = ler.nextInt();

        switch (opcao) {
            case 1:
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("250 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Saved: " + medicaoService.insert(medicao));
                break;
            case 2:
                System.out.println("Informe o Id que deseja atualizar: ");
                int idUpdate = ler.nextInt();
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("187,1 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Updated: " + medicaoService.update(idUpdate, medicao));
                break;
            case 3:
                System.out.println("Informe o Id que deseja deletar: ");
                int idDelete = ler.nextInt();
                System.out.println("Deleted: " + medicaoService.delete(idDelete));
                break;
            case 4:
                System.out.println("Informe o Id que deseja buscar: ");
                int idSearch = ler.nextInt();
                System.out.println("Individual search: " + medicaoService.findById(idSearch));
                break;
            case 5:
                System.out.println("Search: " + medicaoService.findAll());
                break;
            default:
                System.out.println("Invalid option, Err!");
        }
    }
}