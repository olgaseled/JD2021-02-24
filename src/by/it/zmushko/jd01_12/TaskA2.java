package by.it.zmushko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] valuesForHashSet = {1, 1, 2, 2, 3, 4, 5, 6, 7, 1, 6, 7, 1, 2};
        Integer[] valuesForTreeSet = {1, 4, 6, 1, 1, 2, 3, 5, 6, 7, 1, 6, 7, 1, 2};
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(valuesForHashSet));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(valuesForTreeSet));
        System.out.println(hashSet);
        System.out.println(treeSet);
        getUnion(hashSet, treeSet);
        getCross(hashSet, treeSet);
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.addAll(b);
        return resultSet;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        HashSet<Integer> resultSet = new HashSet<>(a);
        resultSet.retainAll(b);
        return resultSet;
    }

}
