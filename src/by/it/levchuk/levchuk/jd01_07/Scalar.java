package by.it.levchuk.levchuk.jd01_07;

public class Scalar extends Var{
    private final double value;

    public Scalar(double value) {
        this.value = value;
        
    }
    
    Scalar(String strScalar, double value){

        this.value = value;
    }

    public Scalar(Var var2) {
        super();
        value = 0;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
