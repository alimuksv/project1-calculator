package alim.dev.history;

import java.util.ArrayList;

public class HistoryManager{

    private ArrayList<String> history;
    private ArrayList<String> historyOfResult;

    private static final int CONSTANT_OF_SIZE = 10;

    public HistoryManager() {
        history = new ArrayList<>(CONSTANT_OF_SIZE);
        historyOfResult = new ArrayList<>(CONSTANT_OF_SIZE);
    }

    public void addToHistory(String expression){
        history.add(expression);
        if(history.size()>CONSTANT_OF_SIZE){
            history.remove(0);
        }
    }

    public void addHistoryResultToHistory(String expression){
            historyOfResult.add(expression);
            if(historyOfResult.size()>CONSTANT_OF_SIZE){
                historyOfResult.remove(0);
            }
        }

    public ArrayList<String> getHistory(){
        return history;
    }

    public ArrayList<String> getHistoryOfResult(){
        return historyOfResult;
    }



    public String getLastExpression(){
        if(history.isEmpty()){
            return null;
        }
        return history.getLast();
    }


    public void clearAllHistory(){
        history.clear();
        historyOfResult.clear();
    }

    public int getSize(){
        return history.size();
    }










}
