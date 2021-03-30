package by.it.voitsekhovskiy.calc;

abstract class Var implements Operation {

    static Var createVar(String strExp) throws CalcException {
        if (strExp.matches(Patterns.SCALAR)) {
            return new Scalar(strExp);
        } else if (strExp.matches(Patterns.VECTOR)) {
            return new Vector(strExp);
        } else if (strExp.matches(Patterns.MATRIX)) {
            return new Matrix(strExp);
        }
        throw new CalcException("Can't define as Var!");
    }

    @Override
    public String toString() {
        return ("abstract Var");
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible\n", this, other));
    }
}
