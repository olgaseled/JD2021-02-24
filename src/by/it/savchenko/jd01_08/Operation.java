package by.it.savchenko.jd01_08;

interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Object mul(Var other);

    Var div(Var other);
}