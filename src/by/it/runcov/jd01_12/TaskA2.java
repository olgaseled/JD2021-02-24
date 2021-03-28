package by.it.runcov.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1, 1, 2, 2, 2, 3, 4, 5, 6, 7, 7};
        Integer[] valuesForTreeSet = {4, 5, 6, 6, 7, 7, 8, 9, 87};
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(valuesForHashSet));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(valuesForTreeSet));
        System.out.println(hashSet);
        Set<Integer> union = getUnion(hashSet, treeSet);
        System.out.println(union);
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }
}
