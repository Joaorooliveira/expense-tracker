package utils;

import com.google.gson.Gson;
import models.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseManager {
    FileManager fileManager = new FileManager();
    List<Expense> despesa = new ArrayList<>();

    private double totalDespesas =0;

    public void adicionarDespesa(Expense despesa) {
        this.despesa.add(despesa);
        System.out.println("Expense added successfully (ID: "+despesa.getId()+")");
        totalDespesas+=despesa.getAmount();
    }

    public void listarDespesas() {
        if (despesa.isEmpty()) {
            System.out.println("Nenhuma despesa cadastrada.");
        } else {
            System.out.println(String.format("# %-3s %-10s %-12s %8s", "ID", "Date", "Description", "Amount"));
            despesa.forEach(System.out::println);
        }
    }

    public void totalDespesas(){
        System.out.println("# Total expenses: $"+totalDespesas);
    }

    public void excluirDespesa(int id){
        boolean removed = despesa.removeIf(expense -> expense.getId() == id);

        if (removed) {
            System.out.println("Despesa com ID " + id + " excluída.");
        } else {
            System.out.println("Nenhuma despesa encontrada com ID " + id);
        }
    }

    public void buscarDespesasPorMes(int mes) {
        List<Expense> despesasDoMes = despesa.stream()
                .filter(expense -> expense.getDate().getMonthValue() == mes)
                .collect(Collectors.toList());

        if (despesasDoMes.isEmpty()) {
            System.out.println("Nenhuma despesa encontrada para o mês " + mes + ".");
        } else {
            System.out.println(String.format("# %-3s %-10s %-12s %8s", "ID", "Date", "Description", "Amount"));
            despesasDoMes.forEach(System.out::println);
        }
    }

    public void conversorParaJson(){
            Gson gson = new Gson();
            String json = gson.toJson(despesa);
            fileManager.conversorArquivo(despesa);

        }
    }

