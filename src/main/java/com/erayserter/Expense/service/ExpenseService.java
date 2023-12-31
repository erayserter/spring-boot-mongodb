package com.erayserter.Expense.service;

import com.erayserter.Expense.model.Expense;
import com.erayserter.Expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {


    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Expense by ID %s", expense.getId())));

        savedExpense.setName(expense.getName());
        savedExpense.setAmount(expense.getAmount());
        savedExpense.setCategory(expense.getCategory());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find expense by name %s", name)));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
