package by.it.kaminskii.jd01_07;

public class Test {
    static int j = 0;
    static String[][] last;

    public static void main(String[] args) {
        double[][] value = {{1.0, 2.0}, {3.0, 4.0}};
        StringBuilder sb2 = new StringBuilder("{");
        String delim2 = " ";

        String one = "";
        String two = "";
        String strMatrix = "{{1.0, 2.0 },{ 3.0, 4.0 }}";
        strMatrix = strMatrix.replaceAll(" ", "");
        String[] matr = strMatrix.split("\\},\\{");
        for (int i = 0; i < matr.length; i++) {
            if (i < (matr.length - 1)) one = matr[i];
            else two = matr[i];
        }
        one = one.replaceAll("\\{|\\}", "");
        String[] oneArray = one.split(",");
        two = two.replaceAll("\\{|\\}", "");
        String[] twoArray = two.split(",");
        String[] both = new String[(oneArray.length + twoArray.length)];
        for (int i = 0; i < oneArray.length; i++) {
            both[i] = oneArray[i];
            both[(i + 2)] = twoArray[i];
        }
        for (int i = 0; i < both.length; i++) {
            System.out.println(both[i]);
        }


        for (int i = 0; i < value.length; i++) {
            sb2.append(delim2).append("{");
            for (j = 0; j < value[0].length; j++) {
                double elem = value[i][j];
                sb2.append(delim2).append(elem);
                delim2 = ", ";
            }
            if (value[0][i] < (value.length)) {
                delim2 = ",";
                sb2.append(" }").append(delim2);
                delim2 = " ";
            } else {
                sb2.append(" } }");
            }
            System.out.println(sb2.toString());

        }
//        String strVector = "{1,2,4}";
//        strVector= strVector.replaceAll("\\{|\\}", " ");
//        strVector=strVector.replaceAll(" ", "");
//        System.out.println(strVector);
//        String[] v = strVector.split(",");
//        double value[] = new double[v.length];
//        for (int i = 0; i < v.length; i++) {
//            value[i] = Double.parseDouble(v[i]);
//            System.out.println(value[i]);
//        }
    }
}
