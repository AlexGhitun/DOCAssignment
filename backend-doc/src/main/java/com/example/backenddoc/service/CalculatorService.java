package com.example.backenddoc.service;

import com.example.backenddoc.entity.CalculationResult;
import com.example.backenddoc.repository.CalculationResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculatorService {

    private final CalculationResultRepository repository;
    public CalculatorService(CalculationResultRepository repository) {
        this.repository = repository;
    }

    public int makeSum(int a, int b) {
        int x = a + b;
        repository.save(new CalculationResult(a, b, x, "sum"));
        return x;
    }

    public int makeSubtraction(int a, int b) {
        int x = a - b;
        repository.save(new CalculationResult(a, b, x, "subtraction"));
        return x;
    }

    public int makeMultiplication(int a, int b) {
        int x = a * b;
        repository.save(new CalculationResult(a, b, x, "multiplication"));
        return x;
    }

    public int makeDivision(int a, int b) {
        int x = a / b;
        repository.save(new CalculationResult(a, b, x, "division"));
        return x;
    }

    public Optional<List<CalculationResult>> getHistory() {
        List<CalculationResult> history = repository.findAll();
        return Optional.ofNullable(history);
    }
}
