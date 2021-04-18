package by.it.runcov.calc;

interface Patterns {

    String BRACKETS = "\\([^\\(]+?\\)";
    String OPERATION = "(?<=[^-+/*=,{])[-=+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
}