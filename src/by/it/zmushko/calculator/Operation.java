package by.it.zmushko.calculator;

interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other) throws CalcException;
}