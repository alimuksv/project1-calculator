package alim.dev.history;

import java.util.ArrayList;

public class HistoryManager{

    private ArrayList<String> history = new ArrayList<>(); //пока пусть будет 3

    public void addToHistory(String expression){
        history.add(expression);
        if(history.size()>10){
            history.remove(0);
        }
    }
    public ArrayList<String> getHistory(){
        return history;
    }

    public String getLastExpression(){
        if(history.isEmpty()){
            return null;
        }
        return history.get(history.size()-1);
    }

    public void clearAllHistory(){
        history.clear();

    }

    public int getSize(){
        return history.size();
    }










}
