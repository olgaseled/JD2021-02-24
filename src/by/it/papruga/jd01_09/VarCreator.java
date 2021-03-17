package by.it.papruga.jd01_09;

class VarCreator {

    private VarCreator(){}

    static Var build(String strVar){

        if (strVar.matches(Patterns.SCALAR)){

            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.SCALAR)){

            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.SCALAR)){

            return new Scalar(strVar);
        }
        else return null; //TODO stub - generate Erro here


    }

}
