package by.it.kirichenko.jd01_09;

public class VarCreator {
   /* private VarCreator(){

    }*/ //TODO
    static Var build(String strVar){
        if(strVar.matches((Patterns.SCALAR))){
            return new Scalar(strVar);
        }
        else if (strVar.matches((Patterns.VECTOR))){
            return new Scalar(strVar);
        }
        else if(strVar.matches((Patterns.MATRIX))){
            return new Scalar(strVar);
        }
        else{
            return null; //TODO exep
        }
    }
}
