package alim.dev.operations;

public class DivideOperation extends GeneralDivisionOperation implements Operation {

    @Override
    public double execute(double num1, double num2){
        checkDivisionByZero(num2);
        return num1 / num2;
    }
}
