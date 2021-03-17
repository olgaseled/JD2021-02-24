package by.it.zmushko.jd01_09;

interface Patterns {

    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "{" + VECTOR + VECTOR + "}";
    /*
    1+111
    2+2.0
    {1, 3, -5.0} + 4.0
    {2, 3, 4} + {2, 3, 4}
    {{1,2}, {3,4}} * {1.0, 2}
     */
}
