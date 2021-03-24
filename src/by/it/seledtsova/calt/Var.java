package by.it.seledtsova.calt;

// нажать alt insert
// все наши переменные наследуется от нашего var
abstract class Var implements Operation { // cлово abstract (модификатор)  означет , что наш класс абстрактный. Также мы убрали слова public
                    //так как этот класс не используется нигде больше
                    //implement Operation означает, что наша переменная реализует нтерфейс Operation


    @Override   // code - generate - implement openation. в каждом из них напишем,
                // что возвращает этот метод  null, а операция не возможно
    public Var add(Var other) {
        System.out.println("Операция сложения"+this+"+"+other+" невоможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания"+this+"-"+other+" невоможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения"+this+"*"+other+" невоможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления"+this+"/"+other+" невоможна");
        return null;
    }

    @Override
    public String toString() {    //здесь мы не можешь снять модификатор public,
        return "Это класс abstract Var";  // тк этот класс String  наследуется от Object
    }                                  //а в object  сказано,  метод  toString возвращает String и он public,

    protected abstract double[] getValues();


    //задание jd0_09
static Var createVar (String operand) { // принимает не вход строку внутри оперант
    operand=operand.trim().replace("\\s+",""); // оперант очи-ся от пробелом. они замен. пустой строкой
    if (operand.matches(Patterns.SCALAR)) //оперант сообветствует регул выраж скаляра.то вернется новый скаляр в контсруктор
        return new Scalar(operand);
    if (operand.matches(Patterns.VECTOR))
        return new Vector(operand);
    if (operand.matches(Patterns.MATRIX))
        return new Matrix(operand);
    return null; // если не один из if не сработает , вернется null
}

}


