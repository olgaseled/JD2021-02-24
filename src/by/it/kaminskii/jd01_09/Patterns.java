package by.it.kaminskii.jd01_09;

public interface Patterns {


    static final String OPERATION = "[-+/*]";
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";
    static final String VECTOR="\\{((-?[1-9]+\\.?[0-9]*),?)+\\}";
    static final String MATRIX="\\{(\\{((-?[1-9]+\\.?[0-9]*),?)+\\},?)+\\}";
}
