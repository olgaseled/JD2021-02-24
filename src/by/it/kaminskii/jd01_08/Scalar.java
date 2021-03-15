package by.it.kaminskii.jd01_08;

class Scalar extends Var {
    private final double value;

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