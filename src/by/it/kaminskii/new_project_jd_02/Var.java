package by.it.kaminskii.new_project_jd_02;


abstract class Var implements Operation{

    @Override
    public String toString() {
        return "3.1415";
    }

    @Override
    public Var add(Var other) {
        System.out.println("низзя плюсануть");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("низзя отнять");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("низзя умножить");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("низзя разделить");
        return null;
    }
}


//разработайте для класса Var наследника Vector с тремя конструкторами:

