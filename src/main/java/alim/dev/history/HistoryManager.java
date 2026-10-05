package alim.dev.history;

import java.util.ArrayList;

public class HistoryManager{

    private ArrayList<String> history;
    private ArrayList<String> historyOfResult;

    public HistoryManager() {
        history = new ArrayList<>(10);
        historyOfResult = new ArrayList<>(10);
    }

    public void addToHistory(String expression){
        history.add(expression);
        if(history.size()>10){
            history.remove(0);
        }
    }

    public void addHistoryResultToHistory(String expression){
            historyOfResult.add(expression);
            if(historyOfResult.size()>10){
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
