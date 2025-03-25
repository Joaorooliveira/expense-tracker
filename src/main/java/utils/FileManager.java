package utils;

import com.google.gson.Gson;
import models.Expense;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    public void conversorArquivo(List<Expense> despesa) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("despesas.json")) {
            gson.toJson(despesa, writer);  // Converte a lista corretamente para JSON e escreve no arquivo
            System.out.println("JSON salvo com sucesso no arquivo 'despesas.json'!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
