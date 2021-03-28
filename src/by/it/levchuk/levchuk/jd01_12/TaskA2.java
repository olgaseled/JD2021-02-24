package by.it.levchuk.levchuk.jd01_12;
/*crash-noobik
Liauchuk Aliaksandr*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6};
        Integer[] valuesForTreeSet = {14, 4, 5, 5, 6, 7, 8, 8, 9, 9, 99};
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(valuesForHashSet));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(valuesForTreeSet));
        System.out.println(getUnion(treeSet, hashSet));
        System.out.println(getCross(treeSet, hashSet));

    }
}
