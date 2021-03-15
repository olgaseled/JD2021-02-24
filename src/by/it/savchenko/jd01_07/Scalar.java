package by.it.savchenko.jd01_07;

class Scalar extends Var {


    @Override
    public String toString() {
        return Double.toString(value);


    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String str){
        this.value = Double.parseDouble(str);
    }
    Scalar(Scalar scalar){
        this.value=scalar.value;
    }
}