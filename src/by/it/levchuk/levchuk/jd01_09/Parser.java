package by.it.levchuk.levchuk.jd01_09;

public class Parser {

    Var evalued(String expression){
        expression = expression.replaceAll("\\s+","");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        Var leftVar=VarCreator.buld(parts[0]);
        if (parts.length<2){
            return leftVar;
        }
        Var rightVar = VarCreator.buld(parts[1]);
       // Pattern patternOperation=Pattern.compile()

                return null;

    }
}
