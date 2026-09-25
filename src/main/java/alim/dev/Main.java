package alim.dev;


import alim.dev.calculator.Calculator;

import java.util.Scanner;

public class Main {

    private static Calculator calculator = new Calculator();

    private static Scanner input = new Scanner(System.in);

    private static final String Introductory_Message = "Enter your expression:";
    private static final String Exiting_Message = "Выход...";
    private static final String Incorrect_Format_Message = "Ошибка: неверный формат. Используйте: число оператор число";
    private static final String Division_By_Zero_Message = "Ошибка: деление на ноль";

    public static void main(String[] args) {


        System.out.println(Introductory_Message);
        String originalExpression = input.nextLine();

        if (originalExpression.equals("exit")) {
            System.out.println(Exiting_Message);

        }

        while (!originalExpression.equals("exit")) {
            try {

                String redactedExpression = originalExpression;
                redactedExpression = redactedExpression.replaceAll("\\s", ""); //удаляет все пробелы

                String[] parts = redactedExpression.split("[+\\-*/]"); //разделяю по операторам

                //честно говоря пока не знаю как реализовать нормальный ввод иначе. чтоб 5+3 было что и 5 + 3
                String operator = "";
                if (redactedExpression.contains("+")) {
                    operator = "+";
                } else if (redactedExpression.contains("-")) {
                    operator = "-";
                } else if (redactedExpression.contains("*")) {
                    operator = "*";
                } else operator = "/";

                int firstNum = Integer.parseInt(parts[0]);
                int secondNum = Integer.parseInt(parts[1]);
                int result = calculator.calculate(firstNum, secondNum, operator);

                System.out.println(originalExpression + " = " + result);

                originalExpression = input.nextLine(); // очищаю регистр, иначе вечный повтор

            } catch (NumberFormatException numberFormatException) {
                System.out.println(Incorrect_Format_Message);
                originalExpression = input.nextLine(); //очистка регистра

            } catch (ArithmeticException arithmeticException) {
                System.out.println(Division_By_Zero_Message);
                originalExpression = input.nextLine(); //очистка, так же

            }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
                System.out.println(Incorrect_Format_Message);
                originalExpression = input.nextLine();
            }


        }
        input.close();

    }
}