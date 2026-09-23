package alim.dev;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your expression:");
        String originalExpression = scanner.nextLine();
        if(originalExpression.equals("exit")){
            System.out.println("Выход...");
        }
        while(!originalExpression.equals("exit")){
            try {
                String redactedExpression = originalExpression;
                redactedExpression = redactedExpression.replaceAll("\\s", ""); //удаляет все пробелы

                String[] parts = redactedExpression.split("[+\\-*/]"); //разделяю по операторам

                //честно говоря пока не знаю как реализовать нормальный ввод иначе чтоб 5+3 было что и 5 + 3
                String operator = "";
                if(redactedExpression.contains("+")){operator = "+";}
                else if(redactedExpression.contains("-")){operator = "-";}
                else if(redactedExpression.contains("*")){operator = "*";}
                else operator = "/";

                int firstNum = Integer.parseInt(parts[0]);
                int secondNum = Integer.parseInt(parts[1]);
//                String operator = parts[1];
                int result = calculate(firstNum, secondNum, operator);
                System.out.println(originalExpression + " = " + result);
                originalExpression =scanner.nextLine(); // очищаю регистр, иначе вечный повтор

            }catch (NumberFormatException numberFormatException){
                System.out.println("Ошибка: неверный формат. Используйте: число оператор число");
                originalExpression =scanner.nextLine();
            }catch (ArithmeticException arithmeticException){
                System.out.println("Ошибка: деление на ноль");
                originalExpression =scanner.nextLine();
            }


        }
        scanner.close();

    }

    private static int calculate(int firstNum, int secondNum, String operator){
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

    }
    return 0;
    }


}