package components;

public class Sigmoid implements FunctionAct{
    @Override
    public Double active(Double v) {
        return  1/(1+ Math.exp(-v));
    }
}
