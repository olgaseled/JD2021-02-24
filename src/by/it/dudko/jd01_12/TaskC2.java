package by.it.dudko.jd01_12;

import java.util.*;

public class TaskC2 extends TaskA2 {

    public static Set<? extends Number> getUnion(Set<? extends Number> ... collections) {
        Set<Long> result = new HashSet<>();
        for (Set<? extends Number> collection : collections) {
            for (Number number : collection) {
                result.add(number.longValue());
            }
        }
        return result;
    }

    public static Set<? extends Number> getCross(Set<? extends Number> ... collections) {
        Set<Long> result = new HashSet<>();

        for (Set<? extends Number> collection : collections) {
            for (Number compare1 : collection) {
                List<Boolean> matchFlags = new ArrayList<>(collections.length);
                for (Set<? extends Number> coll : collections) {
                    boolean matchFlag = false;
                    for (Number compare2 : coll) {
                        if (compare1.longValue() == compare2.longValue()) {
                            matchFlag = true;
                            break;
                        }
                    }
                    matchFlags.add(matchFlag);
                }
                if (matchFlags.stream().allMatch((flag) -> flag)) {
                    result.add(compare1.longValue());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Long[] longs = {156448L, 6L, 8L, 256412L, 323L, 4L, 5654L};
        Byte[] bytes = {5, 4, 6, 7, 8, 9, 10};
        Float[] floats = {4.5F, 65F, 7.0F, 6.0F};
        Set<Long> a = new HashSet<>(Arrays.asList(longs));
        Set<Byte> b = new TreeSet<>(Arrays.asList(bytes));
        Set<Float> c = new LinkedHashSet<>(Arrays.asList(floats));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(getUnion(a, b, c));
        System.out.println(getCross(a, b, c));
    }

}
