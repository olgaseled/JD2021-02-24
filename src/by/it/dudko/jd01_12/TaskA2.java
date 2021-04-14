package by.it.dudko.jd01_12;

import java.util.*;

public class TaskA2 {

    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(4 * (set1.size() + set2.size()) / 3 + 1);
        result.addAll(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>();
        //noinspection ForLoopReplaceableByForEach
        for (Iterator<Integer> it = a.iterator(); it.hasNext(); ) {
            Integer currentElem = it.next();
            if (b.contains(currentElem)) {
                result.add(currentElem);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Integer[] anotherIntArray = {5, 4, 6, 7, 8, 9, 10};
        HashSet<Integer> a = new HashSet<>(Arrays.asList(intArray));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(anotherIntArray));
        System.out.println(a);
        System.out.println(b);
        System.out.println(getUnion(a, b));
        System.out.println(getCross(a, b));
    }

}
