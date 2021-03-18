package by.it.korotkevich.jd01_09;

interface Patterns {

    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";



    /*
    {{1.2,2},{8,3}}*{{1,2},{8,3}}
    {{1,2,3,4},{8,3,3}}*{{1,2,2},{8,3}}
     */

}
