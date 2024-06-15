package com.example.backenddoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.backenddoc.entity.CalculationResult;
import com.example.backenddoc.repository.CalculationResultRepository;
import com.example.backenddoc.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CalculatorServiceTest {

    @Mock
    private CalculationResultRepository repository;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMakeSum() {
        // Given
        int a = 10;
        int b = 5;

        // When
        int result = calculatorService.makeSum(a, b);

        // Then
        assertEquals(15, result);

        // Verify repository interaction
        verify(repository, times(1)).save(any(CalculationResult.class));
    }

    @Test
    public void testMakeSubtraction() {
        // Given
        int a = 10;
        int b = 5;

        // When
        int result = calculatorService.makeSubtraction(a, b);

        // Then
        assertEquals(5, result);

        // Verify repository interaction
        verify(repository, times(1)).save(any(CalculationResult.class));
    }

    @Test
    public void testMakeMultiplication() {
        // Given
        int a = 10;
        int b = 5;

        // When
        int result = calculatorService.makeMultiplication(a, b);

        // Then
        assertEquals(50, result);

        // Verify repository interaction
        verify(repository, times(1)).save(any(CalculationResult.class));
    }

    @Test
    public void testMakeDivision() {
        // Given
        int a = 10;
        int b = 5;

        // When
        int result = calculatorService.makeDivision(a, b);

        // Then
        assertEquals(2, result);

        // Verify repository interaction
        verify(repository, times(1)).save(any(CalculationResult.class));
    }

    @Test
    public void testGetHistory() {
        // Given
        CalculationResult mockResult = new CalculationResult(10, 5, 15, "sum");
        when(repository.findAll()).thenReturn(List.of(mockResult));

        // When
        Optional<List<CalculationResult>> history = calculatorService.getHistory();

        // Then
        assertEquals(1, history.orElseThrow().size());
        assertEquals(mockResult, history.orElseThrow().get(0));
    }
}
