package by.it.savchenko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6};
        Integer[] valuesForTreeSet = {4, 4, 5, 5, 6, 7, 8, 8, 9, 9, 99};
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
