package alim.dev.input;

import alim.dev.calculator.Calculator;
import alim.dev.command.CommandHandler;
import alim.dev.history.HistoryManager;
import java.util.Scanner;

public class UserInput {



    private final Scanner input;
    private final InputParser inputParser;
    private final CommandHandler commandHandler;

    private static final String Incorrect_Format_Message = "Ошибка: неверный формат. Используйте: число оператор число";
    private static final String Division_By_Zero_Message = "Ошибка: деление на ноль";
    private static final String Introductory_Message = "Введите свое выражение:";



    public UserInput(
            Scanner input,
            InputParser inputParser,
            CommandHandler commandHandler
    ){

        this.input = input;
        this.inputParser = inputParser;
        this.commandHandler = commandHandler;
    }

    public void start(){

        System.out.println(Introductory_Message);
        String originalInput = input.nextLine();


        while (!originalInput.equals("exit")) {

            if (commandHandler.responseToTheCommand(originalInput)) {

                originalInput = input.nextLine();

            }else {

                try {

                    String result = inputParser.parsing(originalInput);

                    System.out.println(originalInput + " = " + result);


                    originalInput = input.nextLine(); // очищаю регистр, иначе вечный повтор


                } catch (NumberFormatException numberFormatException) {
                    System.out.println(Incorrect_Format_Message);
                    originalInput = input.nextLine(); //очистка регистра

                } catch (ArithmeticException arithmeticException) {
                    System.out.println(Division_By_Zero_Message);
                    originalInput = input.nextLine(); //очистка, так же

                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    System.out.println(Incorrect_Format_Message);
                    originalInput = input.nextLine();
                }
            }

        }
        input.close();


    }



}
