package by.it.seledtsova.jd02_06.TaskB;


import java.util.Objects;

class VarCreator {

    public VarCreator() {
    }
    //задание jd0_09
    static Var calc(String strVar) throws CaltExeption { //// принимает не вход строку внутри оперант
        strVar = strVar.replaceAll("\\s+", ""); // оперант очи-ся от пробелом. они замен. пустой строкой
        if (strVar.matches(Patterns.SCALAR)) { ////оперант сообветствует регул выраж скаляра.то вернется новый скаляр в контсруктор
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = Var.load(strVar);
            if (Objects.nonNull(var)) {
                return var;
            }
        }
        throw new CaltExeption("Невозможно создать переменную : " + strVar);
    }
}
