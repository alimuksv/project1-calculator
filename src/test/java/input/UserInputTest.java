package input;

import alim.dev.calculator.Calculator;
import alim.dev.command.CommandHandler;
import alim.dev.history.HistoryManager;
import alim.dev.input.InputParser;
import alim.dev.input.UserInput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


public class UserInputTest {



    @Test
    public void correctInputAndExitTest(){

        String inputData = "5+5\nexit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                inputData.getBytes(StandardCharsets.UTF_8)
        );
        Scanner scanner = new Scanner(inputStream);
        Calculator calculator= new Calculator();
        HistoryManager historyManager = new HistoryManager();

        InputParser inputParser = new InputParser(calculator, historyManager);
        CommandHandler commandHandler = new CommandHandler(historyManager, inputParser);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        
        System.setOut(new PrintStream(output));

        try{

            UserInput userInput = new UserInput(
                    scanner,
                    inputParser,
                    commandHandler
            );

            userInput.start();

            String result = output.toString();

            assertTrue(result.contains("5+5 = 10"));

        }finally {
            System.setOut(originalOut);
        }


    }

    @Test
    public void secondOperationIsCorrectAfterIncorrectInputTest(){

        String inputData = "fff\n3+9*6\nexit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                inputData.getBytes(StandardCharsets.UTF_8)
        );
        Scanner scanner = new Scanner(inputStream);
        Calculator calculator= new Calculator();
        HistoryManager historyManager = new HistoryManager();

        InputParser inputParser = new InputParser(calculator, historyManager);
        CommandHandler commandHandler = new CommandHandler(historyManager, inputParser);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try{

            UserInput userInput = new UserInput(
                    scanner,
                    inputParser,
                    commandHandler
            );

            userInput.start();

            String result = output.toString();

            assertTrue(result.contains("Ошибка: неверный формат. Используйте: число оператор число"));
            assertTrue(result.contains("3+9*6 = 57"));

        }finally {
            System.setOut(originalOut);
        }

    }

    @Test
    public void correctDivideZeroResponseTest(){

        String inputData = "3/0\n4%0\nexit\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(
                inputData.getBytes(StandardCharsets.UTF_8)
        );
        Scanner scanner = new Scanner(inputStream);
        Calculator calculator= new Calculator();
        HistoryManager historyManager = new HistoryManager();

        InputParser inputParser = new InputParser(calculator, historyManager);
        CommandHandler commandHandler = new CommandHandler(historyManager, inputParser);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try{

            UserInput userInput = new UserInput(
                    scanner,
                    inputParser,
                    commandHandler
            );

            userInput.start();

            String result = output.toString();

            // /0
            assertTrue(result.contains("Ошибка: деление на ноль"));
            // %0
            assertTrue(result.contains("Ошибка: деление на ноль"));

        }finally {
            System.setOut(originalOut);
        }

    }


}
