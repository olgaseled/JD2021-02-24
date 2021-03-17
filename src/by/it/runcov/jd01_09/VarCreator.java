package by.it.runcov.jd01_09;

public class VarCreator {

    private VarCreator(){
    }
    static Var build(String strVar){
        strVar=strVar.replaceAll("\\s+","");
        if(strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }else if(strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }else{
            return null; //TODO stub - generate Error here
        }
    }

}
