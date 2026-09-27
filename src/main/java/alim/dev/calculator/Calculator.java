package alim.dev.calculator;


public class Calculator {


    public double calculate(double firstNum, double secondNum, String operator){
        switch (operator){
            case "+" -> {
                return firstNum + secondNum;
            }
            case "-" -> {
                return firstNum - secondNum;
            }
            case "*" -> {
                return firstNum * secondNum;
            }
            case "/" -> {
                return firstNum / secondNum;
            }
            default -> {
                throw new IllegalArgumentException("Unknown operator: " + operator);
            }

        }



    }

}
