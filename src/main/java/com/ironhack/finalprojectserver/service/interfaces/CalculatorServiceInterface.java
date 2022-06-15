package com.ironhack.finalprojectserver.service.interfaces;

import com.ironhack.finalprojectserver.DTO.CalculatorDTO;
import com.ironhack.finalprojectserver.model.Calculator;
import com.ironhack.finalprojectserver.model.Project;

public interface CalculatorServiceInterface {
    Calculator getCalculatorById(Long id);
   /* void setCalculator(Long calculatorId);*/

    void saveCalculator(Calculator calculator);

    void deleteCalculator(Long id);
}
