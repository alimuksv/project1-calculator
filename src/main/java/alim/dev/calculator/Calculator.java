package alim.dev.calculator;


public class Calculator {


    public int calculate(int firstNum, int secondNum, String operator){
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
