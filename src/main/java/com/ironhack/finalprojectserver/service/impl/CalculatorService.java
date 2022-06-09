package com.ironhack.finalprojectserver.service.impl;

import com.ironhack.finalprojectserver.DTO.CalculatorDTO;
import com.ironhack.finalprojectserver.DTO.ClusterDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Cluster;
import com.ironhack.finalprojectserver.model.Project;
import com.ironhack.finalprojectserver.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CalculatorService {
    @Autowired
    private CalculatorRepository calculatorRepository;

    public Calculator findById(Long id) {
        return calculatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Calculator not found"));
    }



    public Calculator saveCalculator(Calculator calculator) {
        if (calculator.getId() != null) {
            Optional<Calculator> optionalCalculator = calculatorRepository.findById(calculator.getId());
            if (optionalCalculator.isPresent())
                throw new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "Calculator with id " + calculator.getId() + " already exist");
        }
        Calculator calculator1 = calculatorRepository.save(calculator);
        return calculator1;

    }


    public void setCalculator(CalculatorDTO calculator){
        Calculator newCalculator = new Calculator();
        newCalculator.setXc(calculator.getXc());
        newCalculator.setLreal(calculator.isLreal());
        newCalculator.setKpts(calculator.getKpts());
        newCalculator.setIbrion(calculator.getIbrion());
        newCalculator.setEncut(calculator.getEncut());
        newCalculator.setEdiffg(calculator.getEdiffg());
        newCalculator.setNsw(calculator.getNsw());
        newCalculator.setIspin(calculator.getIspin());
        newCalculator.setNcore(calculator.getNcore());
        newCalculator.setCommand(calculator.getCommand());
        calculatorRepository.save(newCalculator);
    }

    public void deleteCalculator(Long id) {
        Calculator calculatorFromDB = calculatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Calculator not found"));
    }
}
