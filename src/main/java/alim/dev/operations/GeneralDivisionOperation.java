package alim.dev.operations;

public abstract class GeneralDivisionOperation {

    public void checkDivisionByZero(double value){
        if((value == 0)){
            throw new ArithmeticException("Ошибка деления на 0");
        }
    }
}
