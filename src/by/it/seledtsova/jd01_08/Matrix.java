package by.it.seledtsova.jd01_08;

import java.util.Arrays;

public class  Matrix extends Var {


        private final double[][] arrayValues;

        public Matrix(double[][] value) {
            this.arrayValues = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                this.arrayValues[i] = Arrays.copyOf(value[i], value[i].length);
            }
        }

        public Matrix(String strValue) {
            this(new double[][]{{1, 2}, {3, 4}}); //stub
        }

        @Override
        public String toString() {
            return Arrays.deepToString(arrayValues).replace("[", "{").replace("]", "}");
        }

    }

