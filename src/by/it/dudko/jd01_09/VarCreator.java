package by.it.dudko.jd01_09;

public class VarCreator {

    final static String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    final static String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    final static String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    public static Var createVar(String strVar) {
        strVar = strVar.replace(" ", "");
        if (strVar.matches(SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(MATRIX)) {
            return new Matrix(strVar);
        } else {
            return null; // TODO add exception unknown operand
        }
    }
}