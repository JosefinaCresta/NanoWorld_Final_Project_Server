package com.ironhack.finalprojectserver.controller;

import com.ironhack.finalprojectserver.DTO.CalculatorDTO;
import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Project;
import com.ironhack.finalprojectserver.repository.CalculatorRepository;
import com.ironhack.finalprojectserver.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    @Autowired
    private CalculatorRepository calculatorRepository;

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculators")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculator> getCalculators() {
        return calculatorRepository.findAll();
    }

    @GetMapping("/calculators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Calculator getCalculatorById(@PathVariable(name = "id") Long calculatorId) {
        return calculatorService.findById(calculatorId);
    }

    @PostMapping("/calculators")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCalculator(@RequestBody @Valid Calculator calculator){
        calculatorService.saveCalculator(calculator);
    }
    @PostMapping("/calculators/toproject")
    @ResponseStatus(HttpStatus.CREATED)
    public void setCalculator(@RequestBody Long calculatorId){
        calculatorService.setCalculator(calculatorId);
    }


    @DeleteMapping("/calculators/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCalculator(@PathVariable Long id){
        calculatorService.deleteCalculator(id);
    }
}


