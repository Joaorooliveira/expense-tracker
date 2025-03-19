package utils;

import models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    List<Expense> despesa = new ArrayList<>();

    public void adicionarDespesa(Expense despesa) {
        this.despesa.add(despesa);
        System.out.println("Despesa adicionada com sucesso!");
    }

    public void listarDespesas() {
        if (despesa.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
        } else {
            System.out.println("=== Lista de Despesas ===");
            for (Expense despesa : despesa) {
                System.out.println(despesa);
            }
        }
    }
}