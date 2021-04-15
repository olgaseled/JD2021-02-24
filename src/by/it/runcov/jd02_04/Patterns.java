package by.it.runcov.jd02_04;

interface Patterns {

    String BRACKETS = "\\([^\\(]+?\\)";
    String OPERATION = "(?<=[^-+/*=,{])[-=+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
}