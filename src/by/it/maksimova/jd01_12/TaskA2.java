package by.it.maksimova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {

        Integer[] valuesForHashSet = {1, 2, 3, 4, 5, 6, 7, 89};
        Integer[] valuesForTreeSet = {9, 8, 5, 6, 4, 55, 22, 11};
        HashSet<Integer> a = new HashSet<>(Arrays.asList(valuesForHashSet));
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(valuesForTreeSet));
        System.out.println(a);
        Set<Integer> union = getUnion(a, b);
        System.out.println(union);
        Set<Integer> cross = getCross(a, b);
        System.out.println(cross);


    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> newHashSet = new HashSet<>(a);
        newHashSet.addAll(b);
        return newHashSet;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> newHashSet = new HashSet<>(a);
        newHashSet.retainAll(b);
        return newHashSet;
    }

}