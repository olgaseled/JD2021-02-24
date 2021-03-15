package by.it.kaminskii.jd01_08;

class Scalar extends Var {
    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double odds = this.value - ((Scalar) other).value;
            return new Scalar(-1).mul(other).add(this);
        }
        else return other.sub(this);

    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double prod = this.value * ((Scalar) other).value;
            return new Scalar(prod);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {

        if(other instanceof Scalar){
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strScalar){
        this.value= Double.parseDouble(strScalar);
    }
    Scalar(Scalar scallar){
        this.value=scallar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}


//        1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
//        2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
//        3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
//         Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415