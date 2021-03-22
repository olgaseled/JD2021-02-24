package by.it.khrolovich.calc;

interface Patterns {
    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    //String Vector = "\{-?[0-9]+(\.[0-9]+)?(,-?[0-9]+(\.[0-9]+)?)*}";
    //String VECTOR = "\\{((-?[0-9]+(\\.[0-9]+)?),?)+}";//ещё вариант
    //String VECTOR = "\\{("+SCALAR+",?)+}";//ещё вариант
    String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";

    /*11+12
    },{
    2+2.0
    {1,3,-5.0}+4.0
    {1,3,5.0}+{2,3,4}
    {{1,3,5.0},{3,4}}*{1.0,2}
    */
}
