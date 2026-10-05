package alim.dev.input;

import alim.dev.calculator.Calculator;
import alim.dev.history.HistoryManager;

import java.util.*;

public class InputParser {


    private final Calculator calculator;
    private final HistoryManager historyManager;


    private final List<String> parts = new ArrayList<>();
    private final List<String> highPriorityOperators = Arrays.asList("*", "/", "%");
    private final List<String> lowPriorityOperators = Arrays.asList("+", "-");


    private double num1;
    private String operator;
    private double num2;
    private double calculationResult;


    public InputParser(Calculator calculator, HistoryManager historyManager){

        this.calculator = calculator;
        this.historyManager = historyManager;

    }

    public String parsing(String originalInput){

        String parsedInput = originalInput;

        parsedInput = parsedInput.replaceAll("\\s", "");


        StringBuilder number = new StringBuilder();

        if(parsedInput.isEmpty()){
            throw new IllegalArgumentException("Пустой ввод");
        }

        if(isOperator(parsedInput.charAt(parsedInput.length()-1))){
            throw new IllegalArgumentException("Некорректный ввод");
        }


        try {
            for (int i = 0; i < parsedInput.length(); i++) {

                char current = parsedInput.charAt(i);

                if (!isOperator(current)) {
                    number.append(current);
                    continue;
                }

                if (current == '-' && (i == 0 || isOperator(parsedInput.charAt(i - 1)))) {
                    number.append(current);
                    continue;
                }


                parts.add(number.toString());
                number.setLength(0);
                parts.add(String.valueOf(current));
            }
            if (number.length() > 0) {
                parts.add(number.toString());
            }
            if  (parts.size() == 1){
                throw new IllegalArgumentException("Некорректный ввод");
            }


            while (parts.size() != 1) {
                calculationResult = calculateAtIndex();

            }

            isANumber(parts.get(0));

        }finally {
            parts.clear();
        }


            String resultToString = Double.toString(calculationResult);
            historyManager.addToHistory(originalInput);
            historyManager.addHistoryResultToHistory(resultToString);

            return resultToString;

    }

    private boolean isOperator(char c){
        return c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/' ||
                c == '%';
    }


    private int findOperatorIndex(List<String> parts){

       for(int i =0; i < parts.size(); i++){
           if(!Collections.disjoint(parts, highPriorityOperators)) {
               if (highPriorityOperators.contains(parts.get(i))) {
                   return i;
               }
           }else {
               if (lowPriorityOperators.contains(parts.get(i))) {
                   return i;
               }
           }
       }

       return -1;
    }


    private double calculateAtIndex(){

        int index = findOperatorIndex(parts);

        if(index == -1){
            parts.clear();
            throw new IllegalArgumentException("Некорректный ввод");
        }
        operator = parts.get(index);

        num1 = Double.parseDouble(parts.get(index - 1));
        num2 = Double.parseDouble(parts.get(index + 1));

        calculationResult = calculator.calculate(num1, num2, operator);

        parts.set(( index - 1 ), String.valueOf(calculationResult));
        parts.remove(index);
        parts.remove(index);

        return calculationResult;
    }

    private void isANumber(String input){

        try{
            Double.parseDouble(input);

        }catch (NumberFormatException e){
            throw new NumberFormatException("Некорректный ввод");
        }

    }


}