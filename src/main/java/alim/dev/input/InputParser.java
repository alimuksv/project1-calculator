package alim.dev.input;

import alim.dev.calculator.Calculator;
import alim.dev.history.HistoryManager;

public class InputParser {


    private final Calculator calculator;
    private HistoryManager historyManager;


    public InputParser(Calculator calculator, HistoryManager historyManager){

        this.calculator = calculator;
        this.historyManager = historyManager;
    }

    public String parsing(String originalInput){

        String parsedInput = originalInput;

        parsedInput = parsedInput.replaceAll("\\s", "");

        String[] parts = parsedInput.split("[+\\-*/%]");

        String operator = "";

        if (parsedInput.contains("+")) {
            operator = "+";
        } else if (parsedInput.contains("-")) {
            operator = "-";
        } else if (parsedInput.contains("*")) {
            operator = "*";
        } else if (parsedInput.contains("/")){
            operator = "/";
        } else operator = "%";

        double firstNum = Double.parseDouble(parts[0]);
        double secondNum = Double.parseDouble(parts[1]);
        double result = calculator.calculate(firstNum, secondNum, operator);

        String resultToString = Double.toString(result);
        historyManager.addToHistory(originalInput + " = " + resultToString);

        return resultToString;
    }


}