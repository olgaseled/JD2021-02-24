package by.it.belazarovich.Calc;

interface Operation {
    Var add(Var other) throws CalkExeption;

    Var sub(Var other)throws CalkExeption;

    Var mul(Var other)throws CalkExeption;

    Var div(Var other)throws CalkExeption;
}