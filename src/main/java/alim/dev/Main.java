package alim.dev;

import alim.dev.calculator.Calculator;
import alim.dev.command.CommandHandler;
import alim.dev.history.HistoryManager;
import alim.dev.input.InputParser;
import alim.dev.input.UserInput;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        HistoryManager historyManager = new HistoryManager();
        Scanner input = new Scanner(System.in);
        InputParser inputParser = new InputParser(calculator,historyManager);
        CommandHandler commandHandler = new CommandHandler(historyManager,inputParser);

            UserInput userInput = new UserInput(
                    input,
                    inputParser,
                    commandHandler
                    );
            userInput.start();


    }

}