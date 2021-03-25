package by.it.korotkevich.calc;

class VarCreator {

    private VarCreator() {
    }

    static Var build(String strVar) {
        strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (Var.vars.containsKey(strVar)) {
            return Var.vars.get(strVar);
        } else {
            return null; //TODO stub
        }
    }
}
