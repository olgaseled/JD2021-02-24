package by.it.kaminskii.new_project_jd_02;/* created by Kaminskii Ivan
 */

public class VectorAdd extends Var {

    static double[] addScalar(double[] value, double getValue) {
        for (int i = 0; i < value.length; i++) {
            value[i] = value[i] + getValue;
        }
        return value;
    }
}
