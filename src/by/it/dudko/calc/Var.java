package by.it.dudko.calc;

abstract class Var implements Operation {
    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is not possible\n", this, other);
        return null; //TODO replace throw exception
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is not possible\n", this, other);
        return null; //TODO replace throw exception
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is not possible\n", this, other);
        return null; //TODO replace throw exception
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is not possible\n", this, other);
        return null; //TODO replace throw exception
    }

}
