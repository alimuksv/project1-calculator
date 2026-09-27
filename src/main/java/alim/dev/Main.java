package alim.dev;


import alim.dev.calculator.Calculator;
import alim.dev.history.HistoryManager;

import java.util.Scanner;

public class Main {

    private static Calculator calculator = new Calculator();
    private static HistoryManager historyManager = new HistoryManager();

    private static Scanner input = new Scanner(System.in);

    private static final String Introductory_Message = "Enter your expression:";
    private static final String Exiting_Message = "Выход...";
    private static final String Incorrect_Format_Message = "Ошибка: неверный формат. Используйте: число оператор число";
    private static final String Division_By_Zero_Message = "Ошибка: деление на ноль";
    private static final String History_Is_Empty_Message = "История пуста";
    private static final String History_Cleared_Message = "История очищена";


    public static void main(String[] args) {


        System.out.println(Introductory_Message);
        String originalExpression = input.nextLine();



        while (!originalExpression.equals("exit")) {

            if (responseToTheCommand(originalExpression) == true) {

                originalExpression = input.nextLine();

            }else {

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

                    double firstNum = Double.parseDouble(parts[0]);
                    double secondNum = Double.parseDouble(parts[1]);
                    double result = calculator.calculate(firstNum, secondNum, operator);

                    String resultToString = Double.toString(result);
                    historyManager.addToHistory(originalExpression + " = " + resultToString);

                    System.out.println(originalExpression + " = " + result);


                    originalExpression = input.nextLine(); // очищаю регистр, иначе вечный повтор


                } catch (NumberFormatException numberFormatException) {
                    System.out.println(Incorrect_Format_Message);
                    originalExpression = input.nextLine(); //очистка регистра

                } catch (ArithmeticException arithmeticException) {
                    System.out.println(Division_By_Zero_Message);
                    originalExpression = input.nextLine(); //очистка, так же

                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    System.out.println(Incorrect_Format_Message);
                    originalExpression = input.nextLine();
                }
            }

        }
        input.close();

    }

    private static boolean responseToTheCommand(String command){
        switch (command){
            case "history" -> {
                if(historyManager.getHistory().isEmpty()){
                    System.out.println(History_Is_Empty_Message);
                }else{
                    for(int i = 0; i < historyManager.getSize(); i++){
                        System.out.println(
                            i+1 + ") " + historyManager.getHistory().get(i)
                        );
                    }

                }
                return true;

            }

            case "last" -> {
                if(historyManager.getHistory() == null) {
                    System.out.println(History_Is_Empty_Message);
                }
                System.out.println(
                historyManager.getLastExpression());
                return true;
            }

            case "clear" -> {
                historyManager.clearAllHistory();
                System.out.println(History_Cleared_Message);
                return true;
            }

            case "help" ->{
                System.out.println(
                "Доступные команды:\n"+ "\n"+

                "<число> <оператор> <число>\n"+ "\n" +

                "Операторы:\n" +
                "+  сложение\n" +
                "-  вычитание\n" +
                "*  умножение\n" +
                "/  деление\n" + "\n"+

                "Дополнительные команды:\n" +
                "history  — показать историю\n" +
                "last     — повторить последнюю операцию\n" +
                "clear    — очистить историю\n" +
                "exit     — выход"

                );
                return true;
            }

            case "exit" -> {
                System.out.println(Exiting_Message);
                return true;
            }
            default -> {
                return false;
            }

        }

    }



}