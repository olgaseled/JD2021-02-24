package by.it.kaminskii.jd02_06;

class Scalar extends Var {
    private final double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции сложения Скаляр + Скаляр");
            double sum = this.value + ((Scalar) other).value;
            Logger.getLogger().log(CalcLogOut.ADD + this + "+" + other);
            return new Scalar(sum);
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции вычитания Скаляр - Скаляр");
            double odds = this.value - ((Scalar) other).value;
            Logger.getLogger().log(CalcLogOut.SUB + this + "-" + other);
            return new Scalar(-1).mul(other).add(this);
        } else return other.sub(this);

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции умножения Скаляр * Скаляр");
            double prod = this.value * ((Scalar) other).value;
            Logger.getLogger().log(CalcLogOut.MUL + this + "*" + other);
            return new Scalar(prod);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcExeption {

        if (other instanceof Scalar) {
            Logger.getLogger().log("Запуск операции деления Скаляр / Скаляр");
            if (((Scalar) other).value != 0) {
                Logger.getLogger().log("Проверка значения (>0)");
                double result = this.value / ((Scalar) other).value;
                Logger.getLogger().log(CalcLogOut.DIV + this + "/" + other);
                return new Scalar(result);
            } else throw new CalcExeption("Деление на ноль");
        } else return super.div(other);
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
        Logger.getLogger().log("Result" + value);
        return Double.toString(value);
    }
}


//        1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
//        2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
//        3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
//         Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415