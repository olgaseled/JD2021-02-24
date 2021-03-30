package by.it.belazarovich.Calc;

abstract class  Patterns {

  final  static   String OPERATION = "[-= +*/]";
    final  static String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    final  static String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    final  static String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

}
