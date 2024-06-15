package com.example.backenddoc.controller;

import com.example.backenddoc.entity.CalculationResult;
import com.example.backenddoc.entity.Numbers;
import com.example.backenddoc.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorController {
    private CalculatorService service;

    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @PostMapping(value = "/calculator/sum")
    public ResponseEntity<Object> postSum(@RequestBody Numbers numbers) {
        return new ResponseEntity<>(service.makeSum(numbers.getA(), numbers.getB()), HttpStatus.OK);
    }

    @PostMapping(value = "/calculator/subtraction")
    public ResponseEntity<Object> postSubtraction(@RequestBody Numbers numbers) {
        return new ResponseEntity<>(service.makeSubtraction(numbers.getA(), numbers.getB()), HttpStatus.OK);
    }

    @PostMapping(value = "/calculator/multiplication")
    public ResponseEntity<Object> postMultiplication(@RequestBody Numbers numbers) {
        return new ResponseEntity<>(service.makeMultiplication(numbers.getA(), numbers.getB()), HttpStatus.OK);
    }

    @PostMapping(value = "/calculator/division")
    public ResponseEntity<Object> postDivision(@RequestBody Numbers numbers) {
        return new ResponseEntity<>(service.makeDivision(numbers.getA(), numbers.getB()), HttpStatus.OK);
    }

    @GetMapping(value = "/calculator/history")
    public ResponseEntity<List<CalculationResult>> getHistory() {
        return service.getHistory()
                .map(history -> new ResponseEntity<>(history, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
