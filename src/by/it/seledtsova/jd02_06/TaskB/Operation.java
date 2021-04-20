package by.it.seledtsova.jd02_06.TaskB;

interface Operation{
    Var add(Var other) throws CaltExeption; // добавили интерфейс с задания

    Var sub(Var other) throws CaltExeption; //

    Var mul(Var other) throws CaltExeption;

    Var div(Var other) throws CaltExeption;
}
