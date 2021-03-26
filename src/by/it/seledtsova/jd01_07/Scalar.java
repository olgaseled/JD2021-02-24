package by.it.seledtsova.jd01_07;

 class Scalar extends Var {  // мы создали двух потомков и он наследуется от класca var

    private final double value; // определили приватное поле . теперь есть возмозность создать конструктор.
                        //code -gererate - constructor

    Scalar(double value) {  // конструктор будет принимать на вход значение и заносить это значение в приватное поле
        this.value = value;
    }

    Scalar(String strValue) { // конструктор принимает на вход строку и делает из строки число
        this.value = Double.parseDouble(strValue);
    } // коструктор принемает на вход строку и
                                                //делает из него число с помощью parceDouble

    Scalar(Scalar otherScalar) { // на вход принемает экземпляр этого класса.
        this.value = otherScalar.value;
    } // возьмем мы это value из класс скаляр value

    @Override
    public String toString() {
        return Double.toString(value); // вызовем в класе doodle метод toString  и передадим наше значение value
    }

}