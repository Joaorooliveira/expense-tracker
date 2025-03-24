package utils;

import models.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    List<Expense> despesa = new ArrayList<>();
    private int id=1;
    private double totalDespesas =0;

    public void adicionarDespesa(Expense despesa) {
        despesa.setId(id);
        this.despesa.add(despesa);
        System.out.println("Expense added successfully (ID: "+id+")");
        id++;
        totalDespesas+=despesa.getAmount();
    }

    public void listarDespesas() {
        if (despesa.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
        } else {
            System.out.println(String.format("# %-3s %-10s %-12s %8s", "ID", "Date", "Description", "Amount"));
            for (Expense despesa : despesa) {
                System.out.println(despesa);
            }
        }
    }

    public void totalDespesas(){
        System.out.println("# Total expenses: $"+totalDespesas);
    }

    public void excluirDespesa(int id){
        this.despesa.remove(id);
        System.out.println("Despesa do (ID: "+id+")"+"excluida");
    }
}