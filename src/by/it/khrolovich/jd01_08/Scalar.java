package by.it.khrolovich.jd01_08;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }


    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            //проверили, значит имеем право кастить - приводить типы
            double otherValue = ((Scalar) other).value;//other.value
            double result = this.value + otherValue;
            return new Scalar(result);//если это скаляр, значит возвращаем скаляр
            //или одной строкой
        }
        var result2 = other.add(this);//other -точно не скаляр, this - точно скаляр
        //other - или вектор,или матрица
        return result2.mul(new Scalar(-1));//его же и вернем
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            //проверили, значит имеем право кастить - приводить типы
            double otherValue = ((Scalar) other).value;//other.value
            double result = this.value - otherValue;
            return new Scalar(result);//если это скаляр, значит возвращаем скаляр
            //или одной строкой
        }
        Var varSub = other.sub(this);
        return varSub;//TODO умножение на -1
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            //проверили, значит имеем право кастить - приводить типы
            double otherValue = ((Scalar) other).value;//other.value
            double result = this.value * otherValue;
            return new Scalar(result);//если это скаляр, значит возвращаем скаляр
            //или одной строкой
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            //проверили, значит имеем право кастить - приводить типы
            double secondOperand = ((Scalar) other).value;//other.value
            if (secondOperand == 0) {
                return null;//TODO div be zero
            }

            return new Scalar(this.value / secondOperand);
            //или одной строкой
        }
        //return other.div(this);
        return super.div(other);
    }


}






