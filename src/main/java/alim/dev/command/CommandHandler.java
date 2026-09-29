package alim.dev.command;

import alim.dev.history.HistoryManager;
import alim.dev.input.UserInput;

public class CommandHandler {


    private final HistoryManager historyManager;

    private static final String Exiting_Message = "Выход...";
    private static final String History_Is_Empty_Message = "История пуста";
    private static final String History_Cleared_Message = "История очищена";


    public CommandHandler( HistoryManager historyManager){

        this.historyManager = historyManager;
    }

    public boolean responseToTheCommand(String command){

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
                if(historyManager.getLastExpression() == null) {
                    System.out.println(History_Is_Empty_Message);
                    return true;
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
                System.out.println(Exiting_Message);
                return true;
            }

            default -> {
                return false;
            }

        }

    }
}
