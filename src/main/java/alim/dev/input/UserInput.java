package alim.dev.input;

import alim.dev.command.CommandHandler;

import java.util.Scanner;

public class UserInput {



    private final Scanner input;
    private final InputParser inputParser;
    private final CommandHandler commandHandler;

    private static final String INCORRECT_FORMAT_MESSAGE = "Ошибка: неверный формат. Используйте: число оператор число";
    private static final String DIVISION_BY_ZERO_MESSAGE = "Ошибка: деление на ноль";
    private static final String INTRODUCTORY_MESSAGE = "Введите свое выражение:";



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

        System.out.println(INTRODUCTORY_MESSAGE);
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
                    System.out.println(INCORRECT_FORMAT_MESSAGE);
                    originalInput = input.nextLine(); //очистка регистра

                } catch (ArithmeticException arithmeticException) {
                    System.out.println(DIVISION_BY_ZERO_MESSAGE);
                    originalInput = input.nextLine(); //очистка, так же

                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException arrayIndexOutOfBoundsException) {
                    System.out.println(INCORRECT_FORMAT_MESSAGE);
                    originalInput = input.nextLine();

                }


            }

        }
        commandHandler.responseToTheCommand(originalInput);

        input.close();


    }



}
