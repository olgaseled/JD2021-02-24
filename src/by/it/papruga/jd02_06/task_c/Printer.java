package by.it.papruga.jd02_06.task_c;


import java.util.Objects;

public class Printer {

    void print(Var var) {

        if (Objects.nonNull(var)) {
            System.out.println(var);
            Logger.getLogger().log("результат: "+ var.toString());
        }
    }
    void print (CalcException e){

        System.out.println(e.getMessage());
        Logger.getLogger().log("ошибка: "+ e.getMessage());

    }
}


