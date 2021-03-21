package by.it.seledtsova.jd01_09;

public class Scalar extends Var {  // мы создали двух потомков и он наследуется от класca var

    private final double value; // определили приватное поле . теперь есть возмозность создать конструктор

    public double getValue () {
        return value;
    }

    @Override
    public Var add(Var other) { // по умолчанию вставляяется поведение предка.но нам нкжно его изменить
        if (other instanceof Scalar) {  //  если other  является скаляром, то у нас операция скаляр + скаляр
        double sum = this.value + ((Scalar) other).value; // мы получили значение суммы, но должны первуть переменную типа вар
        return new Scalar(sum);
    }
        else //5+ vertor --> vertor.add(5) -- если other был вектором, то add  ищем в векторе
             //5+ matrix --> matrix.add (5) --если other был марицей, то add ищем в матрице

        return other.add(this);
    }

    @Override
    public Var sub(Var other) { //other  это вектор или матрица
        if (other instanceof Scalar) {
            double sub=this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
         else
         return new Scalar(-1).mul(other).add(this); // здесь возвращать значения сложнения, так как просто поменять значения other и this нельзя
                                 // но мы можем скаляр минус вектор заменить на минут 1 * на вектор + скаляр
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other); //т.е операция невозможна
    }

    Scalar(double value) {  // конструктор будет принимать на вход значение и заносить это значение в приватное поле
        this.value = value;
    }

    Scalar(String strValue) { // конструктор принимает на вход строку и делает из строки число
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) { // на вход принемает экземпляр этого класса.
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value); // вызовем в класе doodle метод toString наше значение value
    }

    @Override
    protected double[] getValues() {
        return new double[0];
    }

}