package by.it.korotkevich.jd01_09;

class Matrix extends Var {
    private final double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }


    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    Matrix(String strMatrix) {
        String[] matrixRows = strMatrix.split("},");
        int rowCount = matrixRows.length;
        int colCount = matrixRows[0].split(",").length;
        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < matrixRows.length; i++) {
            matrixRows[i] = matrixRows[i].replaceAll("[{}]", "");
        }

        for (int i = 0; i < matrix[0].length; i++) {
            String[] arrayCols = matrixRows[i].split(",");
            for (int j = 0; j < arrayCols.length; j++) {
                matrix[i][j] = Double.parseDouble(arrayCols[j]);
            }
        }
        this.value = matrix;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");

        for (int i = 0; i < value[0].length; i++) {
            resultString.append("{");

            for (int j = 0; j < value[1].length; j++) {
                resultString.append(value[i][j]);
                if (j != value.length - 1) {
                    resultString.append(", ");
                }
            }

            resultString.append("}");

            if (i != value[0].length - 1) {
                resultString.append(", ");
            }
        }

        resultString.append("}");
        return resultString.toString();
    }
}
