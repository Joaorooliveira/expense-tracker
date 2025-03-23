package app;



import models.Expense;
import utils.ExpenseManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner leitura = new Scanner(System.in);
    private ExpenseManager expenseManager = new ExpenseManager();
    private int opcao=0;
    public void mostrarMenu() {



        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Listar despesas");
            System.out.println("3. Excluir despesa");
            System.out.println("4. Resumo das despesas");
            System.out.println("5. Resumo por mês");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = leitura.nextInt(); // Captura a entrada do usuário
                leitura.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Por favor, digite um número.");
                leitura.nextLine(); // Limpa o buffer para evitar loop infinito
                continue; // Volta para o início do loop
            }
            switch (opcao) {
                case 1:
                    adicionarDespesa();
                    break;
                case 2:
                    expenseManager.listarDespesas();
                    break;
                case 3:

                    break;
                case 4:
                    expenseManager.totalDespesas();
                    break;
                case 5:

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcao invalida! Tente Novamente.");
                    break;
            }
        } while (opcao != 6);
    }
    private void adicionarDespesa(){
        System.out.println("Digite a descricao da despesa:");
        String descricao = leitura.nextLine();

        System.out.print("Digite o valor da despesa: ");
        double valor = leitura.nextDouble();
        leitura.nextLine(); // Consumir quebra de linha

        Expense despesas = new Expense(descricao, valor,LocalDate.now());
        expenseManager.adicionarDespesa(despesas);

    }
}
