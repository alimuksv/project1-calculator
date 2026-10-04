package alim.dev.calculator;


import alim.dev.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operations = new HashMap<>();

    public Calculator(){

        operations.put("+", new AddOperation());
        operations.put("-", new SubtractOperation());
        operations.put("*", new MultiplyOperation());
        operations.put("/", new DivideOperation());
        operations.put("%", new ModuloOperation());

        }

    public double calculate(double num1, double num2, String operator){

        if(operations.get(operator) == null){
            throw new IllegalArgumentException("Неизвестный оператор:" + operator);
        }
        Operation operation = operations.get(operator);
        return operation.execute(num1, num2);
    }



    }

