package com.erayserter.Expense.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("expense")
public class Expense {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private ExpenseCategory category;
    private BigDecimal amount;

    public Expense() {
    }

    public Expense(String name, ExpenseCategory category, BigDecimal amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public Expense(String id, String name, ExpenseCategory category, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
