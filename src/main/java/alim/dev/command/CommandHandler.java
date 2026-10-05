package alim.dev.command;


import alim.dev.history.HistoryManager;
import alim.dev.input.InputParser;

public class CommandHandler {


    private final HistoryManager historyManager;
    private final InputParser inputParser;

    private static final String EXITING_MESSAGE = "Выход...";
    private static final String HISTORY_IS_EMPTY_MESSAGE = "История пуста";
    private static final String HISTORY_CLEARED_MESSAGE = "История очищена";


    public CommandHandler(HistoryManager historyManager, InputParser inputParser){

        this.historyManager = historyManager;
        this.inputParser = inputParser;
    }

    public boolean responseToTheCommand(String command){

        switch (command){
            case "history" -> {
                if(historyManager.getHistory().isEmpty()){
                    System.out.println(HISTORY_IS_EMPTY_MESSAGE);
                }else{
                    for(int i = 0; i < historyManager.getSize(); i++){
                        System.out.println(
                                i+1 + ") " + historyManager.getHistory().get(i) +
                                      " = "  + historyManager.getHistoryOfResult().get(i)
                        );
                    }

                }
                return true;

            }

            case "last" -> {
                if(historyManager.getLastExpression() == null) {
                    System.out.println(HISTORY_IS_EMPTY_MESSAGE);
                    return true;
                }
                System.out.println(historyManager.getLastExpression() + " = " +
                        inputParser.parsing(historyManager.getLastExpression()));
                return true;
            }

            case "clear" -> {
                historyManager.clearAllHistory();
                System.out.println(HISTORY_CLEARED_MESSAGE);
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
                                "%  остаток от деления\n" + "\n" +

                                "Дополнительные команды:\n" +
                                "history  — показать историю\n" +
                                "last     — повторить последнюю операцию\n" +
                                "clear    — очистить историю\n" +
                                "exit     — выход"

                );
                return true;
            }

            case "exit" -> {
                System.out.println(EXITING_MESSAGE);
                return true;
            }

            default -> {
                return false;
            }

        }

    }
}
