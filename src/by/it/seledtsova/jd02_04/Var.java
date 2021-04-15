package by.it.seledtsova.jd02_04;

import java.util.HashMap;
import java.util.Map;

// нажать alt insert
// все наши переменные наследуется от нашего var
abstract class Var implements Operation { // cлово abstract (модификатор)  означет , что наш класс абстрактный. Также мы убрали слова public
                    //так как этот класс не используется нигде больше
                    //implement Operation означает, что наша переменная реализует нтерфейс Operation





    @Override   // code - generate - implement openation. в каждом из них напишем,
                // что возвращает этот метод  null, а операция не возможно
    public Var add(Var other) throws CaltExeption {
        throw new CaltExeption("Операция сложения"+this+"+"+other+" невоможна");
      }

    @Override
    public Var sub(Var other) throws CaltExeption { // теперь при ошибках они будут выбрасываться наверх, а не печ в консоле
        throw new CaltExeption("Операция вычитания"+this+"-"+other+" невоможна");
         }

    @Override
    public Var mul(Var other) throws CaltExeption {
        throw new CaltExeption("Операция умножения"+this+"*"+other+" невоможна");
          }

    @Override
    public Var div(Var other) throws CaltExeption {
        throw new CaltExeption("Операция деления"+this+"/"+other+" невоможна");
          }

    @Override
    public String toString() {    //здесь мы не можешь снять модификатор public,
        return "Это класс abstract Var";  // тк этот класс String  наследуется от Object
    }                                  //а в object  сказано,  метод  toString возвращает String и он public,

    protected abstract double[] getValues();

}


