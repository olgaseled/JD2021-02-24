package by.it.kaminskii.new_project_jd_02;

class Scalar extends Var {
    private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar(Scalar scallar) {
        this.value = scallar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


    //КОНЕЦ ПЕРВОГО БЛОКА


    //Начало калькулятора


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else return other.sub(other);
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else return other.add(other);
    }
}


//        1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
//        2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
//        3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
//         Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415