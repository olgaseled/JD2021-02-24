package by.it.papruga.jd01_08;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {

        System.out.printf("Operation %s + %s is imposiblle\n", this, other);
        return null; // TODO replace throw exception
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
