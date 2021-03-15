package by.it.seledtsova.jd01_08;

public class Scalar extends Var {  // мы создали двух потомков и он наследуется от класca var

    private final double value; // определили приватное поле . теперь есть возмозность создать конструктор

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

}