package by.it.khrolovich.jd01_09;

public class VarCreator {
    public VarCreator() {
    }

    static Var build(String strVar){
        strVar = strVar.replaceAll("\\s+","");
        if (strVar.matches(Patterns.SCALAR)){
            return  new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)){
            return  new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)){
            return  new Matrix(strVar);
        } else {
            return null;//TODO stub - generate ERROR
        }
    }
}
