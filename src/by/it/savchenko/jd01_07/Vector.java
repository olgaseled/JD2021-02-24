package by.it.savchenko.jd01_07;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
//        strVector = strVector.replace("(", "");
//        strVector = strVector.replace(")", "");
//        strVector = strVector.replace("{", "");
//        strVector = strVector.replace("}", "");
//        strVector = strVector.replace("[", "");
//        strVector = strVector.replace("]", "");
//        strVector = strVector.replace(" ", "");
         value = new double[]{1, 2, 4};



        //чтобы в конструкторе сделать строку из массива нужно:
        //удалить из строки скобки
        //сделать сплит по запятой - будет массив строк
        //получить массив из чисел (как в 3 задании)
        //заполнить value вектора
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";

        }
        sb.append("}");
        return sb.toString();
    }
}
