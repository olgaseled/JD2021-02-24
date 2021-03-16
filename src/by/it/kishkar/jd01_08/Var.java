package by.it.kishkar.jd01_08;

public class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("операция сложения " + this + " + "+ other+ " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("операция вычитания " + this + " + "+ other+ " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("операция умжожения " + this + " + "+ other+ " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("операция деления " + this + " + "+ other+ " невозможна");
        return null;
    }
}
