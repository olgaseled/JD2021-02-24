package by.it.papruga.jd01_09;

interface Patterns {


    String OPERATION="[-+*/]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"";


    /*
    1+1
    2+2.0
    {-1,3,-5.0} + 4.0
    {1,3,5.0} + {2,3,4}
    {1,2,5.0},(3,4}*{1.0,2}
     */
}
