package models;

import java.time.LocalDate;

public class Expense {
    private String description;
    private double amount;
    private LocalDate date;
    private int id;



    public Expense(String description, double amount, LocalDate date,int id) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return String.format("# %-3d %-10s %-12s %7.2f", id, date, description, amount);
    }

}

