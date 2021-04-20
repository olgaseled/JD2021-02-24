package by.it.dudko.jd02_05.calc;

public interface Patterns {
    String OPERATION = "(?<=[^-+*/=,{])[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{\\s*" + SCALAR + "(\\s*,\\s*" + SCALAR + ")*\\s*}";
    String MATRIX = "\\{\\s*" + VECTOR + "(\\s*,\\s*" + VECTOR + ")*\\s*}";
    String PRIORITY_GROUP = "\\([^\\(]+?\\)";
    String SAFE_SPACES = "\\s+(?=[-+*/=])|(?<=[-+*/=])\\s+";
}
