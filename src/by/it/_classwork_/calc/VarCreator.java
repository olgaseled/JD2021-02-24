package by.it._classwork_.calc;

class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            return Var.load(strVar); //TODO stub - generate Error here
        }

    }
}
